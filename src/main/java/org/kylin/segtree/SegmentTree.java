package org.kylin.segtree;

/**
 * <pre>
 * 什么是线段树?
 *                                      A[0,9]
 *                           /                       \
 *                      A[0,4]                       A[5,9]
 *                     /        \                 /          \
 *                 A[0,2]      A[3,4]         A[5,7]        A[8,9]
 *                /     \      /    \         /    \        /    \
 *           A[0,1]    A[2]  A[3]  A[4]    A[5,6] A[7]    A[8]  A[9]
 *          /     \                         /    \
 *       A[0]    A[1]                    A[5]   A[6]
 *  1. 线段树特征
 *  * 线段树不是完全二叉树
 *  * 线段树是平衡二叉树
 *  * 线段树依旧可以用数组来表示
 *    > 如果用数组来表示那么大概需要多少空间呢
 *    > 对于满二叉树，h层，有 2^h - 1 个结点, 最后一层 h - 1 层有 2^(h-1) 个结点
 *    > 最后一层的节点数约等于前面所有层的节点数之和，即 2^(h-1) <= 2^h - 1
 *    > 总共大概需要 4n 个空间
 *
 *  2. 线段树和数组的效率对比
 *
 *           数组         线段树
 *   更新    O(N)        O(logN)
 *   查询    O(N)        O(logN)
 * </pre>
 *
 */

public class SegmentTree<E> {

    private E[] data;

    // 把线段树看成了完全二叉树
    // 那么 tree 数组的大小为 4 * n
    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[])new Object[arr.length];

        // System.arraycopy(arr, 0, data, 0, data.length);
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // init segment tree
        tree = (E[])new Object[4 * arr.length];

        build(0, 0, data.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException(">>> Index is out of bound...");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param idx 索引
     * @return 左孩子节点的索引
     */
    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param idx 索引
     * @return 右孩子节点的索引
     */
    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    /**
     * 构建线段树
     * @param treeIndex 从这个索引开始构建线段树
     * @param left 左边界索引
     * @param right 右边界索引
     */
    private void build(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIdx = leftChild(treeIndex);
        int rightTreeIdx = rightChild(treeIndex);
        int mid = left + (right - left) / 2;
        build(leftTreeIdx, left, mid);
        build(rightTreeIdx, mid + 1, right);

        // 融合
        tree[treeIndex] = merger.merge(tree[leftTreeIdx], tree[rightTreeIdx]);
    }

    /**
     * 线段树区间查询
     * @param queryLeft 要查询的左边界索引
     * @param queryRight 要查询的右边界索引
     * @return 线段树查询范围结果
     */
    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= data.length ||
                queryRight < 0 || queryRight >= data.length ||
                queryLeft > queryRight) {
            throw new IllegalArgumentException(">>> Index is out of bound...");
        }

        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    private E query(int treeIdx, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            return tree[treeIdx];
        }

        int mid = left + (right - left) / 2;
        int leftTreeIdx = leftChild(treeIdx);
        int rightTreeIdx = rightChild(treeIdx);

        if (queryLeft >= mid + 1) {
            return query(rightTreeIdx, mid + 1, right, queryLeft, queryRight);
        } else if (queryRight <= mid) {
            return query(leftTreeIdx, left, mid, queryLeft, queryRight);
        }

        // 跨越两个区间
        E leftResult = query(leftTreeIdx, left, mid, queryLeft, mid);
        E rightResult = query(rightTreeIdx, mid + 1, right, mid + 1, queryRight);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * 线段树更新
     * @param index 要更新的索引
     * @param e 要更新的值
     */
    public void set(int index, E e) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException(">>> Index is out of bound...");
        }

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIdx, int left, int right, int index, E e) {
        if (left == right) {
            tree[treeIdx] = e;
            return;
        }

        int mid = left + (right - left) / 2;
        int leftTreeIdx = leftChild(treeIdx);
        int rightTreeIdx = rightChild(treeIdx);

        if (index >= mid + 1) {
            set(rightTreeIdx, mid + 1, right, index, e);
        } else if (index <= mid) {
            set(leftTreeIdx, left, mid, index, e);
        }

        tree[treeIdx] = merger.merge(tree[leftTreeIdx], tree[rightTreeIdx]);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int idx = 0; idx < tree.length; idx++) {
            if (tree[idx] != null) {
                sb.append(tree[idx]);
            } else {
                sb.append("null");
            }

            if (idx != tree.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }



}
