package test.java;

import main.java.RandomizedSelection;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by dianwen on 5/12/15.
 */
public class RandomizedSelectionTest {
    @Test
    public void testSelection() {
        int[] array = createRandomArray(25, 100, 0);
        int orderStatistic = new Random().nextInt(25);
        int valueOfStatistic = RandomizedSelection.select(array, orderStatistic);
        Arrays.sort(array);
        assertEquals(array[orderStatistic], valueOfStatistic);

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
