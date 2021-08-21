package com.company.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int numOfBinaryStringWithNonConsecutiveOnes(int n){
        return binaryStringWithNonConsecutiveOnes(n).size();
    }

    public static List<String> binaryStringWithNonConsecutiveOnes(int n)
    {
        List<String> answer = new ArrayList<>();
        if(n == 1)
        {
            answer.add("0");
            answer.add("1");
            return answer;
        }

        List<String> smallerAnswer = binaryStringWithNonConsecutiveOnes(n-1);
        for(int i = 0; i < smallerAnswer.size(); i++)
        {
            String currString = smallerAnswer.get(i);
            if(currString.charAt(0) != '1')
            {
                answer.add("1" + currString);
            }
            answer.add("0" + currString);
        }
        return answer;
    }

    public static void printStringWithNonConsecutiveOnes(int n, String s) {
        if(s.length() == n)
        {
            System.out.println(s);
            return;
        }
        if(s.length() == 0) {
            printStringWithNonConsecutiveOnes(n, "0");
            printStringWithNonConsecutiveOnes(n, "1");
        } else {
            if(s.charAt(0) != '1')
                printStringWithNonConsecutiveOnes(n, "1" + s);
            printStringWithNonConsecutiveOnes(n, "0" + s);
        }
    }

    public static int power(int a, int b)
    {
        if(b == 0)
            return 1;
        if(b == 1) return a;
        int temp = power(a, b/2);
        if(b % 2 == 0)
            return temp * temp;
        else
            return a * temp * temp;
    }

    public static void pattern1(int n) {
        if(n == 0)
            return;
        for(int i = 0; i< n; i++)
            System.out.print("* ");
        System.out.println();
        pattern1(n-1);
    }

    public static void pattern2(int n, int i) {
        if(n == 0)
            return;
        if(i < n)
        {
            System.out.print("* ");
            pattern2(n, i + 1);
        } else {
            System.out.println();
            pattern2(n-1, 0);

        }
    }

    public static void pattern3(int n) {
        if(n == 0)
            return;
        pattern3(n-1);
        System.out.println();
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print("* ");
        }
    }

    public static void pattern4(int n, int c) {
        if(n == 0 || c == n)
            return;
        if(c <= 0) {
            pattern4(n-1, 0);
            System.out.println();
        }
        System.out.print("* ");
        pattern4(n, c + 1);
    }

    public static void printAllSubsets(int[] arr, String output, int i) {
        if(i == arr.length) {
            System.out.println(output);
            return;
        }
        printAllSubsets(arr, output + arr[i], i + 1);
        printAllSubsets(arr, output, i + 1);
    }
    static int totalPaths = 0;
    public static void nPaths(int i, int j, int n, int m, String osf) {
        if(i == n - 1 && j == m - 1) {
            totalPaths += 1;
            System.out.println(osf);
            return;
        }
        if(i < 0 || i >= n || j < 0 || j >= m)
            return;
        nPaths(i, j + 1, n, m, osf + "R");
        nPaths(i + 1, j, n, m, osf + "D");
        nPaths(i + 1, j + 1, n, m, osf + "T");
    }
    static int totalJumps = 0;
    public static void jumpP(int i, int n, String osf) {
        if(i == n-1){
            totalJumps += 1;
            System.out.println(osf);
            return;
        }
        if(i >= n)
            return;
        for(int j = 1; j <= 6; j++) {
            jumpP(i + j, n, osf + j);
        }
    }

    public static void printLexN(int n, int i)
    {
        if(i > n)
            return;
        System.out.println(i);
        for(int j = (i == 0) ? 1:0; j<= 9; j++) {
            printLexN(n, 10*i+j);
        }

    }

    public static void printAllPermutation(String a, String osf) {
        if(a.length() == 0) {
            System.out.println(osf);
            return;
        }

        for(int i =0; i < a.length(); i++) {
            String toAppend = a.charAt(i) + "";
            String append = (i + 1 >= a.length()) ? "": a.substring(i+1);
            String leftover = a.substring(0, i) + append;
            printAllPermutation(leftover, osf + toAppend);
        }
    }

    public static void main(String[] args) {
//        System.out.println(numOfBinaryStringWithNonConsecutiveOnes(5));
//        printStringWithNonConsecutiveOnes(5, "");
//        pattern1(5);
//        pattern2(5, 0);
//        pattern3(6);
//        pattern4(6, 0);
        int[] arr ={1, 2, 3};
//        printAllSubsets(arr, "", 0);
//        nPaths(0, 0, 3, 3, "");
//        jumpP(0, 4, "");
//        System.out.println(totalJumps);
//        printLexN(100, 0);
        printAllPermutation("ABC", "");
    }
}
