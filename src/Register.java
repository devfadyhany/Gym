public class Register {
    public static void CustomerRegister(String name, String email, String password, String phone_number, char gender){
        Customer customer = new Customer(2023000 + Customer.customersCount + 1, name, email, password, phone_number, gender);
        Gym.AddCustomer(customer);
    }

    public static void CoachRegister(String name, String email, String password, String phone_number, char gender){
        Coach coach = new Coach(2023000 + Coach.coachCount + 1, name, email, password, phone_number, gender);
        Gym.AddCoach(coach);
    }
}
