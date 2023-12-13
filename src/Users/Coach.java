package Users;

public class Coach extends Person {
    private int workingHoursPerDay;
    private int numberOfClients = 0;
    private final Customer[] clients = new Customer[10];

    public Coach(int ID, String name, String email, String password, String phone_number, char gender) {
        super(ID, name, email, password, phone_number, gender);
    }

    public int getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public void setWorkingHoursPerDay(int workingHoursPerDay) {
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
        clients[numberOfClients - 1] = client;
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
        System.out.println(getID() + "\t|\t" + getName() + "\t|\t" + getEmail() + "\t|\t" + getPhone_number() + "\t|\t" + getGender() + "\t|\t" + getWorkingHoursPerDay() + "\t|\t" + getNumberOfClients());
    }

    public void DisplayClientInfo(String Name) {
        if (numberOfClients > 0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tCoach Name");
            System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                if (clients[i].getName().equals(Name)) {
                    clients[i].DisplayInfo();
                    break;
                }
            }
        } else {
            System.out.println("YOU DON'T HAVE ANY CLIENTS AVAILABLE.");
        }
    }

    public void DisplayClientsInfo() {
        if (numberOfClients > 0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tCoach Name");
            System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                if (clients[i] != null) {
                    clients[i].DisplayInfo();
                    System.out.println("---------------------------------------------------------------");
                }
            }
        } else {
            System.out.println("YOU DON'T HAVE ANY CLIENTS AVAILABLE.");
        }
    }


    public void DisplayClientsByGender(char Gender) {
        if (numberOfClients > 0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID\t|\tName\t|\tEmail\t|\tPhoneNumber\t|\tGender\t|\tCoach Name");
            System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                if (clients[i].getGender() == Gender) {
                    clients[i].DisplayInfo();
                    System.out.println("---------------------------------------------------------------");
                }
            }
        } else {
            System.out.println("YOU DON'T HAVE ANY CLIENTS AVAILABLE.");
        }
    }
}
