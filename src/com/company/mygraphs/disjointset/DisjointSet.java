package com.company.mygraphs.disjointset;

public class DisjointSet {

    private final int[] id;
    private final int[] size;

    public DisjointSet(int n) {
    id = new int[n];
    size = new int[n];

    for(int i =0; i < n; i++)
    {
        id[i] = i;
        size[i] = 1;
    }
    }

    // merge two nodes into one component
    void union(int p, int q) {
        int p_root = find(p);
        int q_root = find(q);
        if(p_root == q_root) return;
        if (size[p_root] < size[q_root]) {
            id[p_root] = q_root;
            size[q_root] += size[p_root];
        } else {
            id[q_root] = p_root;
            size[p_root] += size[q_root];
        }
    }

    //Tells if two nodes are connected or not
    boolean connected(int p, int q) {
       return find(p) == find(q);
    }

    //Find root
    int find(int p){
       while (p != id[p])
           p = id[p];
       return p;
    }

}
