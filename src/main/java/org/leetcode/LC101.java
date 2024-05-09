package org.leetcode;

import org.junit.Test;
import org.kylin.binarytree.TreeNode;

/**
 * <h1>101. Symmetric Tree</h1>
 * https://leetcode.com/problems/symmetric-tree/
 */

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);
    }

    @Test
    public void TestSymmetric() {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(null, 3, null),
                        2,
                        new TreeNode(null, 4, null)),
                1,
                new TreeNode(
                        new TreeNode(null, 4, null),
                        2,
                        new TreeNode(null, 3, null)
                ));
        new LC101().isSymmetric(root);
    }
}
