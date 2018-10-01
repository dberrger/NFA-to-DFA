package structure;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addNodeToGraph() {
        this.nodes.add(new Node(nodes.size()));
    }

    public void addEdgeToGraph(int from, int to, String transitionCharacter) {
        this.nodes.get(from).getEdges().add(new Edge(this.nodes.get(from), this.nodes.get(to), transitionCharacter));
    }
}
