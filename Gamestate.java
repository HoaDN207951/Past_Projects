import java.util.*;

public class Gamestate {
    List<Questions> listQuestion;
    int random;
    int randomMon;
    Admin admin = new Admin("admin", "admin");
    Player player = new Player();
    List<Monster> listMonster;
    int numQues;
    Leaderboard board = new Leaderboard();

    public Gamestate() {
        listQuestion = new ArrayList<>();
        listMonster = new ArrayList<>();
        MultipleChoice mc = new MultipleChoice();
        TrueFalse tf = new TrueFalse();
        FillTheBlank fb = new FillTheBlank();

        int numMc;
        numMc = mc.getNumQues();

        int numTf;
        numTf = tf.getNumQues();

        int numFb;
        numFb = fb.getNumQues();

        Monster[] mon1= new Monster[5];

        for(int i = 0; i<5; i++){
            mon1[i] = new Monster(100, 100, 1);
            listMonster.add(mon1[i]);
        }

        Monster[] mon3= new Monster[2];

        for(int i = 0; i<2; i++){
            mon3[i] = new Monster(300, 200, 3);
            listMonster.add(mon3[i]);
        }

        Monster[] mon5= new Monster[2];

        for(int i = 0; i<2; i++){
            mon5[i] = new Monster(500, 300, 5);
            listMonster.add(mon5[i]);
        }

        MultipleChoice[] mcRead = new MultipleChoice[numMc];
        TrueFalse[] tfRead = new TrueFalse[numTf];
        FillTheBlank[] fbRead = new FillTheBlank[numFb];

        for (int i = 0; i < numMc; i++) {
            mcRead[i] = new MultipleChoice();
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    mcRead[i].reset();
                }
            }
            listQuestion.add(mcRead[i]);
        }

        for (int i = 0; i < numTf; i++) {
            tfRead[i] = new TrueFalse();
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    tfRead[i].reset();
                }
            }
            listQuestion.add(tfRead[i]);
        }

        for (int i = 0; i < numFb; i++) {
            fbRead[i] = new FillTheBlank();
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    fbRead[i].reset();
                }
            }
            listQuestion.add(fbRead[i]);
        }
    }

    public String getQuestion() {
        random = (int) (Math.random() * (listQuestion.size()));
        String question = listQuestion.get(random).getDescription();

        return question;
    }

    public String getId() {
        return listQuestion.get(random).getId();
    }

    public Map<String, Boolean> getChoiceVal() {
        return listQuestion.get(random).getChoices();
    }

    public List<String> getChoice() {
        List<String> l = new ArrayList<String>(listQuestion.get(random).getChoices().keySet());
        removeQuestion();
        return l;
    }

    public String getWord() {
        return listQuestion.get(random).getWord();
    }

    public Boolean getAns() {
        return listQuestion.get(random).getAns();
    }

    public void removeQuestion() {
        listQuestion.remove(listQuestion.get(random));
        System.out.println();
        System.out.println(listQuestion.size());
        numQues = listQuestion.size();
    }

    public void setPlayerName(String name){
        player.setHealth(500);
        player.setScore(0);
        player.setUsername(name);
    }

    public Monster getMonster(){
        randomMon = (int) (Math.random() * (listMonster.size()));
        return listMonster.get(randomMon);
    }

    public void removeMonster(){
        listMonster.remove(listMonster.get(randomMon));
    }

    public int getSizeMon(){
        return listMonster.size();
    }

    public boolean checkPlayerName(String name){
        if(board.getRanking().containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    public List<String> displayBoard(){
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : board.ranking.entrySet()) {
            list.add(entry.getKey() + ": " + entry.getValue());
        }
        return list;
    }
}
