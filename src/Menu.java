import java.util.Scanner;

//        For Customer:
//        1. Get his coach info (Name, Phone number, working hours)
//        2. Display for all the Gym Equipment.
//        3. Display the customer the membership’s plan details.
//        4. Display the in-body information at a specific date.
//        5. Display for the user how many kilos need to be reduced according to his body
//        (you can get any calculation through the internet)
//
//        For Coach:
//        1. Show a list of all his customers.
//        2. Get the inbody history of any of his customers.
//        3. Get all the details of a customer by his name.
//        4. Show a list of all his female/male customers.
//
//        For Admin:
//        1. Can add/edit/delete coaches, types of equipment, and customers to the gym.
//        2. Show the subscription history for a customer.
//        3. Display all the customers that subscribed to the gym in a given month/day.
//        4. Display all the customers of a specific coach.
//        5. Display the GYM income in a given month.
//        6. Display the coaches sorted in terms of the most assigned number of
//        customers to the coaches.

public class Menu extends Gym {
    Scanner input = new Scanner(System.in);

    public void MainMenu() {
        boolean flag;
        do {
            int choice;
            flag = false;
            Scanner input = new Scanner(System.in);
            System.out.println("What is your role?\n====================\n1-coach\n2-client\n3-admin");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                case 2:
                    RoleMenu(choice);
                    flag = true;
                    break;
                case 3:
                    LoginMenu(choice);
                    flag = true;
                    break;
            }
        } while (!flag);
    }

    public void RoleMenu(int choice) {
        int newchoice;
        do {
            newchoice = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("1- Login      2-Register");
            newchoice = input.nextInt();
            switch (newchoice) {
                case 1:
                    LoginMenu(choice);
                    newchoice = 0;
                    break;
                case 2:
                    RegisterMenu(choice);
                    newchoice = 0;
                    break;
            }
        } while (newchoice != 0);
    }

    public void LoginMenu(int choice) {
        String email, password;
        Scanner input = new Scanner(System.in);
        System.out.println("enter your email");
        email = input.next();
        System.out.println("enter your password");
        password = input.next();

        if (choice == 1) {
            if (Login.CoachLogin(email, password) != null) {
                coachMenu(Login.CoachLogin(email, password));
            } else {
                System.out.println("Incorrect Email or Password, Try again.");
                LoginMenu(1);
            }
        } else if (choice == 2) {
            if (Login.CustomerLogin(email, password) != null) {
                customerMenu(Login.CustomerLogin(email, password));
            } else {
                System.out.println("Incorrect Email or Password, Try again.");
                LoginMenu(2);
            }
        } else if (choice == 3) {
            if (Login.AdminLogin(email, password) != null) {
                adminMenu(Login.AdminLogin(email, password));
            } else {
                System.out.println("Incorrect Email or Password, Try again.");
                LoginMenu(3);
            }
        }
    }

    public void RegisterMenu(int choice) {
        String name, email, password, phoneNumber;
        char gender;
        System.out.println("enter your name");
        name = input.next();
        System.out.println("enter your email");
        email = input.next();
        System.out.println("enter your password");
        password = input.next();
        System.out.println("enter your phone number");
        phoneNumber = input.next();
        System.out.println("enter your gender");
        gender = input.next().charAt(0);

        if (choice == 1) {
            coachMenu(Register.CoachRegister(name, email, password, phoneNumber, gender));
        } else if (choice == 2) {
            customerMenu(Register.CustomerRegister(name, email, password, phoneNumber, gender));
        }
    }

    public void customerMenu(Customer customer) {
        if (customer.isApproved()) {
            boolean flag;
            do {
                flag = false;
                System.out.println("Welcome, " + customer.getName());
                System.out.println("1-coach info\n2-Gym Equpments\n3-membership plan\n4-INBODY\n5-Kilos remaining");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        customer.DisplayCoachInfo();
                        flag = true;
                        break;
                    case 2:
                        ViewEquipments();
                        flag = true;
                        break;
                    case 3:
                        customer.getSubscription().DisplaySubscriptionInfo();
                        flag = true;
                        break;
                    case 4:
                        customer.getInBodies().displayInBody();
                        flag = true;
                        break;
                    case 5:
                        System.out.println(customer.getInBodies().CalcIdealWeight());
                        flag = true;
                        break;
                }
            } while (!flag);
        } else {
            System.out.println("Account is on Hold\nWaiting for Admin is Approval...");
        }
    }

    public void coachMenu(Coach coach) {
        if (coach.isApproved()) {
            boolean flag;
            do {
                flag = false;
                System.out.println("Welcome, " + coach.getName());
                System.out.println("1-Customers info\n2-InBody History for any of the Customers\n3-Get all the details of a customer by his name.\n4-Show a list of all female/male customers.");
                int choice = input.nextInt();
                String customerName;
                char customerGender;
                switch (choice) {
                    case 1:
                        coach.DisplayClientsInfo();
                        flag = true;
                        break;
                    //   case 2:
//                        ViewEquipments();
                    //    flag = true;
                    //    break;
                    case 3:
                        System.out.println("Enter Customer's Name");
                        customerName = input.next();
                        coach.DisplayClientInfo(customerName);
                        flag = true;
                        break;
                    case 4:
                        System.out.println("Choose Male or Female: M for Male,F for Female.");
                        customerGender = input.next().charAt(0);
                        coach.DisplayClientsByGender(customerGender);
                        flag = true;
                        break;
                }
            } while (!flag);
        } else {
            System.out.println("Account is on Hold\nWaiting for Admin is Approval...");
        }
    }

    public void adminMenu(Admin admin) {

        boolean flag;
        do {
            flag = false;
            System.out.println("Welcome, " + admin.getName());
            System.out.println("Choose what you want to edit");
            System.out.println("1-Customers\n2-Gym Equipments\n3-Coaches");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    AdminCustomerMenu();
                    flag = true;
                    break;
                case 2:
                    AdminEquipmentMenu();
                    flag = true;
                    break;
                case 3:
                    AdminCoachMenu();
                    flag = true;
                    break;
            }
        } while (!flag);
    }
    public void AdminCustomerMenu(){
        boolean flag;
        do {
            flag = false;
            System.out.println("1-Add Customers\n2-Edit Customers\n3-Delete Customers\n4-Show the subscription history for a customer.\n5-Display all the customers that subscribed to the gym in a given month/day.");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String name, email, password, phoneNumber;
                    char gender;
                    System.out.println("enter your name");
                    name = input.next();
                    System.out.println("enter your email");
                    email = input.next();
                    System.out.println("enter your password");
                    password = input.next();
                    System.out.println("enter your phone number");
                    phoneNumber = input.next();
                    System.out.println("enter your gender");
                    gender = input.next().charAt(0);
                    Customer C = new Customer(Customer.customersCount+1,name,email,password,phoneNumber,gender);
                    AddCustomer(C);
                    flag = true;
                    break;
//                case 2:
//                    EditCustomer();
//                    flag = true;
//                    break;
                case 3:
                    int ID;
                    System.out.println("Enter Customer ID:");
                    ID = input.nextInt();
                    RemoveCustomer(ID);
                    flag = true;
                    break;
//                case 4:
//                    AdminCoachMenu();
//                    flag = true;
//                    break;
                case 5:
                    ViewCustomers();
                    flag = true;
                    break;
            }
        } while (!flag);
    }

    public void AdminEquipmentMenu(){
        boolean flag;
        do {
            flag = false;
            System.out.println("1-Add Equipment\n2-Edit Equipment\n3-Delete Equipment");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String name;
                    int quantity;
                    String[]targetedMuscle;
                    System.out.println("enter equipment name");
                    name = input.next();
                    System.out.println("enter equipment quantity");
                    quantity = input.nextInt();
//                    System.out.println("enter equipment targetedMuscle");
//                    targetedMuscle = input.next();
                    Equipment E = new Equipment(Sports_equipment.size()+1,name,quantity,targetedMuscle);
                    AddEquipment(E);
                    flag = true;
                    break;
//                case 2:
//                    EditEquipment();
//                    flag = true;
//                    break;
                case 3:
                    int ID;
                    System.out.println("Enter Equipment ID:");
                    ID = input.nextInt();
                    RemoveEquipment(ID);
                    flag = true;
                    break;
            }
        } while (!flag);
    }

    public void AdminCoachMenu(){
        boolean flag;
        do {
            flag = false;
            System.out.println("1-Add Coaches\n2-Edit Coaches\n3-Delete Coaches\n4-Display all the customers of a specific coach.\n5-Display the coaches sorted in terms of the most assigned number of " +
                    "customers to the coaches.");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String name, email, password, phoneNumber;
                    char gender;
                    System.out.println("enter your name");
                    name = input.next();
                    System.out.println("enter your email");
                    email = input.next();
                    System.out.println("enter your password");
                    password = input.next();
                    System.out.println("enter your phone number");
                    phoneNumber = input.next();
                    System.out.println("enter your gender");
                    gender = input.next().charAt(0);
                    Coach C = new Coach(Coach.coachCount+1,name,email,password,phoneNumber,gender);
                    AddCoach(C);
                    flag = true;
                    break;
//                case 2:
//                    EditCustomer();
//                    flag = true;
//                    break;
                case 3:
                    int ID;
                    System.out.println("Enter Coach ID:");
                    ID = input.nextInt();
                    RemoveCoach(ID);
                    flag = true;
                    break;
                case 4:
                    int CoachID;
                    System.out.println("Enter Coach ID:");
                    CoachID = input.nextInt();
                    getCoachByID(CoachID).DisplayClientsInfo();
                    flag = true;
                    break;
//                case 5:
//                    ViewCustomers();
//                    flag = true;
//                    break;
            }
        } while (!flag);
    }

    public void EditCustomer() {
        int  customerID;
        String newName, newEmail, newPassword, newGender, newNumber;

        System.out.println("Enter customer ID");
        customerID = input.nextInt();
        Customer editedcustomer = null;
        editedcustomer = Gym.SearchCustomerByID(customerID);
        System.out.println("what do you want to edit ====== 1)Name     2)email      3)password      4)phone-number       5)Gender");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.println("enter the new name");
                newName = input.next();
                editedcustomer.setName(newName);
                break;
            case 2:
                System.out.println("enter the new email");
                newEmail = input.next();
                editedcustomer.setEmail(newEmail);
                break;
            case 3:
                System.out.println("enter the new password");
                newPassword = input.next();
                editedcustomer.setPassword(newPassword);
                break;
            case 4:
                System.out.println("enter the new phone number");
                newNumber = input.next();
                editedcustomer.setPhone_number(newNumber);
                break;
            case 5:
                System.out.println("enter the new Gender");
                newGender = input.next();
                editedcustomer.setEmail(newGender);
                break;
        }
    }

    public void EditCoach() {
        int coachID;
        String newName, newEmail, newPassword, newGender, newNumber;

        System.out.println("Enter coach ID");
        coachID = input.nextInt();
        Coach editedcoach = null;
        editedcoach = Gym.SearchCoachByID(coachID);
        System.out.println("what do you want to edit ====== 1)Name     2)email      3)password      4)phone-number       5)Gender");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.println("enter the new name");
                newName = input.next();
                editedcoach.setName(newName);
                break;
            case 2:
                System.out.println("enter the new email");
                newEmail = input.next();
                editedcoach.setEmail(newEmail);
                break;
            case 3:
                System.out.println("enter the new password");
                newPassword = input.next();
                editedcoach.setPassword(newPassword);
                break;
            case 4:
                System.out.println("enter the new phone number");
                newNumber = input.next();
                editedcoach.setPhone_number(newNumber);
                break;
            case 5:
                System.out.println("enter the new Gender");
                newGender = input.next();
                editedcoach.setEmail(newGender);
                break;
        }
    }

    public void EditEquipments() {
        int equipmentcode;
        String newName,newTargetMuscles;
        int newQuantity;

        System.out.println("Enter equipment code");
        equipmentcode= input.nextInt();
        Equipment editedequipment = null;
        editedequipment= Gym.SearchEquipmentByCode(equipmentcode);
        System.out.println("what do you want to edit ====== 1)Name     2)quantity      3)targeted muscles");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.println("enter the new name");
                newName = input.next();
                editedequipment.setName(newName);
                break;
            case 2:
                System.out.println("enter the new quantity");
                newQuantity = input.nextInt();
                editedequipment.setQuantity(newQuantity);
                break;
//            case 3:
//                System.out.println("enter the new targeted muscles");
//                newTargetMuscles = input.next();
//                editedequipment.setTargetedMuscles(newTargetMuscles[]);
//                break;
        }
    }
}

