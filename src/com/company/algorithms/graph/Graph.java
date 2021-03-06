package com.company.algorithms.graph;

import java.util.*;

public class Graph {

    public static void printGraph(int currentVertex, int[][] edges,boolean visited[]) {
        System.out.println(currentVertex);
        visited[currentVertex] = true;
        for(int i = 0; i < edges[0].length; i++)
        {
            if(edges[currentVertex][i] == 1 && !visited[i])
                printGraph(i, edges, visited);
        }
        return;
    }

    public static void printDfs(int[][] edges) {
        boolean visited[] = new boolean[edges.length];

        for(int i = 0 ; i < visited.length; i++)
        {
            if(!visited[i])
                printGraph(i, edges, visited);
        }
    }

    public static void printBfs(int[][] edges){
        boolean visited[] = new boolean[edges.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < edges.length; i++)
        {
            if(!visited[i]){
                q.add(i);
                visited[i] = true;

                while(!q.isEmpty())
                {
                    int currentVertex = q.remove();
                    System.out.println(currentVertex);
                    for(int j = 0; j < edges.length; j++)
                    {
                        if(edges[currentVertex][j] == 1 && !visited[j])
                        {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }

    public static boolean hasPath(int[][] edges, int sv, int ev, boolean[] visited)
    {
        // If there is a direct path return true
        if(edges[sv][ev] == 1) return true;
        // find indirect path using dfs
        visited[sv] = true;
        for(int i =0; i < edges.length; i++)
        {
            if(edges[sv][i] == 1 && !visited[i])
                return hasPath(edges, i, ev, visited);
        }
        return false;
    }

    public static LinkedList<Integer> dfsPath(int[][] edges, int sv, int ev){
        boolean[] visited = new boolean[edges.length];
        return  dfsPath(edges, sv, ev, visited);
    }

    public static LinkedList<Integer> dfsPath(int[][] edges, int sv, int ev, boolean[] visited){
        visited[sv] = true;
        LinkedList<Integer> pathFromSv = new LinkedList<>();
        if(sv == ev)
        {
            pathFromSv.add(0, sv);
            return pathFromSv;
        }

        for(int i =0; i < edges.length; i++)
        {
            if(edges[sv][i] == 1 && !visited[i])
            {
                LinkedList<Integer> pathFromI = dfsPath(edges, i, ev, visited);
                if(!pathFromI.isEmpty()){
                    pathFromI.add(0, sv);
                    return pathFromI;
                }
            }
        }

        return pathFromSv;
    }

    public static LinkedList<Integer> bfsPath(int[][] edges, int sv, int ev){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        q.add(sv);
        visited[sv] = true;
        boolean evPresent = false;
        Map<Integer, Integer> pathBuilder = new HashMap<>();

        while (!q.isEmpty())
        {
            int cv = q.remove();

            for(int i = 0; i < edges.length; i++)
            {
                if (edges[cv][i] == 1 && !visited[i])
                {
                    q.add(i);
                    pathBuilder.put(i, cv);
                    visited[i] = true;
                    if (i == ev)
                    {
                        evPresent = true;
                        break;
                    }
                }
            }
            if (evPresent)
                break;
        }

        if (evPresent){
            LinkedList<Integer> path = new LinkedList<>();
            System.out.println(pathBuilder);
            while ( ev != sv)
            {
                path.add(ev);
                ev = pathBuilder.get(ev);
            }
            path.add(sv);
            return path;
        }
        return new LinkedList<Integer>();
    }

    public static void main(String[] args) {
        int n;
        int e;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        e = s.nextInt();

        int[][] edges = new int[n][n];

        for(int i = 0 ; i < e; i++)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            edges[a][b] = 1;
            edges[b][a] = 1;
        }
        printDfs(edges);
        System.out.println("/////////////");
        printBfs(edges);
        boolean[] visited = new boolean[edges.length];
        System.out.println(hasPath(edges,0, 4, visited));//true
        System.out.println(hasPath(edges,0, 6, visited));//false
        /*
        *  7
        *  7
        *  0 1
        *  0 2
        *  1 2
        *  1 3
        *  2 4
        *  3 4
        *  5 6
        *
        * */

        System.out.println(dfsPath(edges, 0,3));
        System.out.println("///BFS///");
        System.out.println(bfsPath(edges,0,3));
    }
}
