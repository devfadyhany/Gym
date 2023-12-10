package Users;

public class Person {
    private int ID;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private char gender;
    private boolean isApproved = true;

    public Person(int ID ,String name , String email, String password, String phone_number, char gender ){
        this.ID=ID;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone_number=phone_number;
        this.gender=gender;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public char getGender() {
        return gender;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender.charAt(0);
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
