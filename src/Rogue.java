import java.util.List;

public class Rogue extends Player {


    private int cost;
    private int currentEnergy;

    public Rogue (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition,int experience, int level, int cost,char tile){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition, experience, level,tile);
        this.cost = cost;
        this.currentEnergy = 100;
    }

    public boolean levelUp() {
        boolean b = super.levelUp();
        if (b) {
            currentEnergy = 100;
            this.setAttack(this.getAttack()+3*this.getLevel());
        }
        return b;
    }
    @Override
    public void gameTick() {

    }

    public boolean specialAbility (List<Enemy> enemyList){
        if (currentEnergy<cost)
            return false;
        else{
            currentEnergy = currentEnergy -cost;
            //foreach loop must be completed.
        }
        return true;
    }
}
