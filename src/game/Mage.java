package game;

import game.Point;

import java.util.LinkedList;
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
        currentMana=Math.min(manaPool,currentMana+1);
    }

    public String  specialAbility (List<Enemy>[] enemyList) {
        String output="";
        if (currentMana<cost)
            output = "Cannot cast ability, current mana is smaller than cost\n";

        else {
            currentMana = currentMana - cost;
            List<Enemy> enemiesInRange = enemiesInRange(range, enemyList);
            int hits = 0;
            while (!enemiesInRange.isEmpty() & hits < hitTimes)
            {
                output+=selectRandomAndAttack(enemiesInRange);
                hits++;
            }
        }
        return output;

    }

    private String selectRandomAndAttack(List<Enemy> enemiesInRange) {
        int randomEnemy=randomGenerator.generateNumber(enemiesInRange.size());
        Enemy en= enemiesInRange.get(randomEnemy);
        int[] combatStats = attack(en, spellPower);
        if( combatStats[0]>combatStats[1])
        {
            String output=this.getName()+" attacked " + en.getName() +" via special ability and made him "
                    +(combatStats[0]-combatStats[1]) + " damage" ;
            if (en.isDead()) {
                addExp(en.getExperience());
                enemiesInRange.remove(en);
                output+=" and killed him!";
            }
            else
                output+=en.getName() +" has " + en.getCurrentHealth() +" health points remaining";
            output+="\n";
            return  output;
        }
        else
            return (this.getName()+" tried to attack " + en.getName() +" via special ability and make "+combatStats[0]+"," +
                    " but couldn't hurt him because " + en.getName() +"had " +combatStats[1] + " defence points! \n") ;
    }

    public String toString()
    {
        String mage=super.toString();
        mage+="Type: Mage, Spell Power: "+spellPower +"     current mana: "+currentMana +"     mana pool: "+manaPool + "    cost of special ability: "  + cost + "\n"+
            "     hit times: " + hitTimes+ "    range: " +range + "\n";
        return mage;
    }
    private List<Enemy> enemiesInRange(int range,List<Enemy>[] enemiesLists)
    {
        List<Enemy> enemiesInRange=new LinkedList<Enemy>();
        Point playerPosition=this.getPosition();
        for(List<Enemy> enemies : enemiesLists)
            for (Enemy en: enemies) {
                if ((en.getPosition().distance(playerPosition))<range)
                    enemiesInRange.add(en);
        }
        return enemiesInRange;
    }
}
