package com.company.datastrucutures.mytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeOPS {

    static int maxSum = Integer.MIN_VALUE;
    static TreeNode<Integer> nodeWithMaxSum = null;

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

    public static void printTree(TreeNode<Integer> root){
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

    public static void printAllNodesAtKDepth(TreeNode<Integer> root, int k) {
        if(k < 0) return;
        if(k == 0)
        {
            System.out.println(root.data);
            return;
        }
        for(int i = 0 ; i < root.children.size(); i++)
        {
            printAllNodesAtKDepth(root.children.get(i), k-1);
        }
    }

    public static int numberOfLeafNodes(TreeNode<Integer> root){
        if(root == null) return 0;
        int answer = 0;
        int numChildren = root.children.size();
        if(numChildren == 0)
            return 1;
        for (int i = 0 ; i < numChildren; i++)
        {
            answer += numberOfLeafNodes(root.children.get(i));
        }
        return answer;
    }

    public static void printPostOrderTraversal(TreeNode<Integer> root){
        if (root == null) return;
        for (int i = 0 ; i < root.children.size(); i++)
            printPostOrderTraversal(root.children.get(i));
        System.out.println(root.data);
    }

    public static int numberOfNodesGreaterThanX(TreeNode<Integer> root, int x){
        if (root == null) return 0;
        int childrenNodesGreaterThanX = (root.data > x) ? 1 : 0;
        for(int i = 0; i < root.children.size(); i++)
        {
            childrenNodesGreaterThanX += numberOfNodesGreaterThanX(root.children.get(i), x);
        }
        return  childrenNodesGreaterThanX;
    }

    public static void nodeWithMaxDataAndChildrenSum(TreeNode<Integer> root){
        if(root == null) return;
        int currSum = root.data;
        for (int i = 0; i < root.children.size(); i++)
        {
            currSum += root.children.get(i).data;
            nodeWithMaxDataAndChildrenSum(root.children.get(i));
        }
        if (currSum > maxSum)
        {
            maxSum = currSum;
            nodeWithMaxSum = root;
        }
    }

    public static boolean areTheTreesStructurallyIdentical(TreeNode<Integer> tree1, TreeNode<Integer> tree2){
        if (!tree1.data.equals(tree2.data))
            return false;
        int tree1ChildrenSize = tree1.children.size();
        int tree2ChildrenSize = tree2.children.size();
        if (tree1ChildrenSize != tree2ChildrenSize)
            return false;
        boolean areChildrenIdentical = true;
        for (int i = 0 ; i < tree1ChildrenSize; i++)
        {
            areChildrenIdentical = areTheTreesStructurallyIdentical(tree1.children.get(i), tree2.children.get(i));
        }
        return areChildrenIdentical;
    }

    public static int secondLargestThanN(TreeNode<Integer> tree, int N, int currentMax){
        if (tree == null) return currentMax;
        currentMax = (tree.data > N) ? tree.data : currentMax;
        for (int i =0; i < tree.children.size(); i++)
        {
            int currChildNextGreaterValueThanN = secondLargestThanN(tree.children.get(i), N, currentMax);
            if (currChildNextGreaterValueThanN > N && currChildNextGreaterValueThanN < currentMax)
                currentMax = currChildNextGreaterValueThanN;
        }
        return currentMax;
    }

    public static void main(String[] args) {
        //tree data used for testing
        //4 2 5 6 2 7 8 2 9 10 0 1 12 0 1 11 0 0
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = levelWiseInput(s);
//        TreeNode<Integer> root2 = levelWiseInput(s);
        printLevelWise(root);
        System.out.println("number of nodes in tree " + numNodes(root));
        System.out.println("max of nodes in tree " + maxNode(root));
        System.out.println("height of tree " + height(root));
        System.out.println("depth of tree " + depthOfNode(root, 5 ));
        printAllNodesAtKDepth(root, 3);
        System.out.println("No of leaf nodes in the tree " + numberOfLeafNodes(root));
        printPostOrderTraversal(root);
        System.out.println("Number of nodes greater than x " + numberOfNodesGreaterThanX(root, 9));
//        System.out.println("Max node and child sum " + nodeWithMaxSum.data);
//        System.out.println("Are two trees identical " + areTheTreesStructurallyIdentical(root, root2));
        System.out.println("Next largest value than N " + secondLargestThanN(root, 8, Integer.MAX_VALUE));
    }
}
