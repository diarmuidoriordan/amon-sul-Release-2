package controllers;

import models.User;
import play.Logger;
import play.mvc.Controller;

import javax.swing.*;

public class Account extends Controller {

    public static void signup()
    {
        render("signup.html");
    }

    public static void login()
    {
        render("start.html");
    }

    public static void register(String firstname, String lastname, String email, String password)
    {
        Logger.info("Attempting to register a new User with " + email + ":" + password);
        User user = User.findByEmail(email);

        if ((user != null) && (user.email.equals(email))) {
            JOptionPane.showMessageDialog(null, "Email address already registered to another " +
                    "User.\nPlease try again with a different email address");
            Logger.info("Attempted registration using an email address registered to an existing user: " + email);
            signup();
        }
        else {
            Logger.info("Registering new user " + email);
            User newUser = new User(firstname, lastname, email, password);
            newUser.save();
            authenticate(email, password);
        }
    }

    public static void authenticate(String email, String password)
    {
        Logger.info("Attempting to authenticate with " + email + ":" + password);

        User user = User.findByEmail(email);
        if ((user != null) && (user.checkPassword(password) == true)) {
            Logger.info("Authentication successful");
            session.put("logged_in_Userid", user.id);
            redirect ("/dashboard");
        } else {
            Logger.info("Authentication failed");
            redirect("/");
        }
    }

    public static void logout()
    {
        session.clear();
        redirect ("/");
    }

    public static User getLoggedInUser()
    {
        User user = null;
        if (session.contains("logged_in_Userid")) {
            String userId = session.get("logged_in_Userid");
            user = User.findById(Long.parseLong(userId));
        } else {
            login();
        }
        return user;
    }
}
