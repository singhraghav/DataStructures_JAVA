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

    public static void printInRange(BinaryNode<Integer> root, int start, int end) {
        if (root == null) return;
        if (root.data >= start && root.data <= end)
        {
            System.out.println(root.data);
            printInRange(root.left, start, end);
            printInRange(root.right, start, end);
        }
        if (root.data > end) printInRange(root.left, start, end);
        else if (root.data < start) printInRange(root.right, start, end);
    }

    public static boolean isBst(BinaryNode<Integer> root){
        if (root == null) return true;
        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);
        if (root.data <= leftMax || root.data > rightMin)
            return false;
        boolean isLeftTreeBst = isBst(root.left);
        boolean isRightTreeBst = isBst(root.right);
        if (isLeftTreeBst && isRightTreeBst) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Triplet<Integer, Integer, Boolean> optimisedIsBst(BinaryNode<Integer> root) {
        if (root == null)
            return new Triplet<>(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        Triplet<Integer, Integer, Boolean> leftTree = optimisedIsBst(root.left);
        Triplet<Integer, Integer, Boolean> rightTree = optimisedIsBst(root.right);
        Integer min = Math.min(root.data, Math.min(leftTree.first, rightTree.first));
        Integer max = Math.max(root.data, Math.max(leftTree.second, rightTree.second));
        if (root.data > leftTree.second && root.data <= rightTree.first && leftTree.third && rightTree.third){
            return new Triplet<>(min, max, true);
        }
        else
            return new Triplet<>(min, max, false);
    }

    public static int maximum(BinaryNode<Integer> root){
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }

    public static int minimum(BinaryNode<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
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
        System.out.println("All elements in range 1 to 13 ");
        printInRange(root,1, 13);
        System.out.println("is the given tree bst " + optimisedIsBst(root).third);
    }
}
