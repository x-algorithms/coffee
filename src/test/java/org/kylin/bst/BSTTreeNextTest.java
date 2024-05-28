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
    public BSTTree create() {
        BSTTree.BSTNode n1 = new BSTTree.BSTNode(1, "宋江");
        BSTTree.BSTNode n3 = new BSTTree.BSTNode(3, "入云龙");
        BSTTree.BSTNode n2 = new BSTTree.BSTNode(2, "玉麒麟", n1, n3);

        BSTTree.BSTNode n5 = new BSTTree.BSTNode(5, "阮小五");
        BSTTree.BSTNode n7 = new BSTTree.BSTNode(7, "阮小七");
        BSTTree.BSTNode n6 = new BSTTree.BSTNode(6, "林冲", n5, n7);

        BSTTree.BSTNode root = new BSTTree.BSTNode(4, "呼延灼", n2, n6);

        BSTTree tree = new BSTTree();
        tree.root = root;
        return tree;
    }

    @Test
    void get() {
        BSTTree tree = create();
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
        BSTTree tree = create();
        assertEquals("宋江", tree.getWithNoneRecursive(1));
        assertEquals("玉麒麟", tree.getWithNoneRecursive(2));
        assertEquals("入云龙", tree.getWithNoneRecursive(3));
        assertEquals("呼延灼", tree.getWithNoneRecursive(4));
        assertEquals("阮小五", tree.getWithNoneRecursive(5));
        assertEquals("林冲", tree.getWithNoneRecursive(6));
        assertEquals(null, tree.getWithNoneRecursive(8));
    }
}