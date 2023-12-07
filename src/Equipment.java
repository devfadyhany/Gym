import java.util.ArrayList;

public class Equipment {
    private String name;
    public ArrayList<String> targetedMuscles = new ArrayList<>();
    private int quantity ;

    private int EQUIPMENTCODE;
    //private String photo;

    public Equipment (String name,int quantity,int equipmentCode,ArrayList<String> targetedMuscle)
    {
        this.name=name;
        this.quantity=quantity;
        this.EQUIPMENTCODE =equipmentCode;
        this.targetedMuscles =targetedMuscle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getEQUIPMENTCODE() {
        return EQUIPMENTCODE;
    }

    public void setEQUIPMENTCODE(int EQUIPMENTCODE) {
        this.EQUIPMENTCODE = EQUIPMENTCODE;
    }

   /* public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }*/
    public void setTargetedMuscles(ArrayList<String> targetedMuscles) {
        this.targetedMuscles = targetedMuscles;
    }

    public void DisplayInfo()
    {
        System.out.println(this.getName());
        System.out.println(this.getEQUIPMENTCODE());
        System.out.println(this.getQuantity());
    }
    
    public void DisplayTargetedMuscles()
    {
        for (String s: targetedMuscles)
        {
            System.out.println(s);
        }
    }
    public void replaceTargetedMuscles(int index,String muscle) {

        targetedMuscles.remove(index);
        targetedMuscles.add(muscle);


    }
}
