package Test;

import Main.Point;
import org.junit.Assert;
import org.junit.Test;


public class AreaTest {
    private Point point;

    @Test
    public void checkFirstArea() {
        point = new Point(-1., 1.5, 3);
        Assert.assertTrue(point.isArea());
    }

    @Test
    public void checkSecondArea() {
        point = new Point(1., 2., 3);
        Assert.assertFalse(point.isArea());
    }

    @Test
    public void checkThirdArea() {
        point = new Point(1., -2., 5);
        Assert.assertTrue(point.isArea());
    }

    @Test
    public void checkFourthArea() {
        point = new Point(-1., -4., 3.);
        Assert.assertFalse(point.isArea());
    }
}
