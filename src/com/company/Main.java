package com.company;

import NFDAconv.NDFAconv;
import structure.Graph;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        NDFAconv x = new NDFAconv(g);

        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addNodeToGraph();
        g.addEdgeToGraph(0,1,"eps");
        g.addEdgeToGraph(0,7,"eps");
        g.addEdgeToGraph(1,2,"eps");
        g.addEdgeToGraph(1,4,"eps");
        g.addEdgeToGraph(2,3,"a");
        g.addEdgeToGraph(4,5,"b");
        g.addEdgeToGraph(3,6,"eps");
        g.addEdgeToGraph(6,7,"eps");
        g.addEdgeToGraph(5,6,"eps");
        g.addEdgeToGraph(6,1,"eps");
        g.addEdgeToGraph(7,8,"a");
        g.addEdgeToGraph(8,9,"b");
        g.addEdgeToGraph(9,10,"b");

        x.init(0);

    }
}
