package structure;

import java.util.ArrayList;

public class Node {
    private Integer name;
    private ArrayList<Edge> edges;

    public int getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public Node(int name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }
}
