import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
    public static void WriteCustomers() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Customers.csv");
            while (counter <= Customer.customersCount) {
                writer.append(Gym.Customers[counter - 1].getID() + ",");
                writer.append(Gym.Customers[counter - 1].getName() + ",");
                writer.append(Gym.Customers[counter - 1].getEmail() + ",");
                writer.append(Gym.Customers[counter - 1].getPassword() + ",");
                writer.append(Gym.Customers[counter - 1].getPhone_number() + ",");
                writer.append(Gym.Customers[counter - 1].getGender() + ",");
                writer.append(Gym.Customers[counter - 1].getSubscription().getSUBSCRIPTION_ID() + ",");
                writer.append(Gym.Customers[counter - 1].getCoach().getID() + "\n");
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteCoaches() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Coaches.csv");
            while (counter <= Customer.customersCount) {
                writer.append(Gym.Coaches[counter - 1].getID() + ",");
                writer.append(Gym.Coaches[counter - 1].getName() + ",");
                writer.append(Gym.Coaches[counter - 1].getEmail() + ",");
                writer.append(Gym.Coaches[counter - 1].getPassword() + ",");
                writer.append(Gym.Coaches[counter - 1].getPhone_number() + ",");
                writer.append(Gym.Coaches[counter - 1].getGender() + ",");
                writer.append(Gym.Coaches[counter - 1].getWorkingHoursPerDay() + ",");
                writer.append(Gym.Coaches[counter - 1].getNumberOfClients() + "\n");
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadCustomers() {
        String file = "Data/Customers.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ReadCoaches() {
        String file = "Data/Coaches.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteSubscriptions() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Subscriptions.csv");
            while (counter <= Subscription.numberOfSubscriptions) {
                writer.append(Gym.Subscriptions[counter - 1].getSUBSCRIPTION_ID() + ",");
                writer.append(Gym.Subscriptions[counter - 1].getCustomerId() + ",");
                writer.append(Gym.Subscriptions[counter - 1].getCoach() + "\n");
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadSubscriptions() {
        String file = "Data/Subscriptions.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Subscriptions[counter].setSUBSCRIPTION_ID(Integer.parseInt(row[0]));
                Gym.Subscriptions[counter].setCustomerId(Integer.parseInt(row[1]));
                Gym.Subscriptions[counter].setCoach(Integer.parseInt(row[2]));
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteMembershipPlan() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Membership_Plan.csv");
            while (counter <= Subscription.numberOfSubscriptions) {
                writer.append(Gym.Subscriptions[counter - 1].getSUBSCRIPTION_ID() + ",");
                writer.append(Gym.Subscriptions[counter - 1].getPlan().getStart_Date() + ",");
                writer.append(Gym.Subscriptions[counter - 1].getPlan().getMonthly_plan() + ",");
                writer.append(Gym.Subscriptions[counter - 1].getPlan().getRegistred_Months_num() + ",");
                writer.append(Gym.Subscriptions[counter - 1].getPlan().getPlan_price() + "\n");
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadMembershipPlan() {
        String file = "Data/Membership_Plan.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < Subscription.numberOfSubscriptions; i++) {
                    if (Gym.Subscriptions[counter].getSUBSCRIPTION_ID() == Integer.parseInt(row[0])) {
                        Gym.Subscriptions[counter].getPlan().setStart_Date(row[1]);
                        Gym.Subscriptions[counter].getPlan().setMonthly_plan(row[2].charAt(0));
                        Gym.Subscriptions[counter].getPlan().setRegistred_Months_num(Integer.parseInt(row[3]));
                        Gym.Subscriptions[counter].getPlan().setPlan_price(Integer.parseInt(row[4]));
                    }
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteInbodies() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Inbodies.csv");
            while (counter <= InBody.numberOfInbodies) {
                writer.append(Gym.Inbodies[counter - 1].getCustomer_ID() + ",");
                writer.append(Gym.Inbodies[counter - 1].getInBody_date() + ",");
                writer.append(Gym.Inbodies[counter - 1].getHight() + ",");
                writer.append(Gym.Inbodies[counter - 1].getTotal_weight() + ",");
                writer.append(Gym.Inbodies[counter - 1].getFats() + ",");
                writer.append(Gym.Inbodies[counter - 1].getMass() + ",");
                writer.append(Gym.Inbodies[counter - 1].getMinerals() + ",");
                writer.append(Gym.Inbodies[counter - 1].getWater() + ",");
                writer.append(Gym.Inbodies[counter - 1].getProtien() + ",");
                writer.append(Gym.Inbodies[counter - 1].getAge() + "\n");
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadInbodies() {
        String file = "Data/Inbodies.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Inbodies[counter].setCustomer_ID(Integer.parseInt(row[0]));
                Gym.Inbodies[counter].setInBody_date(row[1]);
                Gym.Inbodies[counter].setHight(Float.parseFloat(row[2]));
                Gym.Inbodies[counter].setTotal_wight(Float.parseFloat(row[3]));
                Gym.Inbodies[counter].setFats(Float.parseFloat(row[4]));
                Gym.Inbodies[counter].setMass(Float.parseFloat(row[5]));
                Gym.Inbodies[counter].setMinerals(Float.parseFloat(row[6]));
                Gym.Inbodies[counter].setWater(Float.parseFloat(row[7]));
                Gym.Inbodies[counter].setProtien(Float.parseFloat(row[8]));
                Gym.Inbodies[counter].setAge(Integer.parseInt(row[9]));
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteEquipments() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/Equipments.csv");
            while (counter <= Equipment.numberOfEquipments) {
                writer.append(Gym.Sports_equipment[counter - 1].getEQUIPMENTCODE() + ",");
                writer.append(Gym.Sports_equipment[counter - 1].getName() + ",");
                writer.append(Gym.Sports_equipment[counter - 1].getQuantity() + "\n");
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadEquipments() {
        String file = "Data/Equipments.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Sports_equipment[counter].setEQUIPMENTCODE(Integer.parseInt(row[0]));
                Gym.Sports_equipment[counter].setName(row[1]);
                Gym.Sports_equipment[counter].setQuantity(Integer.parseInt(row[2]));
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteTargetedMuscles() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/TargetedMuscles.csv");
            while (counter <= Equipment.numberOfEquipments) {
                for (String muscle : Gym.Sports_equipment[counter - 1].targetedMuscles) {
                    writer.append(Gym.Sports_equipment[counter - 1].getEQUIPMENTCODE() + ",");
                    writer.append(muscle + "\n");
                }
                counter++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    Logic Needs Fix
    public static void ReadTargetedMuscles() {
        String file = "Data/TargetedMuscles.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < Equipment.numberOfEquipments; i++) {
                    if (Integer.parseInt(row[0]) == Gym.Sports_equipment[i].getEQUIPMENTCODE()) {
                        Gym.Sports_equipment[i].targetedMuscles[i] = (row[1]);
                    }
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteCustomerApproval() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/CustomerApproval.csv");
            while (counter <= Customer.customersCount) {
                for (Customer c : Gym.Customers) {
                    if (!c.isApproved()) {
                        writer.append(c.getID() + "\n");
                        counter++;
                    }
                }


            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadCustomerApproval() {
        String file = "Data/CustomerApproval.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Customer c : Gym.Customers) {
                    if (Integer.parseInt(row[0]) == c.getID()) {
                        c.setApproved(false);
                    }
                }
                counter++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteCoachApproval() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/CoachApproval.csv");
            while (counter <= Coach.coachCount) {
                for (Coach c : Gym.Coaches) {
                    if (!c.isApproved()) {
                        writer.append(c.getID() + "\n");
                        counter++;
                    }
                }


            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadCoachApproval() {
        String file = "Data/CoachApproval.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Coach c : Gym.Coaches) {
                    if (Integer.parseInt(row[0]) == c.getID()) {
                        c.setApproved(false);
                    }
                }
                counter++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteCoachClients() {
        try {
            int counter = 1;
            FileWriter writer = new FileWriter("Data/CoachClients.csv");
            while (counter <= Coach.coachCount) {
                for (Customer c : Gym.Coaches[counter-1].getClients()) {
                    writer.append(Gym.Coaches[counter-1].getID() + ",");
                    writer.append(c.getID() + "\n");
                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadCoachClients() {
        String file = "Data/CoachClients.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Customer c : Gym.Coaches[counter].getClients()) {
                    if (c.getID() == Integer.parseInt(row[1])) {
                        Gym.Coaches[counter].addClient(c);
                    }
                }
                counter++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
