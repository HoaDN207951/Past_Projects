import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrueFalse extends Questions {
    protected boolean ans;

    protected String filePath;

    public TrueFalse() {
        super();
        ans = false;
        filePath = "C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\questions.txt";
        openBuffer();
        readQuestion();
    }

    public TrueFalse(boolean ans) {
        super();
        this.ans = ans;
    }

    private void openBuffer() {
        try {
            buffer = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TrueFalse(String id, String description, boolean ans) {
        this.id = id;
        this.description = description;
        this.ans = ans;
    }

    public int getNumQues() {
        int count = 0;
        try (BufferedReader tempBuffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = tempBuffer.readLine()) != null) {
                if (line.startsWith("TF")) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }

    @Override
    public Boolean getAns() {
        return this.ans;
    }

    @Override
    public void readQuestion() {
        try {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.startsWith("TF")) {
                    id = line.substring(0,2);
                    description = line.substring(2).trim();
                    ans = Boolean.parseBoolean(buffer.readLine().trim());
                    break;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void reset() {
        description = null;
        ans = false;
        readQuestion();
    }
}
