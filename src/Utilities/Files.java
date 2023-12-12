package Utilities;

import Master.Gym;
import Services.Equipment;
import Services.InBody;
import Services.Membership_Plan;
import Services.Subscription;
import Users.Coach;
import Users.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Files {

    public void WriteFiles() {
        WriteCustomers();
        WriteCoaches();
        WriteSubscriptions();
        WriteMembershipPlan();
        WriteInBodies();
        WriteTargetedMuscles();
        WriteEquipments();
        WriteCustomerApproval();
        WriteCoachApproval();
    }

    public void ReadFiles() {
        ReadCustomers();
        ReadCoaches();
        ReadSubscriptions();
        ReadMembershipPlan();
        ReadInBodies();
        ReadTargetedMuscles();
        ReadEquipments();
        ReadCustomerApproval();
        ReadCoachApproval();
    }

    // *************************************************    Write Functions    *************************************************
    public void WriteCustomers() {
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
            System.out.println("Failed to Write in Customers File.");
        }
    }

    public void WriteCoaches() {
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
            System.out.println("Failed to Write in Coaches File.");
        }
    }

    public void WriteSubscriptions() {
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
            System.out.println("Failed to Write in Subscriptions File.");
        }
    }

    public void WriteMembershipPlan() {
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
            System.out.println("Failed to Write in Services.Membership_Plan File.");
        }
    }

    public void WriteInBodies() {
        try {
            int counter = 0;
            FileWriter writer = new FileWriter("Data/InBodies.csv");
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
            System.out.println("Failed to Write in InBodies File.");
        }
    }

    public void WriteEquipments() {
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
            System.out.println("Failed to Write in Equipments File.");
        }
    }

    public void WriteTargetedMuscles() {
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
            System.out.println("Failed to Write in TargetedMuscles File.");
        }
    }

    public void WriteCustomerApproval() {
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
            System.out.println("Failed to Write in CustomerApproval File.");
        }
    }

    public void WriteCoachApproval() {
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
            System.out.println("Failed to Write in CoachApproval File.");
        }
    }

    // *************************************************    Read Functions    *************************************************
    public void ReadCustomers() {
        String file = "Data/Customers.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                Gym.Customers.add(new Customer(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], row[5].charAt(0)));

                Gym.Customers.get(counter).setSubscription_ID(Integer.parseInt(row[6]));
                Gym.Customers.get(counter).setCoach_ID(Integer.parseInt(row[7]));

                counter++;
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From Customers File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Customers File is already Closed.");
            }
        }
    }

    public void ReadCoaches() {
        String file = "Data/Coaches.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Coaches.add(new Coach(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], row[5].charAt(0)));

                Gym.Coaches.get(counter).setWorkingHoursPerDay(Integer.parseInt(row[6]));
                Gym.Coaches.get(counter).setNumberOfClients(Integer.parseInt(row[7]));

                counter++;
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From Coaches File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Coaches File is already Closed.");
            }
        }
    }

    public void ReadSubscriptions() {
        String file = "Data/Subscriptions.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Subscriptions.add(new Subscription(Integer.parseInt(row[0]), Integer.parseInt(row[1]), Integer.parseInt(row[2]), null));

                counter++;
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From Subscriptions File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Subscriptions File is already Closed.");
            }
        }
    }

    public void ReadMembershipPlan() {
        String file = "Data/Membership_Plan.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (Subscription subscription : Gym.Subscriptions) {
                    if (subscription.getSUBSCRIPTION_ID() == Integer.parseInt(row[0])) {
                        LocalDate l = LocalDate.parse(row[1]);
                        subscription.setPlan(new Membership_Plan(l, row[2].charAt(0), Integer.parseInt(row[3]), Float.parseFloat(row[4])));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From Services.Membership_Plan File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Services.Membership_Plan File is already Closed.");
            }
        }
    }

    public void ReadInBodies() {
        String file = "Data/InBodies.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                LocalDate l = LocalDate.parse(row[1]);
                Gym.Inbodies.add(new InBody(Integer.parseInt(row[0]), l, Float.parseFloat(row[2]), Float.parseFloat(row[3]), Float.parseFloat(row[4]), Float.parseFloat(row[5]), Float.parseFloat(row[6]), Float.parseFloat(row[7]), Float.parseFloat(row[8]), Integer.parseInt(row[9])));

                counter++;
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From InBodies File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("InBodies File is already Closed.");
            }
        }
    }

    public void ReadEquipments() {
        String file = "Data/Equipments.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            int counter = 0;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Gym.Sports_equipment.add(new Equipment(row[1], Integer.parseInt(row[2]), Integer.parseInt(row[0]), null));

                counter++;
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From Equipments File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Equipments File is already Closed.");
            }
        }
    }

    public void ReadTargetedMuscles() {
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
        } catch (IOException e) {
            System.out.println("Failed to Read From TargetedMuscles File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("TargetedMuscles File is already Closed.");
            }
        }

    }

    public void ReadCustomerApproval() {
        String file = "Data/CustomerApproval.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                for (Customer c : Gym.Customers) {
                    c.setApproved(!(String.valueOf(c.getID()).equals(line)));
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From CustomerApproval File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("CustomerApproval File is already Closed.");
            }
        }
    }

    public void ReadCoachApproval() {
        String file = "Data/CoachApproval.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                for (Coach c : Gym.Coaches) {
                    c.setApproved(!(String.valueOf(c.getID()).equals(line)));
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to Read From CoachApproval File.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("CoachApproval File is already Closed.");
            }
        }
    }
}
