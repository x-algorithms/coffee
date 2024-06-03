package org.kylin.queue;

public interface Queue<E> {

    /**
     * 添加元素到队尾
     * @param value 添加元素
     * @return 成功true、失败false
     */
    boolean offer(E value);

    /**
     * 获取对头的元素，并且移除
     * @return 对头元素
     */
    E poll();

    /**
     * 获取对头元素，但是不移除
     * @return 队头元素
     */
    E peek();

    /**
     * 判断队列是否为空
     * @return 空返回true 否则返回false
     */
    boolean isEmpty();

    /**
     * 队列是否已经满了
     * @return 满 true / false
     */
    boolean isFull();
}
