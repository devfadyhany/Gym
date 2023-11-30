public class Login{

    public static boolean CustomerLogin(String Email, String Password){
        boolean loggedIn = false;
        for (int i = 0; i < Customer.customersCount; i++){
            if (Gym.Customers[i].getEmail().equals(Email) && Gym.Customers[i].getPassword().equals(Password)){
                loggedIn = true;
                break;
            }
        }
        return loggedIn;
    }

    public static boolean CoachLogin(String Email, String Password){
        boolean loggedIn = false;
        for (int i = 0; i < Coach.coachCount; i++){
            if (Gym.Coaches[i].getEmail().equals(Email) && Gym.Coaches[i].getPassword().equals(Password)){
                loggedIn = true;
                break;
            }
        }
        return loggedIn;
    }

    public static boolean AdminLogin(String Email, String Password){
        boolean loggedIn = false;
        for (int i = 0; i < Admin.adminsCount; i++){
            if (Gym.Admins[i].getEmail().equals(Email) && Gym.Admins[i].getPassword().equals(Password)){
                loggedIn = true;
                break;
            }
        }
        return loggedIn;
    }
}
