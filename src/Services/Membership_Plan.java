package Services;

import java.time.LocalDate;

public class Membership_Plan {
    protected LocalDate Start_Date;
    public char Monthly_plan;
    protected int Registered_Months_Num;
    private float Plan_price;

    public Membership_Plan(LocalDate start_Date, char monthly_plan, int registered_Months_Num, float price) {
        this.Start_Date = start_Date;
        this.Monthly_plan = monthly_plan;
        this.Registered_Months_Num = registered_Months_Num;
        this.Plan_price = price;
    }

    public LocalDate getStart_Date() {
        return Start_Date;
    }

    public char getMonthly_plan() {
        return Monthly_plan;
    }

    public void setMonthly_plan(char monthly_plan) {
        if (monthly_plan == 'a' || monthly_plan == 'b' || monthly_plan == 'A' || monthly_plan == 'B')
            Monthly_plan = monthly_plan;
        else
            System.out.println("plan is not recognizable, choose between plan A or Plan b");
    }

    public int getRegistered_Months_num() {
        return Registered_Months_Num;
    }

    public void setRegistered_Months_num(int registered_Months_num) {
        Registered_Months_Num = registered_Months_num;
    }

    public float getPlan_price() {
        return Plan_price;
    }

    public void setPlan_price(float plan_price) {
        Plan_price = plan_price;
    }

    public float CalcDiscount(int months) {
        if (this.Monthly_plan == 'a' || this.Monthly_plan == 'A') {
            if (months >= 3) {
                switch (months) {
                    case 3:
                        this.Plan_price -= this.Plan_price * 0.2F;
                        break;
                    case 6:
                        this.Plan_price -= this.Plan_price * 0.3F;
                        break;
                    case 12:
                        this.Plan_price -= this.Plan_price * 0.4F;
                        break;
                    default:
                        System.out.println("No discount will be applied.");
                        break;
                }
            }
        } else if (this.Monthly_plan == 'b' || this.Monthly_plan == 'B') {
            switch (Registered_Months_Num) {
                case 3:
                    this.Plan_price -= this.Plan_price * 0.3F;
                    break;
                case 6:
                    this.Plan_price -= this.Plan_price * 0.4F;
                    break;
                case 12:
                    this.Plan_price -= this.Plan_price * 0.5F;
                    break;
                default:
                    System.out.println("No discount will be applied.");
                    break;
            }
        }
        return this.Plan_price;
    }

    public void DisplayInfo() {
        System.out.print(getStart_Date() + "\t|\t" + getMonthly_plan() + "\t|\t" + getRegistered_Months_num() + "\t|\t" + getPlan_price());
    }

}

