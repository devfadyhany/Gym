public class Equipment {
    private String name;
    private String[] targetedMuscles;
    private int quantity ;
    private final int equipmentCode;

    //private String photo;

    public Equipment (String name,int quantity,int equipmentCode,String[] targetedMuscle)
    {
        this.name=name;
        this.quantity=quantity;
        this.equipmentCode =equipmentCode;
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
    public int getEquipmentCode() {
        return equipmentCode;
    }

   /* public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }*/

    public void setTargetedMuscles(String[] targetedMuscles) {
        this.targetedMuscles = targetedMuscles;
    }

    public void DisplayInfo()
    {
        System.out.println(getName());
        System.out.println(getEquipmentCode());
        System.out.println(getQuantity());
    }
    
    public void DisplayTargetedMuscles()
    {
        for (String s: targetedMuscles)
        {
            System.out.println(s);
        }
    }
}
