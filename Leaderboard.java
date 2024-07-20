import java.util.*;
import java.io.*;

public class Leaderboard {
    protected Map<String, Integer> ranking;
    protected String filePath;

    public Leaderboard(String filePath) {
        this.filePath = filePath;
        this.ranking = new LinkedHashMap<>();
        loadLeaderboard();
    }

    public Leaderboard(Map<String, Integer> ranking){
        this.ranking = ranking;
    }

    public Leaderboard() {
        this.filePath = "C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\leaderboard.txt";
        this.ranking = new LinkedHashMap<>();
        loadLeaderboard();
    }

    public void setRanking(Map<String, Integer> ranking) {
        this.ranking = ranking;
    }

    public Map<String, Integer> getRanking() {
        return ranking;
    }

    public void rankScore() { //sort
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(ranking.entrySet());

        list.sort((i1, i2) -> i2.getValue().compareTo(i1.getValue())); // Descending order

        ranking.clear();

        for (Map.Entry<String, Integer> temp : list) {
            ranking.put(temp.getKey(), temp.getValue());
        }
    }
    private void loadLeaderboard() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String playerName = line.trim();
                if ((line = reader.readLine()) != null) {
                    int score = Integer.parseInt(line.trim());
                    ranking.put(playerName, score);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void saveLeaderboard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                writer.write(entry.getKey());
                writer.newLine();
                writer.write(String.valueOf(entry.getValue()));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateLeaderboard(String playerName, int score) {
        if (ranking.containsKey(playerName)) {
            int currentScore = ranking.get(playerName);
            if (score > currentScore) {
                ranking.put(playerName, score);
            }
        } else {
            ranking.put(playerName, score);
        }
        rankScore();
        saveLeaderboard();
    }
}