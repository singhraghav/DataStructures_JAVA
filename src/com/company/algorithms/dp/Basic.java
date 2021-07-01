package com.company.algorithms.dp;

public class Basic {

    public static int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        else
            return fib(n-1) + fib(n-2);
    }

    public static int fibD(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n ; i++)
            arr[i] = arr[i-1] + arr[i-2];
        return arr[n];
    }

    public static int reduceToOne(int n){
        if(n == 1)
            return 0;
        int count2 = Integer.MAX_VALUE;
        if(n %2 ==0){
            count2 = 1 + reduceToOne(n/2);
        }

        int count3 = Integer.MAX_VALUE;
        if(n % 3 ==0){
            count3 = 1 + reduceToOne(n/3);
        }
        int count1 = 1 + reduceToOne(n-1);
        return Math.min(count1, Math.min(count2, count3));
    }

    public static int reduceToOneM(int n, int[] storage){
        if(n == 1)
        {
            storage[n] = 0;
            return storage[n];
        }

        if(storage[n] != -1)
           return storage[n];
        int count2 = Integer.MAX_VALUE;
        if(n %2 ==0){
            count2 = 1 + reduceToOneM(n/2, storage);
        }

        int count3 = Integer.MAX_VALUE;
        if(n % 3 ==0){
            count3 = 1 + reduceToOneM(n/3, storage);
        }
        int count1 = 1 + reduceToOneM(n-1, storage);

        storage[n] =  Math.min(count1, Math.min(count2, count3));
        return storage[n];
    }
    public static int reduceToOneDP(int n){
        int[] storage = new int[n+1];
        storage[1] = 0;

        for(int i = 2; i <= n; i++)
        {
            int min = storage[i-1];
            if(i%3 == 0){
                if(min > storage[i/3])
                    min = storage[i/3];
            }
            if(i%2 == 0){
                if(min > storage[i/2])
                    min = storage[i/2];
            }
            storage[i] = 1 + min;
        }

        return storage[n];
    }
    public static void main(String[] args) {
        long start3 = System.currentTimeMillis();
        System.out.println(reduceToOneDP(1000));
        long end3 = System.currentTimeMillis();
        System.out.println("Time taken by dp " + (end3 - start3)/1000);

        int[] arr = new int[1001];
        for(int i = 0 ; i < 1001; i++)
            arr[i] = -1;
        long start1 = System.currentTimeMillis();
        System.out.println(reduceToOneM(1000, arr));
        long end1 = System.currentTimeMillis();
        System.out.println("Time taken by memo " + (end1 - start1)/1000);
        long start2 = System.currentTimeMillis();
        System.out.println(reduceToOne(1000));
        long end2 = System.currentTimeMillis();
        System.out.println("Time taken by bruteForce " + (end2 - start2)/1000);
    }
}
