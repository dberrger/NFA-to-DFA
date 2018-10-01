package com.company;

import NFDAconv.NDFAconv;
import structure.Graph;
import structure.Set;

public class Main {
    public static void printSet(NDFAconv x) {
        for (Set i:
                x.getSuperSet()) {

                System.out.print(i.getName());

            System.out.println('\n');
        }
    }
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello");
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


//        g.addNodeToGraph();
//        g.addNodeToGraph();
//
//        g.addEdgeToGraph(0,1,"a");
//        g.addEdgeToGraph(0,0,"a");
//        g.addEdgeToGraph(0,0,"b");
//        g.addEdgeToGraph(1,0,"b");
//        g.addEdgeToGraph(1,1,"b");

//        g.addNodeToGraph();
//        g.addNodeToGraph();
//        g.addNodeToGraph();
//        g.addNodeToGraph();
//
//        g.addEdgeToGraph(0,1,"a");
//        g.addEdgeToGraph(0,2,"a");
//        g.addEdgeToGraph(0,3,"b");
//        g.addEdgeToGraph(1,3,"b");
//        g.addEdgeToGraph(2,3,"a");

//        g.addNodeToGraph();
//        g.addNodeToGraph();
//        g.addNodeToGraph();
//        g.addEdgeToGraph(0,1,"eps");
//        g.addEdgeToGraph(0,1,"a");
//        g.addEdgeToGraph(1,0,"b");
//        g.addEdgeToGraph(1,1,"b");
//        g.addEdgeToGraph(1,2,"eps");
        x.init(0);
        printSet(x);

    }
}
