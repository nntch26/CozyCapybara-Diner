public class Guest extends Customer implements GetInfocustomer{

    public Guest(int Id, String Name, String Telcus, String Email, double Point) {
        super(Id, Name, Telcus, Email, Point);
    }
    public Guest(String Name) {
        super(0, Name, "", "", 0);
    }



    @Override
    protected void culculatePoint(double a) {
        this.setPoint(0);
    }

    @Override
    protected double culculatetotal(double a) {
        return 0;
    }

    @Override
    public String getInfocustomer() {
        return "Guest  "+this.getName();
    }
}
