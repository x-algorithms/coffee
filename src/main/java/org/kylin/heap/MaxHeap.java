package org.kylin.heap;

import org.kylin.array.Array;

import java.util.Random;

/**
 * 用数组存储二叉堆
 * <pre>
 *                  52
 *               /      \
 *             39        41
 *           /   \      /  \
 *         29     15  27   12
 *       /  \    /
 *     18  16   14
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  39  41  29  15  27  12  18  16  14
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
 *         29     15  27   12
 *       /  \    /  \
 *     18  16   14  48
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  39  41  29  15  27  12  18  16  14  48(新添加)
 *
 *     a. 48 比 15 大，交换 15 和 48
 *                  52
 *               /      \
 *             39        41
 *           /   \      /  \
 *         29     48  27   12
 *       /  \    /  \
 *     18  16   14  15
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  39  41  29  48  27  12  18  16  14  15
 *
 *     b. 48 比 39 大，交换 48 和 39
 *                  52
 *               /      \
 *             48        41
 *           /   \      /  \
 *         29     39  27   12
 *       /  \    /  \
 *     18  16   14  15
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     52  48  41  29  39  27  12  18  16  14  15
 *
 *     c. 这个时候就符合堆的特征了，添加完成！
 * <br><br>
 * 2. 从堆中删除元素 Sift Down
 * <li>相当于从堆顶删除元素 52，如果直接删除 52 那么形成的两个左右子树融合成一个堆相对比较复杂</li>
 * <li>一般我们先交换 52 和数组最后一个元素 15，最后删除数组末尾元素 52</li>
 * <li>然后进行 Sift Down 操作，元素下沉操作</li>
 *
 *    a. 交换 52 和 15, 然后删除 52
 *                  15
 *               /      \
 *             48        41
 *           /   \      /  \
 *         29     39  27   12
 *       /  \    /
 *     18  16   14
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     15  48  41  29  39  27  12  18  16  14
 *
 *     b. 15 比 48 和 41 都大，交换 15 和 48
 *                  48
 *               /      \
 *             15        41
 *           /   \      /  \
 *         29     39  27   12
 *       /  \    /
 *     18  16  14
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     48  15  41  29  39  27  12  18  16  14
 *
 *     c. 15 比 39 和 29 都大，交换 15 和 39
 *                  48
 *               /      \
 *             39        41
 *           /   \      /  \
 *         29     15  27   12
 *       /  \    /
 *     18  16  14
 *
 *     0   1    2   3   4   5   6   7   8   9  10  11  12
 *     ----------------------------------------
 *     48  39  41  29  15  27  12  18  16  14
 *
 *     d. 15 比 14 大调整结束！
 * </pre>
 *
 */
public class MaxHeap< E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

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
     * 获取堆中最大元素
     * @return 最大元素
     */
    public E getMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException(">>> Heap is empty...");
        }
        return data.get(0);
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

    /**
     * 取出堆中最大元素
     * @return 当前堆中最大元素
     */
    public E extractMax() {
        E res = getMax();
        // 交换第一个元素和最后一个元素
        data.swap(0, data.getSize() - 1);

        // 删除最后一个元素
        data.deleteLast();

        // 元素下沉操作
        siftDown(0);
        return res;
    }

    private void siftDown(int index) {
        // 左子树的节点和右子树节点相差一
        // 那么只有当左子树节点小于数组大小才能保证循环操作执行下去
        while(leftChild(index) < data.getSize()) {
            // 先找到左右孩子中较大的那个
            int j = leftChild(index);

            // 右子树比左子树大，反之左子树大于右子树
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(index);
            }

            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(index, j);
            index = j;
        }
    }

    public static void main(String[] args) {
        TestCreateBigHeap();
    }

    /**
     * 这个测试本身比较消耗空间
     * 1. 先创建一个大顶堆，一个个元素放进去
     * 2. 一个个元素取出来进行排序，放到一个数组中
     * 3. 效率太低了...
     */
    private static void TestCreateBigHeap() {
        int count = 1000000;
        MaxHeap<Integer> bigHeap = new MaxHeap<>();
        Random random = new Random();
        for (int idx = 0; idx < count; idx++) {
            bigHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[count];
        for (int idx = 0; idx < count; idx++) {
            arr[idx] = bigHeap.extractMax();
        }

        for (int i = 1; i < count; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException(">>> Error...");
            }
        }
        System.out.println(">>> Test Heap Success...");
    }


}
