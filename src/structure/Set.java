package structure;

import java.util.ArrayList;

public class Set {
    private String name;
    private boolean done;



    private ArrayList<Node> set = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getSet() {
        return set;
    }

    public void clear() {
        this.set.clear();
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setSet(ArrayList<Node> set) {
        this.set = set;
    }

}
