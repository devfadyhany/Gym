package Services;

public class Subscription {
    private int SUBSCRIPTION_ID;
    private int Customer_ID;
    private int Assigned_Coach_ID;
    private Membership_Plan plan;

    public Subscription(int SUBSCRIPTION_ID, int Customer_ID, int Assigned_Coach_ID, Membership_Plan plan) {
        this.SUBSCRIPTION_ID = SUBSCRIPTION_ID;
        this.Customer_ID = Customer_ID;
        this.Assigned_Coach_ID = Assigned_Coach_ID;
        this.plan = plan;
    }

    public int getSUBSCRIPTION_ID() {
        return SUBSCRIPTION_ID;
    }

    public void setSUBSCRIPTION_ID(int SUBSCRIPTION_ID) {
        this.SUBSCRIPTION_ID = SUBSCRIPTION_ID;
    }

    public void setCustomerId(int id) {
        Customer_ID = id;
    }

    public int getCustomerId() {
        return Customer_ID;
    }

    public void setCoach(int coachId) {
        Assigned_Coach_ID = coachId;
    }

    public int getCoach() {
        return Assigned_Coach_ID;
    }

    public void setPlan(Membership_Plan p) {
        plan = p;
    }

    public Membership_Plan getPlan() {
        return plan;
    }

    public void DisplaySubscriptionInfo() {
        System.out.println("Subscription_ID: " + this.getSUBSCRIPTION_ID());
        System.out.println("Customer_ID: " + this.getCustomerId());
        System.out.println("Coach_ID: " + this.getCoach());
        plan.DisplayInfo();
    }
}
