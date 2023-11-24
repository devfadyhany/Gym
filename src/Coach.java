package eg.edu.asu.cis;

public class Coach extends Person{
    private float workingHoursPerDay;
    private int numberOfClients = 0;
    private Customer[] clients = new Customer[10];

    public Coach(int ID, String Name, String Email, String Password, String Phonenumber){
        super(ID,Name,Email,Password,Phonenumber);
    }

    public float getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public void setWorkingHoursPerDay(float workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public Customer[] getClients() {
        return clients;
    }

    public void AddClient(Customer client){
        clients[numberOfClients] = client;
    }

    public void RemoveClient(int ID){
        int removedIndex = 0;

        for(int i = 0; i < 10; i++) {
            if (clients[i].getId == ID) {
                clients[i] = null;
                removedIndex = i;
                break;
            }
        }

        for (int j = 0; j < 10; j++){
            if (j >= removedIndex){
                clients[j] = clients[j+1];
            }
        }
    }

    public void DisplayInfo(){
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Password: " + this.getPassword());
        System.out.println("Phonenumber: " + this.getPhonenumber());
        System.out.println("Working Hours_Per_Day: " + this.getWorkingHoursPerDay());
        System.out.println("Number Of Clients: " + this.getNumberOfClients());
    }

    public void DisplayClientInfo(int ID){
        for (int i = 0; i < 10; i++){
            if (clients[i].getId == ID){
                clients[i].DisplayInfo();
                break;
            }
        }
    }
}
