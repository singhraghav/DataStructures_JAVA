package com.company.datastrucutures.myhashmap;

import java.util.ArrayList;
import java.util.Map;

class MapNode <K, V> {
    K key;
    V value;
    MapNode<K, V> next;

    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
        next = null;
    }
}

public class MyMap <K, V>{
    private ArrayList<Map<K,V>> map;
    private int size;
    int numBuckets;

    public MyMap(int n){
        numBuckets = n;
        map = new ArrayList<>(n);
        for(int i = 0 ; i <n; i++){
            map.add(null);
        }
    }

    public void add(K Key, V value){

    }
}
