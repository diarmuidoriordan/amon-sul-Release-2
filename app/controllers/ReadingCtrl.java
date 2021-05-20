package controllers;

import models.Station;
import models.Reading;
import play.mvc.Controller;

public class ReadingCtrl extends Controller {

    public static void addReading(Long id, int code, double temperature, double windSpeed,
                                  int windDirection, int pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }
}
