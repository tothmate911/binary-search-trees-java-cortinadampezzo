package com.codecool.javabst;

import lombok.Data;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
@Data
public class BinarySearchTree {

    private Node root;

    public static BinarySearchTree build(List<Integer> elements) {
        // TODO construct a binary search tree here
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        int middleIndex = elements.size() / 2;
        Integer middleElement = elements.get(middleIndex);

        binarySearchTree.root = ;
        Node.builder()
                .value(middleElement)

        return binarySearchTree;
    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        return false;
    }

    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

}
