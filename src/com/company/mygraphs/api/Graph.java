package com.company.mygraphs.api;

import java.util.ArrayList;

public class Graph {
    private final int vertices;
    private int edges;

    ArrayList<ArrayList<Integer>> bag;

    public Graph(int v){
        this.vertices = v;
        this.edges = 0;
        bag = new ArrayList<ArrayList<Integer>>(v);

        for(int i =0; i < v; i++)
            bag.add(i, new ArrayList<Integer>());
    }

    void addEdge(int v, int w){
        bag.get(v).add(w);
        bag.get(w).add(v);
        edges += 2;
    }

    Iterable<Integer> adj(int v) {
        return bag.get(v);
    }

    int V(){
        return this.vertices;
    }

    int E(){
        return this.edges;
    }
}
