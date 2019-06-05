import java.util.List;

public abstract class Player extends  GameUnit {

    private int experience;
    private int level;

    public Player(String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition, int experience, int level, char tile) {
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition, tile);
        this.experience = 0;
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public boolean levelUp() {

        boolean b = false;
        if (experience >= level * 50) {
            experience = experience - 50 * level;
            level = level + 1;
            this.setHealthPool(this.getHealthPool() + 10 * level);
            this.setCurrentHealth(this.getHealthPool());
            this.setAttack(this.getAttack() + 5 * level);
            this.setDefense(this.getDefense() + 2 * level);
            b = true;
        }
        return b;
    }
    public void addExp(int experience)
    {
        this.experience+=experience;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public boolean isDead() {
        boolean isDead= super.isDead();
        if(isDead)
        {
            setTile('X');
            return true;
        }
        return false;

    }
    public String toString()
    {
        String player="Player:"+getName()+" Stats:\n" +
                "Health Pool:"+getHealthPool()+"\n" +
                "Current Health: "+ getCurrentHealth()+"\n" +
                "Attack points: " + getAttack() + "\n" +
                "Defense Points: "+ getDefense() +"\n" +
                "Experience: "+ experience + "\n"+
                "Level: "+ level+"\n";
        return player;
    }
    public abstract boolean specialAbility(List<Enemy> enemyList);
}
