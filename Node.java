package com.mortek;
import java.util.ArrayList;

import static com.mortek.Main.routesInfos;

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
    public Node(int state){
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
        return this.state == node.state;
    }


// the following static strings are the information to be written to the file
static String info;
static String info1;
static String info2;
static String info3;
static String info4;

    //  this method get all parents of node leading to the destination
    public SolutionPath solutionPath(){
        ArrayList<Integer> state_sequence= new ArrayList<>();
        double finalpathcost = this.path_cost;
        state_sequence.add(0,this.state);

        Node node = this.parent;
        while (!(node ==null)){
            state_sequence.add(0,node.getState());
            node = node.parent;
        }
        return new SolutionPath(state_sequence, finalpathcost);
    }


    // this method is an implementation of Comparator compareTo compares path costs
    public int compareTo(Node o) {
        return Double.compare(this.getPathCost(),o.getPathCost());
    }
}