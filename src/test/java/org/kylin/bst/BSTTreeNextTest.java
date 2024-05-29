package org.kylin.bst;

import org.junit.jupiter.api.Test;
import org.kylin.utils.ColorfulPrintUtil;
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
    public static BSTTreeNext create() {
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

    static boolean isSameTree(BSTTreeNext.BSTNode p, BSTTreeNext.BSTNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void preOrder(BSTTreeNext.BSTNode root) {
        if (root == null) {
            return;
        }
        ColorfulPrintUtil.printMagenta(root.value + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Test
    void TestPut() {
        BSTTreeNext tree = new BSTTreeNext();
        tree.Put(4, "呼延灼");
        tree.Put(2, "玉麒麟");
        tree.Put(6, "林冲");
        tree.Put(1, "宋江");
        tree.Put(3, "入云龙");
        tree.Put(7, "阮小七");
        tree.Put(5, "阮小五");
        preOrder(tree.root);
        assertTrue(isSameTree(create().root, tree.root));

        System.out.println();

        tree.Put(1, "鲁智深");
        assertEquals("鲁智深", tree.get(1));
        preOrder(tree.root);
    }

    @Test
    void TestPredecessor() {
        BSTTreeNext tree = create();
        assertEquals("呼延灼", tree.predecessor(5));
        assertEquals("林冲", tree.predecessor(7));
        assertEquals(null, tree.predecessor(1));
        assertEquals("宋江", tree.predecessor(2));
    }
}

