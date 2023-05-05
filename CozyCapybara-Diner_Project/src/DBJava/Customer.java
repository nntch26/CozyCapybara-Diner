package DBJava;

public class Customer {
    private int Id;
    private String Name;
    private String Telcus;
    private String Email;
    private int Point;

    public Customer(int Id, String Name, String Telcus, String Email, int Point) {
        this.Id = Id;
        this.Name = Name;
        this.Telcus = Telcus;
        this.Email = Email;
        this.Point = Point;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTelcus() {
        return Telcus;
    }

    public void setTelcus(String Telcus) {
        this.Telcus = Telcus;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }
    
    
}
