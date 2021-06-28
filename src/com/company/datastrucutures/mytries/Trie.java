package com.company.datastrucutures.mytries;

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
}
