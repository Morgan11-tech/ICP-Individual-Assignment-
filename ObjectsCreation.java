package com.mortek;


public class ObjectsCreation {
    /**
     *
     * @param airport_array
     * @return
     */
    public static Airports airport (String[] airport_array){
        int airport_ID = 0;
        double latitude = 0.0;
        double longitude = 0.0;
        double altitude = 0.0;
        double timezone = 0.0;

        try{
            airport_ID = Integer.parseInt(airport_array[0]);
            latitude = Double.parseDouble(airport_array[6]);
            longitude = Double.parseDouble(airport_array[7]);
            altitude = Double.parseDouble(airport_array[8]);
            timezone = Double.parseDouble(airport_array[9]);

        }catch (NumberFormatException numberFormatException){
            System.out.println(numberFormatException.getMessage());
        }
        String name = airport_array[1];
        String city = airport_array[2];
        String country = airport_array[3];
        String IATA_code = airport_array[4];
        String ICAO_code = airport_array[5];
        String dst = airport_array[10];
        String database_time_zone = airport_array[11];
        String type = airport_array[12];
        String source =  airport_array[13];

        return new Airports(airport_ID,name,city,country,IATA_code,ICAO_code,latitude,longitude,
                altitude,timezone,dst,database_time_zone,type,source
        );


    }

    public static Airline airline(String[] airline_array) {
        int airline_ID = 0;
        try {
            airline_ID = Integer.parseInt(airline_array[0]);
        }catch (NumberFormatException numberFormatException){
            System.out.println(numberFormatException.getMessage());
        }
        String name = airline_array[1];
        String alias = airline_array[2];
        String IATA_code = airline_array[3];
        String ICAO_code = airline_array[4];
        String callsign = airline_array[5];
        String country = airline_array[6];
        String active = airline_array[7];

        return new Airline(airline_ID,name,alias,IATA_code,ICAO_code,callsign,country,active);
    }
    public static Routes routes(String[] route_array){
        int airline_ID = 0;
        int destination_airport_ID = 0;
        int source_airport_ID = 0;
        try{
            airline_ID = Integer.parseInt(route_array[1]);
            destination_airport_ID = Integer.parseInt(route_array[5]);
            source_airport_ID = Integer.parseInt(route_array[3]);
        }catch (NumberFormatException numberFormatException){
            System.out.println(numberFormatException.getMessage());
        }
        String airline_code = route_array[0];
        String source_airport_code = route_array[2];
        String destination_airport_code = route_array[4];
        String codeshare = route_array[6];
        String stops = route_array[7];
        String equipment = route_array[route_array.length - 1];

        return new Routes(airline_code,airline_ID,source_airport_code,source_airport_ID,destination_airport_code,destination_airport_ID,codeshare,stops,equipment);
    }



}
