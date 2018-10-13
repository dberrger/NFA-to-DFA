package NFDAconv;

import structure.Edge;
import structure.Graph;
import structure.Node;
import structure.SetStates;


import java.util.*;

public class NDFAconv {
    private Graph graph;
    private ArrayList<SetStates> finalSetOfSets = new ArrayList<>();
    private String prevLetter;
    private SetStates currentSet = new SetStates();
    private ArrayList<String> alphabet = new ArrayList<String>() {{
        add("a");
        add("b");
    }};
//    private SetStates currentSetWithLetter = new SetStates();

    public NDFAconv(Graph graph) {
        this.graph = graph;
    }

    public void init(int startNode) {
        this.currentSet.getStates().add(getNodeByNumber(startNode));
        epsClosure(getNodeByNumber(startNode));
        traverse();
    }

    public void traverse() {
        Queue<SetStates> queueOfSets = new LinkedList<>();
        queueOfSets.add(currentSet);
        finalSetOfSets.add(currentSet);
        while(queueOfSets.peek() != null) {
            currentSet = queueOfSets.poll();
            for (String letter :
                    this.alphabet) {
                SetStates newStates = move(currentSet, letter);
                if(!isExistInFinalSet(newStates)) {
                    queueOfSets.add(newStates);
                    finalSetOfSets.add(newStates);
                }
            }
        }
    }
    
    public boolean isExistInFinalSet(SetStates newStates) {
        for (SetStates set:
        finalSetOfSets) {
            if(set.getStates().equals(newStates.getStates())) return true;
        }
        return false;
    }

    public void epsClosure(Node incomeNode) {
        for (Edge e : incomeNode.getEdges()) {
            if (e.getTransitionCharacter().equals("eps")) {
                this.currentSet.getStates().add(e.getTo());
                epsClosure(e.getTo());
            }
        }
    }

    public void epsClosureWithLetter(SetStates currentSetWithLetter, Node incomeNode, String currentLetter) {
        for (Edge e : incomeNode.getEdges()) {
            if (!e.getTo().isDone() && (e.getTransitionCharacter().equals("eps") || (e.getTransitionCharacter().equals(currentLetter) && !prevLetter.equals(e.getTransitionCharacter())))) {
                currentSetWithLetter.getStates().add(e.getTo());
                incomeNode.setDone(true);
                prevLetter = e.getTransitionCharacter();
                epsClosureWithLetter(currentSetWithLetter, e.getTo(), currentLetter);
            }
        }
    }


    public SetStates move(SetStates states, String letter) {
        SetStates currentSetWithLetter = new SetStates();
        for (Object node :
                states.getStates()) {
            for (Edge e :
                    ((Node) node).getEdges()) {
                if (e.getTransitionCharacter().equals(letter)) {
                    currentSetWithLetter.getStates().add(e.getTo());
                    // TODO: ?TEST?
                    prevLetter = e.getTransitionCharacter();
                    epsClosureWithLetter(currentSetWithLetter ,e.getTo(), letter);
                    clearDones(currentSetWithLetter);
                }
            }
        }
        // names
        System.out.println(":> " + getName(states) + " =[" + letter +"]=>" + getName(currentSetWithLetter) );
        return currentSetWithLetter;
    }

    public String getName(SetStates set) {
        String res = "";
        for (Object n :
                set.getStates()) {
            res += ((Node)n).getName();
        }
        return res;
    }

    public Node getNodeByNumber(int number) {
        for (Node el:
             this.graph.getNodes()) {
            if (el.getName() == number) return el;
        }
        return null;
    }

    public void clearDones(SetStates s) {
        for (Object n:
             s.getStates()) {
            ((Node)n).setDone(false);
        }
    }
}

