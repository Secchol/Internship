package com.ontotext.javacourse.objects.homogeneoustree;

import lombok.Getter;
import lombok.Setter;

/**
 * The Node class defines a node. Each node has a value of a specified type and points to two other
 * nodes leftChild and right child.
 *
 * @param <T>
 */
@Getter
@Setter
public class Node<T> {
  private T value;
  private Node<T> leftChild;
  private Node<T> rightChild;

  public Node(T value) {
    setValue(value);
    setLeftChild(null);
    setRightChild(null);
  }
}
