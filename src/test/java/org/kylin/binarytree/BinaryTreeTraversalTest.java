package org.kylin.binarytree;


import org.junit.Test;

public class BinaryTreeTraversalTest {
    /////////////////////////////
    //
    //           1
    //          / \
    //         2   3
    //        /   / \
    //       4   5   6
    //
    /////////////////////////////
    TreeNode root = new TreeNode(
            new TreeNode(new TreeNode(null, 4, null), 2, null),
            1,
            new TreeNode(new TreeNode(null, 5, null), 3, new TreeNode(null, 6, null)));

    @Test
    public void TestPreOrder() {
        BinaryTreeTraversal.preOrder(root);
    }

    @Test
    public void inOrder() {
        BinaryTreeTraversal.inOrder(root);
    }

    @Test
    public void postOrder() {
        BinaryTreeTraversal.postOrder(root);
    }
}