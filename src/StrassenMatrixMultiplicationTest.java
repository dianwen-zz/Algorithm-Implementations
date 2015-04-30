import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by dianwen on 4/27/15.
 */
public class StrassenMatrixMultiplicationTest {
    @Test
    public void testCorrectMultiplication() {
        int[][] a = {{1, 9, 0, 7},
                {5, 5, 7, 9},
                {0, 5, 7, 5},
                {1, 8, 7, 9}};
        int[][] b = {{1, 5, 9, 0},
                {5, 2, 1, 9},
                {6, 8, 4, 2},
                {8, 3, 7, 3}};
        int[][] result = {{102, 44, 67, 102},
                {144, 118, 141, 86},
                {107, 81, 68, 74},
                {155, 104, 108, 113}};
        assertArrayEquals(result, StrassenMatrixMultiplication.multiply(a, b));
    }
}