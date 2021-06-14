package com.company.datastrucutures.mybinarysearchtree;

import com.company.datastrucutures.mybinaryTree.BinaryNode;

import java.util.Scanner;

import static com.company.datastrucutures.mybinaryTree.BinaryTreeOps.printLevelWise;
import static com.company.datastrucutures.mybinaryTree.BinaryTreeOps.takeLevelWiseInput;

public class BinarySearchTreeOps {
    public static boolean contains(BinaryNode<Integer> root, int element){
        if (root == null) return false;
        if (element == root.data) return true;
        if (root.data > element) return contains(root.left, element);
        else return contains(root.right, element);
    }

    public static void main(String[] args) {
        //10 5 15 2 8 12 18 1 -1 -1 -1 11 13 -1 20 -1 -1 -1 -1 -1 -1 -1 -1
         /*
                    10
                   /  \
                  5    15
                 / \  /  \
                2   8 12  18
               /     /  \   \
              1     11  13   20
        */
        Scanner scan = new Scanner(System.in);
        BinaryNode<Integer> root = takeLevelWiseInput(scan);
//        printLevelWise(root);

        System.out.println("Tree contains 13 " + contains(root, 13));
        System.out.println("Tree contains 10 " + contains(root, 17));
    }
}
