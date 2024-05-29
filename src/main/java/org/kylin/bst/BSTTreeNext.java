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
        // return minHelper(root);
        return min(root);
    }
    public V min(BSTNode<K, V> node) {
        if (node == null) {
            return null;
        }

        BSTNode<K, V> p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
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

    /**
     * Find bst node's successor
     * @param key bst node key
     * @return min bst node
     */
    public V successor(K key) {
        BSTNode<K, V> p = root;
        BSTNode<K, V> ancestorFromRight = null;

        while (p != null) {
            int result = key.compareTo(p.key);
            if (result > 0) {
                p = p.right;
            } else if (result < 0){
                ancestorFromRight = p;
                p = p.left;
            } else {
                break;
            }
        }

        // find no bst node
        if (p == null) {
            return null;
        }

        // case 1: 节点存在右子树，那么右子树最小值就是前任节点
        if (p.right != null) {
            return min(p.right);
        }

        // case 2: 节点没有右子树，祖先节点中从右侧过来的、相邻的节点就是前驱节点
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    /**
     * Delete node from bst
     * case 1: delete node has no left child,
     *                   2
     *                     \
     *                      3(deleted)
     *                       \
     *                        4
     *                       /
     *                     5
     *
     * case 2: delete node has no right child
     *                   2
     *                  /
     *                 3(deleted)
     *                /
     *               4
     *                \
     *                 5
     *
     * case 3: delete node has left and right child
     *      3.1        7
     *               /
     *              4 (deleted)
     *             / \
     *            2   5
     *           / \   \
     *          1   3   6
     *
     *      3.2
     *                  4(deleted)
     *                /   \
     *               2     8
     *             / \    / \
     *            1   3  7   9
     *                  /
     *                 5
     *                  \
     *                   6
     *
     * @param key node's key
     * @return node's value
     */
    public V delete(K key) {
        BSTNode<K, V> p = root;
        BSTNode<K, V> parent = null;
        while (p != null) {
            int result = key.compareTo(p.key);
            if (result > 0) {
                parent = p;
                p = p.right;
            } else if(result < 0) {
                parent = p;
                p = p.left;
            } else {
                break;
            }
        }

        // target node doesn't exist
        if (p == null) {
            return null;
        }

        if (p.left == null) {
            // case 1
            shift(parent, p, p.right);
        } else if (p.right == null) {
            // case 2
            shift(parent, p, p.left);
        } else {
            // case 3:
            // find bst successor node
            BSTNode<K, V> s = p.right;
            BSTNode<K, V> sParent = p;
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }

            // if successor not the deleted node's neighbor
            if (sParent != p) {
                shift(sParent, s, s.right);
                s.right = p.right;
            }

            // successor node replace the deleted node
            shift(parent, p, s);
            s.left = p.left;
        }

        return p.value;
    }


    /**
     * <h1>Don't ask me why use if if and if, why not use if...else if </h1>
     * <br /><h2>I don't know...</h2>
     * <br /><strong>Fucking why...</strong>
     *
     * @param parent
     * @param deleted
     * @param child
     */
    public void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        }

        if (deleted == parent.left) {
            parent.left = child;
        }

        if (deleted == parent.right) {
            parent.right = child;
        }
    }












}
