import java.util.Scanner;

//1. Get his coach info (Name, Phone number, working hours)
//2. Display for all the Gym Equipment.
//3. Display the customer the membership’s plan details.
//4. Display the in-body information at a specific date.
//5. Display for the user how many kilos need to be reduced according to his body
//(you can get any calculation through the internet)

public abstract class Menu {
Coach X = new Coach();

char ch;
int choice;
Scanner input = new Scanner(System.in);
    public void DisplayClientInfo() {
        do {
            System.out.println("1->Display Coach Information.");
            System.out.println("2->Display Gym Equipment.");
            System.out.println("3->Display Membership Plan.");
            System.out.println("4->Display In-Body Information.");
            System.out.println("5->Display Kilos to be reduced.");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    X.DisplayInfo();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;


            }
        }
        while (true);
    }

}
