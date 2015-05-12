package test.java;

import javafx.geometry.Point2D;
import main.java.ClosestPair;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by dianwen on 4/30/15.
 */
public class ClosestPairTest {
    @Test
    public void testNonSplitPairs() {
        Point2D[] points = new Point2D[5];
        points[0] = new Point2D(1, 1);
        points[1] = new Point2D(2, 2);
        points[2] = new Point2D(4, 4);
        points[3] = new Point2D(6, 6);
        points[4] = new Point2D(8, 8);
        assertArrayEquals(ClosestPair.findClosestPair(points), new Point2D[]{new Point2D(1, 1), new Point2D(2, 2)});
        points[0] = new Point2D(1, 1);
        points[1] = new Point2D(3, 3);
        points[2] = new Point2D(5, 5);
        points[3] = new Point2D(7, 7);
        points[4] = new Point2D(8, 8);
        assertArrayEquals(ClosestPair.findClosestPair(points), new Point2D[]{new Point2D(7, 7), new Point2D(8, 8)});
    }

    @Test
    public void testSplitPairs() {
        Point2D[] points = new Point2D[5];
        points[0] = new Point2D(1, 1);
        points[1] = new Point2D(8, 8);
        points[2] = new Point2D(4, 4);
        points[3] = new Point2D(6, 6);
        points[4] = new Point2D(2, 2);
        assertArrayEquals(ClosestPair.findClosestPair(points), new Point2D[]{new Point2D(1, 1), new Point2D(2, 2)});
    }

    @Test
    public void testBruteForceImplementation() {
        Point2D[] points = new Point2D[5];
        points[0] = new Point2D(1, 1);
        points[1] = new Point2D(2, 2);
        points[2] = new Point2D(4, 4);
        points[3] = new Point2D(6, 6);
        points[4] = new Point2D(8, 8);
        assertArrayEquals(ClosestPair.bruteForceFindClosestPair(points), new Point2D[]{new Point2D(1, 1), new Point2D(2, 2)});
    }

    @Test
    public void testSmartClosestPairDistanceMatchesBruteForce() {
        Point2D[] array = createRandomPointSet(100, -100, 100, -100, 100);
        Point2D[] bruteForceClosestPair = ClosestPair.bruteForceFindClosestPair(array);
        Point2D[] smartImplementationClosestPair = ClosestPair.findClosestPair(array);
        assertEquals(bruteForceClosestPair[0].distance(bruteForceClosestPair[1]), smartImplementationClosestPair[0].distance(smartImplementationClosestPair[1]), 1e-99);
    }

    public static Point2D[] createRandomPointSet(int numberOfPoints, double xMin, double xMax, double yMin, double yMax) {
        Random rand = new Random();
        Point2D[] array = new Point2D[numberOfPoints];
        for(int i = 0; i < numberOfPoints; i++) {
            array[i] = new Point2D(rand.nextDouble() * (xMax - xMin) + xMin, rand.nextDouble() * (yMax - yMin) + yMin);
        }
        return array;
    }
}
