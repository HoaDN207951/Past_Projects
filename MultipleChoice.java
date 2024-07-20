import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MultipleChoice extends Questions {
    protected Map<String, Boolean> choices;
    protected String filePath;

    public MultipleChoice() {
        super();
        filePath = "C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\questions.txt";
        choices = new LinkedHashMap<>();
        openBuffer();
        readQuestion();
    }

    public MultipleChoice(Map<String, Boolean> choices) {
        super();
        this.choices = choices;
    }

    public MultipleChoice(String id, String description, Map<String, Boolean> choices) {
        this.id = id;
        this.description = description;
        this.choices = choices;
    }

    private void openBuffer() {
        try {
            buffer = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setChoices(Map<String, Boolean> choices) {
        this.choices = choices;
    }

    @Override
    public Map<String, Boolean> getChoices() {
        return choices;
    }

    public void reset() {
        choices.clear();
        readQuestion();
    }

    public String correctAns() {
        for (Map.Entry<String, Boolean> entry : choices.entrySet()) {
            if (entry.getValue() == Boolean.TRUE) {
                System.out.println("The correct answer is: " + entry.getKey());
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public void readQuestion() {
        try {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.startsWith("MC")) {
                    id = line.substring(0,2);
                    description = line.substring(2).trim();
                    for (int i = 0; i < 4; i++) {
                        String choice = buffer.readLine().trim();
                        boolean isCorrect = Boolean.parseBoolean(buffer.readLine());
                        choices.put(choice, isCorrect);
                    }
                    break; // stop reading further line
                }
                //break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNumQues() {
        int count = 0;
        try (BufferedReader tempBuffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = tempBuffer.readLine()) != null) {
                if (line.startsWith("MC")) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}