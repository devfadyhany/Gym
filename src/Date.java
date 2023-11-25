public class Date {
    protected int day;
    protected int month;
    protected int year;

    public Date(int day,int month,int year) {
        this.day = day;
        this.month=month;
        this.year=year;
    }

    public void getDate() {
        System.out.println(this.day + "/" + this.month + "/" + this.year);
    }
}
