package lintcode.systemdesign.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Mini Uber
 */
public class MiniUber {
    Map<Integer, Trip> driverToTrip;
    Map<Integer, Location> driverToLocation;

    public MiniUber() {
        driverToTrip = new HashMap<>();
        driverToLocation = new HashMap<>();
    }

    public Trip report(int driver_id, double lat, double lng) {
        if (driverToTrip.containsKey(driver_id)) {
            return driverToTrip.get(driver_id);
        }
        if (driverToLocation.containsKey(driver_id)) {
            Location loc = driverToLocation.get(driver_id);
            loc.lat = lat;
            loc.lng = lng;
        } else {
            driverToLocation.put(driver_id, new Location(lat, lng));
        }
        return null;
    }

    public Trip request(int rider_id, double lat, double lng) {
        Trip trip = new Trip(rider_id, lat, lng);
        double minDistance = -1;
        int driver_id = -1;
        for (Map.Entry<Integer, Location> entry : driverToLocation.entrySet()) {
            Location location = entry.getValue();
            double curr = Helper.get_distance(location.lat, location.lng, lat, lng);
            if (minDistance == -1 || curr < minDistance) {
                minDistance = curr;
                driver_id = entry.getKey();
            }
        }
        if (driver_id != -1) {
            driverToLocation.remove(driver_id);
        }
        trip.driver_id = driver_id;
        driverToTrip.put(driver_id, trip);
        return trip;
    }
}

class Location {
    public double lat, lng;
    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}

class Trip {
    public int id;
    public int driver_id, rider_id;
    public double lat, lng;
    public Trip(int rider_id, double lat, double lng) {
        this.rider_id = rider_id;
        this.lat = lat;
        this.lng = lng;
    }
}

class Helper{
    public static double get_distance(double lat1, double lng1, double lat2, double lng2) {
        return 0;
    }
}


