package com.mortek;

import java.util.ArrayList;
import java.util.Objects;

/**
 * the node class implements the Comparable interface which allows
 * to create a method that allows us to compare path cost
 */
public class Node implements Comparable<Node>{
    private int state;
    private Node parent;
    private int action;
    private double path_cost;

    /**
     * Constructor of Node class
     * @param state
     * @param parent
     * @param action
     * @param pathCost
     */
    public Node(int state, Node parent, int action, double pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.path_cost = pathCost;
    }
    public Node(Integer state){
        this.state = state;
        this.parent = null;
        this.action = 0;
        this.path_cost = 0.0;
    }


    public int getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public int getAction() {
        return action;
    }

    public double getPathCost() {
        return path_cost;
    }

    @Override
    public String toString() {
        {
            return "Node{" +
                    "state='" + state + '\'' +
                    ", parent='" + parent + '\'' +
                    ", action='" + action + '\'' +
                    ", path_cost='" + path_cost + '\'' +
                    '}';
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return state == node.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, parent, action, path_cost);
    }

//  get all parents of node leading to the destination
    public Object[] solutionPath(){
        ArrayList<Integer> state_sequence= new ArrayList<>();
        state_sequence.add(0,state);
        double path_cost = this.getPathCost();


        Node node = this.parent;
        while (!(node ==null)){
            state_sequence.add(0,node.getState());
            node = node.parent;
        }

        return new Object[]{state_sequence,path_cost};
    }


    //        Comparator compareTo compares path costs
    public int compareTo(Node o) {
        return Double.compare(this.getPathCost(),o.getPathCost());
    }
}