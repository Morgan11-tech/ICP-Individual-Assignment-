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
            routesInfos.add(routesObject);
        }
//        System.out.println(routesInfos);
        //System.out.println(getairport_ID("Accra","Ghana"));
        //System.out.println(airportInfos.get(248));

       System.out.println("Haversine distance is: "+ Haversine.distanceHaversine(6156, 2952));
        Problem problem = new Problem(248,492, routesInfos);
        System.out.println(Arrays.toString(UCS.uniformCostSearch(problem)));
    }

    public static ArrayList<Airports> getairport_ID(String city, String country) {
        ArrayList<Airports> result = new ArrayList<>();
        for (Airports airport : airportInfos.values()) {
            if (airport.getCity().equals(city) && airport.getCountry().equals(country)) {
                result.add(airport);
            }
//            System.out.println("The haversine distance between"+ city +" and" + country+ "is"+ Haversine.distanceHaversine(6156, 2952));
        }return result;

    }
}







