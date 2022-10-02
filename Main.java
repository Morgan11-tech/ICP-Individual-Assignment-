/**
 * @author Nana Kofi Morgan Sarpong
 */
package com.mortek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;



public class Main {
// creating hashmaps for each file which takes an id as the key and an object as the value
    public static HashMap<Integer, Airports> airportInfos = new HashMap<>();
    public static HashMap<Integer, Airline> airlineInfos = new HashMap<>();
    public static ArrayList<Routes> routesInfos = new ArrayList<>();
    public static HashMap<Integer, ArrayList<Routes>> routeMap = new HashMap<>();

    public static void main(String[] args) {

        ArrayList<String[]> airportArray = new ArrayList<>(FileReadWrite.FRead("src/airports.csv"));
        for(String[] array: airportArray) {
            Airports airportObject = ObjectsCreation.airport(array);
            airportInfos.put(airportObject.getAirport_ID(), airportObject);
        }
//       System.out.println(airportInfos);

        ArrayList<String[]> airlineArray = new ArrayList<>(FileReadWrite.FRead("src/airlines.csv"));
        for(String[] array: airlineArray) {
            Airline airlineObject = ObjectsCreation.airline(array);
            airlineInfos.put(airlineObject.getAirline_ID(),airlineObject);
        }
//       System.out.println(airlineInfos);

       ArrayList<String[]> routesArray = new ArrayList<>(FileReadWrite.FRead("src/routes.csv"));
       for(String[] array: routesArray) {
           Routes routesObject = ObjectsCreation.routes(array);
           if (routesObject.getSource_airport_ID() != 0 && routesObject.getDestination_airport_ID() != 0) {
               routesInfos.add(routesObject);
            } else {
                System.out.println("The source or destination ID cannot be null or zero.");
            }
        }

        ArrayList<String[]> routesArray1 = new ArrayList<>(FileReadWrite.FRead("src/routes.csv"));
        for(String[] array: routesArray) {
            Routes routesObject = ObjectsCreation.routes(array);
            if (routesObject.getSource_airport_ID() != 0 && routesObject.getDestination_airport_ID() != 0) {
                if (!(routeMap.containsKey(routesObject.getSource_airport_ID()))) {
                    ArrayList<Routes> routeList = new ArrayList<>();
                    routeList.add(routesObject);
                    routeMap.put(routesObject.getSource_airport_ID(), routeList);
                } else {
                    ArrayList<Routes> routeList = routeMap.get(routesObject.getSource_airport_ID());
                    routeList.add(routesObject);
                }
            } else {
                System.out.println("The source or destination ID cannot be null or zero.");
            }
        }
//        Test cases:

//         System.out.println(routesInfos);
//        System.out.println(getairport_ID("Accra","Ghana"));
//        System.out.println(airportInfos.get(248));

//        System.out.println("Haversine distance is: "+ Haversine.distanceHaversine(6156, 2952));

//        Problem problem = new Problem(508,248, routeMap);
//        System.out.println(Arrays.toString(UCS.uniformCostSearch(problem)));
//        //System.out.println("The source airport code is: "+ getRoutebySourceID(2913));
//        System.out.println(FileReadWrite.Write("src/output.txt"));

//        ArrayList<Integer> sourceairportIDs = getairport_ID("Accra", "Ghana");
//        ArrayList<Integer> destinationairportIDs = getairport_ID("Winnipeg", "Canada");

        ArrayList<String[]> input = FileReadWrite.FRead("src/com/mortek/Accra-Winnipeg");
        String[] sourceCityCountry = input.get(0);
        String[] destinationCityCountry = input.get(1);

        ArrayList<Integer> sourceairportIDs = getairport_ID(sourceCityCountry[0].trim(),
                sourceCityCountry[1].trim());
        ArrayList<Integer> destinationairportIDs = getairport_ID(destinationCityCountry[0].trim(),
                destinationCityCountry[1].trim());

        ArrayList<SolutionPath> possiblepaths = new ArrayList<>();
        for(Integer sourceairportID: sourceairportIDs){
            for(Integer destinationairportID: destinationairportIDs){
                Problem problem = new Problem(sourceairportID,destinationairportID,routeMap);
                 SolutionPath path = UCS.uniformCostSearch(problem);
//                 checking if path is not empty
                if(path!= null){
                    possiblepaths.add(path);
                }
            }
        }

        StringBuilder info = new StringBuilder();
        int iter = 0;
        int cumStops = 0;
        Collections.sort(possiblepaths);
        SolutionPath bestPath = possiblepaths.get(0);
        System.out.println(bestPath);

            for (Integer airportID: bestPath.getStateSequence()) {
                for (Routes route: Main.routeMap.get(airportID)) {
                    if (iter < (bestPath.getStateSequence().size() -1)) {
                        if (route.getDestination_airport_ID() == bestPath.getStateSequence().get(iter + 1)) {
                            info.append((iter + 1) + ". " +
                                    route.getAirline_code() + " from " +
                                    Main.airportInfos.get(route.getSource_airport_ID()).getIATA_Code() + " to " +
                                    Main.airportInfos.get(route.getSource_airport_ID()).getIATA_Code() + " " +
                                    route.getStops() + " stops.\n"
                            );
                            iter++;
                            cumStops += Integer.parseInt(route.getStops());
                        }
                    }
                }
            }

            info.append("\nTotal flights: ").append(iter);
            info.append("\nTotal additional stops: ").append(cumStops);
            info.append("\nTotal distance: ").append(bestPath.getCost()).append(" km");


            FileReadWrite.FWrite("src/com/mortek/Accra-Winnipeg-output.txt", info);
     }


    /**
     *
     * @param city
     * @param country
     * @return result
     */
    public static ArrayList<Integer> getairport_ID(String city, String country) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Airports airport : airportInfos.values()) {
            if (airport.getCity().equals(city) && airport.getCountry().equals(country)) {
                result.add(airport.getAirport_ID());
            }
        }return result;

    }

    /**
     * this method returns the route given the source airport ID
     * @param SourceID
     * @return result
     */

    public static String getRoutebySourceID(int SourceID) {
        String result = null;
        for (Routes element : routesInfos) {
            if (element.getSource_airport_ID() == SourceID) {
                result = element.getSource_airport_code();
            }
        }
        return result;
    }

    public static String getAirlineCode(String airlinecode) {
        String result = null;
        for (Routes element : routesInfos) {
            if (element.getAirline_code().equals(airlinecode)){
                result = element.getAirline_code();
            }
        }
        return result;
    }


}







