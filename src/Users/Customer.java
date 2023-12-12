package Users;

import Services.InBody;
import Services.Subscription;

public class Customer extends Person {
    private Subscription subscription;
    private InBody CurrentInBody;
    private Coach coach;

    public Customer(int ID, String name, String email, String password, String phone_number, char gender) {
        super(ID, name, email, password, phone_number, gender);
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public InBody getInBodies() {
        return CurrentInBody;
    }

    public void setInBodies(InBody inBodies) {
        this.CurrentInBody = inBodies;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getSubscription_ID() {
        if (subscription != null) {
            return this.subscription.getSUBSCRIPTION_ID();
        }
        return 0;
    }

    public void setSubscription_ID(int subscription_ID) {
        if (subscription != null) {
            subscription.setSUBSCRIPTION_ID(subscription_ID);
        }
    }

    public int getCoach_ID() {
        if (coach != null) {
            return this.coach.getID();
        }
        return 0;
    }

    public void setCoach_ID(int coach_ID) {
        if (coach != null) {
            coach.setID(coach_ID);
        }
    }

    public void Subscribe(Subscription subscription, Coach coach){
        this.setSubscription(subscription);
        this.setCoach(coach);
    }

    public void DisplayInfo() {
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
//        System.out.println("Password: " + this.getPassword());
        System.out.println("Phone number: " + this.getPhone_number());
        System.out.println("Subscription: " + this.getSubscription());
        System.out.println("Coach: " + this.getCoach().getName());
    }

    public void DisplayCoachInfo() {
        if (coach != null){
            coach.DisplayInfo();
        }
    }
}
