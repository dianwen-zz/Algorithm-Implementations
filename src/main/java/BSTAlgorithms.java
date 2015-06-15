package main.java;

import main.resources.BinarySearchTree;

import java.util.Arrays;


/**
 * Created by dianwen on 6/7/15.
 */
public class BSTAlgorithms {
    public static void createMinimalHeightBST(int[] sortedArray,  BinarySearchTree bst) {
        if(sortedArray.length == 0) {
            return;
        }

        bst.insert(sortedArray[sortedArray.length / 2]);

        if(sortedArray.length > 1) {
            int[] left = Arrays.copyOfRange(sortedArray, 0, sortedArray.length / 2);
            int[] right = Arrays.copyOfRange(sortedArray, sortedArray.length / 2 + 1, sortedArray.length);
            createMinimalHeightBST(left, bst);
            createMinimalHeightBST(right, bst);
        }
    }
}
