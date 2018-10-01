package NFDAconv;

import structure.Edge;
import structure.Graph;
import structure.Node;
import structure.Set;

import java.util.ArrayList;
import java.util.Arrays;

public class NDFAconv {
    private Graph graph;
    private String currentLetter;
    private Set currentSet;
    private ArrayList<Set> superSet = new ArrayList<>();
    private ArrayList<String> alphabet = new ArrayList<String>() {{
        add("a");
        add("b");
    }};

    public ArrayList<Set> getSuperSet() {
        return superSet;
    }

    public NDFAconv(Graph graph) {
        this.graph = graph;
    }

    public void init(int startNode) {
        // FIXME
        ArrayList<Node> n = new ArrayList<Node>() {{
            add(graph.getNodes().get(startNode));
        }};
        epsClosureByAllSet(n);
        outherMove();
    }


    public void epsClosureByAllSet(ArrayList<Node> initNodes) {
        Set currentSet = new Set();
        for (Node incomeNode :
                initNodes) {
           if(stillNotExistInSet(incomeNode, currentSet.getSet())) currentSet.getSet().add(incomeNode);
            epsClosure(currentSet, incomeNode);
//            currentSet = checkDuplicates(currentSet);
        }
        currentSet.setName(getName(currentSet));
        System.out.println(currentSet.getName());
        if(superSet.size() >= 1) {
            System.out.println(this.currentSet.getName() + " =["+this.currentLetter+"]=> " + currentSet.getName());
        }
        if (!exist(currentSet)) {
            this.superSet.add(currentSet);
        }
    }

    public void outherMove() {
        int sizeOfsuperSet = superSet.size();
        for (int i = 0; i < sizeOfsuperSet; i++) {
            if (!superSet.get(i).isDone()) {
                sizeOfsuperSet = checkSetByAllLetters(superSet.get(i), i);
            }
        }
    }

    public int checkSetByAllLetters(Set set, int number) {
        for (String letter :
                this.alphabet) {
            this.currentLetter = letter;
            this.currentSet = set;
            epsClosureByAllSet(move(set, letter));
        }
        superSet.get(number).setDone(true);
        return superSet.size();
    }

    public void epsClosure(Set currSet, Node incomeNode) {
        for (Edge e : incomeNode.getEdges()) {
//            System.out.println(e.getFrom().getName() + "  -> " + e.getTo().getName() + " by: " + e.getTransitionCharacter());
            if (e.getTransitionCharacter().equals("eps") && stillNotExistInSet(e.getTo(), currSet.getSet())) {
                currSet.getSet().add(e.getTo());
                epsClosure(currSet, e.getTo());
            }
        }
    }


    public ArrayList<Node> move(Set state, String letter) {
        ArrayList<Node> nodesAfterLetter = new ArrayList<>();
        for (Node node :
                state.getSet()) {
//            if(node.getEdges().size() == 0) {
//                nodesAfterLetter.add(new Node(999));
//                return nodesAfterLetter;}
            for (Edge e :
                    node.getEdges()) {
                if (e.getTransitionCharacter().equals(letter) && stillNotExistInSet(e.getTo(), nodesAfterLetter)) {
                    nodesAfterLetter.add(e.getTo());
                }
            }
        }
        return nodesAfterLetter;
    }

    public boolean stillNotExistInSet(Node toAdd, ArrayList<Node> nodesAfterLetter) {
        if(nodesAfterLetter.size() == 0) return true;
        for (Node n:
             nodesAfterLetter) {
            if(toAdd.getName() == n.getName()) {
                return false;
            }
        }
        return true;
    }
    // TODO if set already exists in the superset
    public boolean exist(Set set) {
        for (int i = 0; i < superSet.size(); i++) {
            String[] a = superSet.get(i).getName().split("");
            int[] array = Arrays.stream(getName(set).split("")).mapToInt(Integer::parseInt).toArray();
            int[] array2 = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(array);
            Arrays.sort(array2);
            if(Arrays.equals(array ,array2)) {
                return true;
            }
        }
        return false;
    }

//    String[] ary = "abc".split("");

    public String getName(Set set) {
        String res = "";
        for (Node n :
                set.getSet()) {
            res += n.getName();
        }
        return res;
    }
}

