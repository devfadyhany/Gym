public class Customer extends Person{
    private Subscription subscription;
    private InBody inBodies;
    private Coach coach;
    public static int customersCount = 0;

    public Customer(int ID, String Name, String Email, String Password, String Phonenumber){
        super(ID,Name,Email,Password,Phonenumber);
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

    public void DisplayInfo(){
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Password: " + this.getPassword());
        System.out.println("Phonenumber: " + this.getPhonenumber());
        System.out.println("Subscription: " + this.getSubscription());
        System.out.println("Coach: " + this.getCoach().getName());
    }

    public void DisplayCoachInfo(){
        this.getCoach().DisplayInfo();
    }
}
