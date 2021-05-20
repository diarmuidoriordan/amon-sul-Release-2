package controllers;

import models.Station;
import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.LatestWeather;

public class StationCtrl extends Controller {

    public static void index(Long id) {

        Logger.info("Rendering Station Info.");

        Station stations = Station.findById(id);
        stations = LatestWeather.getLatestReadings(stations);

        Logger.info ("Station ID = " + id);
        render ("stations.html", stations);
    }

    public static void addStation(String name, double latitude, double longitude) {

        User user = new Account().getLoggedInUser();
        Station station = new Station(name, latitude, longitude);

        Logger.info ("Adding a new Station called " + name + " for User: " + user.email);
        Logger.info("This station is located at:\nLAT: " + latitude + "\nLNG: " + longitude);

        user.stations.add(station);
        user.save();

        redirect ("/dashboard");
    }
}
