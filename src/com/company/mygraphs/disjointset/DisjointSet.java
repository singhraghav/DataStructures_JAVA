package com.company.mygraphs.disjointset;

public class DisjointSet {

    private final int[] id;
    private final int[] size;
    private int count;

    public DisjointSet(int n) {
    id = new int[n];
    size = new int[n];
    count = n;

    for(int i =0; i < n; i++)
    {
        id[i] = i;
        size[i] = 1;
    }
    }

    // merge two nodes into one component
    boolean union(int p, int q) {
        int p_root = find(p);
        int q_root = find(q);
        if(p_root == q_root) return false;
        if (size[p_root] < size[q_root]) {
            id[p_root] = q_root;
            size[q_root] += size[p_root];
        } else {
            id[q_root] = p_root;
            size[p_root] += size[q_root];
        }
        count--;
        return true;
    }

    //Tells if two nodes are connected or not
    boolean connected(int p, int q) {
       return find(p) == find(q);
    }

    //Find root
    int find(int p){
       if(p == id[p])
           return p;
       return id[p] = find(id[p]);
    }
    // return number of connected components
    int count() {
        return this.count;
    }

}
