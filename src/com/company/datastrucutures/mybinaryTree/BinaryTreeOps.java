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

    public static void printLevelWise(BinaryNode<Integer> root) {
        if (root == null) return;
        Queue<BinaryNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode<Integer> currentElement = q.remove();
            String toBePrinted = currentElement.data + " : ";
            if(currentElement.left != null){
                toBePrinted += "L: " + currentElement.left.data + ", ";
                q.add(currentElement.left);
            }
            if(currentElement.right != null){
                toBePrinted += "R: " + currentElement.right.data;
                q.add(currentElement.right);
            }
            System.out.println(toBePrinted);
        }
    }

    public static int numNodes(BinaryNode<Integer> root){
        if (root == null) return 0;
        return 1 + numNodes(root.left) + numNodes(root.right);
    }

    public static int diameter(BinaryNode<Integer> root){
        if(root == null) return 0;

        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    public static int height(BinaryNode<Integer> root) {
        if (root == null) return 0;
        else return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //4 5 6 7 8 9 -1 10 -1 -1 -1 -1 -1 -1 -1
        /*
                    4
                   / \
                  5   6
                 / \  /
                7   8 9
               /
              10
        */
    BinaryNode<Integer> root = takeLevelWiseInput(scan);
    printLevelWise(root);
    System.out.println("Number of nodes in the tree are " + numNodes(root)); // 7
    System.out.println("Diameter of tree is " + diameter(root)); // 5
    }
}
