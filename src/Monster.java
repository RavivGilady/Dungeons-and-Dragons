import java.util.Random;

public class Monster extends Enemy{

    private int range;

    public Monster (String name, int HealthPool, int CurrentHealth, int Attack, int Defense, int Xposition, int Yposition, int experience, char Tile, int range){
        super(name, HealthPool, CurrentHealth, Attack, Defense, Xposition, Yposition,experience,Tile);
        this.range = range;

    }

    @Override
    public Point move(Point player) {
        Point output = new Point(getPosition());
        if (getPosition().distance(player)<range)        {
            output.moveTowards(player);
        }
        else {
            int movementValue = randomGenerator.generateNumber(500);
            if (movementValue %5 == 0)
                output.moveLeft();
            if (movementValue % 5 == 1)
                output.moveUp();
            if (movementValue % 5 == 2)
                output.moveRight();
            if (movementValue % 5 == 3)
                output.moveDown();
            //if %5==4 do nothing - output=output
        }
        return output;
    }

    @Override
    public void gameTick() {

    }
}
