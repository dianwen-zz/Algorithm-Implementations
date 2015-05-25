package test.java;

import main.resources.Heap;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static test.resources.Assertx.assertArrayEquals;

/**
 * Created by dianwen on 5/12/15.
 */
public class HeapTest {
    @Test
    public void testHeapBySorting() {
        int[] array = createRandomArray(25, 100, 0);
        Heap h = new Heap(array.length);
        for(int i : array) {
            h.insert(i);
        }
        int[] sortedArray = new int[array.length];
        Integer removed = h.remove();
        int i = 0;
        while(removed != null) {
            sortedArray[i] = removed;
            removed = h.remove();
            i++;
        }
        Arrays.sort(array);
        assertArrayEquals(array, sortedArray);
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
