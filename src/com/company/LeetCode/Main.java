package com.company.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][];
        for(int i =0; i < mat.length; i++) {
            result[i] = new int[mat[i].length];
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        for(int i =0; i < mat.length; i++) {
            for(int j =0; j < mat[i].length; j++) {
                if(mat[i][j] == 0)
                    result[i][j] = 0;
                else {
                    if(i > 0)
                        result[i][j] = Math.min(result[i][j], result[i-1][j] + 1);
                    if(j > 0)
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        for(int i = mat.length - 1; i >= 0; i--) {
            for(int j =mat[i].length - 1; j >=0 ; j--) {
                if(i < mat.length - 1)
                    result[i][j] = Math.min(result[i][j], result[i+1][j] + 1);
                if(j < mat[i].length - 1)
                    result[i][j] = Math.min(result[i][j], result[i][j+1] + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
