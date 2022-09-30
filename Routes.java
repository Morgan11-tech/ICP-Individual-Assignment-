package com.mortek;

public class Routes {
    /**
     * Required Instance variables
     */
    private final String Airline_code;
    private final int Airline_ID;
    private final String Source_airport_code;
    private final int Source_airport_ID;
    private final String Destination_airport_code;
    private final int Destination_airport_ID;
    private final String Codeshare;
    private final String Stops;
    private final String Equipment;

    /**
     *
     * @param airline_code
     * @param airline_id
     * @param source_airport_code
     * @param source_airport_id
     * @param destination_airport_code
     * @param Destination_airport_id
     * @param codeshare
     * @param stops
     * @param equipment
     */

    public Routes(String airline_code, int airline_id, String source_airport_code, int source_airport_id, String destination_airport_code,
                  int Destination_airport_id, String codeshare, String stops, String equipment) {
        Airline_code = airline_code;
        Airline_ID = airline_id;
        Source_airport_code = source_airport_code;
        Source_airport_ID = source_airport_id;
        Destination_airport_code = destination_airport_code;
        Destination_airport_ID = Destination_airport_id;
        Codeshare = codeshare;
        Stops = stops;
        Equipment = equipment;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "Airline_code='" + Airline_code + '\'' +
                ", Airline_ID=" + Airline_ID +
                ", Source_airport_code='" + Source_airport_code + '\'' +
                ", Source_airport_ID=" + Source_airport_ID +
                ", Destination_airport_code='" + Destination_airport_code + '\'' +
                ", Destination_airport_ID=" + Destination_airport_ID +
                ", Codeshare='" + Codeshare + '\'' +
                ", Stops='" + Stops + '\'' +
                ", Equipment='" + Equipment + '\'' +
                '}';
    }

    public String getAirline_code() {
        return Airline_code;
    }

    public int getAirline_ID() {
        return Airline_ID;
    }

    public String getSource_airport_code() {
        return Source_airport_code;
    }

    public int getSource_airport_ID() {
        return Source_airport_ID;
    }

    public String getDestination_airport_code() {
        return Destination_airport_code;
    }

    public int getDestination_airport_ID() {
        return Destination_airport_ID;
    }


    public String getStops() {
        return Stops;
    }

    public String getEquipment() {
        return Equipment;
    }
}
