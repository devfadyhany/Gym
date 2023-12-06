import java.util.ArrayList;

public class Gym {

    private String Name;
    private String Address;
    private String Phone_number;
    public static ArrayList<Customer> Customers = new ArrayList<>();
    public static ArrayList<Coach> Coaches = new ArrayList<>();
    public static ArrayList<Equipment> Sports_equipment = new ArrayList<>();
    public static ArrayList<Subscription> Subscriptions = new ArrayList<>();

    public static ArrayList<InBody> Inbodies = new ArrayList<>();

    public Gym() {
        this.Name = "GYM";
        this.Address = "Default";
        this.Phone_number = "00000000000";
    }

    public Gym(String Name, String Address, String Phone_number) {
        this.Name = Name;
        this.Address = Address;
        this.Phone_number = Phone_number;
    }


    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setPhoneNumber(String Phone_number) {
        this.Phone_number = Phone_number;
    }

    public String getPhoneNumber() {
        return Phone_number;
    }

    public void AddEquipment(Equipment equipment) {
        Sports_equipment.add(equipment);
    }

    public void RemoveEquipment(int Code) {


        for (Equipment equipment:Sports_equipment) {
            if (equipment.getEQUIPMENTCODE() == Code) {
                Sports_equipment.remove(equipment);
                break;
            }
        }
    }

    public void ViewEquipments() {
        for (Equipment equipment:Sports_equipment) {
            equipment.DisplayInfo();
            System.out.println("=================");

        }
    }

    public static void AddCustomer(Customer customer) {
        Customers.add(customer);
    }

    public static void RemoveCustomer(int ID) {


        for (Customer customer:Customers) {
            if (customer.getID() == ID) {
                Customers.remove(customer);
                break;
            }
        }
        Customer.customersCount--;
    }

    public static void ViewCustomers() {
        for (Customer customer:Customers) {
            customer.DisplayInfo();
            System.out.println("=================");
        }
    }

    public static void AddCoach(Coach coach) {
        Coaches.add(coach);
    }

    public static void RemoveCoach(int ID) {

        for (Coach coach:Coaches) {
            if (coach.getID() == ID) {
                Coaches.remove(coach);
                break;
            }
        }
        Coach.coachCount--;
    }

    public static void ViewCoaches(int ID) {
        for (Coach coach:Coaches) {
            if (coach.getID() == ID) {
                coach.DisplayInfo();
                System.out.println("=================");
                break;
            }
        }
    }

    public static Coach SearchCoachByID(int id) {
        Coach c=null;
        for (Coach coach:Coaches) {
            if (coach.getID() == id) {
                c=coach;
                break;
            }
        }
        return c;
    }

    public static Customer SearchCustomerByID(int id) {
        Customer cus=null;
        for (Customer customer:Customers) {
            if (customer.getID() == id) {
                cus=customer;
                break;
            }
        }
        return cus;
    }

    public void AddSubscription(Subscription Subscription) {

        Subscriptions.add(Subscription);
    }

    public void RemoveSubscriptions(int ID) {

        for (Subscription subscription:Subscriptions) {
            if (subscription.getSUBSCRIPTION_ID() == ID) {
                Subscriptions.remove(subscription);
                break;
            }
        }


    }

    public void ViewSubscriptions(int ID) {
        for (Subscription subscription:Subscriptions) {
            if (subscription.getSUBSCRIPTION_ID() == ID) {
                subscription.DisplaySubscriptionInfo();
                System.out.println("=================");
                break;
            }
        }
    }

    public Coach getCoachByID(int ID) {
        Coach C = null;
        for (Coach coach:Coaches) {
            if (coach.getID() == ID) {
                C = coach;
            }
        }
        return C;
    }
}

