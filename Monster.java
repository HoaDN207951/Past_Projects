public class Monster implements attack{
    private int health;
    private int attackDmg;
    private int type;

    public Monster(){
        health = 0;
    }

    public Monster(int health, int attackDmg, int type){
        this.health = health;
        this.attackDmg = attackDmg;
        this.type = type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public void attacked(int num) {
            setHealth(health-100);
    }
}
