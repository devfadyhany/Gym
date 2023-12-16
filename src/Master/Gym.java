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

    public static void ViewGymInfo() {
        System.out.println("Name\t|\tAddress\t|\tPhone_number");
        System.out.println(Gym.getName() + "\t|\t" + getAddress() + "\t|\t" + getPhoneNumber());
    }

    public static String getName() {
        return Name;
    }

    public void setName(String Name) {
        Gym.Name = Name;
    }

    public static String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        Gym.Address = Address;
    }

    public static String getPhoneNumber() {
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
                        if (cus != null) {
                            if (cus.getID() == ID) {
                                c.RemoveClient(ID);
                            }

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
        System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tCoach Name");
        System.out.println("------------------------------------------------------------------------------------------------");
        if (Customers != null) {
            for (Customer customer : Customers) {
                if (customer != null) {
                    customer.DisplayInfo();
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
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
            if (coach != null) {
                if (coach.getID() == ID) {
                    Coaches.remove(coach);
                    break;
                }

            }
        }
    }

    public static void ViewCoaches() {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tWorking Hours-Per-Day\t|\tNumber Of Clients");
        System.out.println("------------------------------------------------------------------------------------------------");
        if (Coaches != null) {
            for (Coach coach : Coaches) {
                if (coach != null) {
                    coach.DisplayInfo();
                    System.out.println("------------------------------------------------------------------------------------------------");
                }
            }
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

    public static void AddEquipment(Equipment equipment) {
        Sports_equipment.add(equipment);
        EquipmentsIdsCounter++;
    }

    public static void RemoveEquipment(int Code) {
        for (Equipment equipment : Sports_equipment) {
            if (equipment != null) {
                if (equipment.getEQUIPMENTCODE() == Code) {
                    Sports_equipment.remove(equipment);
                    break;
                }
            }
        }
    }

    public static void ViewEquipments() {
        System.out.println("---------------------------------------------------");
        System.out.println("CODE\t|\tName\t|\tQuantity\t|\tTargeted-Muscles");
        System.out.println("---------------------------------------------------");
        if (Sports_equipment != null) {
            for (Equipment equipment : Sports_equipment) {
                if (equipment != null) {
                    equipment.DisplayInfo();
                    System.out.println("---------------------------------------------------");
                }
            }
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
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("SUBSCRIPTION_ID\t|\tCUSTOMER_ID\t|\tCOACH_ID\t|\tStart_Date\t|\tMonthly_Plan\t|\tRegistered_Months_Number\t|\tPrice");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Subscription subscription : Subscriptions) {
            if (subscription.getCustomerId() == ID) {
                subscription.DisplaySubscriptionInfo();
                System.out.println("------------------------------------------------------------------------------------------------");
            }
        }
    }

    public static void AddInBody(InBody inBody) {
        InBodies.add(inBody);
    }
}

