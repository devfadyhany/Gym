public class Subscription {
    private int Customer_ID;
    private int Assigned_Coach_ID;
    private plan Membership_plan;

    public Subscription(int Customer_ID,int Assigned_Coach_ID,plan Membership_plan){
        this.Customer_ID = Customer_ID;
        this.Assigned_Coach_ID =Assigned_Coach_ID;
        this.Membership_plan = Membership_plan;
    }
    public void setCustomerid (int id){
        Customer_ID = id;


    }
    public int getCustomerid() {
        return Customer_ID;

    }
    public void setCoach(int coachid)
    {
        Assigned_Coach_ID = coachid;
    }
    public int getCoach()
    {
        return Assigned_Coach_ID;
    }
    public void setPlan(plan p)
    {
        Membership_plan=p;
    }
    public plan getPlan()
    {
        return Membership_plan;
    }
