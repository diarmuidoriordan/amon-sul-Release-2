package controllers;

import models.Station;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {

    User user = Account.getLoggedInUser();
    List<Station> stations = user.stations;

    Logger.info("Rendering Dashboard for User: " + user.email);

    render ("dashboard.html", stations);
  }
}
