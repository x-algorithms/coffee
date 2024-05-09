package org.kylin.binarytree;

import org.kylin.utils.ColorfulPrintUtil;

import java.util.Stack;

public class CommonBinaryTreeTraversal {

    public static void traversal(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pop = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                ColorfulPrintUtil.printRed("preorder: " + curr.val);
                curr = curr.left;
            } else {
                TreeNode peekElement = stack.peek();
                // no right sub child
                if (peekElement.right == null) {
                    ColorfulPrintUtil.printMagenta("inorder:" + peekElement.val);
                    pop = stack.pop();
                    ColorfulPrintUtil.printGreen("postorder:" + pop.val);
                } else if (peekElement.right == pop) {
                    // right sub child done
                    pop = stack.pop();
                    ColorfulPrintUtil.printGreen("postorder:" + pop.val);
                } else {
                    // process right sub child
                    ColorfulPrintUtil.printMagenta("inorder:" + peekElement.val);
                    curr = peekElement.right;
                }
            }
        }
    }
}
