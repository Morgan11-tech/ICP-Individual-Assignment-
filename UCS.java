package com.mortek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;


        public class UCS {

            public static Object[] uniformCostSearch(Problem problem) {
                Node node = new Node(problem.getInit_state());
                PriorityQueue<Node> pr_queue = new PriorityQueue<>();
                pr_queue.add(node);
                HashSet explored = new HashSet();

                while (pr_queue.size() > 0) {
                    Node new_node = pr_queue.poll();
                    if (problem.goal_test(new_node.getState())) {
//                System.out.println("Solution Path: " + deepToString(new_node.solution_path()));
                        System.out.println("Found a solution: ");
                        System.out.println(new_node);
                        while (new_node.getParent() != null) {
                            System.out.println(new_node.getParent());
                        }
                        return new_node.solutionPath();
                    } else {
                        explored.add(new_node.getState());
                    }

                    try {
                        ArrayList<Routes> actions = problem.actions(new_node.getState());

                        for (Routes route : actions) {
                            Node child = new Node(route.getDestination_airport_ID(), new_node,
                                    route.getDestination_airport_ID(), node.getPathCost() + 1.0);
                            System.out.println("Child" + child);
                            if (!pr_queue.contains(child) && !explored.contains(child.getState())) {
                                pr_queue.add(child);
                                System.out.println("New child" + child);
                            }
                        }
                    } catch (NullPointerException ne) {
                        System.out.println(ne.getMessage());
                    }
                }
                return null;
            }
        }