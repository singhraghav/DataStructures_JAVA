package com.company.practice.recursion;

import com.company.datastrucutures.Pair;

import java.util.*;

public class BackTracking {

    public static void printPermutationR(String str, String osf) {
        if(str.length() == 0) {
            System.out.println(osf);
            return;
        }
        for (int i = 0 ; i < str.length(); i++) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(i+1);
            printPermutationR(prefix + suffix, str.charAt(i) + "" + osf);
        }
    }

    public static void printPermutationB(StringBuffer str, int j) {
        if(j == str.length() - 1) {
            System.out.println(str);
            return;
        }
        for(int i=j; i < str.length(); i++) {
            swap(j, i, str);
            printPermutationB(str, j + 1);
            swap(j, i, str);
        }
    }

    public static int totalWays(int i, int j, int n, int m, int[][] maze, String path) {
        if(i == n - 1 && j == m -1) {
            System.out.println(path);
            return 1;
        }
        if(i < 0 || i >= n || j < 0 || j >= m)
            return 0;
        if (maze[i][j] == -1)
            return 0;
        maze[i][j] = -1;
        int upward = totalWays(i-1, j, n, m, maze, path + "U");
        int downward = totalWays(i+1, j, n, m, maze, path + "D");
        int left = totalWays(i, j-1, n, m, maze, path + "L");
        int right = totalWays(i, j+1, n, m, maze,path + "R");
        maze[i][j] = 0;
        return upward + downward + left + right;
    }

    public static void swap(int i, int j, StringBuffer s) {
        String temp = s.charAt(i) + "";
        s.replace(i, i +1, s.charAt(j) + "");
        s.replace(j, j+1, temp);
    }

    static int nQueensWay = 0;
    public static void printBoard(int[][] board, int n, int m) {
        for(int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void nQueens(int i, int n, int numQueens, int[][] board) {
        if(i >= n) {
            nQueensWay += 1;
            printBoard(board, n, n);
            System.out.println();
            return;
        }
        for(int j =0; j < n; j++) {
            if (isSafe(i, j, n, board)) {
                board[i][j] = 1;
                nQueens(i+1, n, numQueens--, board);
                board[i][j] = 0;
            }
        }
        return;
    }

    public static boolean isSafe(int i, int j, int n, int[][] board) {
       for(int k = i; k >=0; k--) {
           if(board[k][j] == 1)
               return false;
       }

       for(int u=i,rd=j; u >=0 && rd < n; u--, rd++) {
           if (board[u][rd] == 1)
               return false;
       }

        for(int u=i,ld=j; u >=0 && ld >= 0; u--, ld--) {
            if (board[u][ld] == 1)
                return false;
        }

       return true;
    }
    static List<Pair<Integer, Integer>> possibleMoves(int i, int j) {
        List<Pair<Integer, Integer>> moves = new LinkedList<>();
        moves.add(new Pair<>(i + 2, j + 1));
        moves.add(new Pair<>(i + 2, j - 1));
        moves.add(new Pair<>(i - 2, j + 1));
        moves.add(new Pair<>(i - 2, j - 1));
        moves.add(new Pair<>(i - 1, j - 2));
        moves.add(new Pair<>(i + 1, j - 2));
        moves.add(new Pair<>(i - 1, j + 2));
        moves.add(new Pair<>(i + 1, j + 2));
        return moves;
    }
    static int all_x[] = {2, 2, -2, -2, -1, 1, -1, 1};
    static int all_y[] = {1, -1, 1, -1, -2, -2, 2, 2};

    static void allTraversed(int[][] board, int move, int i, int j, int n, int m) {
        if (move == n * m) {
            printBoard(board, n, m);
            return ;
        }
        for (int k =0; k < 8; k++) {
            int x = i + all_x[k];
            int y = j + all_y[k];
            boolean isNextMoveInvalid = x >= n || x < 0 || y >= m || y < 0;
            if (!isNextMoveInvalid && board[x][y] == 0) {
                board[i][j] = move;
//                System.out.println("At (" + i + ", " + j +") " + "move - " + move);
                allTraversed(board, move + 1, x, y, n, m);
//                if (isPossible)
//                    break;
                board[i][j] = 0;
//                System.out.println("undone (" + i + ", " + j +") " + "move - " + move);
            }
        }
        return;
    }

//    public static void main(String[] args) {
////        printPermutationR("ABC", "");
////        System.out.println(" ***** BACKTRACKING SOLUTION *****");
////        printPermutationB(new StringBuffer("ABC"), 0);
////        int[][] maze = new int[7][7]
////        System.out.println(totalWays(0, 0, 7, 7, maze, ""));
//        int n = 5;
//        int[][] board= new int[n][n];
//        allTraversed(board, 1, 0, 0, n, n);
////        nQueens(0, 5, 5, board);
//    }

    public static int superDigit(String n, int k) {
        if(n.length() == 1)
            return Integer.parseInt(n);
        long sum = 0;
        for(int i = 0 ; i < n.length(); i++)
            sum += Integer.parseInt(n.charAt(i) + "");
        if (k > 1)
            return superDigit((sum * k) + "", 1);
        else
            return superDigit(sum + "", 1);
    }

    static boolean isBadVersion(int version) {return false;}
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = (start + end) / 2;
            if(isBadVersion(mid)){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int idx = nums.length - 1;

        while (l <= r) {
            if(Math.abs(nums[l]) < Math.abs(nums[r])) {
                result[idx] = nums[r] * nums[r];
                r--;
            } else {
                result[idx] = nums[l] * nums[l];
                l++;
            }
            idx--;
        }
        return result;
    }
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            while(nums[l] == 0) {
                int last = nums[r];
                r--;
                shift(l, r, nums, last);
            }
            l++;
        }
    }

    private void shift(int l, int r, int[] a, int lastElement) {
        for(int i = l; i < r; i++) {
            a[i] = a[i+1];
        }
        a[r] = lastElement;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int colorToChange = image[sr][sc];
        return floodFillHelper(image, sr, sc, newColor, colorToChange);
    }

    public static int[][] floodFillHelper(int[][] image, int sr, int sc, int newColor, int colorToChange) {
        if(sr >= image.length || sr < 0 || sc >= image[sr].length || sc < 0) {
            return image;
        }
         if(image[sr][sc] != colorToChange)
             return image;
         else {
             image[sr][sc] = newColor;
             int[][] upperUpdated = floodFillHelper(image, sr-1, sc, newColor, colorToChange);
             int[][] bottomUpdated = floodFillHelper(upperUpdated, sr+1, sc, newColor, colorToChange);
             int[][] leftUpdated = floodFillHelper(bottomUpdated, sr, sc - 1, newColor, colorToChange);
             int[][] rightUpdated = floodFillHelper(leftUpdated, sr, sc + 1, newColor, colorToChange);
             return rightUpdated;
         }
    }
    public static void main(String[] args) {
//        System.out.println(checkInclusion("pwwkew", ""));
        int[][] image = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(image));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1) {
                    int areaForThisIsland = maxAreaOfIslandHelper(grid, i, j);
                    if(areaForThisIsland > maxArea)
                        maxArea = areaForThisIsland;
                }
            }
        }
        return maxArea;
    }

    private static int maxAreaOfIslandHelper(int[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int areaFromUp = maxAreaOfIslandHelper(grid, i - 1, j);
        int areaFromDown = maxAreaOfIslandHelper(grid, i + 1, j);
        int areaFromLeft = maxAreaOfIslandHelper(grid, i, j - 1);
        int areaFromRight = maxAreaOfIslandHelper(grid, i, j + 1);
        int areaFromIJ = 1 + areaFromUp + areaFromDown + areaFromLeft + areaFromRight;
        return areaFromIJ;
    }
}
