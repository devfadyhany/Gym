import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
    public static void WriteCustomers(){
        try{
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Customers.csv");
            while (counter <= Customer.customersCount){
                writer.append(Gym.Customers[counter-1].getID() + ",");
                writer.append(Gym.Customers[counter-1].getName() + ",");
                writer.append(Gym.Customers[counter-1].getEmail() + ",");
                writer.append(Gym.Customers[counter-1].getPassword() + ",");
                writer.append(Gym.Customers[counter-1].getPhone_number() + ",");
                writer.append(Gym.Customers[counter-1].getGender() + ",");
                writer.append(Gym.Customers[counter-1].getSubscription().getSUBSCRIPTION_ID() + ",");
                writer.append(Gym.Customers[counter-1].getCoach().getID() + "\n");
                counter++;
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void WriteCoaches(){
        try{
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Coaches.csv");
            while (counter <= Customer.customersCount){
                writer.append(Gym.Coaches[counter-1].getID() + ",");
                writer.append(Gym.Coaches[counter-1].getName() + ",");
                writer.append(Gym.Coaches[counter-1].getEmail() + ",");
                writer.append(Gym.Coaches[counter-1].getPassword() + ",");
                writer.append(Gym.Coaches[counter-1].getPhone_number() + ",");
                writer.append(Gym.Coaches[counter-1].getGender() + ",");
                writer.append(Gym.Coaches[counter-1].getWorkingHoursPerDay() + ",");
                writer.append(Gym.Coaches[counter-1].getNumberOfClients() + "\n");
                counter++;
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void ReadCustomers(){
        String file = "Data/Customers.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                Gym.Customers[counter].setID(Integer.parseInt(row[0]));
                Gym.Customers[counter].setName(row[1]);
                Gym.Customers[counter].setEmail(row[2]);
                Gym.Customers[counter].setPassword(row[3]);
                Gym.Customers[counter].setPhone_number(row[4]);
                Gym.Customers[counter].setGender(row[5]);
//                Gym.Customers[counter].setSubscription_ID(Integer.parseInt(row[6]));
//                Gym.Customers[counter].setCoach_ID(Integer.parseInt(row[7]));
                counter++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void ReadCoaches(){
        String file = "Data/Coaches.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                Gym.Coaches[counter].setID(Integer.parseInt(row[0]));
                Gym.Coaches[counter].setName(row[1]);
                Gym.Coaches[counter].setEmail(row[2]);
                Gym.Coaches[counter].setPassword(row[3]);
                Gym.Coaches[counter].setPhone_number(row[4]);
                Gym.Coaches[counter].setGender(row[5]);
                Gym.Coaches[counter].setWorkingHoursPerDay(Integer.parseInt(row[6]));
                Gym.Coaches[counter].setNumberOfClients(Integer.parseInt(row[7]));
                counter++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void ReadAdmins(){
        String file = "Data/Admins.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                Gym.Admins[counter].setID(Integer.parseInt(row[0]));
                Gym.Admins[counter].setName(row[1]);
                Gym.Admins[counter].setEmail(row[2]);
                Gym.Admins[counter].setPassword(row[3]);
                counter++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
