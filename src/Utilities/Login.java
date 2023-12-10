package Utilities;

import Master.Gym;
import Users.Admin;
import Users.Coach;
import Users.Customer;

public class Login {

    public static Customer CustomerLogin(String Email, String Password) {
        Customer Loggedcustomer = null;
        for (int i = 0; i < Gym.Customers.size(); i++) {
            if (Gym.Customers.get(i).getEmail().equals(Email) && Gym.Customers.get(i).getPassword().equals(Password)) {
                Loggedcustomer = Gym.Customers.get(i);
                break;
            }
        }
        return Loggedcustomer;
    }

    public static Coach CoachLogin(String Email, String Password) {
        Coach LoggedCoach = null;
        for (int i = 0; i < Gym.Coaches.size(); i++) {
            if (Gym.Coaches.get(i).getEmail().equals(Email) && Gym.Coaches.get(i).getPassword().equals(Password)) {
                LoggedCoach = Gym.Coaches.get(i);
                break;
            }
        }
        return LoggedCoach;
    }

    public static boolean AdminLogin(String Email, String Password) {
        return Admin.getEmail().equals(Email) && Admin.getPassword().equals(Password);
    }
}
