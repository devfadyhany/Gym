import java.util.Scanner;

public class InBody {

    protected Date InBody_date;
    protected float hight;
    protected float Total_Weight;
    protected float Fats;
    protected float mass;
    protected float minerals;
    protected float water;
    protected float protien;
    private float Bmi;
    public int age;
   // public float activity_factor;

    public InBody(Date InBody_date, float hight, float Total_Weight, float Fats, float mass, float minerals, float water, float protien/*float Bmi*/, int age/*, float activity_factor*/) {
        this.InBody_date = InBody_date;
        this.hight = hight;
        this.Total_Weight = Total_Weight;
        this.Fats = Fats;
        this.mass = mass;
        this.minerals = minerals;
        this.water = water;
        this.protien = protien;
        // this.Bmi=Bmi;
        this.age = age;
       // this.activity_factor = activity_factor;
    }

    public void setInBody_date(Date inBody_date) {
        InBody_date = inBody_date;
    }

    public Date getInBody_date() {
        return InBody_date;
    }


    public void setHight(float h) {
        hight = h;
    }

    public float getHight() {
        return hight;
    }


    public void setTotal_wight(float w) {
        Total_Weight = w;
    }

    public float getTotal_weight() {
        return Total_Weight;
    }

    public void setFats(float f) {
        Fats = f;
    }

    public float getFats() {
        return Fats;
    }

    public void setMass(float m) {
        mass = m;
    }

    public float getMass() {
        return mass;
    }

    public void setMinerals(float x) {
        minerals = x;
    }

    public float getMinerals() {
        return minerals;
    }

    public void setWater(float w) {
        water = w;
    }

    public float getWater() {
        return water;
    }

    public void setProtien(float p) {
        protien = p;
    }

    public float getProtien() {
        return protien;
    }

    /*public void setBmi(float B) {
        Bmi=B;
    }
*/
   /* public float getBmi() {
        return Bmi;
    }*/
    public int getage() {
        return age;
    }

    public float CalcBmi() {
        return (getTotal_weight()) / (getHight() * getHight());
    }

    public float CalcIdealWeight() {
        return (float) ((2.2 * this.CalcBmi()) + (3.5 * this.CalcBmi()) * (this.getHight() - 1.5));

    }

    public float Calc_bmr_male() {
        return (float) ((10 * getTotal_weight()) + (6.25 * (getHight() * 100)) - (5 * getage()) + 5);

    }

    public float Calc_bmr_fmale() {
        return (float) ((10 * getTotal_weight()) + (6.25 * (getHight() * 100)) - (5 * getage()) - 16);

    }

    public float calcBMI(int choose) {

        while (true) {
            System.out.println("press 1->no excercise\npress 2->light excerise\npress 3->moderate excercise\npress 4->heavy excercise\npress 5->very heavy excercise\n");

            switch (choose) {
                case 1:
                    return (float) (1.2 * Calc_bmr_male());

                case 2:
                    return (float) (1.375 * Calc_bmr_male());

                case 3:
                    return (float) (1.55 * Calc_bmr_male());

                case 4:
                    return (float) (1.725 * Calc_bmr_male());

                case 5:
                    return (float) (1.725 * Calc_bmr_male());

                default:
                    System.out.println("unavalible choise");
            }
        }
    }

    public void displayInBody(){
        System.out.println("Height:"+getHight());
        System.out.println("Total Weight"+getTotal_weight());
        System.out.println("Mass:"+getMass());
        System.out.println("Water:"+getWater());
        System.out.println("Fats:"+getFats());
        System.out.println("Minerals:"+getMinerals());
        System.out.println("Protein:"+getProtien());
    }
}