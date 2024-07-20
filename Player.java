public class Player extends User implements attack{
    protected int score;
    protected int health;

    public Player(){
        super();
        score = 0;
        health = 0;
    }

    public Player(int score, int health){
        super();
        this.score = score;
        this.health = health;
    }

    public Player(String username, int score, int health){
        this.username = username;
        this.score = score;
        this.health = health;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void attacked(int num) {
            setHealth(health-num);
    }

    public void healthRestore(){
        setHealth(health+100);
    }

    public void giftAns(){
        setScore(score+100);
    }

    public void doubleScore(){
        setScore(score+200);
    }

    public void updateScore(){
        setScore(score+100);
    }
}