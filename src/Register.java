public class Register {
    Menu menu=new Menu();
    public static Customer CustomerRegister(String name, String email, String password, String phone_number, char gender){
        Customer customer = new Customer(Gym.Customers.size() + 1, name, email, password, phone_number, gender);
        Gym.AddCustomer(customer);
        return customer;
    }

    public static Coach CoachRegister(String name, String email, String password, String phone_number, char gender){
        Coach coach = new Coach(Gym.Coaches.size() + 1, name, email, password, phone_number, gender);
        Gym.AddCoach(coach);
        return coach;
    }
}
