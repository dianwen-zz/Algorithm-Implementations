package test.java;

import main.java.CountInversions;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by dianwen on 4/27/15.
 */
public class CountInversionsTest {
    @Test
    public void testCorrectlyCountInversions() {
        int[] array = {1, 3, 5, 2, 4, 6};
        assertEquals((long) 3, (long) CountInversions.countInversionsAndMergeSort(array));
    }

    @Test
    public void testMergeSortMatchesBruteForceCount() {
        int[] randomArray = createRandomArray(32, 100, 0);
        assertEquals((long) CountInversions.bruteForceCountInversions(randomArray), (long) CountInversions.countInversionsAndMergeSort(randomArray));
    }

    public static int[] createRandomArray(int arraySize, int maxValue, int minValue) {
        Random rand = new Random();
        int[] array = new int[arraySize];
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(maxValue - minValue) + minValue;
        }
        return array;
    }
}