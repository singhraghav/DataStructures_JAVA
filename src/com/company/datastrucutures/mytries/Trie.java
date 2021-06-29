package com.company.datastrucutures.mytries;

import java.util.LinkedList;
import java.util.List;

public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }

    public void add(String s){
        add(root, s);
    }

    private void add(TrieNode root, String word) {
        if(word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
        {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.numChildren++;
        }
        add(child, word.substring(1));
    }

    public void remove(String s){
        remove(root, s);
    }

    private void remove(TrieNode root, String s)
    {
        if (s.length() == 0)
        {
            root.isTerminating = false;
            return;
        }

        int childIndex = s.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return;
        remove(child, s.substring(1));
        if (!child.isTerminating && child.numChildren == 0){
            root.children[childIndex] = null;
            child = null;
            root.numChildren--;
        }
    }

    public boolean search(String s){
        return search(root, s);
    }

    private boolean search(TrieNode root, String s){
        if (s.length() == 0)
        {
            return root.isTerminating;
        }
        int childIndex = s.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return false;
        return search(child, s.substring(1));
    }

    public List<String> startsWith(String word) {
        return startsWithHelper(root, word, "");
    }

    private List<String> startsWithHelper(TrieNode root, String start, String currentWord) {
     if(start.length() == 0) {
         return findAll(root, currentWord);
     }
     int childIndex = start.charAt(0) - 'a';
     TrieNode child = root.children[childIndex];
     if(child == null)
         return new LinkedList<>();

     return startsWithHelper(child, start.substring(1), currentWord + start.charAt(0));
    }

    private LinkedList<String> findAll(TrieNode root, String currentWord) {
        LinkedList<String> result = new LinkedList<>();
        if (root.isTerminating) result.add(currentWord);

        for(int i = 0; i < root.children.length; i++)
        {
            TrieNode child = root.children[i];
            if(child != null) {
                LinkedList<String> subResult = findAll(child, currentWord + child.data);
                result.addAll(subResult);
            }
        }
        return result;
    }
}
