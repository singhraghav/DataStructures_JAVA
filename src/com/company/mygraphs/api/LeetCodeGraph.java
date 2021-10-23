package com.company.mygraphs.api;

import com.company.practice.Pair;

import java.util.*;

public class LeetCodeGraph {

//
//    public boolean validPath(int n, int[][] edges, int start, int end) {
//        int[][] graph = new int[n][n];
//
//        for(int i =0; i < edges.length; i++) {
//            int a = edges[i][0];
//            int b = edges[i][1];
//            graph[a][b] = 1;
//            graph[b][a] = 1;
//        }
//        boolean[] visited = new boolean[n];
//        dfs(graph, start, visited);
//        return visited[end];
//    }

//    void dfs(int[][] graph, int start, boolean[] visited) {
//        visited[start] = true;
//        for(int i =0; i < graph.length; i++) {
//            if(i != start && graph[start][i] == 1 && !visited[i])
//                dfs(graph, i, visited);
//        }
//    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int start = 0;
        int destination = graph.length - 1;
        boolean[] visited = new boolean[destination];
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> currPath = new LinkedList<>();
        dfs(visited, start, destination, graph, result, currPath);
        return result;
    }

    public void dfs(boolean[] visited, int start, int destination, int[][] graph, List<List<Integer>> result, LinkedList<Integer> currPath){
        if(start == destination){
            currPath.add(destination);
            result.add(new LinkedList<>(currPath));
            return;
        }
        visited[start] = true;
        currPath.add(start);
        for(int i : graph[start]) {
            if(!visited[i]){
                dfs(visited, i, destination, graph, result, currPath);
            }
        }
        currPath.removeLast();
        visited[start] = false;
    }
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;

        if(visited.containsKey(node))
            return visited.get(node);

        Node clonedNode = new Node(node.val);
        for(Node adj: node.neighbors){
            clonedNode.neighbors.add(cloneGraph(adj));
        }
        return clonedNode;
    }

    void dfsClone(Set<Integer> visited, Map<Integer, Node> graph, Node currNode) {
        visited.add(currNode.val);
        if(!graph.containsKey(currNode.val))
            graph.put(currNode.val, new Node(currNode.val));

        for(Node adj: currNode.neighbors) {
            if(!visited.contains(adj.val)){
                if(!graph.containsKey(adj.val))
                    graph.put(adj.val, new Node(adj.val));
                graph.get(currNode.val).neighbors.add(graph.get(adj.val));
                graph.get(adj.val).neighbors.add(graph.get(currNode.val));
                dfsClone(visited, graph, adj);
            }
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Set<String> visited = new HashSet<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(!graph.containsKey(from))
                graph.put(from, new PriorityQueue<>());
            if(!graph.containsKey(to))
                graph.put(to, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        LinkedList<String> result = new LinkedList<>();
        result.add("JFK");
        dfsItinerary("JFK", result, visited, graph);
        return result;
    }

    public void dfsItinerary(String source, LinkedList<String> result, Set<String> visited, Map<String, PriorityQueue<String>> graph) {
        PriorityQueue<String> adj = graph.get(source);
        for(String to: adj) {
            String newPath = source + " " + to;
            if(!visited.contains(newPath)){
                result.add(to);
                visited.add(newPath);
                dfsItinerary(to, result, visited, graph);
            }
            break;
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
