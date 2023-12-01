import java.awt.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean flag;
        do {
            int choice;
             flag=false;
            Scanner input = new Scanner(System.in);
            System.out.println("What is your role 1-coash    2-client    3-admin)");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    LoginOrRegister(choice);
                    flag=true;
                   break;
                case 2:
                    LoginOrRegister(choice);
                    flag=true;
                    break;
                case 3:
                    LoginMenu(choice);
                    flag=true;
                    break;
            }
        } while (flag = false);

    }

    public static  void LoginOrRegister(int choice) {
        int newchoice;
        do {
            newchoice = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("1- Login      2-Register");
            newchoice = input.nextInt();
            switch (newchoice) {
                case 1:
                    LoginMenu(choice);
                    newchoice=0;
                    break;
                case 2:
                    RegisterMenu(choice);
                    newchoice=0;
                    break;
            }

        }  while (newchoice != 0) ;
    }

    public static void LoginMenu(int choice){
        String email,password;
        Scanner input=new Scanner(System.in);
        System.out.println("enter your email");
        email=input.next();
        System.out.println("enter your password");
        password=input.next();

        if (choice==1){
            Login.CoachLogin(email,password);
        } else if (choice==2) {
            Login.CustomerLogin(email,password);
        }
       else {
          Login.AdminLogin(email,password);
        }
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
    }
}

