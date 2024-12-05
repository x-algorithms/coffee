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
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  39  41  29  15  27  14  18  16  14
 * </pre>
 *
 *  有以下特征：
 *   1. parent(index / 2)
 *   2. left child(index) = index * 2
 *   3. right child(index) = index * 2 + 1
 *   下边方法中，index 从 0 开始，而不是 1，这个要注意！！！
 *
 * <br /><br />
 * 1. 向堆中添加元素 48 Sift Up
 * <li>向堆中添加元素 48, 先添加到数组的最后，相当于放到完全二叉树的最后一个叶子结点上</li>
 * <li>此时并不满足堆的特征</li>
 * <li>开始进行 Sift Up 操作，元素上浮操作</li>
 *
 * <pre>
 *                  52
 *               /      \
 *             39        41
 *           /   \      /  \
 *         29     15  27   14
 *       /  \    /  \
 *     18  16   14  48
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  39  41  29  15  27  14  18  16  14  48(新添加)
 *
 *     a. 48 比 15 大，交换 15 和 48
 *                  52
 *               /      \
 *             39        41
 *           /   \      /  \
 *         29     48  27   14
 *       /  \    /  \
 *     18  16   14  15
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  39  41  29  48  27  14  18  16  14  15
 *
 *     b. 48 比 39 大，交换 48 和 39
 *                  52
 *               /      \
 *             48        41
 *           /   \      /  \
 *         29     39  27   14
 *       /  \    /  \
 *     18  16   14  15
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  48  41  29  39  27  14  18  16  14  15
 *
 *     c. 这个时候就符合堆的特征了，添加完成！
 * </pre>
 *
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

    /**
     * 向堆中添加元素
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 元素上浮操作
     * @param index 元素索引
     */
    private void siftUp(int index) {
        // 只要当前元素比父元素大，就交换，直到当前元素比父元素小，或者当前元素已经是根节点
        while(index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            // 交换当前元素和父元素的位置
            data.swap(index, parent(index));
            // 交换后，当前元素变成父元素，继续上浮
            index = parent(index);
        }
    }





}
