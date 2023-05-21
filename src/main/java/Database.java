



import java.sql.*;

import java.util.ArrayList;
import java.util.Iterator;


public class Database {
    String url = "jdbc:mysql://localhost:3306/projectreal"; // URL ของฐานข้อมูล
    String user = "root"; // ชื่อผู้ใช้
    String password = "1234"; // รหัสผ่าน
        private ArrayList<Table> table;
        private ArrayList<Menu> menu;
        private ArrayList<Member> member;
       private ArrayList tableView = new ArrayList();
       
       
//        private static ArrayList<Table> Bill = new ArrayList<Bill>();

    
    public Connection getConnection(){
        Connection connect = null;
        //PreparedStatement pre = null;
        try {
            
            connect = DriverManager.getConnection(url,user,password);
     
        } catch (SQLException e) {
        e.printStackTrace();
        }
       return connect;
   }
   public boolean loadTable(){
       table = new ArrayList<Table>();
       try(Connection connect = getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tablenumber");
            ){
           
           
           while(rs.next()){
            int id = rs.getInt("idTable");
            int cap= rs.getInt("Cap");
            String name = rs.getString("NameCus");
            String tel = rs.getString("TelCus");
            String time = rs.getString("DTime");
            String stus = rs.getString("Status");
            
            Table t = new Table(id, cap, name, tel, stus, time);
            table.add(t);
//               System.out.println(table.size());
//               System.out.println(table.get(0).getId());
         
           }
//         return true  System.out.println(table.iterator());
          return true;  
       }catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
     
   }
    public void autoCreatTabel(){
        PreparedStatement pre = null;
        try(Connection connect = getConnection();


        ){pre = connect.prepareStatement("insert into tablenumber (Cap,Status, Namecus, TelCus, Dtime) values (?, ?, ?, ?, ?)");
            pre.setString(1, "4");
            pre.setString(2, "free");
            pre.setString(3, "");
            pre.setString(4, "");
            pre.setString(5, "");
            pre.executeUpdate();



        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
   public void reserveTable(String id,String namecus, String phonecus, String time){
       PreparedStatement pre = null;
       try(Connection connect = getConnection();
            

            ){pre = connect.prepareStatement("update tablenumber set NameCus = ?, TelCus = ?, DTime = ?, Status = ? where idTable = ?");
              pre.setString(1, namecus);
              pre.setString(2, phonecus);
              pre.setString(3, time);
              pre.setString(4, "booked");
              pre.setString(5, id);
              
              pre.executeUpdate();
           
           

       }catch (SQLException e) {
        e.printStackTrace();
        }
       
   }

    public void editTable(Table_PopUp tablePopUp){
        String id = tablePopUp.getTake_idTable().getText();
        String namecus = tablePopUp.getTfName().getText();
        String time = tablePopUp.getTfTime().getText();
        String status = ""+tablePopUp.getSelectStatus().getSelectedItem();
        String phonecus = tablePopUp.getTfPhoneNumber().getText();

        PreparedStatement pre = null;
        try(Connection connect = getConnection();


        ){pre = connect.prepareStatement("update tablenumber set NameCus = ?, TelCus = ?, DTime = ?, Status = ? where idTable = ?");
            pre.setString(1, namecus);
            pre.setString(2, phonecus);
            pre.setString(3, time);
            pre.setString(4, status);
            pre.setString(5, id);

            pre.executeUpdate();



        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
   public void setStatustable(String id,String Status){
       PreparedStatement pre = null;
       try(Connection connect = getConnection();
            

            ){pre = connect.prepareStatement("update tablenumber set Status = ? where idTable = ?");
              pre.setString(1, Status);
              pre.setString(2, id);
              
              pre.executeUpdate();
           
           

       }catch (SQLException e) {
        e.printStackTrace();
        }
       
   }
   public ArrayList<Table> getTable(){
       return table;
   }
   public void setTable(ArrayList table){
       this.table = table;
   }
   
   public boolean loadMenu(){
       menu = new ArrayList<Menu>();
       try(Connection connect = getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM menulist");
            ){
           
           
           while(rs.next()){
            
            Menu t = new Menu(rs.getInt("id"), rs.getString("FoodName"), rs.getString("Price"), rs.getString("Type"));
              
            menu.add(t);
//               System.out.println(table.size());
//               System.out.println(table.get(0).getId());
         
           }
//         return true  System.out.println(table.iterator());
          return true;  
       }catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
      
   }
   public void addMenu(String name,String price, String type){
       PreparedStatement pre = null;
       try(Connection connect = getConnection();


            ){pre = connect.prepareStatement("insert into menulist (FoodName,Price,Type) values (?, ?, ?)");
              pre.setString(1, name);
              pre.setString(2, price);
              pre.setString(3, type);

              pre.executeUpdate();



       }catch (SQLException e) {
        e.printStackTrace();
        }
       
   }

    public void memSetPoint(Member memobject){


        PreparedStatement pre = null;
        try(Connection connect = getConnection();


        ){pre = connect.prepareStatement("UPDATE customer SET point = ? WHERE TelCustomer = ?");
            pre.setDouble(1, memobject.getPoint());
            pre.setString(2, memobject.getTelcus());


            pre.executeUpdate();



        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
   public void addMenu2(Addmenu menu){
       PreparedStatement pre = null;
       String name = menu.getT1().getText();
       String price = menu.getT2().getText();
       String type = menu.getT3().getText();
       try(Connection connect = getConnection();
            

            ){pre = connect.prepareStatement("insert into menulist (FoodName,Price,Type) values (?, ?, ?)");
              pre.setString(1, name);
              pre.setString(2, price);
              pre.setString(3, type);
              
              pre.executeUpdate();
           
           

       }catch (SQLException e) {
        e.printStackTrace();
        }
       
   }
   public Table searchTableById(int id) {
    for (Table t : table) {
        if (t.getId() == id) {
            return t;
        }
    }
    return null;
}
//    public Table searchTableById(Table tableObject) {
//    int id = tableObject.getId();
//    for (Table t : table) {
//        if (t.getId() == id) {
//            return t;
//        }
//    }
//    return null;
//}
   
   
   public Member searchmemberByphone(String phone) {
    for (Member mem : member) {
        if (mem.getTelcus().equals(phone)) {
            return mem;
        }
    }
    return null;
}

    public Member searchmemberByphone(Member memObject) {
        String phone = memObject.getTelcus();
        for (Member mem : member) {
            if (mem.getTelcus().equals(phone)) {
                return mem;
            }
        }
        return null;
    }
   
//    public static void main(String[] args) {
//        Database db = new Database();
//        ArrayList<Table> dd = new ArrayList<Table>();
//        if (db.loadTable()){
//            dd = db.getTable();
//            System.out.println(dd.size());
//            System.out.println(dd.get(1).getId());  
//        }
//        
    //}

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }
    public boolean loadMember(){
       member = new ArrayList<>();
       try(Connection connect = getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customer");
            ){
           while(rs.next()){
            Member mem = new Member(rs.getInt("idCustomer"), rs.getString("NameCustomer"), rs.getString("TelCustomer")
                    ,rs.getString("Email"), rs.getInt("Point"));
            
              
            member.add(mem);
//               System.out.println(table.size());
//               System.out.println(table.get(0).getId());
         
           }
//         return true  System.out.println(table.iterator());
          return true;  
       }catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
      
   }

    public ArrayList<Member> getMember() {
        return member;
    }

    public void setMember(ArrayList<Member> member) {
        this.member = member;
    }

    public void addContactView(Refreshable view) {
        if (!tableView.contains(view))
            tableView.add(view);
    }
    public void updateModel(ArrayList<Table> tables) {
        loadTable();
        tables = table;
        System.out.println("update");
        updateView();
    }
    private void updateView() {
        Iterator notifyViews = tableView.iterator();
        System.out.println(notifyViews);
        System.out.println("tappp ++"+tableView.size());
        while (notifyViews.hasNext())
            ((Refreshable)notifyViews.next()).refreshtable(table);


    }

}
   
   
    
    
