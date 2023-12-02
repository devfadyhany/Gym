import java.util.Scanner;

//1. Get his coach info (Name, Phone number, working hours)
//2. Display for all the Gym Equipment.
//3. Display the customer the membership’s plan details.
//4. Display the in-body information at a specific date.
//5. Display for the user how many kilos need to be reduced according to his body
//(you can get any calculation through the internet)

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
        Scanner input = new Scanner(System.in);
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

    }

    public void adminMenu(Admin admin) {

    }
}
