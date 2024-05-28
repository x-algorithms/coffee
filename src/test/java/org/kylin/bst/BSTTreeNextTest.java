package org.kylin.bst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BSTTreeNextTest {

    /**
     *                4
     *              /  \
     *             2    6
     *           / \   / \
     *          1  3  5   7
     *
     */
    public BSTTreeNext create() {
        BSTTreeNext.BSTNode n1 = new BSTTreeNext.BSTNode(1, "宋江");
        BSTTreeNext.BSTNode n3 = new BSTTreeNext.BSTNode(3, "入云龙");
        BSTTreeNext.BSTNode n2 = new BSTTreeNext.BSTNode(2, "玉麒麟", n1, n3);

        BSTTreeNext.BSTNode n5 = new BSTTreeNext.BSTNode(5, "阮小五");
        BSTTreeNext.BSTNode n7 = new BSTTreeNext.BSTNode(7, "阮小七");
        BSTTreeNext.BSTNode n6 = new BSTTreeNext.BSTNode(6, "林冲", n5, n7);

        BSTTreeNext.BSTNode root = new BSTTreeNext.BSTNode(4, "呼延灼", n2, n6);

        BSTTreeNext tree = new BSTTreeNext();
        tree.root = root;
        return tree;
    }

    @Test
    void get() {
        BSTTreeNext tree = create();
        assertEquals("宋江", tree.get(1));
        assertEquals("玉麒麟", tree.get(2));
        assertEquals("入云龙", tree.get(3));
        assertEquals("呼延灼", tree.get(4));
        assertEquals("阮小五", tree.get(5));
        assertEquals("林冲", tree.get(6));
        assertEquals(null, tree.get(8));
    }

    @Test
    void getWithNoneRecursive() {
        BSTTreeNext tree = create();
        assertEquals("宋江", tree.getWithNoneRecursive(1));
        assertEquals("玉麒麟", tree.getWithNoneRecursive(2));
        assertEquals("入云龙", tree.getWithNoneRecursive(3));
        assertEquals("呼延灼", tree.getWithNoneRecursive(4));
        assertEquals("阮小五", tree.getWithNoneRecursive(5));
        assertEquals("林冲", tree.getWithNoneRecursive(6));
        assertEquals(null, tree.getWithNoneRecursive(8));
    }

    @Test
    void TestGetMin() {
        BSTTreeNext tree = create();
        assertEquals("宋江", tree.min());
    }

    @Test
    void getMax() {
        BSTTreeNext tree = create();
        assertEquals("阮小七", tree.max());
    }
}

