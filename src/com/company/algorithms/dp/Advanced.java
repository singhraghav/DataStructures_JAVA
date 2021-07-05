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

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {4,5,2}, {7,8,9}};
        System.out.println(minimumCostPath(matrix, 0, 0));
    }
}
