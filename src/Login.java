public class Login{

    public static Customer CustomerLogin(String Email, String Password){
        Customer Loggedcustomer = null;
        for (int i = 0; i < Customer.customersCount; i++){
            if (Gym.Customers[i].getEmail().equals(Email) && Gym.Customers[i].getPassword().equals(Password)){
                Loggedcustomer = Gym.Customers[i];
                break;
            }
        }
        return Loggedcustomer;
    }

    public static Coach CoachLogin(String Email, String Password){
        Coach LoggedCoach = null;
        for (int i = 0; i < Coach.coachCount; i++){
            if (Gym.Coaches[i].getEmail().equals(Email) && Gym.Coaches[i].getPassword().equals(Password)){
                LoggedCoach = Gym.Coaches[i];
                break;
            }
        }
        return LoggedCoach;
    }

    public static Admin AdminLogin(String Email, String Password){
        Admin LoggedAdmin = null;
        for (int i = 0; i < Admin.adminsCount; i++){
            if (Gym.Admins[i].getEmail().equals(Email) && Gym.Admins[i].getPassword().equals(Password)){
                LoggedAdmin = Gym.Admins[i];
                break;
            }
        }
        return LoggedAdmin;
    }
}
