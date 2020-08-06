package com.codecool.javabst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {

    private Node root;

    public static BinarySearchTree build(List<Integer> elements) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

//        int middleIndex = elements.size() / 2;

        binarySearchTree.root = buildBranch(elements, 0, elements.size() - 1);

//        binarySearchTree.root = Node.builder()
//                .value(elements.get(middleIndex))
//                .left(buildBranch(elements, 0, middleIndex - 1))
//                .right(buildBranch(elements, middleIndex + 1, elements.size() - 1))
//                .build();

        return binarySearchTree;
    }

    private static Node buildBranch(List<Integer> elements, int low, int high) {
        if (low > high) return null;

        int middleIndex = low + (high - low) / 2;

        return Node.builder()
                .value(elements.get(middleIndex))
                .left(buildBranch(elements, low, middleIndex - 1))
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
        Node currentNode = root;
        Node toAddNode = Node.builder()
                .value(toAdd)
                .build();

        while (true) {
            if (currentNode.getValue().equals(toAdd)) throw new Exception();

            if (toAdd < currentNode.getValue()) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode.setLeft(toAddNode);
                    break;
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode.setRight(toAddNode);
                    break;
                }
            }
        }
    }

    public void remove(Integer toRemove) throws Exception {
        Map<String, Node> toRemoveAndParent = getNodeAndParent(toRemove);
        Node toRemoveNode = toRemoveAndParent.get("searched node");
        Node toRemoveParentNode = toRemoveAndParent.get("parent node");

        if (toRemoveNode.isLeaf()) {
            removeLeaf(toRemoveNode, toRemoveParentNode);
            return;
        }
        if (toRemoveNode.hasOnlyOneChild()) {
            removeOneChildNode(toRemoveNode, toRemoveParentNode);
            return;
        }

        Map<String, Node> toReplaceWithAndParent = getToReplaceWithAndParent(toRemoveNode);
        Node toReplaceWithNode = toReplaceWithAndParent.get("searched node");
        Node toReplaceWithParentNode = toReplaceWithAndParent.get("parent node");

        removeNodeAndRearrangeTree(toRemoveNode, toRemoveParentNode,
                toReplaceWithNode, toReplaceWithParentNode);
    }

    private void removeNodeAndRearrangeTree(Node toRemoveNode, Node toRemoveParentNode,
                                            Node toReplaceWithNode, Node toReplaceWithParentNode) {
        if (toRemoveNode == root) {
            root = toReplaceWithNode;
        } else if (toRemoveParentNode.getLeft() == toRemoveNode) {
            toRemoveParentNode.setLeft(toReplaceWithNode);
        } else {
            toRemoveParentNode.setRight(toReplaceWithNode);
        }

        toReplaceWithNode.setLeft(toRemoveNode.getLeft());

        if (toRemoveNode != toReplaceWithParentNode) {
            toReplaceWithParentNode.setLeft(toReplaceWithNode.getRight());
            toReplaceWithNode.setRight(toRemoveNode.getRight());
        }

    }

    private Map<String, Node> getNodeAndParent(Integer toRemove) throws Exception {
        Map<String, Node> nodeAndParent = new HashMap<>();
        Node currentNode = root;
//        Pair
        Node currentParentNode = null;

        while (currentNode != null) {
            if (toRemove.equals(currentNode.getValue())) {
                nodeAndParent.put("searched node", currentNode);
                nodeAndParent.put("parent node", currentParentNode);
                return nodeAndParent;
            }
            currentParentNode = currentNode;
            currentNode = toRemove < currentNode.getValue() ? currentNode.getLeft() : currentNode.getRight();
        }
        throw new Exception();
    }

    private void removeLeaf(Node toRemoveNode, Node toRemoveParentNode) {
        if (toRemoveParentNode.getLeft() == toRemoveNode) {
            toRemoveParentNode.setLeft(null);
        } else {
            toRemoveParentNode.setRight(null);
        }
    }

    private void removeOneChildNode(Node toRemoveNode, Node toRemoveParentNode) {
        Node theOneChildOfToRemoveNode = toRemoveNode.hasLeft() ? toRemoveNode.getLeft() : toRemoveNode.getRight();

        if (toRemoveParentNode.getLeft() == toRemoveNode) {
            toRemoveParentNode.setLeft(theOneChildOfToRemoveNode);
        } else {
            toRemoveParentNode.setRight(theOneChildOfToRemoveNode);
        }
    }

    private Map<String, Node> getToReplaceWithAndParent(Node toRemoveNode) {
        Map<String, Node> nodeAndParent = new HashMap<>();
        Node currentNode = toRemoveNode.getRight();
        Node currentParentNode = toRemoveNode;

        while (currentNode.hasLeft()) {
            currentParentNode = currentNode;
            currentNode = currentNode.getLeft();
        }
        nodeAndParent.put("searched node", currentNode);
        nodeAndParent.put("parent node", currentParentNode);
        return nodeAndParent;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
