import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by dianwen on 4/27/15.
 */
public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if(array.length == 1) {
            return array;
        }
        int[] leftHalf = new int[array.length/2];
        int[] rightHalf = new int[array.length - array.length/2]; // Account for odd length arrays
        for(int i = 0 ; i < array.length/2; i++) {
            leftHalf[i] = array[i];
        }
        for(int i = array.length/2; i < array.length; i++) {
            rightHalf[i - array.length/2] = array[i];
        }
        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private static int[] merge(int[] leftHalf, int[] rightHalf) {
        int i = 0;
        int j = 0;
        int totalSize = leftHalf.length + rightHalf.length;
        int[] result = new int[totalSize];
        for(int k = 0; k < totalSize; k++) {
            if(i < leftHalf.length && j < rightHalf.length) {
                if(leftHalf[i] < rightHalf[j]) {
                    result[k] = leftHalf[i];
                    i++;
                }
                else {
                    result[k] = rightHalf[j];
                    j++;
                }
            }
            else if(i >= leftHalf.length) {
                result[k] = rightHalf[j];
                j++;
            }
            else {
                result[k] = leftHalf[i];
                i++;
            }
        }
        return result;
    }
}
