import java.util.Scanner;

//1. Get his coach info (Name, Phone number, working hours)
//2. Display for all the Gym Equipment.
//3. Display the customer the membership’s plan details.
//4. Display the in-body information at a specific date.
//5. Display for the user how many kilos need to be reduced according to his body
//(you can get any calculation through the internet)

public class Menu extends Gym {
    Scanner input=new Scanner(System.in);
    public void clientMenu(Customer customer){
        boolean flag;
        do {
            flag=false;
            System.out.println("1- coach info\n2- Gym Equpments\n3- membership plan\n4- INBODY\n5- Kilos remaining");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    customer.DisplayCoachInfo();
                    flag=true;
                    break;
                case 2:
                    ViewEquipments();
                    flag=true;
                    break;
                case 3:
                    customer.getSubscription().DisplaySubscriptionInfo();
                    flag=true;
                    break;
                case 4:
                    customer.getInBodies().displayInBody();
                    flag=true;
                    break;
                case 5:
                    System.out.println(customer.getInBodies().CalcIdealWeight());
                    flag=true;
                    break;
            }
        }while (flag = false);
    }

    public void coachMenu(Coach coach){

    }

    public void adminMenu(Admin admin){

    }

    public static void RegisterMenu(int choice){
        Scanner input=new Scanner(System.in);
        String name,email,password,phoneNumber;
        char gender;
        System.out.println("enter your name");
        name=input.next();
        System.out.println("enter your email");
        email=input.next();
        System.out.println("enter your password");
        password=input.next();
        System.out.println("enter your phone number");
        phoneNumber=input.next();
        System.out.println("enter your gender");
        gender=input.next().charAt(0);
        if (choice==2){
            this.clientMenu( Register.CustomerRegister(name,email,password,phoneNumber,gender));
        }
    }

}
