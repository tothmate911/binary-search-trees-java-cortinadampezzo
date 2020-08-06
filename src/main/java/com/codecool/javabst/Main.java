package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                5, 10, 17, 20, 25, 29, 30, 40, 41, 50, 55, 60, 65, 75, 79, 80, 82, 85, 89
        ));

//        for (int i = 0; i < 50; i++) {
//            numbers.add(i * 2 + 5);
//        }

        BinarySearchTree myTree = BinarySearchTree.build(numbers);
        System.out.println(myTree);

        // write some test code here
//        System.out.println("search for 7, should be true: " + myTree.search(7)); // should be true
//        System.out.println("search for 55, should be true: " + myTree.search(55)); // should be true
//        System.out.println("search for 34535, should be false: " + myTree.search(34535)); // should be false
//        System.out.println();
//
//        int x = 58;
//        System.out.println("search for " + x + ", should be false: " + myTree.search(x));
//        myTree.add(x);
//        System.out.println("add " + x + " and search for " + x + ", should be true: " + myTree.search(x));
//        System.out.println(myTree);
//        System.out.println();
//
//        x = 77;
//        System.out.println("search for " + x + ", should be true: " + myTree.search(x) );
//        myTree.remove(x);
//        System.out.println("remove " + x + " and search for " + x + ", should be false: " + myTree.search(x));
//        System.out.println();
//
//        x = 55;
//        System.out.println("search for " + x + ", should be true: " + myTree.search(x) );
//        myTree.remove(x);
//        System.out.println("remove " + x + " and search for " + x + ", should be false: " + myTree.search(x));
//        System.out.println();


    }
}