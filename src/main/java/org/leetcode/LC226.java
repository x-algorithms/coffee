package org.leetcode;
import org.kylin.binarytree.TreeNode;


/**
 *
 * <h1>226. Invert Binary Tree</h1>
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class LC226 {

    public TreeNode invertTree(TreeNode root) {
        Revert(root);
        return root;
    }

    public void Revert(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        Revert(node.left);
        Revert(node.right);
    }


}
