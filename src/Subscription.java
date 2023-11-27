public class Subscription {
    private final int SUBSCRIPTION_ID;
    private int Customer_ID;
    private int Assigned_Coach_ID;
    private Membership_Plan plan;

    public Subscription(int SUBSCRIPTION_ID, int Customer_ID, int Assigned_Coach_ID, Membership_Plan plan) {
        this.SUBSCRIPTION_ID = SUBSCRIPTION_ID;
        this.Customer_ID = Customer_ID;
        this.Assigned_Coach_ID = Assigned_Coach_ID;
        this.plan = plan;
    }

    public int getID() {
        return SUBSCRIPTION_ID;
    }

    public void setCustomerid(int id) {
        Customer_ID = id;
    }

    public int getCustomerid() {
        return Customer_ID;
    }

    public void setCoach(int coachid) {
        Assigned_Coach_ID = coachid;
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
        System.out.println("Subscription_ID: " + this.getID());
        System.out.println("Customer_ID: " + this.getCustomerid());
        System.out.println("Coach_ID: " + this.getCoach());
        plan.DisplayInfo();
    }
}
