import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    // *************************************************    Write Functions    *************************************************
    public static void WriteCustomers() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/Customers.csv");
            writer.write("");
            while (counter < Gym.Customers.size()) {
                for (Customer customer : Gym.Customers) {
                    writer.append(String.valueOf(customer.getID())).append(",");
                    writer.append(customer.getName()).append(",");
                    writer.append(customer.getEmail()).append(",");
                    writer.append(customer.getPassword()).append(",");
                    writer.append(customer.getPhone_number()).append(",");
                    writer.append(customer.getGender()).append(",");
                    writer.append(String.valueOf(customer.getSubscription_ID())).append(",");
                    writer.append(String.valueOf(customer.getCoach_ID())).append("\n");

                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteCoaches() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/Coaches.csv");
            writer.write("");
            while (counter < Gym.Coaches.size()) {
                for (Coach coach : Gym.Coaches) {
                    writer.append(String.valueOf(coach.getID())).append(",");
                    writer.append(coach.getName()).append(",");
                    writer.append(coach.getEmail()).append(",");
                    writer.append(coach.getPassword()).append(",");
                    writer.append(coach.getPhone_number()).append(",");
                    writer.append(coach.getGender()).append(",");
                    writer.append(String.valueOf(coach.getWorkingHoursPerDay())).append(",");
                    writer.append(String.valueOf(coach.getNumberOfClients())).append("\n");

                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteSubscriptions() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/Subscriptions.csv");
            writer.write("");
            while (counter < Gym.Subscriptions.size()) {
                for (Subscription subscription : Gym.Subscriptions) {
                    writer.append(String.valueOf(subscription.getSUBSCRIPTION_ID())).append(",");
                    writer.append(String.valueOf(subscription.getCustomerId())).append(",");
                    writer.append(String.valueOf(subscription.getCoach())).append("\n");

                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteMembershipPlan() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/Membership_Plan.csv");
            writer.write("");
            while (counter < Gym.Subscriptions.size()) {
                for (Subscription subscription : Gym.Subscriptions) {
                    writer.append(String.valueOf(subscription.getSUBSCRIPTION_ID())).append(",");
                    writer.append(String.valueOf(subscription.getPlan().getStart_Date())).append(",");
                    writer.append(String.valueOf(subscription.getPlan().getMonthly_plan())).append(",");
                    writer.append(String.valueOf(subscription.getPlan().getRegistred_Months_num())).append(",");
                    writer.append(String.valueOf(subscription.getPlan().getPlan_price())).append("\n");

                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteInbodies() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/Inbodies.csv");
            writer.write("");
            while (counter < Gym.Inbodies.size()) {
                for (InBody inbody : Gym.Inbodies) {
                    writer.append(String.valueOf(inbody.getCustomer_ID())).append(",");
                    writer.append(String.valueOf(inbody.getInBody_date())).append(",");
                    writer.append(String.valueOf(inbody.getHight())).append(",");
                    writer.append(String.valueOf(inbody.getTotal_weight())).append(",");
                    writer.append(String.valueOf(inbody.getFats())).append(",");
                    writer.append(String.valueOf(inbody.getMass())).append(",");
                    writer.append(String.valueOf(inbody.getMinerals())).append(",");
                    writer.append(String.valueOf(inbody.getWater())).append(",");
                    writer.append(String.valueOf(inbody.getProtien())).append(",");
                    writer.append(String.valueOf(inbody.getAge())).append("\n");

                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteEquipments() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/Equipments.csv");
            writer.write("");
            while (counter < Gym.Sports_equipment.size()) {
                for (Equipment equipment : Gym.Sports_equipment) {
                    writer.append(String.valueOf(equipment.getEQUIPMENTCODE())).append(",");
                    writer.append(equipment.getName()).append(",");
                    writer.append(String.valueOf(equipment.getQuantity())).append("\n");

                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteTargetedMuscles() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/TargetedMuscles.csv");
            writer.write("");
            while (counter < Gym.Sports_equipment.size()) {
                for (Equipment equipment : Gym.Sports_equipment) {
                    for (String muscle : equipment.targetedMuscles) {
                        writer.append(String.valueOf(equipment.getEQUIPMENTCODE())).append(",");
                        writer.append(muscle).append("\n");
                    }
                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteCustomerApproval() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/CustomerApproval.csv");
            while (counter < Gym.Customers.size()) {
                for (Customer c : Gym.Customers) {
                    if (!c.isApproved()) {
                        writer.append(String.valueOf(c.getID())).append("\n");
                    }
                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteCoachApproval() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/CoachApproval.csv");
            writer.write("");
            while (counter < Gym.Coaches.size()) {
                for (Coach c : Gym.Coaches) {
                    if (!c.isApproved()) {
                        writer.append(String.valueOf(c.getID())).append("\n");
                    }
                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteCoachClients() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/CoachClients.csv");
            writer.write("");
            while (counter < Gym.Coaches.size()) {
                for (Coach coach : Gym.Coaches) {
                    for (Customer customer : coach.getClients()) {
                        writer.append(String.valueOf(coach.getID())).append(",");
                        writer.append(String.valueOf(customer.getID())).append("\n");
                    }
                    counter++;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // *************************************************    Read Functions    *************************************************
    public static void ReadCustomers() {
        String file = "Data/Customers.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Customers.get(counter).setID(Integer.parseInt(row[0]));
                Gym.Customers.get(counter).setName(row[1]);
                Gym.Customers.get(counter).setEmail(row[2]);
                Gym.Customers.get(counter).setPassword(row[3]);
                Gym.Customers.get(counter).setPhone_number(row[4]);
                Gym.Customers.get(counter).setGender(row[5]);
                Gym.Customers.get(counter).setSubscription_ID(Integer.parseInt(row[6]));
                Gym.Customers.get(counter).setCoach_ID(Integer.parseInt(row[7]));

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
                Gym.Coaches.get(counter).setID(Integer.parseInt(row[0]));
                Gym.Coaches.get(counter).setName(row[1]);
                Gym.Coaches.get(counter).setEmail(row[2]);
                Gym.Coaches.get(counter).setPassword(row[3]);
                Gym.Coaches.get(counter).setPhone_number(row[4]);
                Gym.Coaches.get(counter).setGender(row[5]);
                Gym.Coaches.get(counter).setWorkingHoursPerDay(Integer.parseInt(row[6]));
                Gym.Coaches.get(counter).setNumberOfClients(Integer.parseInt(row[7]));

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

    public static void ReadSubscriptions() {
        String file = "Data/Subscriptions.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Subscriptions.get(counter).setSUBSCRIPTION_ID(Integer.parseInt(row[0]));
                Gym.Subscriptions.get(counter).setCustomerId(Integer.parseInt(row[1]));
                Gym.Subscriptions.get(counter).setCoach(Integer.parseInt(row[2]));

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

    public static void ReadMembershipPlan() {
        String file = "Data/Membership_Plan.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Subscription subscription : Gym.Subscriptions) {
                    if (subscription.getSUBSCRIPTION_ID() == Integer.parseInt(row[0])) {
//                        subscription.getPlan().setStart_Date(row[1]);
                        subscription.getPlan().setMonthly_plan(row[2].charAt(0));
                        subscription.getPlan().setRegistred_Months_num(Integer.parseInt(row[3]));
                        subscription.getPlan().setPlan_price(Integer.parseInt(row[4]));
                    }
                }
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

    public static void ReadInbodies() {
        String file = "Data/Inbodies.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Inbodies.get(counter).setCustomer_ID(Integer.parseInt(row[0]));
//                    Gym.Inbodies.get(counter).setInBody_date(row[1]);
                Gym.Inbodies.get(counter).setHight(Float.parseFloat(row[2]));
                Gym.Inbodies.get(counter).setTotal_wight(Float.parseFloat(row[3]));
                Gym.Inbodies.get(counter).setFats(Float.parseFloat(row[4]));
                Gym.Inbodies.get(counter).setMass(Float.parseFloat(row[5]));
                Gym.Inbodies.get(counter).setMinerals(Float.parseFloat(row[6]));
                Gym.Inbodies.get(counter).setWater(Float.parseFloat(row[7]));
                Gym.Inbodies.get(counter).setProtien(Float.parseFloat(row[8]));
                Gym.Inbodies.get(counter).setAge(Integer.parseInt(row[9]));

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

    public static void ReadEquipments() {
        String file = "Data/Equipments.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Sports_equipment.get(counter).setEQUIPMENTCODE(Integer.parseInt(row[0]));
                Gym.Sports_equipment.get(counter).setName(row[1]);
                Gym.Sports_equipment.get(counter).setQuantity(Integer.parseInt(row[2]));
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

    public static void ReadTargetedMuscles() {
        String file = "Data/TargetedMuscles.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Equipment equipment : Gym.Sports_equipment) {
                    if (Gym.Sports_equipment.get(counter).getEQUIPMENTCODE() == Integer.parseInt(row[0])) {
                        equipment.targetedMuscles.add(row[1]);
                    }
                    break;
                }
                counter++;
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void ReadCustomerApproval() {
        String file = "Data/CustomerApproval.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Customer c : Gym.Customers) {
                    if (c.getID() == Integer.parseInt(row[0])) {
                        c.setApproved(false);
                        break;
                    }
                }
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

    public static void ReadCoachApproval() {
        String file = "Data/CoachApproval.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Coach c : Gym.Coaches) {
                    if (c.getID() == Integer.parseInt(row[0])) {
                        c.setApproved(false);
                        break;
                    }
                }
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

    public static void ReadCoachClients() {
        String file = "Data/CoachClients.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Coach coach : Gym.Coaches) {
                    if (coach.getID() == Integer.parseInt(row[0])) {
                        coach.getClients()[coach.getNumberOfClients()] = Gym.SearchCustomerByID(Integer.parseInt(row[0]));
                        coach.setNumberOfClients(coach.getNumberOfClients() + 1);
                        break;
                    }
                }
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
