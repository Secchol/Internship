package com.ontotext.javacourse.objects.homogeneoustree;

/**
 * The Node class defines a node. Each node has a value of a specified type and points to two other
 * nodes leftChild and right child.
 *
 * @param <T>
 */
public class Node<T> {
  private T value;
  private Node<T> leftChild;
  private Node<T> rightChild;

  public Node(T value) {
    setValue(value);
    setLeftChild(null);
    setRightChild(null);
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node<T> leftChild) {
    this.leftChild = leftChild;
  }

  public Node<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node<T> rightChild) {
    this.rightChild = rightChild;
  }
}
