package org.kylin.sort;

import org.junit.Test;
import org.kylin.utils.ColorfulPrintUtil;

import java.util.Arrays;

/**
 * 选择排序：一般来说是从一组数据中选择最小或者最大的数据，跟指定位置的数据交换
 * https://zh.wikipedia.org/zh-cn/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        // 选择轮数一般是数组长度 arr.length - 1
        // 我们选择数组尾部当做交换的目标元素，每一轮向前移动交换目标元素
        for (int right = arr.length - 1; right > 0; right--) {
            int max = right;

            for (int i = 0; i < right; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }

            if (max != right) {
                swap(arr, max, right);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void TestSelectionSort() {
        int[] ant = {8, 3, 9, 7, 6, 5, 4, 1, 2};
        ColorfulPrintUtil.printlnMagenta(">>> " + Arrays.toString(ant));
        sort(ant);
        ColorfulPrintUtil.printlnGreen(">>> " + Arrays.toString(ant));
    }
}
