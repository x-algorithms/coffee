package org.kylin.segtree;

/**
 * 自定义融合器
 * 用户自定义融合规则
 * @param <E>
 */
public interface Merger<E> {
    E merge(E ant, E bear);
}
