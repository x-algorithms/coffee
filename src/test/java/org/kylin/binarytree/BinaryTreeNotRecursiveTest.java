package org.kylin.binarytree;

import junit.framework.TestCase;

public class BinaryTreeNotRecursiveTest extends TestCase {

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

    public void testPreOrder() {
        BinaryTreeNotRecursive.preOrder(root);
    }

    public void testInOrder() {
        BinaryTreeNotRecursive.inOrder(root);
    }

    public void testPostOrder() {
        BinaryTreeNotRecursive.postOrder(root);
    }
}