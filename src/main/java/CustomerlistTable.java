import javax.swing.*;
import java.sql.ResultSet;

public class CustomerlistTable extends DataTable {
    public CustomerlistTable() {
        super(new Object[][]{}, new Object[]{"IDCustomer", "NameCustomer", "TelCustomer","Email","Point"});
    }

    public void loadFromDatabase(String query) {
        // เพิ่มข้อมูลลงในตาราง
        try {
            DatabaseConnect conn = new DatabaseConnect();
            ResultSet rs = conn.selectAr(query);

            int i = 0;
            while (rs.next()) {
                i++;
                String num = String.valueOf(i);
                String name = rs.getString("NameCustomer");
                String tel = rs.getString("TelCustomer");
                String em = rs.getString("Email");
                String point = rs.getString("Point");

                String[] row = {num, name,tel,em,point};
                model.addRow(row);
            }
        } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " + e);
        }
    }




}
