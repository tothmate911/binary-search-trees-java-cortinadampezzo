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
                ", left=" + (left != null ? left.getValue() : null) +
                ", right=" + (right != null ? right.getValue() : null) +
                '}';
    }
}
