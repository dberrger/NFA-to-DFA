package structure;

import java.util.HashSet;
import java.util.Set;

public class SetStates {
    private String name;
    private boolean done;
    private Set<Node> states = new HashSet<>();

    public Set getStates() {
        return states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
