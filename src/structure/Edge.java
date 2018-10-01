package structure;

public class Edge {
    private Node from;
    private Node to;
    private String transitionCharacter;

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public String getTransitionCharacter() {
        return transitionCharacter;
    }

    public void setTransitionCharacter(String transitionCharacter) {
        this.transitionCharacter = transitionCharacter;
    }

    public Edge(Node from, Node to, String transitionCharacter) {

        this.from = from;
        this.to = to;
        this.transitionCharacter = transitionCharacter;
    }
}
