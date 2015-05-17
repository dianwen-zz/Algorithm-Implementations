package main.java;

import java.util.Random;

/**
 * Created by dianwen on 4/27/15.
 */
public class RandomizedSelection {
    public static int select(int[] array, int orderStatistic) {
        if (array.length == 1) {
            return array[0];
        }

        Random r = new Random();
        int pivotIndex = r.nextInt(array.length);
        pivotIndex = partition(array, pivotIndex);

        if(pivotIndex == orderStatistic) {
            return array[pivotIndex];
        }
        if(pivotIndex > orderStatistic) {
            int[] leftPartition = new int[pivotIndex];
            for(int i = 0 ; i < pivotIndex; i++) {
                leftPartition[i] = array[i];
            }
            return select(leftPartition, orderStatistic);
        }
        else{ // pivotIndex < orderStatistic
            int[] rightParition = new int[array.length - pivotIndex-1];
            for(int i = pivotIndex + 1; i < array.length; i++) {
                rightParition[i - pivotIndex - 1] = array[i];
            }
            return select(rightParition, orderStatistic - pivotIndex - 1);
        }
    }

    public static int partition(int[] array, int pivotIndex) {
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

        return boundary - 1;
    }
}
