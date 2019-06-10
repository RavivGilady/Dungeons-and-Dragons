import java.util.TooManyListenersException;

public class Trap extends Enemy {


    private int range;
    private int respawn;
    private int visibility;
    private int tickCounts;

    private char originalTile;

    public Trap (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition, int experience, char Tile, int range, int respawn, int visibility){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition,experience,Tile);
        this.range = range;
        this.respawn = respawn;
        this.visibility = visibility;
        this.originalTile= Tile;

    }

    public int getRange() {
        return range;
    }

    public int getRespawn() {
        return respawn;
    }

    public int getVisibility() {
        return visibility;
    }

    @Override
    public void gameTick() {
        tickCounts++;
        if(tickCounts<visibility)
            setTile(originalTile);
        else
            setTile('.');
    }
    @Override
    public Point move(Point player) {
        if (tickCounts==respawn){
            tickCounts=0;
            return null;//TODO move
        }
        else
            return null; // if
    }
}
