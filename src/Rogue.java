import java.util.LinkedList;
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
        if (currentEnergy+10>100)
            currentEnergy=100;
        else
            currentEnergy+=10;
    }

    public String specialAbility (List<Enemy>[] enemyList){
        String output="";
        if (currentEnergy<cost)
            output= "Cannot cast ability, current energy is smaller than cost";
        else{
            currentEnergy = currentEnergy -cost;
            List<Enemy> enemiesInRange=enemiesInRange(2,enemyList);
            for (Enemy en : enemiesInRange) {
                int[] combatStats = attack(en, getAttack());
                if( combatStats[0]>combatStats[1])
                {
                    output+=this.getName()+" attacked " + en.getName() +" via special ability and made him "+combatStats[0] + "damage!" ;
                    if (en.isDead())
                    {
                        output+=" And killed him! ";
                    }
                    else
                        output+=en.getName() +" has " + en.getCurrentHealth() +" health points remaining";
                    output+="\n";
                }
                else
                    output+=this.getName()+" tried to attack " + en.getName() +" via special ability and make "+combatStats[0]+"," +
                            " but couldn't hurt him because " + en.getName() +"had " +combatStats[1] + " defence points! \n" ;
            }
        }
        return output;

    }


    public String toString()    {
        String Rouge=super.toString();
        Rouge+="Type: Rouge, Current energy: "+currentEnergy +"     cost of special ability: "+cost +"\n";
        return Rouge;

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
