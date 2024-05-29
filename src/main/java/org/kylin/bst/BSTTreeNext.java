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
        // return maxHelper(root);
        return max(root);
    }

    public V max(BSTNode<K, V> node) {
        if (node == null) {
            return null;
        }

        BSTNode<K, V> p = node;
        while(p.right != null) {
            p = p.right;
        }
        return p.value;
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

    /**
     * Add new bst node to BSTTree.
     * @param key key
     * @param value value
     */
    public void Put(K key, V value) {
        BSTNode<K, V> node = root;
        BSTNode<K, V> parent = null;

        while (node != null) {
            parent = node;
            int result = key.compareTo(node.key);
            if (result > 0) {
                node = node.right;
            } else if (result < 0) {
                node = node.left;
            } else {
                node.value = value;
                return;
            }
        }

        // new bst node
        if (parent == null) {
            root = new BSTNode<>(key, value);
            return;
        }

        if (key.compareTo(parent.key) > 0) {
            parent.right = new BSTNode<>(key, value);
        } else if(key.compareTo(parent.key) < 0) {
            parent.left = new BSTNode<>(key, value);
        }
    }

    /**
     * Find bst node's predecessor
     * @param key current node key
     * @return predecessor node
     */
    public V predecessor(K key) {
        BSTNode<K, V> p = root;
        BSTNode<K, V> ancestorFromLeft = null;

        while (p != null) {
            int result = key.compareTo(p.key);
            if (result > 0) {
                ancestorFromLeft = p;
                p = p.right;
            } else if (result < 0){
                p = p.left;
            } else {
                break;
            }
        }

        // find no bst node
        if (p == null) {
            return null;
        }

        // case 1: 节点存在左子树，那么左子树最大值就是前任节点
        if (p.left != null) {
            return max(p.left);
        }

        // case 2: 节点没有左子树，祖先节点中从左侧过来的、相邻的节点就是前驱节点
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }













}
