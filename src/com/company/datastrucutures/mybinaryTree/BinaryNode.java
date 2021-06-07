package com.company.datastrucutures.mybinaryTree;

public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data, BinaryNode<T> node, boolean isLeft){
        this.data = data;
        if(isLeft)
        {
            this.left = node;
            this.right = null;
        }
        else
        {
            this.right = node;
            this.left = null;
        }
    }
}
