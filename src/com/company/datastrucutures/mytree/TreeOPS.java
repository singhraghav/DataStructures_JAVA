package com.company.datastrucutures.mytree;

import java.util.LinkedList;
import java.util.Queue;
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

    public static TreeNode<Integer> levelWiseInput(Scanner s){
        System.out.println("Enter node data");
        int rootData = s.nextInt();

        TreeNode<Integer> node = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(node);

        while (!pendingNodes.isEmpty())
        {
            TreeNode<Integer> frontNode = pendingNodes.remove();
            System.out.println("Enter number of children for " + frontNode.data);
            int numChildren = s.nextInt();

            for(int i = 0 ; i < numChildren; i++)
            {
                System.out.println("Enter " + (i+1) + " child of " + frontNode.data);
                int child = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return node;
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()){
            TreeNode<Integer> currentNode = pendingNodes.remove();
            String s = currentNode.data +" : ";
            for(int i = 0; i< currentNode.children.size(); i++)
            {
                TreeNode<Integer> child = currentNode.children.get(i);
                pendingNodes.add(child);
                s = s + child.data + ", ";
            }
            System.out.println(s);
        }
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

    public static int numNodes(TreeNode<Integer> root){
        if(root == null) return 0;
        int nodeSize = 1;
        if(root.children.isEmpty())
            return nodeSize;
        for(int i = 0; i< root.children.size(); i++)
        {
            nodeSize += numNodes(root.children.get(i));
        }
        return nodeSize;
    }

    public static int maxNode(TreeNode<Integer> root){
        if(root == null) return Integer.MIN_VALUE;
        int maxDataForThisNode = root.data;
        for(int i = 0; i< root.children.size(); i++)
        {
            int subAnswer = maxNode(root.children.get(i));
            if(subAnswer > maxDataForThisNode)
            maxDataForThisNode = subAnswer;
        }
        return maxDataForThisNode;
    }

    public static int height(TreeNode<Integer> root){
        if(root == null) return 0;
        int heightOfChildren = 0;
        for(int i = 0; i< root.children.size(); i++)
        {
            int childHeight = height(root.children.get(i));
            if(childHeight > heightOfChildren)
                heightOfChildren = childHeight;
        }
        return 1 + heightOfChildren;
    }

    public static int depthOfNode(TreeNode<Integer> root, int nodeData) {
        if(root == null) return -1;
        if(root.data == nodeData) return 0;
        int depthOfChildNode = -1;
        for(int i = 0 ; i < root.children.size(); i++)
        {
           int depthFromCurrentChildNode = depthOfNode(root.children.get(i), nodeData);
                if(depthFromCurrentChildNode != -1)
                    depthOfChildNode = 1 + depthFromCurrentChildNode;
        }
        return depthOfChildNode;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = levelWiseInput(s);
        printLevelWise(root);
        System.out.println("number of nodes in tree " + numNodes(root));
        System.out.println("max of nodes in tree " + maxNode(root));
        System.out.println("height of tree " + height(root));
        System.out.println("depth of tree " + depthOfNode(root, 5));
    }
}
