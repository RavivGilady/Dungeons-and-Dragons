public class Monster extends Enemy{

    private int range;

    public Monster (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition, int experience, char Tile, int range){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition,experience,Tile);
        this.range = range;

    }

    @Override
    public void gameTick() {

    }
}
