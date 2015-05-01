/**
 * Created by dianwen on 4/28/15.
 */
public class CountInversions {
    public static int countInversionsAndMergeSort(int[] array) {
        if(array.length == 1) {
            return 0;
        }
        int[] leftHalf = new int[array.length/2];
        int[] rightHalf = new int[array.length - array.length/2]; // Account for odd length arrays
        for(int i = 0 ; i < array.length/2; i++) {
            leftHalf[i] = array[i];
        }
        for(int i = array.length/2; i < array.length; i++) {
            rightHalf[i - array.length/2] = array[i];
        }
        int leftInversions = countInversionsAndMergeSort(leftHalf);
        int rightInversions = countInversionsAndMergeSort(rightHalf);
        int splitInversions = countSplitInversionsAndMerge(leftHalf, rightHalf, array);
        return leftInversions + rightInversions + splitInversions;
    }

    private static int countSplitInversionsAndMerge(int[] leftHalf, int[] rightHalf, int[] result) {
        int i = 0;
        int j = 0;
        int inversions = 0;
        int totalSize = leftHalf.length + rightHalf.length;
        for(int k = 0; k < totalSize; k++) {
            if(i < leftHalf.length && j < rightHalf.length) {
                if(leftHalf[i] <= rightHalf[j]) {
                    result[k] = leftHalf[i];
                    i++;
                }
                else {
                    result[k] = rightHalf[j];
                    j++;
                    inversions += leftHalf.length - i;
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
        return inversions;
    }

    public static int bruteForceCountInversions(int[] array) {
        int inversions = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
}
