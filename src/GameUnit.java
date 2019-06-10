public abstract class GameUnit {

    private  String name;
    private int HealthPool;
    private int CurrentHealth;
    private int Attack;
    private int Defense;
    private int Xposition;
    private int Yposition;
    private char tile;
    private Point position;

    public GameUnit (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition, char Tile){

        this.name = name;
        this.HealthPool = HealthPool;
        this.CurrentHealth = CurrentHealth;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Xposition = Xposition;
        this.Yposition = Yposition;
        this.tile=Tile;
        this.position=new Point(Xposition,Yposition);
    }
    public int[] attack(GameUnit gu)
    {
        //TODO random
        int[] combatInfo=new int[2];
        combatInfo[0]=0; //AttackPoints //TODO change
        combatInfo[1]=gu.defense(combatInfo[0]);
        return combatInfo;
    }
    public int[] attack(GameUnit gu,int attackPoints)
    {
            //TODO random
        int[] combatInfo=new int[2];
        combatInfo[0]=attackPoints; //TODO change
        combatInfo[1]=gu.defense(attackPoints);
        return combatInfo;
    }
    public int defense(int attackPoints)
    {
        int defencePoints=0; //TODO change to random between 0 to Defense
        if(attackPoints>Defense)
            CurrentHealth-= (attackPoints-defencePoints);
        return defencePoints;

    }
    public  boolean isDead()
    {
        return (CurrentHealth<=HealthPool);
    }

    public abstract void gameTick();
    public String getName() {
        return name;
    }

    public int getHealthPool() {
        return HealthPool;
    }

    public void setHealthPool(int healthPool) {
        HealthPool = healthPool;
    }

    public int getCurrentHealth() {
        return CurrentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        CurrentHealth = currentHealth;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public int getXposition() {
        return position.x;
    }

    public void setXposition(int xpositin) {
        Xposition = xpositin;
    }

    public int getYposition() {
        return position.y;
    }

    public void setYposition(int yposition) {
        Yposition = yposition;
    }

    public char getTile() {
        return tile;
    }

    public void setTile(char tile) {
        this.tile = tile;
    }

    public Point getPosition() {return position;}

    public void setPosition(Point position){this.position=position;}

}


