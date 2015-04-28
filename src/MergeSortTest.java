import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by dianwen on 4/27/15.
 */
public class MergeSortTest {
    @Test
    public void testSorting() {
        int[] array = createRandomArray(32, 100, 0);

        System.out.println("Array before sorting: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Array after my sorting: ");
        int[] mySort = MergeSort.mergeSort(array);
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