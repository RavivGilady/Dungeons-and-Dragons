public abstract class Enemy extends GameUnit {

    private int experience;

    public Enemy (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition, int experience, char Tile){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition,Tile);
        this.experience =  experience;

    }

    public int getExperience() {
        return experience;
    }


    public abstract Point move(Point player);
}
