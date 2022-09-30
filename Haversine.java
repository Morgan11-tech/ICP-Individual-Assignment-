package com.mortek;


/**
 * This is the implementation Haversine Distance Algorithm between two places
 * @author ananth
 * R = earth’s radius (mean radius = 6,371km)
Δlat = lat2− lat1
Δlong = long2− long1
a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
c = 2.atan2(√a, √(1−a))
d = R.c
 *
 */

public class Haversine {
    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
    public static double distance(double startLat, double startLong,
                                  double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }


    public static double distanceHaversine(int start, int end) {
        Airports airport_start = Main.airportInfos.get(start);
        Airports airport_end = Main.airportInfos.get(end);

        double answer = distance(airport_start.getLatitude(), airport_start.getLongtitude(),
                airport_end.getLatitude(), airport_end.getLongtitude());
        return answer;
    }
}