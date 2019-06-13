import TestsPackage.ProjectTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PointTest extends ProjectTests {
    private Point point;
    @Before
    public void setUp() throws Exception {
        point=new Point(10,5);
    }

    @Test
    public void distance() {
        Point distanceDouble=new Point(11,6);
        Point distanceInt=new Point(10,6);

        Assert.assertEquals(1,point.distance(distanceInt),0);
        Assert.assertEquals(1.414,point.distance(distanceDouble),0.001);
    }

    @Test
    public void outOfBounds() {
    }

    @Test
    public void moveTowards() {
    }

    @Test
    public void findPointsInRange() {

    }
}