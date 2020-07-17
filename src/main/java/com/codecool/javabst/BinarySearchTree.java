package com.codecool.javabst;

import lombok.Data;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
@Data
public class BinarySearchTree {

    private Node root;

    public static BinarySearchTree build(List<Integer> elements) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        int middleIndex = elements.size() / 2;

        binarySearchTree.root = Node.builder()
                .value(elements.get(middleIndex))
                .left(buildBranch(elements, 0, middleIndex))
                .right(buildBranch(elements, middleIndex + 1, elements.size() - 1))
                .build();

        return binarySearchTree;
    }

    private static Node buildBranch(List<Integer> elements, int low, int high) {
        if (low >= high) return null;

        int middleIndex = low + (high - low) / 2;

        return Node.builder()
                .value(elements.get(middleIndex))
                .left(buildBranch(elements, low, middleIndex))
                .right(buildBranch(elements, middleIndex + 1, high))
                .build();
    }

    public boolean search(Integer toFind) {
        Node currentNode = root;

        while (currentNode != null) {
            if (currentNode.getValue().equals(toFind)) return true;
            currentNode = toFind < currentNode.getValue() ? currentNode.getLeft() : currentNode.getRight();
        }
        return false;
    }

    public void add(Integer toAdd) throws Exception {
        // TODO adds an element. Throws an error if it exist.

        Node currentNode = root;

        while (true) {
            if (currentNode.getValue().equals(toAdd)) throw new Exception();
            if (toAdd < currentNode.getValue()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode.setLeft(Node.builder()
                            .value(toAdd)
                            .build());
                    break;
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode.setRight(Node.builder()
                            .value(toAdd)
                            .build());
                    break;
                }
            }
        }
    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

}
