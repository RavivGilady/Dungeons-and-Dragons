package TestsPackage;
import game.GameUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import game.*;
public class GameUnitTest extends ProjectTests {
    private GameUnit gameUnitAlive1 =new Rogue("Arya Stark",150,150,40,2,1,1,0,1,20,'@');
    private GameUnit gameUnitAlive2 =new Rogue("Arya Stark",150,1,40,2,5,1,0,1,20,'@');
    private GameUnit gameUnitDead1 =new Rogue("Arya Stark",150,0,40,2,1,1,0,1,20,'@');
    private GameUnit gameUnitDead2 =new Rogue("Arya Stark",150,-5,40,2,1,1,0,1,20,'@');


    @Before
    public void setup(){

    }

    @Test
    public void getPosition() {
        Point newPoint=new Point(5,1);
        gameUnitAlive1.setPosition(newPoint);
        Assert.assertTrue(gameUnitAlive1.getPosition().equals(gameUnitAlive2.getPosition()));
        Assert.assertFalse(gameUnitDead1.getPosition().equals(gameUnitAlive2.getPosition()));

    }

    @Test
    public void isDead() {

        Assert.assertFalse(gameUnitAlive1.isDead());
        Assert.assertFalse(gameUnitAlive2.isDead());
        Assert.assertTrue(gameUnitDead1.isDead());
        Assert.assertTrue(gameUnitDead2.isDead());
    }
}