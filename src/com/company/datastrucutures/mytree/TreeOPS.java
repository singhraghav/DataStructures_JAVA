package com.company.datastrucutures.mytree;

import java.util.Scanner;

public class TreeOPS {
    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);

        int children = s.nextInt();
        for(int i = 0 ; i < children; i++){
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;
    }

    public static void printTree(TreeNode<Integer> root)
    {
        String s = root.data + " : ";
        for(int i = 0 ; i < root.children.size(); i++){
            s = s + root.children.get(i).data + ", ";
        }
        System.out.println(s);
        for(int i = 0 ; i < root.children.size(); i++){
            printTree(root.children.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(s);
        printTree(root);
    }
}
