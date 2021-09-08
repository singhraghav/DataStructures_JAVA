package com.company.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        TreeNode mergeLeft = mergeTrees(root1.left, root2.left);
        TreeNode mergeRight = mergeTrees(root1.right, root2.right);

        return new TreeNode(root1.val + root2.val, mergeLeft, mergeRight);
    }
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i =0; i < size; i++) {
                Node currentNode = q.remove();
                if(i < size - 1)
                    currentNode.next = q.peek();
                else
                    currentNode.next = null;
                q.add(currentNode.left);
                q.add(currentNode.right);
            }
        }
       return root;
    }
    public static void main(String[] args) {

    }
}
