package com.company.mygraphs.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.company.LeetCode.Node;

public class BfsGraph {

    public Node connect(Node root) {
        if(root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node top = queue.remove();
            if(top != null) {
                if(queue.peek() != null){
                    top.next = queue.peek();
                }
                if(top.left != null)
                    queue.add(top.left);
                if(top.right != null)
                    queue.add(top.right);
                if (queue.peek() == null)
                    queue.add(null);
            }
        }
        return root;
    }

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0)
            return -1;

        Queue<int[][]> queue = new LinkedList<>();
        queue.add(new int[][]{{0, 0}});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[][] top = queue.remove();
            int curr_i = top[0][0];
            int curr_j = top[0][1];

            if(curr_i == grid.length - 1 && curr_j == grid.length - 1)
                return grid[curr_i][curr_j];

            for(int[] direction: directions){
                int next_i = curr_i + direction[0];
                int next_j = curr_j + direction[1];

                if(isValid(grid, next_i, next_j)){
                    queue.add(new int[][]{{next_i, next_j}});
                    grid[next_i][next_j] = grid[curr_i][curr_j] + 1;
                }
            }
        }

        return  -1;
    }

    private boolean isValid(int[][] grid, int next_i, int next_j) {
        return next_i>= 0 && next_j >= 0 && next_i < grid.length && next_j < grid.length && grid[next_i][next_j] == 0;
    }

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[][]> queue = new LinkedList<>();

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int currentTime = -1;

        for(int i =0; i < grid.length; i++) {
            for(int j =0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[][]{{i, j}});
                }
                if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        queue.add(null);

        while (!queue.isEmpty() && freshOranges > 0){
            int[][] curr_x_y = queue.poll();

            if(curr_x_y == null){
                currentTime++;
                if(!queue.isEmpty())
                    queue.add(null);
            } else {
                int x = curr_x_y[0][0];
                int y = curr_x_y[0][1];

                for(int[] direction: directions){
                    int next_i = direction[0] + x;
                    int next_j = direction[1] + y;
                    if(isValidMove(grid, next_i, next_j)){
                        freshOranges--;
                        grid[next_i][next_j] = 2;
                        queue.add(new int[][]{{next_i, next_j}});
                    }
                }
            }
        }

        if (freshOranges == 0)
            return currentTime;
        else
            return -1;
    }

    private boolean isValidMove(int[][] grid, int next_i, int next_j) {
        return next_i >=0 && next_j >= 0 && next_i < grid.length && next_j < grid.length && grid[next_i][next_j] == 1;
    }


}

class NGraph{

    private final int N;
    private final ArrayList<ArrayList<Integer>> nodes;
    private int E;

    public NGraph(int n) {
        this.N = n;
        this.nodes = new ArrayList<>(n);
        for(int i =0; i < n; i++){
            nodes.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b){
        this.nodes.get(a).add(b);
        this.nodes.get(b).add(a);
        E += 2;
    }

    public int getE() {
        return E;
    }

    public ArrayList<Integer> adjacentNodes(int node){
        return nodes.get(node);
    }

    public int getN() {
        return N;
    }
}
