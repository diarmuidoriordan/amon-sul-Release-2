package controllers;

import models.Station;
import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.LatestWeather;

import javax.swing.*;
import java.util.List;

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
        List<Station> stations = user.stations;
        boolean exists = false;

        for (Station station : stations) {
            if (station.name.equals(name)) {
                exists = true;
                break;
            }
            else {
                exists = false;
            }
        }

        if (exists) {
            JOptionPane.showMessageDialog(null, "A Station with this name already exists " +
                    "\nPlease try again with a different Station name");
            Logger.info("Attempted creating a Station with the same name as an existing Station: " + name);
            Dashboard.index();
        }
        else if (!exists) {
            Station station = new Station(name, latitude, longitude);

            Logger.info("Adding a new Station called " + name + " for User: " + user.email);
            Logger.info("This station is located at:\n\t\tLAT: " + latitude + "\n\t\tLNG: " + longitude);

            user.stations.add(station);
            user.save();

            redirect("/dashboard");
        }
    }
}
