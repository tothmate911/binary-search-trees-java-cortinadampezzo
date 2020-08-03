package com.codecool.javabst;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Node {

    private Node left;
    private Node right;
    private Integer value;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + (left != null ? left : null) +
                ", right=" + (right != null ? right : null) +
                '}';
    }

    public boolean isLeaf() {
        return right == null && left == null;
    }

    public boolean hasOnlyOneChild() {
        return !this.isLeaf() && (right == null || left == null);
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

}
