package org.kylin.bst;

/**
 * BST Binary Search Tree
 */
public class BSTTree {

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // root node
    BSTNode root;

    /**
     * Find BSTNode by key
     * @param key
     * @return BST Node
     */
    public Object get(int key) {
        return getHelper(root, key);
    }

    public Object getHelper(BSTNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return getHelper(node.left, key);
        } else if (key > node.key) {
            return getHelper(node.right, key);
        } else {
            return node.value;
        }
    }

    public Object getWithNoneRecursive(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }












}
