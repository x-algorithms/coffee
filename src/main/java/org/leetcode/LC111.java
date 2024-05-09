package org.leetcode;

import org.junit.Test;
import org.kylin.binarytree.TreeNode;
import org.kylin.utils.ColorfulPrintUtil;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * <h1>111. Minimum Depth of Binary Tree</h1>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */

public class LC111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (leftHeight == 0) {
            return rightHeight + 1;
        }

        if (rightHeight == 0) {
            return leftHeight + 1;
        }

        return Integer.min(leftHeight, rightHeight) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                ColorfulPrintUtil.printYellow(poll.val + "\t");
                if (poll.left == null && poll.right == null) {
                    return depth;
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            System.out.println();
            depth++;
        }

        return depth;
    }

    @Test
    public void Test11() {
        TreeNode root = new TreeNode(null, 1, new TreeNode(null, 2, null));
        int result = new LC111().minDepth(root);
        assertEquals(2, result);
    }

    @Test
    public void Test12() {
        TreeNode root = new TreeNode(new TreeNode(null, 9, null), 3, new TreeNode(new TreeNode(null, 15, null), 20,new TreeNode(null, 7, null)));
        int result = new LC111().minDepth(root);
        assertEquals(2, result);
    }


    @Test
    public void Test21() {
        TreeNode root = new TreeNode(null, 1, new TreeNode(null, 2, null));
        int result = new LC111().minDepth2(root);
        assertEquals(2, result);
    }

    @Test
    public void Test22() {
        TreeNode root = new TreeNode(new TreeNode(null, 9, null), 3, new TreeNode(new TreeNode(null, 15, null), 20,new TreeNode(null, 7, null)));
        int result = new LC111().minDepth2(root);
        assertEquals(2, result);
    }
}
