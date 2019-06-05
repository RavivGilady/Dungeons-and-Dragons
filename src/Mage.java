import java.util.List;

public class Mage extends Player {

    private int spellPower;
    private int manaPool;
    private int currentMana;
    private int cost;
    private int hitTimes;
    private int range;

    public Mage (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition,int experience, int level, int spellPower, int manaPool, int currentMana, int cost, int hitTimes, int range,char tile){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition, experience, level,tile);
        this.spellPower = spellPower;
        this.manaPool = manaPool;
        this.currentMana = currentMana;
        this.cost = cost;
        this.hitTimes = hitTimes;
        this.range = range;
    }

    public boolean levelUp() {
        boolean b = super.levelUp();
        if (b) {
            manaPool = (manaPool + 25 * getLevel());
            currentMana = Math.min(currentMana + (manaPool / 4), manaPool);
            spellPower = spellPower + 10 * getLevel();
        }
        return b;
    }
    @Override
    public void gameTick() {

    }

    public boolean specialAbility (List<Enemy> enemyList){
        if (currentMana<cost)
            return false;
        else{
            currentMana = currentMana -cost;
            int hit =0;
            //while loop must be completed
        }
        return true;
    }
}
