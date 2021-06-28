package com.company.datastrucutures.mytries;

public class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int numChildren;

    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        numChildren = 0;
    }
}
