package com.company.mygraphs.disjointset;

import java.util.HashSet;
import java.util.Set;

public class DisjointSetPractice {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i =0; i < n; i++){
            for(int j =0; j < n; j++)
                if (isConnected[i][j] == 1)
                    ds.union(i, j);
        }
        Set<Integer> result = new HashSet<>();
        for(int i = 0 ; i < n; i++)
            result.add(ds.find(i));
        return result.size();
    }

    public boolean validTree(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        for(int i = 0; i < n ; i ++){
            int a = edges[i][0];
            int b = edges[i][1];
            if (!set.union(a, b))
                return false;
        }
        return set.count() == 1;
    }
}
