package utils;

import models.Reading;
import models.Station;

public class MaxMinValues {

    public static double getMaxTempC(Station stations) {

        double max = Double.MIN_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.temperature > max) {
                max = reading.temperature;
            }
        }
        return max;
    }

    public static double getMinTempC(Station stations) {

        double min = Double.MAX_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.temperature < min) {
                min = reading.temperature;
            }
        }
        return min;
    }

    public static double getMaxWindSpeed(Station stations) {

        double max = Double.MIN_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.windSpeed > max) {
                max = reading.windSpeed;
            }
        }
        return max;
    }

    public static double getMinWindSpeed(Station stations) {

        double min = Double.MAX_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.windSpeed < min) {
                min = reading.windSpeed;
            }
        }
        return min;
    }

    public static int getMaxPressure(Station stations) {

        int max = Integer.MIN_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.pressure > max) {
                max = reading.pressure;
            }
        }
        return max;
    }

    public static int getMinPressure(Station stations) {

        int min = Integer.MAX_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.pressure < min) {
                min = reading.pressure;
            }
        }
        return min;
    }
}
