package org.kylin.binarytree;

import org.kylin.utils.ColorfulPrintUtil;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeNotRecursive {

    public static void preOrder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                ColorfulPrintUtil.printCyan("front: " + cur.val + "\t");
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                ColorfulPrintUtil.printRed("back: " + pop.val + "\t");
                cur = pop.right;
            }

        }
    }

    public static void inOrder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // ColorfulPrintUtil.printCyan("head: " + cur.val + "\t");
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                ColorfulPrintUtil.printRed("back: " + pop.val + "\t");
                cur = pop.right;
            }
        }
    }

    public static void postOrder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pop = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // that means left tree is processed.
                // stack peek element
                TreeNode peekElement = stack.peek();
                if (peekElement.right == null || peekElement.right == pop) {
                   pop = stack.pop();
                   ColorfulPrintUtil.printYellow("back: " + pop.val + "");
                } else {
                    cur = peekElement.right;
                }
            }
        }

    }
}
