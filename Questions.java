import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

abstract public class Questions {
    protected String id;
    protected String description;
    static FileReader file;
    static BufferedReader buffer;

    public Questions() {
        try {
            file = new FileReader("questions.txt");
            buffer = new BufferedReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Questions(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getQuestion(String typeIdentifier) {
        String question = null;
        try {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.startsWith(typeIdentifier)) {
                    question = line.substring(typeIdentifier.length()).trim();
                    System.out.println(question);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return question;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    abstract public void reset();

    public String getWord(){
        return null;
    }

    public Boolean getAns(){
        return null;
    }

    abstract public void readQuestion();

    public Map<String, Boolean> getChoices(){
        return null;
    }
}