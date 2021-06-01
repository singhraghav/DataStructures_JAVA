package com.company.datastrucutures.mytree;

import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        this.children = new ArrayList<>();
    }

    public TreeNode(T data, ArrayList<TreeNode<T>> children){
        this.data = data;
        this.children = children;
    }
}
