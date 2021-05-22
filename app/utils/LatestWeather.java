package utils;

import models.Reading;
import models.Station;

public class LatestWeather {

    public static Station getLatestReadings(Station stations) {

        Reading reading;

        if (stations.readings.size() > 0) {
            reading = stations.readings.get(stations.readings.size() - 1);
        }
        else {
            reading = new Reading(0, 0.0, 0.0, 0, 0);
        }
        stations.weatherFromCode = Conversions.weatherCodeToString(reading.code);
        stations.weatherIcon = Conversions.weatherIconFromCode(reading.code);

        stations.tempC = reading.temperature;
        stations.tempF = Conversions.tempToF(reading.temperature);
        stations.maxTempC = MaxMinValues.getMaxTempC(stations);
        stations.minTempC = MaxMinValues.getMinTempC(stations);

        stations.windBft = Conversions.windToBft(reading.windSpeed);
        stations.windDirection = reading.windDirection;
        stations.windDirectionOutput = Conversions.windDirectionToString(reading.windDirection);

        stations.windChill = Conversions.windChillCalc(reading.windSpeed, reading.temperature);
        stations.maxWindSpeed = MaxMinValues.getMaxWindSpeed(stations);
        stations.minWindSpeed = MaxMinValues.getMinWindSpeed(stations);

        stations.pressureHPA = reading.pressure;
        stations.maxPressure = MaxMinValues.getMaxPressure(stations);
        stations.minPressure = MaxMinValues.getMinPressure(stations);

        return stations;
    }
}
