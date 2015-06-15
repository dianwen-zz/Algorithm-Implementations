package test.java;

import main.java.BSTAlgorithms;
import main.resources.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dianwen on 6/7/15.
 */
public class BSTTest {
    @Test
    public void testIsTreeBalanced() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(4);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);
        assertEquals(true, BinarySearchTree.isTreeBalanced(bst.getRoot()));
        bst.insert(9);
        assertEquals(false, BinarySearchTree.isTreeBalanced(bst.getRoot()));
    }

    @Test
    public void testCreateMinimalHeightBST() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BSTAlgorithms.createMinimalHeightBST(sortedArray, bst);
        String preOrderResult = BinarySearchTree.printPreOrder(bst.getRoot(), new StringBuilder());
        assertEquals("7, 4, 2, 1, 3, 6, 5, 10, 9, 8, 12, 11, ", preOrderResult);
    }
}
