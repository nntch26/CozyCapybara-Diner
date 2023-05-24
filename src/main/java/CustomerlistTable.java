import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerlistTable extends DataTable {
    private ArrayList<Member> memlist;
    public CustomerlistTable() {
        super(new Object[][]{}, new Object[]{"IDCustomer", "NameCustomer", "TelCustomer","Email","Point"});
    }

    public void loadFromDatabase(String query) {
        // เพิ่มข้อมูลลงในตาราง
        memlist = new ArrayList<>();
        try {
            DatabaseConnect db = new DatabaseConnect();
            memlist = db.getMemberList();

            for (int i =0; i < memlist.size();i++){
                String id = String.valueOf(i+1);
                String name = memlist.get(i).getName();
                String tel = memlist.get(i).getTelcus();
                String em = memlist.get(i).getEmail();
                Double point = memlist.get(i).getPoint();
                Object[] rowData = { id, name, tel, em,point};
                model.addRow(rowData);
                System.out.println("Show Table Successfully");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error " + e);
        }
    }
}
