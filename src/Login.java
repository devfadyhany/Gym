public class Login {
    static Admin admin = new Admin();

    public static Customer CustomerLogin(String Email, String Password) {
        Customer Loggedcustomer = null;
        for (int i = 0; i < Gym.Customers.size(); i++) {
            if (Gym.Customers.get(i).getEmail().equals(Email) &&Gym.Customers.get(i).getPassword().equals(Password)) {
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
        if (admin.getEmail().equals(Email) && admin.getPassword().equals(Password)) {
            return true;
        }
        return false;
    }
}
