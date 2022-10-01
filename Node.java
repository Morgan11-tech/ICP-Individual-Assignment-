package com.mortek;
import java.util.ArrayList;

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
    public ArrayList<ArrayList<Integer>> solutionPath(){
        int counter = 0;

        ArrayList<Integer> state_sequence= new ArrayList<>();
        state_sequence.add(0,state);
        double path_cost = this.getPathCost();


        Node node = this.parent;
        while (!(node ==null)){
            state_sequence.add(0,node.getState());
            node = node.parent;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(state_sequence);
        ArrayList<String> sourcecodes = new ArrayList<>();
        ArrayList<Integer> sourceID = new ArrayList<>();

        for (ArrayList<Integer> element: result) {
            for (int num = 0; num < element.size(); num++) {
                sourceID.add(element.get(num));
                if (!(element.get(num) == state)) {
                    sourcecodes.add(Main.getRoutebySourceID(num));
                    counter += 1;
                }


            }
            for (int i = 0; i < sourcecodes.size(); i++) {
                if (sourcecodes.size() == 2) {
                    String destination = (Main.getRoutebySourceID(element.get(element.size() - 1)));
                    String root = Main.getRoutebySourceID(element.get(i));
                    System.out.println(destination + " from " + root + " " + 0 + " stops");
                } else {
                    Main.getRoutebySourceID(element.get(i + 1));
                    Main.getRoutebySourceID(element.get(i));
                   Main.getRoutebySourceID(element.get(element.size() - 1));


                    System.out.println(Main.getRoutebySourceID(element.get(i + 1)) + " from " + Main.getRoutebySourceID(element.get(i)) + " to " + Main.getRoutebySourceID(element.get(element.size() - 1)) + " " + 0 + " stops");
                }
                info = Main.getRoutebySourceID(element.get(1)) + " from " + Main.getRoutebySourceID(element.get(0)) + " to " + Main.getRoutebySourceID(element.get(3)) + " " + 0 + " stops";
                info1 = Main.getRoutebySourceID(element.get(2)) + " from " + Main.getRoutebySourceID(element.get(1)) + " to " + Main.getRoutebySourceID(element.get(3)) + " " + 0 + " stops";
                info2 = Main.getRoutebySourceID(element.get(3)) + " from " + Main.getRoutebySourceID(element.get(2)) + " to " + Main.getRoutebySourceID(element.get(3)) + " " + 0 + " stops";



            }
            double pathcost;

        }

        info3 ="Total number of flights : "+ counter;
        info4 ="Total pathcost is: "+ Haversine.distanceHaversine(sourceID.get(0), sourceID.get(sourceID.size()-1));
        System.out.print("The solution path is: ");
        return result;
    }


    // this method is an implementation of Comparator compareTo compares path costs
    public int compareTo(Node o) {
        return Double.compare(this.getPathCost(),o.getPathCost());
    }
}