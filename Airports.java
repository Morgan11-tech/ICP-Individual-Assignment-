package com.mortek;

public class Airports {
    private final int Airport_ID;
    private final String Name;
    private final String City;
    private final String Country;
    private final String IATA_Code;
    private final String ICAO_Code;
    private final double Latitude;
    private final double Longtitude;
    private final double Altitude;
    private final double Timezone;
    private final String DST;
    private final String Tz_database_time_zone;
    private final String Type;
    private final String Source_of_the_data;

    /**
     *
     * @param airport_id
     * @param name
     * @param city
     * @param country
     * @param iata_code
     * @param icao_code
     * @param latitude
     * @param longtitude
     * @param altitude
     * @param timezone
     * @param dst
     * @param tz_database_time_zone
     * @param type
     * @param source_of_the_data
     */

    public Airports(int airport_id, String name, String city, String country, String iata_code, String icao_code, double latitude,
                    double longtitude, double altitude, double timezone, String dst, String tz_database_time_zone, String type, String source_of_the_data) {
        this.Airport_ID = airport_id;
        this.Name = name;
        this.City = city;
        this.Country = country;
        this.IATA_Code = icao_code;
        this.ICAO_Code = iata_code;
        this.Latitude = latitude;
        this.Longtitude = longtitude;
        this.Altitude = altitude;
        this.Timezone = timezone;
        this.DST = dst;
        this.Tz_database_time_zone = tz_database_time_zone;
        this.Type = type;
        this.Source_of_the_data = source_of_the_data;
    }


    @Override
    public String toString() {
        return "Airports{" +
                "Airport_ID=" + Airport_ID +
                ", Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", IATA_Code='" + IATA_Code + '\'' +
                ", ICAO_Code='" + ICAO_Code + '\'' +
                ", Latitude=" + Latitude +
                ", Longtitude=" + Longtitude +
                ", Altitude=" + Altitude +
                ", Timezone=" + Timezone +
                ", DST='" + DST + '\'' +
                ", Tz_database_time_zone='" + Tz_database_time_zone + '\'' +
                ", Type='" + Type + '\'' +
                ", Source_of_the_data='" + Source_of_the_data + '\'' +
                '}';
    }

    public int getAirport_ID() {
        return Airport_ID;
    }

    public String getName() {
        return this.Name;
    }

    public String getCity() {
        return this.City;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getIATA_Code() {
        return this.IATA_Code;
    }

    public String getICAO_Code() {
        return this.ICAO_Code;
    }

    public double getLatitude() {
        return this.Latitude;
    }

    public double getLongtitude() {
        return this.Longtitude;
    }

    public double getAltitude() {
        return this.Altitude;
    }

    public double getTimezone() {
        return this.Timezone;
    }

    public String getDST() {
        return this.DST;
    }

    public String getTz_database_time_zone() {
        return this.Tz_database_time_zone;
    }

    public String getType() {
        return this.Type;
    }

    public String getSource_of_the_data() {
        return this.Source_of_the_data;
    }
}
