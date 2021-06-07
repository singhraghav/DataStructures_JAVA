package com.company.datastrucutures.mybinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeOps {

    public static BinaryNode<Integer> takeRecursiveInput(Scanner s) {
        System.out.println("Enter root data ");
        int data = s.nextInt();
        if(data == -1)
            return null;
        BinaryNode<Integer> root = new BinaryNode<>(data);
        root.left = takeRecursiveInput(s);
        root.right = takeRecursiveInput(s);
        return  root;
    }

    public static BinaryNode<Integer> takeLevelWiseInput(Scanner s) {
        System.out.println("Enter Root Data");
        BinaryNode<Integer> root = takeNodeInput(s);
        if (root == null) return root;
        Queue<BinaryNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            BinaryNode<Integer> currentElement = q.remove();
            System.out.println("Enter Left Child of " + currentElement.data);
            BinaryNode<Integer> leftChild = takeNodeInput(s);
            if (leftChild != null)
            {
                currentElement.left = leftChild;
                q.add(leftChild);
            }

            System.out.println("Enter Right Child of " + currentElement.data);
            BinaryNode<Integer> rightChild = takeNodeInput(s);
            if (rightChild != null)
            {
                currentElement.right = rightChild;
                q.add(rightChild);
            }
        }
     return root;
    }

    private static BinaryNode<Integer> takeNodeInput(Scanner s) {
        int data = s.nextInt();
        if(data == -1) return null;
        return new BinaryNode<Integer>(data);
    }

    public static void printRecursive(BinaryNode<Integer> root) {
    if (root == null) return;
    String toBePrinted = root.data + " ";
    if(root.left != null){
        toBePrinted += "L: " + root.left.data + ", ";
    }
    if(root.right != null){
        toBePrinted += "R: " + root.right.data;
    }
        System.out.println(toBePrinted);
        printRecursive(root.left);
        printRecursive(root.right);
    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    BinaryNode<Integer> root = takeLevelWiseInput(scan);
    printRecursive(root);
    }
}
