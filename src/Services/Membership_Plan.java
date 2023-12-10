package Services;

import java.time.LocalDate;

public class Membership_Plan {
    private LocalDate Start_Date;
    private char Monthly_plan;
    private int Registred_Months_num;
    private float Plan_price;
    public Membership_Plan(LocalDate l, char c,int i,float f){
        this.Start_Date= l;
        this.Monthly_plan=c;
        this.Registred_Months_num=i;
        this.Plan_price=f;

    }

    public void setStart_Date(LocalDate start_Date) {
        Start_Date = start_Date;
    }

    public LocalDate getStart_Date() {
        return Start_Date;
    }

    public void setMonthly_plan(char monthly_plan) {
        if(monthly_plan=='a' || monthly_plan =='b'|| monthly_plan=='A'||monthly_plan=='B')
            Monthly_plan = monthly_plan;
        else
            System.out.println("plan is not recognizable, choose between plan A or Plan b");
    }

    public char getMonthly_plan() {
        return Monthly_plan;
    }

    public void setRegistred_Months_num(int registred_Months_num) {
        Registred_Months_num = registred_Months_num;
    }

    public int getRegistred_Months_num() {
        return Registred_Months_num;
    }

    public void setPlan_price(float plan_price) {
        Plan_price = plan_price;
    }

    public float getPlan_price() {
        return Plan_price;
    }
    public float CalcDiscount() {
        if (this.Monthly_plan == 'a' || this.Monthly_plan == 'A') {
            if (this.Registred_Months_num >= 3) {
                switch (Registred_Months_num) {
                    case 3:
                        this.Plan_price -= this.Plan_price *= 0.2F;
                    case 6:
                        this.Plan_price -= this.Plan_price *= 0.3F;
                    case 12:
                        this.Plan_price -= this.Plan_price *= 0.4F;
                    default:
                        System.out.println("No discount will be applied ");
                }


            }
        } else if (this.Monthly_plan=='b'|| this.Monthly_plan=='B')
        {
            switch (Registred_Months_num) {
                case 3:
                    this.Plan_price -= this.Plan_price *= 0.3F;
                case 6:
                    this.Plan_price -= this.Plan_price *= 0.4F;
                case 12:
                    this.Plan_price -= this.Plan_price *= 0.5F;
                default:
                    this.Plan_price+=this.Plan_price*=0.15F;
            }


        }
        return this.Plan_price;
    }

    public void DisplayInfo(){
        System.out.println("Start_Date: " + Start_Date);
        System.out.println("Monthly_Plan: " + getMonthly_plan());
        System.out.println("Number of Months Registered: " + getRegistred_Months_num());
        System.out.println("Plan_Price: " + getPlan_price());
    }

}

