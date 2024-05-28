package org.kylin.bst;

/**
 * BST Binary Search Tree With Type
 */
public class BSTTreeNext<K extends Comparable<K>, V> {

    static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // root node
    BSTNode<K, V> root;

    /**
     * Find BSTNode by key
     * @param key key
     * @return BST Node
     */
    public V get(K key) {
        return getHelper(root, key);
    }

    public V getHelper(BSTNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int result = key.compareTo(node.key);

        if (result < 0) {
            return getHelper(node.left, key);
        } else if (result > 0) {
            return getHelper(node.right, key);
        } else {
            return node.value;
        }
    }

    public V getWithNoneRecursive(K key) {
        BSTNode<K, V> node = root;
        while (node != null) {
            int result = key.compareTo(node.key);
            if (result > 0) {
                node = node.right;
            } else if (result < 0) {
                node = node.left;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * Find min node
     * @param key key
     * @return min bst node
     */
    public V min() {
        return minHelper(root);
    }

    public V minHelper(BSTNode<K, V> node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.value;
        }

        return minHelper(node.left);
    }

    /**
     * Find bst min node with none recursive.
     * @return Min bst node
     */
    public V getMinWithNoneRecursive() {
        if (root == null) {
            return null;
        }

        BSTNode<K, V> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public V getMaxWithNodeRecursive() {
        if (root == null) {
            return null;
        }

        BSTNode<K, V> node = root;
        while(node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    public V max() {
        return maxHelper(root);
    }

    public V maxHelper(BSTNode<K, V> node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.value;
        }

        return maxHelper(node.right);
    }
















}
