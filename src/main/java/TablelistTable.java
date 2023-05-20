import javax.swing.*;
import java.sql.ResultSet;

public class TablelistTable extends DataTable {
    public TablelistTable() {
        super(new Object[][]{}, new Object[]{"ID", "Cap", "Name","Tel","Time","Status"});
    }

    public void loadFromDatabase(String query) {
        // เพิ่มข้อมูลลงในตาราง
        try {
            DBConnect conn = new DBConnect();
            ResultSet rs = conn.selectAr(query);

            int i = 0;
            while (rs.next()) {
                i++;
                String num = String.valueOf(i);
                String cap = rs.getString("Cap");
                String name = rs.getString("NameCus");
                String tel = rs.getString("TelCus");
                String time = rs.getString("DTime");
                String status = rs.getString("Status");
                String[] row = {num, cap, name,tel,time,status};
                model.addRow(row);
            }
        } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " + e);
        }
    }




}
