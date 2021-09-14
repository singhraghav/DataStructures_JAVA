package com.company.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Day11 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newHead = null;
        ListNode newHeadLast = null;

        while (l1 != null || l2 != null) {

            if(l1.val < l2.val) {
                if(newHead == null) {
                    newHead = l1;
                    newHeadLast = l1;
                } else {
                    newHeadLast.next = l1;
                    newHeadLast = newHeadLast.next;
                }
                l1 = l1.next;
            } else {
                if(newHead == null) {
                    newHead = l2;
                    newHeadLast = l2;
                } else {
                    newHeadLast.next = l2;
                    newHeadLast = newHeadLast.next;
                }
                l2 = l2.next;
            }

        }

        if(l2 == null && newHeadLast != null)
            newHeadLast.next = l1;

        if(l1 == null && newHeadLast != null)
            newHeadLast.next = l2;


        return newHead;
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        helper(1, new LinkedList<Integer>(), result, k, n);
        return result;
    }

    private static void helper(int curr, List<Integer> comb, List<List<Integer>> result, int k, int n) {
        if(comb.size() == k) {
            result.add(comb);
            return;
        }

        for(int i = curr; i < n + 1; i++) {
            comb.add(curr);
            helper(i+1, comb, result, k, n);
            comb.remove(comb.size() - 1);
        }
    }

    public static List<String> letterCasePermutation(String s) {
      List<String> result = new LinkedList<>();
      letterCasePermutation(new StringBuilder(s), result, 0);
      return result;
    }

    public static void letterCasePermutation(StringBuilder s, List<String> result, int curr) {
        if(curr == s.length()){
            result.add(s.toString());
            return;
        }

        for(int i = curr; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))){
                char currentChar = s.charAt(i);
                letterCasePermutation(s.replace(i, i+ 1, (currentChar + "").toUpperCase()), result, i + 1);
                s.replace(i, i+ 1, currentChar + "");
            }
        }
        return;
    }

    int helper(int i, List<Integer> row){
     int element = 0;
     if(row.size() > i)
         element = row.get(i);
     return element;
    }

    public static void main(String[] args) {
//        System.out.println(combine(4, 2));
        System.out.println(letterCasePermutation("a1b2"));
    }
}
