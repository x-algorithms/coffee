package org.kylin.heap;

import org.kylin.array.Array;

/**
 * 用数组存储二叉堆
 * <pre>
 *                  52
 *               /      \
 *             39        41
 *           /   \      /  \
 *         29     15  27   14
 *       /  \    /
 *     18  16   14
 * </pre>
 *
 *  有以下特征：
 *   1. parent(index / 2)
 *   2. left child(index) = index * 2
 *   3. right child(index) = index * 2 + 1
 *
 *   下边方法中，index 从 0 开始，而不是 1，这个要注意！！！
 */
public class MaxHeap< E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {}

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 返回堆中元素个数
     * @return size
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回一个布尔值，表示堆是否为空
     * @return true or false
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个元素的父亲节点的索引
     * @param index 当前元素索引
     * @return 父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException(">> Index-0 element doesn't have parent...");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个元素的左孩子节点的索引
     * @param index 当前元素索引
     * @return 左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个元素的右孩子节点的索引
     * @param index 当前元素索引
     * @return 右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }




}
