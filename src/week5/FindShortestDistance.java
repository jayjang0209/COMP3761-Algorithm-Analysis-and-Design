package week5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindShortestDistance {

    public static int findShortestDistanceUsingPresorting(int[] stationLocations) throws Exception {
        Arrays.sort(stationLocations);

        if (stationLocations.length < 2) {
            throw new Exception("The number of stations has be at least 2");
        }

        int shortestDistance = stationLocations[1] - stationLocations[0];
        for (int i = 0; i < stationLocations.length - 2; i++) {
            if ((stationLocations[i+1] - stationLocations[i]) < shortestDistance) {
                shortestDistance = stationLocations[i+1] - stationLocations[i];
            }
        }
        return shortestDistance;
    }

    public static int findShortestDistanceUsingBruteForce(int[] stationLocations) {
        int shortestDistance = stationLocations[1] - stationLocations[0];
        for (int i = 0; i < stationLocations.length - 2; i++) {
            for (int j = i + 1; j < stationLocations.length - 1; j++) {
                if ((stationLocations[j] - stationLocations[i]) < shortestDistance) {
                    shortestDistance = stationLocations[j] - stationLocations[i];
                }
            }
        }
        return shortestDistance;
    }


    public static void main(String[] args) throws Exception {
        int[] stationLocations = {480, 231, 0, 477, 121, 1176, 501, 2000};
        System.out.println(findShortestDistanceUsingPresorting(stationLocations));
        System.out.println(findShortestDistanceUsingBruteForce(stationLocations));
    }
}
