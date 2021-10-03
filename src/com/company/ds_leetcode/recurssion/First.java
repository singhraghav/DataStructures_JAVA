package com.company.ds_leetcode.recurssion;

import com.company.LeetCode.TreeNode;

public class First {

    private static void printInReverse(String str) {
        if (str.isEmpty())
            return;
        printInReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    private static String reverse(String s){
        if (s.isEmpty())
            return "";
        String smaller = reverse(s.substring(1));
        return  smaller + s.charAt(0);
    }

    public void reverseString(char[] s) {

    }

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        boolean validatedLeft = isValidBST(root.left);
        boolean validatedRight = isValidBST(root.right);

        boolean isGreaterThanLeft = true;
        if (root.left != null)
            isGreaterThanLeft = root.val > root.left.val;
        boolean isSmallerThanRight = true;
        if (root.right != null)
            isSmallerThanRight = root.val < root.right.val;

        return  validatedLeft && validatedRight && isGreaterThanLeft && isSmallerThanRight;
    }
    public static void main(String[] args) {
//        printInReverse("abc");
        System.out.println(reverse("abc"));
    }
}
