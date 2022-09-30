package com.mortek;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem {
    private final int init_state;
    private final int goal_state;
    private ArrayList<Routes> map;



    public Problem(int init_state, int goal_state, ArrayList<Routes> maps) {
        this.init_state = init_state;
        this.goal_state = goal_state;
        map = maps;
    }

    public int getInit_state() {
        return init_state;
    }

    public int getGoal_state() {
        return goal_state;
    }

    public boolean goal_test(int state){
        return (state == goal_state);
    }

    public ArrayList<Routes> actions(int state){
        ArrayList<Routes> OtherNodes = new ArrayList<>();
        for(Routes routes: map){
            if(routes.getSource_airport_ID() == state){
                OtherNodes.add(routes);
            }
        }
        System.out.println(OtherNodes);
        return OtherNodes;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "init_state='" + init_state + '\'' +
                ", goal_state='" + goal_state + '\'' +
                '}';
    }




}


