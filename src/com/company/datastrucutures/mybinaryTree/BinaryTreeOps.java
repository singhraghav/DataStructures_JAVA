package com.company.datastrucutures.mybinaryTree;

import com.company.datastrucutures.Pair;

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

    public static Pair<Integer, Integer> optimisedDiameter(BinaryNode<Integer> root) {
        if (root == null) return  new Pair<>(0, 0);
        Pair<Integer, Integer> left = optimisedDiameter(root.left);
        Pair<Integer, Integer> right = optimisedDiameter(root.right);

        int height = 1 + Math.max(left.first, right.first);
        int option1 = left.first + right.first;
        int option2 = left.second;
        int option3 = right.second;

        int diameter = Math.max(option1, Math.max(option2, option3));
//        System.out.println("height: " + height +" diameter: " + diameter);
        return new Pair<>(height, diameter);
    }

    public static int height(BinaryNode<Integer> root) {
        if (root == null) return 0;
        else return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void inOrderTraversal(BinaryNode<Integer> root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(BinaryNode<Integer> root){
        if (root == null) return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(BinaryNode<Integer> root){
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public static BinaryNode<Integer> constructTreeUsingInorderAndPreOrderTraversal
            (int[] inorder, int[] preorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        if (inorderStart > inorderEnd) return null;

        BinaryNode<Integer> root = new BinaryNode<>(preorder[preorderStart]);
        if (inorderStart == inorderEnd) return root;
        int rootIndexInInOrder = -1;
        for(int i = inorderStart; i <= inorderEnd; i++)
        {
            if(inorder[i] == root.data)
            {
             rootIndexInInOrder = i;
             break;
            }
        }

        if (rootIndexInInOrder == -1) return null;

       int inorderStartForLeftSubtree = inorderStart;
       int inorderEndForLeftSubTree = rootIndexInInOrder - 1;

       int inorderStartForRightSubTree = rootIndexInInOrder + 1;
       int inorderEndForRightSubTree = inorderEnd;

       int preorderStartForLeftSubtree = preorderStart + 1;
       int preorderEndForLeftSubtree = inorderEndForLeftSubTree - inorderStartForLeftSubtree + preorderStartForLeftSubtree;

       int preorderStartForRightSubtree = preorderEndForLeftSubtree + 1;
       int preorderEndForRightSubtree = preorderEnd;

       root.left =
               constructTreeUsingInorderAndPreOrderTraversal(inorder, preorder, inorderStartForLeftSubtree, inorderEndForLeftSubTree, preorderStartForLeftSubtree, preorderEndForLeftSubtree);
       root.right =
               constructTreeUsingInorderAndPreOrderTraversal(inorder, preorder, inorderStartForRightSubTree, inorderEndForRightSubTree, preorderStartForRightSubtree, preorderEndForRightSubtree);
       return root;
    }

    public static int sumOfAllNodes(BinaryNode<Integer> root) {
        if(root == null) return 0;
        int leftSubtreeSum = sumOfAllNodes(root.left);
        int rightSubtreeSum = sumOfAllNodes(root.right);

        return root.data + leftSubtreeSum + rightSubtreeSum;
    }

    public static boolean isBalanced(BinaryNode<Integer> root){
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
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
//    printLevelWise(root);
//    System.out.println("Number of nodes in the tree are " + numNodes(root)); // 7
//    System.out.println("Diameter of tree is " + optimisedDiameter(root)); // 5
//    System.out.println("Inorder Traversal ");
//    inOrderTraversal(root); //10 7 5 8 4 9 6
//    System.out.println("Pre Order Traversal ");
//    preOrderTraversal(root); //4 5 7 10 8 6 9
//    System.out.println("Post Order Traversal ");
//    postOrderTraversal(root); //10 7 8 5 9 6 4
        int[] inorder = {10, 7, 5, 8, 4, 9, 6};
        int[] preorder = {4, 5, 7, 10, 8, 6, 9};
        BinaryNode<Integer> tree = constructTreeUsingInorderAndPreOrderTraversal(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
        System.out.println("Constructed Tree");
        printLevelWise(tree);

        System.out.println("Sum of all nodes in the tree " + sumOfAllNodes(root));
    }
}
