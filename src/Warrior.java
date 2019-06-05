import java.util.List;

public class Warrior extends Player {

    private int cooldown;
    private int remaining;

    public Warrior (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition,int experience, int level , int cooldown, int remaining,char tile){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition, experience, level,tile);
        this.cooldown = cooldown;
        this.remaining = 0;

    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    @Override
    public boolean levelUp() {
        boolean b = super.levelUp();
        if (b){
            remaining = 0;
            this.setHealthPool(this.getHealthPool() + this.getLevel()*5);
            this.setDefense(this.getDefense() +this.getLevel());
        }

        return b;
    }

    public boolean specialAbility (List<Enemy> enemyList){
        if (remaining>0)
            return false;
        else{
            remaining = getCooldown();
            if(this.getHealthPool()-2*this.getDefense()>=(this.getCurrentHealth()+ 2*this.getDefense()))
                this.setCurrentHealth(this.getCurrentHealth() + 2*this.getDefense());
        }
        return true;
    }





}
