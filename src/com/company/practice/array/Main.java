package com.company.practice.array;

import com.company.practice.Pair;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static String reverseWord(String str)
    {
        char[] s = str.toCharArray();
        int start = 0;
        int end = s.length - 1;

        while (start < end)
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(s);
    }

    public Pair<Integer, Integer> minMax(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i =0; i < arr.length; i++)
        {
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }

        return new Pair<>(min, max);
    }

    public static int kthSmallest(int[] arr, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxComparator());
        int i = 0;
        for(; i < k; i++)
            pq.add(arr[i]);
        for(; i < arr.length; i++)
        {
            int currentMax = pq.element();
            if(arr[i] < currentMax)
            {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        return pq.remove();
    }

    public static int doUnion(int a[], int n, int b[], int m)
    {
        Map<Integer, Integer> t = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++)
        {
            t.put(a[i], 0);
        }
        for(int i = 0; i < m; i++)
        {
            t.put(b[i], 0);
        }
        return t.size();
    }

    int maxSubarraySum(int arr[], int n){

        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for(int i = 0; i < n ; i++)
        {
            if(current_sum + arr[i] > arr[i])
            {
                current_sum = current_sum + arr[i];
            }
            else {
                current_sum = arr[i];
            }

            if (current_sum > max_sum)
                max_sum = current_sum;
        }

        return max_sum;
    }

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int minElement;
        int maxElement;
        int result = arr[n-1] - arr[0];

        for(int i = 1; i <= n-1; i++)
        {
            if(arr[i] >= k && arr[n-1] >= k) {
                minElement = Math.min(arr[0] + k, arr[i] - k);
                maxElement = Math.max(arr[i] + k, arr[n - 1] - k);
                result = Math.min(result, maxElement - minElement);
            }
        }

        return result;
    }

    static int minJumps(int[] arr){
        int[] storage = new int[arr.length];
        Arrays.fill(storage, -1);
        int answer = minJumpsHelper(0, arr, arr.length, storage);
        if ( answer == Integer.MAX_VALUE)
            return -1;
        else
           return answer;
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] storage = new int[n];

        for(int i =0; i< nums.length; i++)
        {
            int index = nums[i] % n;
            storage[index] += 1;
            if (storage[index] > 1)
                return nums[i];
        }
        return -1;
    }
    static int minJumpsHelper(int currIndex, int[] arr, int n, int[] storage)
    {
        if(currIndex == n - 1)
        {
            storage[currIndex] = 0;
            return 0;
        }
        if (currIndex > n-1)
            return 0;
        if (storage[currIndex] != -1)
            return storage[currIndex];
        int result = Integer.MAX_VALUE;

        for(int i = 1; i <= arr[currIndex]; i++)
        {
            int subAnswer = minJumpsHelper(currIndex + i, arr, n, storage);
            if (subAnswer == Integer.MAX_VALUE)
                result = Math.min(subAnswer, result);
            else
              result = Math.min(subAnswer + 1, result);
        }
        storage[currIndex] = result;
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(reverseWord("abc"));
        int[] arr = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(minJumps(arr));
    }

}

class MaxComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}