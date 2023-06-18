package com.ontotext.javacourse.objects.homogeneoustree;

import java.security.InvalidParameterException;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * The HomogenousTree class defines an unbalanced binary tree with elements of a specified type.
 * This tree has methods for inserting new elements, searching for an element in the tree and
 * printing all the tree elements.
 *
 * @param <T>
 */
public class HomogeneousTree<T extends Comparable<T>> {

  private static final Logger LOGGER = Logger.getLogger(HomogeneousTree.class.getName());
  private Node<T> root;

  public HomogeneousTree() {
    this.root = null;
  }

  /**
   * Inserts new node in tree if there is not already a node with the same value.
   *
   * @param element the element to insert
   * @throws InvalidParameterException if the element with the same value is already present in the
   *     tree
   */
  public void insert(Node<T> element) {
    if (search(element) != null) {
      throw new InvalidParameterException("Element is already present in the tree");
    }
    if (root == null) {
      root = element;
    } else {
      insert(root, element);
    }
  }

  private Node<T> insert(Node<T> root, Node<T> element) {
    if (root == null) {
      return element;
    }
    if (element.getValue().compareTo(root.getValue()) < 0) {
      Node<T> leftChild;
      leftChild = insert(root.getLeftChild(), element);
      root.setLeftChild(leftChild);
    } else if (element.getValue().compareTo(root.getValue()) > 0) {
      Node<T> rightChild;
      rightChild = insert(root.getRightChild(), element);
      root.setRightChild(rightChild);
    }
    return root;
  }

  /**
   * Finds and returns the given element if it is present in the tree.
   *
   * @param element the element to search for
   * @return null if the element is not found or the element if it is found
   */
  public Node<T> search(Node<T> element) {
    return search(this.root, element);
  }

  private Node<T> search(Node<T> root, Node<T> element) {
    if (root == null) {
      return null;
    }
    if (element.getValue().compareTo(root.getValue()) < 0) {
      return search(root.getLeftChild(), element);
    } else if (element.getValue().compareTo(root.getValue()) > 0) {
      return search(root.getRightChild(), element);
    } else {
      return element;
    }
  }

  /** Prints all the tree elements value in order with a 4 space indent. */
  public void print() {
    LOGGER.info(printInOrder(root, 0));
  }

  private String printInOrder(Node<T> root, int indent) {
    StringBuilder result = new StringBuilder();

    if (root.getLeftChild() != null) {
      result.append(printInOrder(root.getLeftChild(), indent + 4));
    }

    String emptySpace = StringUtils.repeat(" ", indent);
    result.append(emptySpace);
    result.append(root.getValue());
    result.append(System.lineSeparator());

    if (root.getRightChild() != null) {
      result.append(printInOrder(root.getRightChild(), indent + 4));
    }
    return result.toString();
  }
}
