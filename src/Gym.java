
public class Gym {


    private String Name;
    private String Address;
    private String Phone_number;
    private Equipment[] Sports_equipment;
    private int numberOfEquipments= 0;
    private Coach[] Coaches;
    private int numberOfCoaches = 0;
    private Subscription[] Subscriptions;
    private int numberOfSubscriptions = 0;



    public Gym(String Name, String Address, String Phone_number, Equipment[] Sports_equipment, Coach[] Coaches, Subscription[] Subscriptions) {
        this.Name = Name;
        this.Address = Address;
        this.Phone_number = Phone_number;
        this.Sports_equipment = Sports_equipment;
        this.Coaches = Coaches;
        this.Subscriptions = Subscriptions;
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
    public void setNumberOfEquipments(int numberOfEquipments) {

        this.numberOfEquipments = numberOfEquipments;
    }
    public int getNumberOfEquipments() {

        return numberOfEquipments;
    }
    public void setNumberOfCoaches(int numberOfCoaches) {

        this.numberOfCoaches = numberOfCoaches;
    }
    public int getNumberOfCoaches() {
        return numberOfCoaches;
    }
    public void setNumberOfSubscriptions(int numberOfSubscriptions) {

        this.numberOfSubscriptions = numberOfSubscriptions;
    }


    public int getNumberOfSubscriptions() {

        return numberOfSubscriptions;
    }

    public void AddEquipment(Equipment[] Sports_equipment){

        Equipment[NumberOfEquipments] = Sports_equipment;
    }

    public void RemoveEquipment(int Code){
        int removedIndex = 0;

        for(int i = 0; i < 10; i++) {
            if (Sports_equipment[i].getEquipmentCode() == Code) {
                Sports_equipment[i] = null;
                removedIndex = i;
                break;
            }
        }

        for (int j = 0; j < 10; j++){
            if (j >= removedIndex){
                Sports_equipment[j] = Sports_equipment[j+1];
            }
        }
    }
    public void ViewEquipments(int ID){
        for (int i = 0; i < 10; i++){
            if (Sports_equipment[i].getEquipmentCode() == ID){
                Sports_equipment[i].DisplayInfo();
                System.out.println("=================");
                break;
            }
        }
    }

    public void AddCoach(Coach[] Coaches){

        Coach[numberOfCoaches] = Coaches;
    }

    public void RemoveCoach(int ID){
        int removedIndex = 0;

        for(int i = 0; i < 10; i++) {
            if (Coaches[i].getId == ID) {
                Coaches[i] = null;
                removedIndex = i;
                break;
            }
        }

        for (int j = 0; j < 10; j++){
            if (j >= removedIndex){
                Coaches[j] = Coaches[j+1];
            }
        }
    }
    public void ViewCoaches(int ID){
        for (int i = 0; i < 10; i++){
            if (Coaches[i].getId == ID){
                Coaches[i].DisplayInfo();
                System.out.println("=================");
                break;
            }
        }
    }
    public void AddSubscription(Subscription[] Subscriptions){

        Subscription[numberOfSubscriptions] = Subscriptions;
    }

    public void RemoveSubscriptions(int ID){
        int removedIndex = 0;

        for(int i = 0; i < 10; i++) {
            if (Subscriptions[i].getId == ID) {
                Subscriptions[i] = null;
                removedIndex = i;
                break;
            }
        }

        for (int j = 0; j < 10; j++){
            if (j >= removedIndex){
                Subscriptions[j] = Subscriptions[j+1];
            }
        }
    }
    public void ViewSubscriptions(int ID){
        for (int i = 0; i < 10; i++){
            if (Subscriptions[i].getId == ID){
                Subscriptions[i].DisplaySubscriptionInfo();
                System.out.println("=================");
                break;
            }
        }
    }
}
