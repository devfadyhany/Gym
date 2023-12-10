package Master;

import Services.Equipment;
import Services.InBody;
import Services.Subscription;
import Users.Admin;
import Users.Coach;
import Users.Customer;
import Utilities.Login;
import Utilities.Register;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//        For Customer:
//        1. Get his coach info (Name, Phone number, working hours)
//        2. Display for all the Master.Gym Services.Equipment.
//        3. Display the customer the membership’s plan details.
//        4. Display the in-body information at a specific date.
//        5. Display for the user how many kilos need to be reduced according to his body
//        (you can get any calculation through the internet)
//
//        For Coach:
//        1. Show a list of all his customers.
//        2. Get the inBody history of any of his customers.
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

        char flag = 'y';
        do {
            int choice;
            System.out.println("========================================");
            System.out.println("What is your role?\n====================\n1-coach\n2-client\n3-admin\n4-Exit.");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                case 2:
                    RoleMenu(choice);

                    break;
                case 3:
                    LoginMenu(choice);

                    break;
                case 4:
                    flag = 'n';
                    break;
            }
        } while (flag == 'y');
    }

    public void RoleMenu(int choice) {

        int newchoice;
        do {
            System.out.println("========================================");
            System.out.println("1- Login      2-Register      3-cancel");
            newchoice = input.nextInt();
            switch (newchoice) {
                case 1:
                    LoginMenu(choice);
                    break;
                case 2:
                    RegisterMenu(choice);
                    break;
                case 3:
                    newchoice = 0;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        } while (newchoice != 0);
    }

    public void LoginMenu(int choice) {

        int ErrorChoice;
        String email, password;
        System.out.println("========================================");
        System.out.println("enter your email");
        email = input.next();
        System.out.println("enter your password");
        password = input.next();

        if (choice == 1) {
            if (Login.CoachLogin(email, password) != null) {
                coachMenu(Login.CoachLogin(email, password));
            } else {
                System.out.println("Incorrect Email or Password, Press 1 to 'TryAgain' or any number to go 'Back'.");
                ErrorChoice = input.nextInt();
                if (ErrorChoice == 1){
                    LoginMenu(1);
                }
            }
        } else if (choice == 2) {
            if (Login.CustomerLogin(email, password) != null) {
                customerMenu(Login.CustomerLogin(email, password));
            } else {
                System.out.println("Incorrect Email or Password, Press 1 to 'TryAgain' or any number to go 'Back'.");
                ErrorChoice = input.nextInt();
                if (ErrorChoice == 1){
                    LoginMenu(2);
                }
            }
        } else if (choice == 3) {
            if (Login.AdminLogin(email, password)) {
                adminMenu();
            } else {
                System.out.println("Incorrect Email or Password, Try again.");
                LoginMenu(3);
            }
        }
    }

    public void RegisterMenu(int choice) {

        String name, email, password, phoneNumber;
        char gender;
        System.out.println("========================================");
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

        System.out.println(customer.isApproved());
        if (customer.isApproved()) {
            char flag = 'y';
            do {
                System.out.println("========================================");
                System.out.println("Welcome, " + customer.getName());
                System.out.println("1-coach info\n2-Gym Equipment\n3-membership plan\n4-IN-BODY\n5-Kilos remaining\n6-Back To Main Menu");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        customer.DisplayCoachInfo();

                        break;
                    case 2:
                        ViewEquipments();

                        break;
                    case 3:
                        if (customer.getSubscription() != null) {
                            customer.getSubscription().DisplaySubscriptionInfo();
                        }
                        break;
                    case 4:
                        if (customer.getInBodies() != null) {
                            customer.getInBodies().displayInBody();
                        }
                        break;
                    case 5:
                        if (customer.getInBodies() != null) {
                            System.out.println(customer.getInBodies().CalcIdealWeight());
                        }
                        break;
                    case 6:
                        flag = 'n';
                        break;
                }
            } while (flag == 'y');
        } else {
            System.out.println("========================================");
            System.out.println("Account is on Hold\nWaiting for Admin is Approval...");
        }
    }

    public void coachMenu(Coach coach) {

        if (coach.isApproved()) {
            char flag = 'y';
            do {
                System.out.println("========================================");
                System.out.println("Welcome, " + coach.getName());
                System.out.println("1-Customers info\n2-InBody History for any of the Customers\n3-Get all the details of a customer by his name.\n4-Show a list of all female/male customers.\n5-Back To Main Menu.");
                int choice = input.nextInt();
                String customerName;
                int customerId;
                char customerGender;
                switch (choice) {
                    case 1:
                        coach.DisplayClientsInfo();

                        break;
                    case 2:
                        System.out.println("enter id for customer");
                        customerId = input.nextInt();
                        for (InBody B : Gym.Inbodies) {
                            if (B.getCustomer_ID() == customerId) {
                                B.displayInBody();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter Customer's Name");
                        customerName = input.next();
                        coach.DisplayClientInfo(customerName);
                        break;
                    case 4:
                        System.out.println("Choose Male or Female: (M for Male,F for Female).");
                        customerGender = input.next().charAt(0);
                        coach.DisplayClientsByGender(customerGender);
                        break;
                    case 5:
                        flag = 'n';
                        break;
                }
            } while (flag == 'y');
        } else {
            System.out.println("========================================");
            System.out.println("Account is on Hold\nWaiting for Admin is Approval...");
        }
    }

    public void adminMenu() {

        char flag = 'y';
        do {
            System.out.println("========================================");
            System.out.println("Welcome, " + Admin.getName());
            System.out.println("Which menu do you want?\n");
            System.out.println("1-Customers\n2-Gym Equipments\n3-Coaches\n4-Back To Main Menu");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    AdminCustomerMenu();
                    break;
                case 2:
                    AdminEquipmentMenu();
                    break;
                case 3:
                    AdminCoachMenu();
                    break;
                case 4:
                    flag = 'n';
                    break;
            }
        } while (flag == 'y');
    }

    public void AdminCustomerMenu() {

        char flag = 'y';
        do {
            System.out.println("========================================");
            System.out.println("1-Add Customers\n2-Edit Customers\n3-Delete Customers\n4-Show the subscription history for a customer.\n5-Display all the customers that subscribed to the gym in a given month/day.\n6-Approve Customers.\n7-Back.");
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
                    Customer C = new Customer(Gym.Customers.size() + 1, name, email, password, phoneNumber, gender);
                    C.setApproved(true);
                    AddCustomer(C);
                    break;
                case 2:
                    EditCustomer();
                    break;
                case 3:
                    int ID;
                    System.out.println("Enter Customer ID:");
                    ID = input.nextInt();
                    RemoveCustomer(ID);
                    break;
                case 4:
                    int cID;
                    System.out.println("Enter Customer ID:");
                    ID = input.nextInt();
                    Gym.ViewSubscriptions(ID);
                    break;
                case 5:
                    int day, month;
                    System.out.println("Enter a day:");
                    day = input.nextInt();
                    System.out.println("Enter a month:");
                    month = input.nextInt();

                    LocalDate specificDate = LocalDate.of(0, month, day);

                    for (Subscription s : Gym.Subscriptions) {
                        if (specificDate.getDayOfMonth() == s.getPlan().getStart_Date().getDayOfMonth() && specificDate.getMonth() == s.getPlan().getStart_Date().getMonth()) {
                            Gym.SearchCustomerByID(s.getCustomerId()).DisplayInfo();
                        }
                    }
                    break;
                case 6:
                    int approveId, needApproveCounter = 0;
                    if (Gym.Customers.isEmpty()) {
                        System.out.println("There is no registered customers");
                    } else {
                        for (Customer c : Gym.Customers) {
                            if (!c.isApproved()) {
                                System.out.println("customer#" + needApproveCounter + 1 + ": id-" + c.getID() + " name-" + c.getName());
                                needApproveCounter++;
                            }
                        }
                        if (needApproveCounter != 0) {
                            System.out.println("Enter the id of the customer you want to approve:");
                            approveId = input.nextInt();
                            if (Gym.SearchCustomerByID(approveId) != null && !Gym.SearchCustomerByID(approveId).isApproved()) {
                                Gym.SearchCustomerByID(approveId).setApproved(true);
                                System.out.println("========================================");
                                System.out.println("CUSTOMER APPROVED");
                            } else {
                                System.out.println("========================================");
                                System.out.println("Invalid option");
                            }
                        } else {
                            System.out.println("========================================");
                            System.out.println("No Customers needs approve.");
                        }
                    }
                    break;
                case 7:
                    flag = 'n';
                    break;
            }
        } while (flag == 'y');
    }

    public void AdminEquipmentMenu() {

        char flag = 'y';
        do {
            System.out.println("========================================");
            System.out.println("1-Add Services.Equipment\n2-Edit Services.Equipment\n3-Delete Services.Equipment\n4-Back.");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String name;
                    int quantity, noOfMuscles;
                    ArrayList<String> targetedMuscles = new ArrayList<>();
                    System.out.println("enter equipment name");
                    name = input.next();
                    System.out.println("enter equipment quantity");
                    quantity = input.nextInt();
                    System.out.println("How many Targeted Muscles?");
                    noOfMuscles = input.nextInt();
                    for (int i = 0; i < noOfMuscles; i++) {
                        String muscle;
                        System.out.println("enter equipment targetedMuscle" + i + 1);
                        muscle = input.next();
                        targetedMuscles.add(muscle);
                    }

                    Equipment E = new Equipment(name, quantity, Sports_equipment.size() + 1, targetedMuscles);
                    AddEquipment(E);

                    break;
                case 2:
                    EditEquipments();
                    break;
                case 3:
                    int ID;
                    System.out.println("Enter Services.Equipment ID:");
                    ID = input.nextInt();
                    RemoveEquipment(ID);

                    break;
                case 4:
                    flag = 'n';
                    break;
            }
        } while (flag == 'y');
    }

    public void AdminCoachMenu() {

        char flag = 'y';
        do {
            System.out.println("========================================");
            System.out.println("1-Add Coaches\n2-Edit Coaches\n3-Delete Coaches\n4-Display all the customers of a specific coach.\n5-Display the coaches sorted in terms of the most assigned number of " +
                    "customers to the coaches.\n6-Approve Coaches.\n7-Back.");
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
                    Coach C = new Coach(Gym.Coaches.size() + 1, name, email, password, phoneNumber, gender);
                    C.setApproved(true);
                    AddCoach(C);
                    break;
                case 2:
                    EditCoach();
                    break;
                case 3:
                    int ID;
                    System.out.println("Enter Coach ID:");
                    ID = input.nextInt();
                    RemoveCoach(ID);

                    break;
                case 4:
                    int CoachID;
                    System.out.println("Enter Coach ID:");
                    CoachID = input.nextInt();
                    getCoachByID(CoachID).DisplayClientsInfo();

                    break;
                case 5:
                    Gym.Coaches.sort(Comparator.comparingInt(Coach::getNumberOfClients));
                    Gym.ViewCoaches();
                    break;
                case 6:
                    int approveId, needApproveCounter = 0;
                    if (Gym.Coaches.isEmpty()) {
                        System.out.println("There is no registered coaches");
                    } else {
                        for (Coach c : Gym.Coaches) {
                            if (!c.isApproved()) {
                                System.out.println("coach#" + needApproveCounter + 1 + ": id-" + c.getID() + " name-" + c.getName());
                                needApproveCounter++;
                            }
                        }
                        if (needApproveCounter != 0) {
                            System.out.println("Enter the id of the coach you want to approve:");
                            approveId = input.nextInt();
                            if (Gym.SearchCoachByID(approveId) != null && !Gym.SearchCoachByID(approveId).isApproved()) {
                                Gym.SearchCoachByID(approveId).setApproved(true);
                                System.out.println("========================================");
                                System.out.println("COACH APPROVED");
                            } else {
                                System.out.println("========================================");
                                System.out.println("Invalid option");
                            }
                        } else {
                            System.out.println("========================================");
                            System.out.println("No Coaches needs approve.");
                        }
                    }
                    break;
                case 7:
                    flag = 'n';
                    break;
            }
        } while (flag == 'y');

    }

    public void EditCustomer() {

        int customerID;
        String newName, newEmail, newPassword, newGender, newNumber;
        System.out.println("========================================");
        System.out.println("Enter customer ID");
        customerID = input.nextInt();
        Customer editedcustomer = null;
        char flag;

        int index = Gym.Customers.indexOf(Gym.SearchCustomerByID(customerID));
        editedcustomer = Gym.Customers.get(index);
        do {
            System.out.println("========================================");
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

            Gym.replaceCustomer(index, editedcustomer);
            System.out.println("do you want to edit another thing?y/n");
            flag = input.next().charAt(0);
        } while (flag == 'y' || flag == 'Y');
    }

    public void EditCoach() {
        int coachID;
        String newName, newEmail, newPassword, newGender, newNumber;
        System.out.println("========================================");
        System.out.println("Enter coach ID");
        coachID = input.nextInt();
        Coach editedcoach = null;
        char flag;

        int index = Gym.Coaches.indexOf(Gym.SearchCoachByID(coachID));
        editedcoach = Gym.Coaches.get(index);
        do {
            System.out.println("========================================");
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

            Gym.replaceCoach(index, editedcoach);
            System.out.println("do you want to edit another thing?y/n");
            flag = input.next().charAt(0);
        } while (flag == 'y' || flag == 'Y');
    }

    public void EditEquipments() {

        int equipmentcode;
        String newName;
        int newQuantity;
        System.out.println("========================================");
        System.out.println("Enter equipment code");
        equipmentcode = input.nextInt();
        Equipment editedequipment = null;
        char flag;

        int index = Gym.Sports_equipment.indexOf(Gym.SearchEquipmentByCode(equipmentcode));
        editedequipment = Gym.Sports_equipment.get(index);
        do {
            System.out.println("========================================");
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
                case 3:
                    int choice;
                    System.out.println("Choose the targeted muscle you want to edit");
                    for (int i = 0; i < Gym.Sports_equipment.get(index).targetedMuscles.size(); i++) {
                        System.out.println(i + 1 + ":" + Gym.Sports_equipment.get(index).targetedMuscles.get(i));

                    }
                    choice = input.nextInt();
                    String muscle;
                    System.out.println("Enter the new Targeted Muscle");

                    muscle = input.next();

                    editedequipment.replaceTargetedMuscles(choice - 1, muscle);
                    break;
            }

            Gym.replaceEquipment(index, editedequipment);
            System.out.println("do you want to edit another thing?y/n");
            flag = input.next().charAt(0);
        } while (flag == 'y' || flag == 'Y');
    }
}

