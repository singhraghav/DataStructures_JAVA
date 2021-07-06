package com.company.algorithms.dp;

public class Advanced {
    public static int minimumCostPath(int[][] matrix, int x, int y) {
        if (x == matrix[0].length - 1 && y == matrix.length - 1)
            return matrix[x][y];
        if(x < 0 || y < 0 || y >= matrix.length || x >= matrix[0].length)
            return Integer.MAX_VALUE;
        int path1 = minimumCostPath(matrix, x + 1, y);
        int path2 = minimumCostPath(matrix, x + 1, y + 1);
        int path3 = minimumCostPath(matrix, x, y + 1);

        return matrix[x][y] + Math.min(path1, Math.min(path2, path3));
    }

    public static int minimumCostPathM(int[][] matrix,int[][] storage, int x, int y) {
        if (x == matrix[0].length - 1 && y == matrix.length - 1)
        {
            storage[x][y] = matrix[x][y];
            return matrix[x][y];
        }
        if(x < 0 || y < 0 || y >= matrix.length || x >= matrix[0].length)
            return Integer.MAX_VALUE;
        if(storage[x][y] != -1) return storage[x][y];
        int path1 = minimumCostPathM(matrix, storage, x + 1, y);
        int path2 = minimumCostPathM(matrix, storage, x + 1, y + 1);
        int path3 = minimumCostPathM(matrix, storage, x, y + 1);
        storage[x][y] = matrix[x][y] + Math.min(path1, Math.min(path2, path3));
        return storage[x][y];
    }

    public static int longestSubsequence(String s, String t){
        if(s.length() == 0 || t.length() == 0) return 0;
        if(s.charAt(0) == t.charAt(0))
            return 1 + longestSubsequence(s.substring(1), t.substring(1));
        else
            return Math.max(longestSubsequence(s, t.substring(1)), longestSubsequence(s.substring(1), t));
    }

    public static int longestSubsequenceM(String s, String t){
        int[][] storage = new int[s.length()+1][t.length()+1];
        for (int i = 0 ; i < s.length()+1; i++)
        {
            for(int j =0; j <= t.length(); j++)
                storage[i][j] = -1;
        }
        return lcsM(s, t, storage);
    }

    public static int lcsM(String s, String t, int[][] storage){
        int m = s.length();
        int n = t.length();
        if (m == 0 || n == 0)
        {
            storage[m][n] = 0;
            return 0;
        }
        if (storage[m][n] != -1)
            return storage[m][n];

        if(s.charAt(0) == t.charAt(0)){
            int length =  1 + lcsM(s.substring(1), t.substring(1), storage);
            storage[m][n] = length;
            return length;
        } else {
           int length =  Math.max(lcsM(s, t.substring(1), storage), lcsM(s.substring(1), t, storage));
           storage[m][n] = length;
           return length;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {4,5,2}, {7,8,9}};
        System.out.println(minimumCostPath(matrix, 0, 0));
        System.out.println(longestSubsequenceM("abcfgsadfasaddsaasdasdasdsad", "abcdfdasdsadsafdasdasasdasdas"));
        System.out.println(longestSubsequence("abcfgsadfasaddsaasdasdasdsad", "abcdfdasdsadsafdasdasasdasdas"));
    }
}
