package com.company.practice.recursion;

import java.util.LinkedList;
import java.util.List;

public class FirstRevision {

    public static List<String> binaryWithNonConsecutiveOnes(int n) {
        List<String> answers = new LinkedList<>();
        if(n == 1) {
            answers.add("1");
            answers.add("0");
            return answers;
        }
        List<String> answerForNMinusOne = binaryWithNonConsecutiveOnes(n-1);
        for (String toAppend : answerForNMinusOne) {
            answers.add("0" + toAppend);
            if (toAppend.charAt(0) != '1')
                answers.add("1" + toAppend);
        }
        return answers;
    }

    public static void printBinaryWithNonConsecutiveOnes(int n, String osf) {
        if(n == 0) {
            System.out.print(osf + " ");
            return;
        }
        printBinaryWithNonConsecutiveOnes(n-1, "0" + osf);
        if (osf.length() > 0 && osf.charAt(0) != '1')
            printBinaryWithNonConsecutiveOnes(n-1, "1" + osf);
        else if(osf.length() == 0)
            printBinaryWithNonConsecutiveOnes(n-1, "1" + osf);
    }

    public static int power(int a, int b) {
        if(b == 0)
            return 1;
        int smaller = power(a, b-1);
        return a * smaller;
    }

    public static int optimisedPower(int a, int b) {
        if(b == 0)
            return 1;
        if(b == 1)
            return a;
        int smaller = optimisedPower(a, b/2);
        if(b % 2 == 0)
            return smaller * smaller;
        else
            return smaller * smaller * a;
    }

    public static void pattern1(int n) {
        if(n == 0)
            return;
        pattern1(n-1);
        for (int i = 0 ; i < n; i++ ) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void pattern1(int n, int c){
        if (n == 0 || c == n)
            return;
        if (n > 0 && c <= 0) {
            pattern1(n-1, 0);
            System.out.println();
        }
        System.out.print("* ");
        pattern1(n, c + 1);
    }

    public static void pattern2(int n, int c) {
        if(n == 0)
            return;
        if(c < n)
        {
            System.out.print("* ");
            pattern2(n, c + 1);
        } else {
            System.out.println();
            pattern2(n-1, 0);
        }
    }

    public static int nJumps(int i, int n, String osf) {
        if(i == n - 1) {
            System.out.println(osf);
            return 1;
        }
        if (i >= n){
            return 0;
        }
        int totalWays = 0;
        for(int j = 1 ; j <= 6; j++) {
            totalWays += nJumps(i + j, n, osf + j);
        }
        return totalWays;
    }

    public static void printLexOrder(int n, int i) {
        if(i > n)
            return;
        System.out.println(i);
        for (int j = (i == 0)? 1 : 0; j <= 9; j++) {
            printLexOrder(n, i * 10 + j);
        }
    }

    public static void main(String[] args) {
//        System.out.println(binaryWithNonConsecutiveOnes(5));
//        printBinaryWithNonConsecutiveOnes(5, "");
//        pattern1(5);
//        pattern1(5, 0);
//        System.out.println();
//        System.out.println();
//        pattern2(5, 0);
//        System.out.println(nJumps(0, 5, ""));
        printLexOrder(1000, 0);
    }
}
