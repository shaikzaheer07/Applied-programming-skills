import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Trip {
        int totalTime;
        int count;

        Trip(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    Map<Integer, CheckIn> checkInMap;
    Map<String, Trip> tripMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        tripMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn ci = checkInMap.get(id);
        checkInMap.remove(id);

        String key = ci.station + "-" + stationName;
        int time = t - ci.time;

        Trip trip = tripMap.getOrDefault(key, new Trip(0, 0));
        trip.totalTime += time;
        trip.count += 1;

        tripMap.put(key, trip);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        Trip trip = tripMap.get(key);
        return (double) trip.totalTime / trip.count;
    }
}