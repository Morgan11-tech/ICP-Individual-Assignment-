package com.mortek;

public class Airline {
    /**
     * Required Instance Variables
     */
    private final int Airline_ID;
    private final String Name;
    private final String Alias;
    private final String IATA_Code;
    private final String ICAO_Code;
    private final String Callsign;
    private final String Country;
    private final String Active;

    /**
     * Constructor parameters
     *
     * @param airline_id
     * @param name
     * @param alias
     * @param iata_code
     * @param icao_code
     * @param callsign
     * @param country
     * @param active
     */

    public Airline(int airline_id, String name, String alias, String iata_code,
                   String icao_code, String callsign, String country, String active) {
        Airline_ID = airline_id;
        Name = name;
        Alias = alias;
        IATA_Code = iata_code;
        ICAO_Code = icao_code;
        Callsign = callsign;
        Country = country;
        Active = active;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "Airline_ID=" + Airline_ID +
                ", Name='" + Name + '\'' +
                ", Alias='" + Alias + '\'' +
                ", IATA_Code='" + IATA_Code + '\'' +
                ", ICAO_Code='" + ICAO_Code + '\'' +
                ", Callsign='" + Callsign + '\'' +
                ", Country='" + Country + '\'' +
                ", Active='" + Active + '\'' +
                '}';
    }

    public int getAirline_ID() {
        return Airline_ID;
    }

    public String getName() {
        return Name;
    }

    public String getAlias() {
        return Alias;
    }

    public String getCountry() {
        return Country;
    }

    public String getActive() {
        return Active;
    }
}
