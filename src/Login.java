public class Login {
    static Admin admin = new Admin();

    public static Customer CustomerLogin(String Email, String Password) {
        Customer Loggedcustomer = null;
        for (int i = 0; i < Customer.customersCount; i++) {
            if (Gym.Customers[i].getEmail().equals(Email) && Gym.Customers[i].getPassword().equals(Password)) {
                Loggedcustomer = Gym.Customers[i];
                break;
            }
        }
        return Loggedcustomer;
    }

    public static Coach CoachLogin(String Email, String Password) {
        Coach LoggedCoach = null;
        for (int i = 0; i < Coach.coachCount; i++) {
            if (Gym.Coaches[i].getEmail().equals(Email) && Gym.Coaches[i].getPassword().equals(Password)) {
                LoggedCoach = Gym.Coaches[i];
                break;
            }
        }
        return LoggedCoach;
    }

    public static boolean AdminLogin(String Email, String Password) {
        if (admin.getEmail().equals(Email) && admin.getPassword().equals(Password)) {
            return true;
        }
        return false;
    }
}
