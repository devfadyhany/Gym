public class Customer extends Person{
    private Subscription subscription;
    private InBody inBodies;
    private Coach coach;
    public static int customersCount = 0;

    public Customer(int ID ,String name , String email, String password, String phone_number, char gender){
        super(ID,name,email,password,phone_number,gender);
        customersCount++;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public InBody getInBodies() {
        return inBodies;
    }

    public void setInBodies(InBody inBodies) {
        this.inBodies = inBodies;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getSubscription_ID() {
        return this.subscription.getSUBSCRIPTION_ID();
    }

    public void setSubscription_ID(int subscription_ID) {
        this.subscription.setSUBSCRIPTION_ID(subscription_ID);
    }

    public int getCoach_ID() {
        return this.coach.getID();
    }

    public void setCoach_ID(int coach_ID) {
        this.coach.setID(coach_ID);
    }

    public void DisplayInfo(){
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Password: " + this.getPassword());
        System.out.println("Phonenumber: " + this.getPhone_number());
        System.out.println("Subscription: " + this.getSubscription());
        System.out.println("Coach: " + this.getCoach().getName());
    }

    public void DisplayCoachInfo(){
        this.getCoach().DisplayInfo();
    }
}
