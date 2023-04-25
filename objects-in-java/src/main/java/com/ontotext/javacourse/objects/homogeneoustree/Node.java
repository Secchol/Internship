package com.ontotext.javacourse.objects.homogeneoustree;

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
