package org.kylin.array;

import org.kylin.utils.ColorfulPrintUtil;

/**
 * <b>工具类</b>
 * 对数组的二次封装
 */

public class Array<E> {
    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(E[] arr) {
        data = (E[])new Object[arr.length];
        for (int idx = 0; idx < arr.length; idx++) {
            data[idx] = arr[idx];
        }
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E e) {
        for (int idx = 0; idx < size; idx++) {
            if (data[idx].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int idx = 0; idx < size; idx++) {
            if (data[idx].equals(e)) {
                return idx;
            }
        }
        return -1;
    }

    public void add(int index, E e) {
        if (size == data.length) {
            // dynamic resize
            resize();
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException(">>> Param out of range...");
        }

        // 当然还有更高效的算法
        // 插入位置元素和尾部元素互换
        for (int idx = size - 1; idx >= index; idx--) {
            data[idx + 1] = data[idx];
        }
        data[index] = e;
        size++;
    }

    private void resize() {
        E[] newData = (E[])new Object[data.length * 2];
        for (int idx = 0; idx < size; idx++) {
            newData[idx] = data[idx];
        }
        data = newData;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(">>> Param out of range...");
        }
        return data[index];
    }

    public E delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(">>> Param out of range...");
        }
        E res = data[index];
        for (int idx = index + 1; idx < size; idx++) {
            data[idx - 1] = data[idx];
        }
        size--;
        return res;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    public void deleteElement(E e) {
        int idx = find(e);
        if (idx != -1) {
            delete(idx);
        }
    }

    public void set(int index, E e) {
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Array: size = %d \t capacity = %d\n", size, getCapacity()));
        sb.append("[");
        for (int idx = 0; idx < size; idx++) {
            sb.append(data[idx]);
            if (idx != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    /**
     * 交换数组中两个元素的位置
     * @param i 索引 i
     * @param j 索引 j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException(">>> Param out of range...");
        }

        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        ColorfulPrintUtil.printBlue(arr.toString());

        for (int idx = 0; idx < 12; idx++) {
            if (idx % 2 == 0) {
                arr.addFirst(idx);
            } else {
                arr.addLast(idx);
            }
        }
        ColorfulPrintUtil.printGreen(arr.toString());
    }


}
