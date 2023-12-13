package Services;

public class Subscription {
    private int SUBSCRIPTION_ID;
    private final int Customer_ID;
    private final int Assigned_Coach_ID;
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

    public int getCustomerId() {
        return Customer_ID;
    }

    public int getCoachId() {
        return Assigned_Coach_ID;
    }

    public Membership_Plan getPlan() {
        return plan;
    }

    public void setPlan(Membership_Plan p) {
        plan = p;
    }

    public void DisplaySubscriptionInfo() {
        System.out.print(getSUBSCRIPTION_ID() + "\t|\t" + getCustomerId() + "\t|\t" + getCoachId() + "\t|\t");
        plan.DisplayInfo();
        System.out.print("\n");
    }
}
