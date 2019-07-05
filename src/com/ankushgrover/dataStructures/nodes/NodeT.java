package com.ankushgrover.dataStructures.nodes;

/**
 * Node for binary tree
 */
public class NodeT {

    public int value;
    public NodeT left;
    public NodeT right;
    public int height ;

    public NodeT(int value) {
        this.value = value;
        this.height = 1;
    }


}
