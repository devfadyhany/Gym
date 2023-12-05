public class Equipment {
    private String name;
    public String[] targetedMuscles;
    private int quantity ;

    private int EQUIPMENTCODE;
    public static int numberOfEquipments = 0;
    //private String photo;

    public Equipment (String name,int quantity,int equipmentCode,String[] targetedMuscle)
    {
        this.name=name;
        this.quantity=quantity;
        this.EQUIPMENTCODE =equipmentCode;
        this.targetedMuscles =targetedMuscle;
        numberOfEquipments++;
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

    public void setTargetedMuscles(String[] targetedMuscles) {
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
}
