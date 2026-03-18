import java.util.*;

class UndergroundSystem {

   
    private Map<Integer, Pair> checkInMap;

    
    private Map<String, int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    
    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkIn = checkInMap.get(id);

        String startStation = checkIn.station;
        int startTime = checkIn.time;

        String route = startStation + "->" + stationName;
        int travelTime = t - startTime;

        travelMap.putIfAbsent(route, new int[2]);

        travelMap.get(route)[0] += travelTime;  
        travelMap.get(route)[1] += 1;          

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        int[] data = travelMap.get(route);

        return (double) data[0] / data[1];
    }
}