package TestsPackage;

import game.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointTest extends ProjectTests {
    private Point point1;
    private Point point2;

    @Before
    public void setUp()  {
        point1 =new Point(10,5);
        point2 =new Point(5,2);

    }

    @Test
    public void distance() {
        Point distanceDouble=new Point(11,6);
        Point distanceInt=new Point(10,6);

        Assert.assertEquals(1, point1.distance(distanceInt),0);
        Assert.assertEquals(1.414, point1.distance(distanceDouble),0.001);
    }


    @Test
    public void moveTowards() {
        double range=point1.distance(point2);
        point2.moveTowards(point1);
        double newRange=point1.distance(point2);

        Assert.assertTrue(range>newRange);

    }


}