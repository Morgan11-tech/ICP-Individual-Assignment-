package com.mortek;

import java.util.ArrayList;

public class SolutionPath implements Comparable<SolutionPath> {

    ArrayList<Integer> stateSequence;
    double cost;

    public SolutionPath(ArrayList<Integer> stateSequence, double cost) {
        this.stateSequence = stateSequence;
        this.cost = cost;
    }

    public ArrayList<Integer> getStateSequence() {
        return stateSequence;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "SolutionPath{" +
                "stateSequence=" + stateSequence +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(SolutionPath o) {
        return Double.compare(this.cost, o.cost);
    }

}
