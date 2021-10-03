package com.company.ds_leetcode.binary_tree;

import com.company.LeetCode.TreeNode;
import com.company.practice.Pair;

import java.util.*;

public class Traversal {

    public List<Integer> preOrderIterative(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();

        if(root == null)
            return result;
        else {
            stk.push(root);
            while (!stk.isEmpty()) {
                TreeNode current = stk.pop();
                result.add(current.val);
                if (current.right != null)
                    stk.push(current.right);
                if (current.left != null)
                    stk.push(current.left);
            }
        }
        return result;
    }

    public List<Integer> inOrderIterative(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();

        TreeNode curr = root;
        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public List<Integer> postOrderIterative(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stk = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        stk.push(new Pair<>(root, 0));

        while (!stk.isEmpty()) {
            Pair<TreeNode, Integer> curr = stk.pop();
            if (curr == null || curr.second == 3) continue;
            stk.push(new Pair<>(curr.first, curr.second + 1));

            if (curr.second == 0) stk.push(new Pair<>(curr.first.left, 0));
            else if(curr.second == 1) stk.push(new Pair<>(curr.first.right, 0));
            else result.add(curr.first.val);
        }

        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> pip = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        else {
            pip.add(root);

            while(!pip.isEmpty()) {
                int size = pip.size();
                List<Integer> temp = new ArrayList<>(size);
                for(int i =0; i < size; i++) {
                    TreeNode curr = pip.remove();
                    temp.add(curr.val);
                    if(curr.left != null)
                        pip.add(curr.left);
                    if(curr.right != null)
                        pip.add(curr.right);
                }
                result.add(temp);
            }
            return result;
        }

    }
}
