package Services;

import java.time.LocalDate;

public class InBody {

    private final int CUSTOMER_ID;
    protected LocalDate InBody_date;
    protected float height;
    protected float Total_Weight;
    protected float fats;
    protected float mass;
    protected float minerals;
    protected float water;
    protected float protein;
    private float Bmi;
    public int age;
     public int activity_factor;

    public InBody(int customer_ID, LocalDate start_date, float height, float Total_Weight, float fats, float mass, float minerals, float water, float protein , float Bmi, int age, int activity_factor) {
        this.CUSTOMER_ID = customer_ID;
        this.InBody_date = start_date;
        this.height = height;
        this.Total_Weight = Total_Weight;
        this.fats = fats;
        this.mass = mass;
        this.minerals = minerals;
        this.water = water;
        this.protein = protein;
         this.Bmi=Bmi;
        this.age = age;
         this.activity_factor = activity_factor;
    }

    public int getCustomer_ID() {
        return CUSTOMER_ID;
    }

    public LocalDate getInBody_date() {
        return InBody_date;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float h) {
        height = h;
    }

    public float getTotal_weight() {
        return Total_Weight;
    }

    public void setTotal_wight(float w) {
        Total_Weight = w;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float f) {
        fats = f;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float m) {
        mass = m;
    }

    public float getMinerals() {
        return minerals;
    }

    public void setMinerals(float x) {
        minerals = x;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float w) {
        water = w;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float p) {
        protein = p;
    }

    public void setBmi(float B) {
        Bmi=B;
    }

    public float getBmi() {
        return Bmi;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float CalcBmi() {
        return (getTotal_weight()) / (getHeight() * getHeight());
    }

    public float CalcIdealWeight() {
        return (float) ((2.2 * this.CalcBmi()) + (3.5 * this.CalcBmi()) * (this.getHeight() - 1.5));
    }

    public float Calc_bmr_male() {
        return (float) ((10 * getTotal_weight()) + (6.25 * (getHeight() * 100)) - (5 * getAge()) + 5);

    }

    public float Calc_bmr_female() {
        return (float) ((10 * getTotal_weight()) + (6.25 * (getHeight() * 100)) - (5 * getAge()) - 16);

    }

    public float CalcCalories(int choose, char gender) {

        if (gender == 'm' || gender == 'M'){
            switch (choose) {
                case 1:
                    return (1.2f * Calc_bmr_male());
                case 2:
                    return (1.375f * Calc_bmr_male());
                case 3:
                    return (1.55f * Calc_bmr_male());
                case 4:
                case 5:
                    return (1.725f * Calc_bmr_male());
                default:
                    System.out.println("UNAVAILABLE CHOICE.");
                    break;
            }
        }else if (gender == 'f' || gender == 'F'){
            switch (choose) {
                case 1:
                    return (1.2f * Calc_bmr_female());
                case 2:
                    return (1.375f * Calc_bmr_female());
                case 3:
                    return (1.55f * Calc_bmr_female());
                case 4:
                case 5:
                    return (1.725f * Calc_bmr_female());
                default:
                    System.out.println("UNAVAILABLE CHOICE.");
                    break;
            }
        }
        return 0.0f;
    }

    public void displayInBody() {
        System.out.println(getInBody_date() + "\t|\t" + getHeight() + "\t|\t" + getTotal_weight() + "\t|\t" + getMass() + "\t|\t" + getWater() + "\t|\t" + getFats() + "\t|\t" + getMinerals() + "\t|\t" + getProtein() + "\t|\t" + getBmi() + "\t|\t" + getAge());
    }
}