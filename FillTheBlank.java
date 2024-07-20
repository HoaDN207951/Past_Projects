import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FillTheBlank extends Questions {
    protected String word;

    protected String filePath;

    public FillTheBlank() {
        super();
        word = "";
        filePath = "C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\questions.txt";
        openBuffer();
        readQuestion();
    }

    private void openBuffer() {
        try {
            buffer = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public FillTheBlank(String word) {
        super();
        this.word = word;
    }

    public FillTheBlank(String id, String description, String word) {
        this.id = id;
        this.description = description;
        this.word = word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public void readQuestion() {
        try {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.startsWith("FB")) {
                    id = line.substring(0,2);
                    description = line.substring(2).trim();
                    word = buffer.readLine().trim();
                    break;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getNumQues() {
        int count = 0;
        try (BufferedReader tempBuffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = tempBuffer.readLine()) != null) {
                if (line.startsWith("FB")) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public void reset() {
        description = null;
        word = "";
        readQuestion();
    }
}