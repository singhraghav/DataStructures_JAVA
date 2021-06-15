package com.company.datastrucutures.mybinarysearchtree;

import com.company.datastrucutures.mybinaryTree.BinaryNode;

import java.util.LinkedList;
import java.util.Scanner;

import static com.company.datastrucutures.mybinaryTree.BinaryTreeOps.printLevelWise;
import static com.company.datastrucutures.mybinaryTree.BinaryTreeOps.takeLevelWiseInput;

public class BinarySearchTreeOps {
    public static BinaryNode<Integer> insert(BinaryNode<Integer> root, int element) {
        if (root == null) return new BinaryNode<>(element);
        if (element < root.data)
        {
            root.left = insert(root.left, element);
            return root;
        }
        else if (element > root.data)
        {
            root.right = insert(root.right, element);
            return root;
        }
        else
            return root;
    }

    private static BinaryNode<Integer> leftLeaf(BinaryNode<Integer> root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return leftLeaf(root.left);
    }

    public static BinaryNode<Integer> delete(BinaryNode<Integer> root, int element) {
        if (root == null) return null;
        if (element < root.data)
        {
            root.left = delete(root.left, element);
            return root;
        }
        else if (element > root.data)
        {
            root.right = delete(root.right, element);
            return root;
        }
        else
        {   if (root.left == null && root.right == null) return null;
            else if (root.right == null) return root.left;
            else if (root.left == null) return root.right;
            else {
               BinaryNode<Integer> leftLeafOfRightSubTree = leftLeaf(root.right);
               BinaryNode<Integer> newRightTree = delete(root.right, leftLeafOfRightSubTree.data);
               leftLeafOfRightSubTree.left = root.left;
               leftLeafOfRightSubTree.right = newRightTree;
               return leftLeafOfRightSubTree;
        }
        }
    }

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

    public static BinaryNode<Integer> constructTree(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2 ;
        BinaryNode<Integer> root = new BinaryNode<>(arr[mid]);
        root.left = constructTree(arr, start, mid -1);
        root.right = constructTree(arr, mid+1, end);
        return root;
    }

    public static LinkedList<Integer> constructSortedList(BinaryNode<Integer> root){
        if (root == null) return null;
        LinkedList<Integer> left = constructSortedList(root.left);
        LinkedList<Integer> right = constructSortedList(root.right);
        if (left == null)
        {
            left = new LinkedList<Integer>();
            left.add(root.data);
        }
        else
            left.add(root.data);
        if (right != null)
            left.addAll(right);
        return left;
    }

    public static LinkedList<Integer> pathToData(BinaryNode<Integer> root, int data) {
        if (root == null) return null;
        if(root.data > data){
            LinkedList<Integer> answer = pathToData(root.left, data);
            if (answer == null) return answer;
            answer.add(0, root.data);
            return answer;
        }
        else if(root.data < data)
        {
            LinkedList<Integer> answer = pathToData(root.right, data);
            if (answer == null) return answer;
            answer.add(0, root.data);
            return answer;
        }
        else
        {
            LinkedList<Integer> answer = new LinkedList<>();
            answer.add(root.data);
            return answer;
        }
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
        System.out.println("Construct new Tree");
        int[] arr = {1,2,5,8,10,11,12,13,15,18,20};
        BinaryNode<Integer> constructedTree = constructTree(arr, 0, arr.length - 1);
        printLevelWise(constructedTree);

        System.out.println(constructSortedList(constructedTree));
        System.out.println(pathToData(root, 8));

        BinaryNode<Integer> updatedTree = delete(root, 10);
        printLevelWise(updatedTree);
        System.out.println("///////////////////////////////////////");
        BinaryNode<Integer> updatedTree1 = insert(root, 10);
        printLevelWise(updatedTree1);
    }
}
