package test.java;

import main.java.MergeSort;
import main.java.QuickSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by dianwen on 5/12/15.
 */
public class QuickSortTest {
    @Test
    public void testSorting() {
        int[] array = createRandomArray(25, 100, 0);
        System.out.println("Array before sorting: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Array after my sorting: ");
        int[] mySort = QuickSort.quickSort(array);
        System.out.println(Arrays.toString(mySort));

        Arrays.sort(array);
        assertArrayEquals(array, mySort);
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
