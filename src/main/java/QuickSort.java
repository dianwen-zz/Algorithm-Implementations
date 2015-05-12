package main.java;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by dianwen on 4/27/15.
 */
public class QuickSort {
    public static int[] quickSort(int[] array) {
        if(array.length == 0) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }

        Random r = new Random();
        int pivotIndex = r.nextInt(array.length);
        partition(array, pivotIndex);

        int[] leftPartition = new int[pivotIndex];
        int[] rightParition = new int[array.length - pivotIndex];
        for(int i = 0 ; i < pivotIndex; i++) {
            leftPartition[i] = array[i];
        }
        for(int i = pivotIndex; i < array.length; i++) {
            rightParition[i - pivotIndex] = array[i];
        }

        leftPartition = quickSort(leftPartition);
        rightParition = quickSort(rightParition);

        int[] sorted = new int[array.length];
        for(int i = 0; i < leftPartition.length; i++) {
            sorted[i] = leftPartition[i];
        }
        for(int i = leftPartition.length; i < array.length; i++) {
            sorted[i] = rightParition[i - leftPartition.length];
        }

        return sorted;
    }

    public static void partition(int[] array, int pivotIndex) {
        //Swap pivot with first element before moving elements around the pivot
        int pivotValue = array[pivotIndex];
        array[pivotIndex] = array[0];
        array[0] = pivotValue;

        //Partition
        int boundary = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < pivotValue) {
                int temp = array[boundary];
                array[boundary] = array[i];
                array[i] = temp;
                boundary++;
            }
        }

        //Swap the pivot into the correct location
        array[0] = array[boundary - 1];
        array[boundary - 1] = pivotValue;

    }
}
