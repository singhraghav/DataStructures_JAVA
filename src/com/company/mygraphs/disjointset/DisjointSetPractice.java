package com.company.mygraphs.disjointset;

import com.company.practice.Pair;

import java.util.*;

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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DisjointSet ds = new DisjointSet(n);


        for(List<Integer> p: pairs) {
            ds.union(p.get(0), p.get(1));
        }

        StringBuilder sb = new StringBuilder();
        Map<Integer, PriorityQueue<Character>> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int root = ds.find(i);
            if (!mp.containsKey(root)){
                mp.put(root, new PriorityQueue<>());
            }
            PriorityQueue<Character> t = mp.get(root);
            t.add(s.charAt(i));
        }

        for (int i =0; i < n; i++){
            int root = ds.find(i);
            sb.append(mp.get(root).poll());
        }
        return sb.toString();
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Pair<String, Double>> gidWeight = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            String dividend = eq.get(0);
            String divisor = eq.get(1);
            Double quotient = values[i];
            union(gidWeight, dividend, divisor, quotient);
        }
    }

    private Pair<String, Double> find(HashMap<String, Pair<String, Double>> gidWeight, String id) {
        if (!gidWeight.containsKey(id))
            gidWeight.put(id, new Pair<String, Double>(id, 1.0));
        Pair<String, Double> entry = gidWeight.get(id);
        // if this is not the root
        if(!entry.first.equals(id)) {
            Pair<String, Double> newEntry = find(gidWeight, entry.first);
            gidWeight.put(id, new Pair<>(newEntry.first, newEntry.second * entry.second));
        }
        return gidWeight.get(id);
    }

    private void union(HashMap<String, Pair<String, Double>> gidWeight, String dividend, String divisor, Double quotient){
        Pair<String, Double> dividendEntry = find(gidWeight, dividend);
        Pair<String, Double> divisorEntry = find(gidWeight, divisor);

        String dividendGid = dividendEntry.first;
        String divisorGid = divisorEntry.first;
        Double dividendWeight = dividendEntry.second;
        Double divisorWeight = divisorEntry.second;

        if (!dividendGid.equals(divisorGid)) {
            gidWeight.put(dividendGid, new Pair<>(divisorGid, divisorWeight * quotient / dividendWeight));
        }
    }
}
