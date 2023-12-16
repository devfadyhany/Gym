package Master;

import Services.Equipment;
import Services.InBody;
import Services.Subscription;
import Users.Coach;
import Users.Customer;

import java.util.ArrayList;

public class Gym {
    private static String Name;
    private static String Address;
    private static String Phone_number;
    public static ArrayList<Customer> Customers = new ArrayList<>();
    public static int CustomersIdsCounter = 0;
    public static ArrayList<Coach> Coaches = new ArrayList<>();
    public static int CoachesIdsCounter = 0;
    public static ArrayList<Equipment> Sports_equipment = new ArrayList<>();
    public static int EquipmentsIdsCounter = 0;
    public static ArrayList<Subscription> Subscriptions = new ArrayList<>();
    public static int SubscriptionsIdsCounter = 0;
    public static ArrayList<InBody> InBodies = new ArrayList<>();

    public Gym(String Name, String Address, String Phone_number) {
        Gym.Name = Name;
        Gym.Address = Address;
        Gym.Phone_number = Phone_number;

        for (Customer c : Customers) {
            for (InBody b : InBodies) {
                if (b.getCustomer_ID() == c.getID()) {
                    c.setInBody(b);
                }
            }
            for (Subscription s : Subscriptions) {
                if (s.getCustomerId() == c.getID()) {
                    c.setSubscription(s);
                    c.setCoach(Gym.SearchCoachByID(s.getCoachId()));
                }
            }
            CustomersIdsCounter++;
        }

        for (Coach c : Coaches) {
            for (Subscription s : Gym.Subscriptions) {
                if (s.getCoachId() == c.getID()) {
                    c.AddClient(Gym.SearchCustomerByID(s.getCustomerId()));
                }
            }
            CoachesIdsCounter++;
        }

        for (Subscription s : Subscriptions) {
            SubscriptionsIdsCounter++;
        }

        for (Equipment e : Sports_equipment) {
            EquipmentsIdsCounter++;
        }

    }

    public void ViewGymInfo() {
        System.out.println("Name\t|\tAddress\t|\tPhone_number");
        System.out.println(getName() + "\t|\t" + getAddress() + "\t|\t" + getPhoneNumber());
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Gym.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        Gym.Address = Address;
    }

    public String getPhoneNumber() {
        return Phone_number;
    }

    public void setPhoneNumber(String Phone_number) {
        Gym.Phone_number = Phone_number;
    }

    public static void AddCustomer(Customer customer) {
        Customers.add(customer);
        CustomersIdsCounter++;
    }

    public static void RemoveCustomer(int ID) {
        for (Customer customer : Customers) {
            if (customer.getID() == ID) {
                for (Coach c : Coaches) {
                    for (Customer cus : c.getClients()) {
                        if (cus.getID() == ID) {
                            c.RemoveClient(ID);
                        }
                    }
                }
                Customers.remove(customer);
                break;
            }
        }
    }

    public static void ViewCustomers() {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tWorking Hours-Per-Day\t|\tNumber Of Clients");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Customer customer : Customers) {
            try {
                customer.DisplayInfo();
                System.out.println("------------------------------------------------------------------------------------------------");
            }catch (NullPointerException exp){
                continue;
            }
        }
    }

    public static Customer SearchCustomerByID(int id) {
        Customer cus = null;
        for (Customer customer : Customers) {
            if (customer.getID() == id) {
                cus = customer;
                break;
            }
        }
        return cus;
    }

    public static void AddCoach(Coach coach) {
        Coaches.add(coach);
        CoachesIdsCounter++;
    }

    public static void RemoveCoach(int ID) {

        for (Coach coach : Coaches) {
            if (coach.getID() == ID) {
                Coaches.remove(coach);
                break;
            }
        }
    }

    public static void ViewCoaches() {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tWorking Hours-Per-Day\t|\tNumber Of Clients");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Coach coach : Coaches) {
            coach.DisplayInfo();
            System.out.println("------------------------------------------------------------------------------------------------");
        }
    }

    public static Coach SearchCoachByID(int id) {
        Coach c = null;
        for (Coach coach : Coaches) {
            if (coach.getID() == id) {
                c = coach;
                break;
            }
        }
        return c;
    }

    public void AddEquipment(Equipment equipment) {
        Sports_equipment.add(equipment);
        EquipmentsIdsCounter++;
    }

    public void RemoveEquipment(int Code) {
        for (Equipment equipment : Sports_equipment) {
            if (equipment.getEQUIPMENTCODE() == Code) {
                Sports_equipment.remove(equipment);
                break;
            }
        }
    }

    public void ViewEquipments() {
        System.out.println("CODE\t|\tName\t|\tQuantity\t|\tTargeted-Muscles");
        for (Equipment equipment : Sports_equipment) {
            equipment.DisplayInfo();
            System.out.println("---------------------------------------------------");
        }
    }

    public static Equipment SearchEquipmentByCode(int code) {
        Equipment equ = null;
        for (Equipment equipment : Sports_equipment) {
            if (equipment.getEQUIPMENTCODE() == code) {
                equ = equipment;
                break;
            }
        }
        return equ;
    }

    public static void AddSubscription(Subscription Subscription) {
        Subscriptions.add(Subscription);
        SubscriptionsIdsCounter++;
    }

    public static Subscription SearchSubscriptionById(int id) {
        Subscription sub = null;
        for (Subscription subscription : Subscriptions) {
            if (subscription.getSUBSCRIPTION_ID() == id) {
                sub = subscription;
                break;
            }
        }
        return sub;
    }

    public static void ViewSubscriptions(int ID) {
        for (Subscription subscription : Subscriptions) {
            if (subscription.getCustomerId() == ID) {
                subscription.DisplaySubscriptionInfo();
                System.out.println("=================");

            }
        }
    }

    public static void AddInBody(InBody inBody) {
        InBodies.add(inBody);
    }
}

