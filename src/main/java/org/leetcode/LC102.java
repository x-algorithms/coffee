package org.leetcode;

import org.junit.Test;
import org.kylin.binarytree.TreeNode;
import org.kylin.utils.ColorfulPrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * <h1>102. 二叉树的层序遍历</h1>
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 */
public class LC102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int c1 = 1;

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }

        ColorfulPrintUtil.printlnMagenta(result.toString());
        return result;
    }

    @Test
    public void test() {
        /**
         *               1
         *              /  \
         *             2    5
         *            / \  / \
         *           3  4 6  7
         */
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(null, 3, null),
                        2,
                        new TreeNode(null, 4, null)),
                1,
                new TreeNode(
                        new TreeNode(null, 6, null),
                        5,
                        new TreeNode(null, 7, null)
                ));
        new LC102().levelOrder(root);
    }
}
