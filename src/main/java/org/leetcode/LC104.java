package org.leetcode;

import org.junit.Test;
import org.kylin.binarytree.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * <h1>104. Maximum Depth of Binary Tree</h1>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * left child traversal -> right child traversal -> post order traversal
 */
public class LC104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Integer.max(leftHeight, rightHeight) + 1;
    }

    @Test
    public void Test1() {
        TreeNode root = new TreeNode(null, 1, null);
        int result = new LC104().maxDepth(root);
        assertEquals(1, result);
    }

    @Test
    public void Test2() {
        TreeNode root = new TreeNode(new TreeNode(null, 2, null), 1, null);
        int result = new LC104().maxDepth(root);
        assertEquals(2, result);
    }

    @Test
    public void Test3() {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(null, 3, null), 2, null), 1, null);
        int result = new LC104().maxDepth(root);
        assertEquals(3, result);
    }
}
