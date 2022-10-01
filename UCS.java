package com.mortek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * In this class has a method, UniformCostSearch which takes in
 * a problem as an argument and uses the priority queue in determinng which node has
 * the priority over the other. The priority in this case is the path cost to reach that node.
 * A node has a higher priority if it has a shorter path cost than the other.
 * It also has an explored set for keeping track of nodes so that the algorithm will not come back
 * to process nodes twice.
 */
        public class UCS {
            public static SolutionPath uniformCostSearch(Problem problem) {
                Node node = new Node(problem.getInit_state());
                PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(node);
                HashSet explored = new HashSet();

                while (priorityQueue.size() > 0) {
                    Node new_node = priorityQueue.poll();
                    if (problem.goal_test(new_node.getState())) {
                        System.out.println("Found a solution: ");
                        System.out.println(new_node);
                        return new_node.solutionPath();
                    } else {
                        explored.add(new_node.getState());
                    }

                    try {
                        ArrayList<Routes> actions = problem.actions(new_node.getState());

                        for (Routes route : actions) {
                            Node child = new Node(route.getDestination_airport_ID(), new_node,
                                    route.getDestination_airport_ID(), node.getPathCost() + 1.0);

                            if (!priorityQueue.contains(child) && !explored.contains(child.getState())) {
                                priorityQueue.add(child);
                                System.out.println("New child" + child);
                            }
                            else if (priorityQueue.contains(child)) {
                                double oldCost = priorityQueue.peek().getPathCost();
                                if (oldCost > child.getPathCost()) {
                                    priorityQueue.remove(child);
                                    priorityQueue.add(child);
                                }
                            }
                        }
                    } catch (NullPointerException ne) {
                        System.out.println(ne.getMessage());
                    }
                }
                return null;
            }
        }