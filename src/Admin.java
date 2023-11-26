public class Admin {
    private final int ID;
    private String Name;
    private String Email;
    private String Password;
    Admin(int i,String n,String e,String p){
        this.ID=i;
        this.Name=n;
        this.Email=e;
        this.Password=p;
    }

    public int getID() {
        return ID;
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
}
