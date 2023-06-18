package com.ontotext.javacourse.objects.homogeneoustree;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomogeneousTreeTest {

  private static HomogeneousTree<Integer> TREE = new HomogeneousTree<>();

  @BeforeEach
  void setUp() {
    TREE = new HomogeneousTree<>();
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
    HomogeneousTree<Integer> emptyTree = new HomogeneousTree<>();
    Node<Integer> node = new Node<>(10);
    emptyTree.insert(node);
    assertEquals(emptyTree.search(node), node);
  }

  @Test
  void insertCreatesNewNodeInTree() {
    Node<Integer> node = new Node<>(8);
    TREE.insert(node);
    assertEquals(TREE.search(node), node);
  }

  @Test
  void insertThrowsExceptionIfElementIsAlreadyPresentInTheTree() {
    assertThrows(InvalidParameterException.class, () -> TREE.insert(new Node<>(18)));
  }

  @Test
  void searchReturnsNullIfElementIsNotInTheTree() {
    assertNull(TREE.search(new Node<>(100)));
  }

  @Test
  void searchReturnsElementIfItIsPresentInTheTree() {
    Node<Integer> element = new Node<>(16);
    assertEquals(element, TREE.search(element));
  }
}
