package Master;

import Services.Equipment;
import Services.InBody;
import Services.Subscription;
import Users.Coach;
import Users.Customer;

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


        for (Equipment equipment : Sports_equipment) {
            if (equipment.getEQUIPMENTCODE() == Code) {
                Sports_equipment.remove(equipment);
                break;
            }
        }
    }

    public void ViewEquipments() {
        for (Equipment equipment : Sports_equipment) {
            equipment.DisplayInfo();
            System.out.println("=================");

        }
    }

    public static void AddCustomer(Customer customer) {
        Customers.add(customer);
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
        for (Customer customer : Customers) {
            customer.DisplayInfo();
            System.out.println("=================");
        }
    }

    public static void AddCoach(Coach coach) {
        Coaches.add(coach);
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
        for (Coach coach : Coaches) {

            coach.DisplayInfo();
            System.out.println("=================");

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

    public static void replaceCustomer(int index, Customer co) {

        Customers.remove(index);
        Customers.add(co);


    }

    public static void replaceCoach(int index, Coach co) {

        Coaches.remove(index);
        Coaches.add(co);


    }

    public static void replaceEquipment(int index, Equipment eq) {

        Sports_equipment.remove(index);
        Sports_equipment.add(eq);


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

    public static void AddInbody(InBody inBody) {

        Inbodies.add(inBody);
    }

    public void RemoveSubscriptions(int ID) {

        for (Subscription subscription : Subscriptions) {
            if (subscription.getSUBSCRIPTION_ID() == ID) {
                Subscriptions.remove(subscription);
                break;
            }
        }


    }

    public static void ViewSubscriptions(int ID) {
        for (Subscription subscription : Subscriptions) {
            if (subscription.getCustomerId() == ID) {
                subscription.DisplaySubscriptionInfo();
                System.out.println("=================");

            }
        }
    }

    public Coach getCoachByID(int ID) {
        Coach C = null;
        for (Coach coach : Coaches) {
            if (coach.getID() == ID) {
                C = coach;
            }
        }
        return C;
    }

    public InBody getInbody_By_CustomerID(int ID) {
        InBody inBody = null;
        for (InBody inbody : Inbodies) {
            if (inbody.getCustomer_ID() == ID) {
                inBody = inbody;
            }
        }
        return inBody;
    }
}

