package game;

import game.GameUnit;
import TestsPackage.ProjectTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameUnitTest extends ProjectTests {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isDead() {

        GameUnit gameUnitAlive1 =new Rogue("Arya Stark",150,150,40,2,1,1,0,1,20,'@');
        GameUnit gameUnitAlive2 =new Rogue("Arya Stark",150,1,40,2,1,1,0,1,20,'@');
        GameUnit gameUnitDead1 =new Rogue("Arya Stark",150,0,40,2,1,1,0,1,20,'@');
        GameUnit gameUnitDead2 =new Rogue("Arya Stark",150,-5,40,2,1,1,0,1,20,'@');

        Assert.assertFalse(gameUnitAlive1.isDead());
        Assert.assertFalse(gameUnitAlive2.isDead());
        Assert.assertTrue(gameUnitDead1.isDead());
        Assert.assertTrue(gameUnitDead2.isDead());
    }
}