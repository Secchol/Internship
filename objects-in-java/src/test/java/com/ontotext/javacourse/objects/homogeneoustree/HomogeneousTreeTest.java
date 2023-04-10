package com.ontotext.javacourse.objects.homogeneoustree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HomogeneousTreeTest {

    private static HomogeneousTree<Integer> TREE = new HomogeneousTree<Integer>();

    @BeforeEach
    void setUp() {
        TREE = new HomogeneousTree<Integer>();
        Node<Integer> first = new Node<>(12);
        Node<Integer> second = new Node<>(10);
        Node<Integer> third = new Node<>(16);
        Node<Integer> fourth = new Node<>(18);
        Node<Integer> fifth = new Node<>(15);
        Node<Integer> sixth = new Node<>(11);
        Node<Integer> seventh = new Node<>(9);
        TREE.insert(first);
        TREE.insert(second);
        TREE.insert(third);
        TREE.insert(fourth);
        TREE.insert(fifth);
        TREE.insert(sixth);
        TREE.insert(seventh);
    }

    @Test
    void insertCreatesRootIfTreeHasNoElements() {
        HomogeneousTree<Integer> emptyTree = new HomogeneousTree<Integer>();
        Node<Integer> node = new Node<Integer>(10);
        emptyTree.insert(node);
        assertEquals(emptyTree.search(node), node);
    }

    @Test
    void insertCreatesNewNodeInTree() {
        Node<Integer> node = new Node<Integer>(8);
        TREE.insert(node);
        assertEquals(TREE.search(node), node);
    }

    @Test
    void insertThrowsExceptionIfElementIsAlreadyPresentInTheTree() {
        assertThrows(InvalidParameterException.class, () -> TREE.insert(new Node<Integer>(18)));
    }

    @Test
    void searchReturnsNullIfElementIsNotInTheTree() {
        assertEquals(null, TREE.search(new Node<Integer>(100)));
    }

    @Test
    void searchReturnsElementIfItIsPresentInTheTree() {
        Node<Integer> element = new Node<>(16);
        assertEquals(element, TREE.search(element));
    }
}