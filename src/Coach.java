public class Coach extends Person {
    private float workingHoursPerDay;
    private int numberOfClients = 0;
    private Customer[] clients = new Customer[10];

    public Coach(int ID, String name, String email, String password, String phone_number, char gender) {
        super(ID, name, email, password, phone_number, gender);
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

    public void AddClient(Customer client) {
        clients[numberOfClients] = client;
        numberOfClients++;
    }

    public void RemoveClient(int ID) {
        int removedIndex = 0;

        for (int i = 0; i < 10; i++) {
            if (clients[i].getID() == ID) {
                clients[i] = null;
                removedIndex = i;
                break;
            }
        }

        for (int j = 0; j < 10; j++) {
            if (j < 9) {
                if (j >= removedIndex) {
                    clients[j] = clients[j + 1];
                }
            }
        }
        numberOfClients--;
    }

    public void DisplayInfo() {
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Password: " + this.getPassword());
        System.out.println("Phonenumber: " + this.getPhone_number());
        System.out.println("Working Hours_Per_Day: " + this.getWorkingHoursPerDay());
        System.out.println("Number Of Clients: " + this.getNumberOfClients());
    }

    public void DisplayClientInfo(String Name) {
        for (int i = 0; i < 10; i++) {
            if (clients[i].getName().equals(Name)) {
                clients[i].DisplayInfo();
                break;
            }
        }
    }

    public void DisplayClientsInfo() {
        for (int i = 0; i < 10; i++) {

            clients[i].DisplayInfo();
            System.out.println("=================");
        }
    }


    public void DisplayClientsByGender(char Gender) {

        for (int i = 0; i < 10; i++) {
            if (clients[i].getGender() == Gender) {
                clients[i].DisplayInfo();
                System.out.println("=================");
            }
        }
    }
}
