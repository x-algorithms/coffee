package org.leetcode;

import org.junit.Test;
import org.kylin.binarytree.TreeNode;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * <h1>104. Maximum Depth of Binary Tree</h1>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * left child traversal -> right child traversal -> post order traversal
 */
public class LC104 {

    /**
     * Recursive of binary tree
     * @param root
     * @return max depth of binary tree
     */
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

    /**
     * Using postorder traversal
     * @param root
     * @return max depth of binary tree
     */
    public int maxDepth2(TreeNode root) {
        TreeNode curr = root;
        TreeNode pop = null;
        Stack<TreeNode> stack = new Stack<>();
        int max = 0;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (max < size) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }

    @Test
    public void Test1() {
        TreeNode root = new TreeNode(null, 1, new TreeNode(null, 2, null));
        int result = new LC104().maxDepth(root);
        assertEquals(2, result);
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

    @Test
    public void Test21() {
        TreeNode root = new TreeNode(null, 1, new TreeNode(null, 2, null));
        int result = new LC104().maxDepth2(root);
        assertEquals(2, result);
    }

    @Test
    public void Test22() {
        TreeNode root = new TreeNode(new TreeNode(null, 2, null), 1, null);
        int result = new LC104().maxDepth2(root);
        assertEquals(2, result);
    }

    @Test
    public void Test23() {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(null, 3, null), 2, null), 1, null);
        int result = new LC104().maxDepth2(root);
        assertEquals(3, result);
    }
}
