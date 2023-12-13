package Services;

import java.util.ArrayList;

public class Equipment {
    private final int EQUIPMENTCODE;
    public String name;
    public ArrayList<String> targetedMuscles;
    protected int quantity;

    public Equipment(String name, int quantity, int equipmentCode, ArrayList<String> targetedMuscle) {
        this.EQUIPMENTCODE = equipmentCode;
        this.name = name;
        this.targetedMuscles = targetedMuscle;
        this.quantity = quantity;
    }

    public int getEQUIPMENTCODE() {
        return EQUIPMENTCODE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void DisplayInfo() {
        System.out.print(getEQUIPMENTCODE() + "\t|\t" + getName() + "\t|\t" + getQuantity() + "\t|\t");
        DisplayTargetedMuscles();
        System.out.print("\n");
    }

    public void DisplayTargetedMuscles() {
        for (String s : targetedMuscles) {
            System.out.print(s + ",");
        }
    }
}
