/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Member extends Customer implements GetInfocustomer{
    private static final double RATE = 0.03;
    
    public Member(int Id, String Name, String Telcus, String Email, double Point) {
        super(Id, Name, Telcus, Email, Point);
    }
  
   
    @Override
    public void culculatePoint(double a) {
        this.setPoint((this.getPoint() + a*RATE));
    }
    
    
    @Override
    public String getInfocustomer(){
        return ""+this.getName()+""+this.getPoint();
    }

    @Override
    protected double culculatetotal(double a) {
        return a-a*RATE;
    }
    

    
    
}
