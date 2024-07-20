import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User{
    protected String password;
    private final String filePath = "C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\questions.txt";


    public Admin(){
        super();
        password = "";
    }

    public Admin(String password){
        super();
        this.password = password;
    }

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean addMCQuestion(String typeIdentifier,String question, String[] choices, String[] answers){
        if (isQuestionExists(typeIdentifier + " " + question)) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(typeIdentifier + " " + question);
            writer.newLine();
            for (int i = 0; i < choices.length; i++) {
                if (choices[i] != null) {
                    writer.write(choices[i]);
                    writer.newLine();
                    writer.write(answers[i]);
                    writer.newLine();
                }
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addTFQuestion(String typeIdentifier,String question, String answer) {
        if (isQuestionExists(typeIdentifier + " " + question)) {
            return false;
        }

        if (!answer.equalsIgnoreCase("true") && !answer.equalsIgnoreCase("false")) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(typeIdentifier + " " + question);
            writer.newLine();
            writer.write(answer);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addFBQuestion(String typeIdentifier,String question, String answer) {
        if (isQuestionExists(typeIdentifier + " " + question)) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(typeIdentifier + " " + question);
            writer.newLine();
            writer.write(answer);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeQuestion(String questionDescription) throws IOException {
        List<String> lines = new ArrayList<>();
        boolean questionFound = false;
        int skipLines = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(questionDescription) && !questionFound) {
                    questionFound = true;
                    String questionType = line.substring(0, 2);
                    if (questionType.equals("MC")) {
                        skipLines = 8; // Skip 8 lines
                    } else if (questionType.equals("TF")) {
                        skipLines = 1; // Skip 1
                    } else if (questionType.equals("FB")) {
                        skipLines = 1; // Skip 1
                    }
                } else if (questionFound && skipLines > 0) {
                    skipLines--;
                } else {
                    lines.add(line);
                }
            }
        }

        if (questionFound) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
                return true;
            }
        } else {
            return false;
        }
    }

    public List<String> displayAll() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("MC") || line.startsWith("TF")
                        || line.startsWith("FB")){
                    list.add(" ");
                    list.add(line);
                }
                else{
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<String> displayOnlyQues() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("MC") || line.startsWith("TF")
                    || line.startsWith("FB")){
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    private boolean isQuestionExists(String questionDescription) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(questionDescription)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
