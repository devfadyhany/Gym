public class Admin {
    private int ID;
    private String Name;
    private String Email;
    private String Password;
    public static int adminsCount = 0;

    Admin(int i,String n,String e,String p){
        this.ID=i;
        this.Name=n;
        this.Email=e;
        this.Password=p;
        adminsCount++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void DisplayInfo(){
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Password: " + this.getPassword());
    }
}
