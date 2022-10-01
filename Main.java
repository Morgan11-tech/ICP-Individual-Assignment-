/**
 * @author Nana Kofi Morgan Sarpong
 */
package com.mortek;

import java.util.ArrayList;
import java.util.Arrays;
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

//        main test with output in file:
        Problem problem = new Problem(508,248, routeMap);
        System.out.println(Arrays.toString(UCS.uniformCostSearch(problem)));
        //System.out.println("The source airport code is: "+ getRoutebySourceID(2913));
        System.out.println(FileReadWrite.Write("src/output.txt"));
    }

    /**
     *
     * @param city
     * @param country
     * @return result
     */
    public static ArrayList<Airports> getairport_ID(String city, String country) {
        ArrayList<Airports> result = new ArrayList<>();
        for (Airports airport : airportInfos.values()) {
            if (airport.getCity().equals(city) && airport.getCountry().equals(country)) {
                result.add(airport);
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

}







