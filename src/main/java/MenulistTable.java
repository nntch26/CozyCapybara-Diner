import javax.swing.*;
import java.sql.ResultSet;

public class MenulistTable extends DataTable {
    public MenulistTable() {
        super(new Object[][]{}, new Object[]{"ID", "FoodName", "Price","Type"});
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
                String name = rs.getString("FoodName");
                String price = rs.getString("Price");
                String type = rs.getString("Type");
                String[] row = {num, name,price,type};
                model.addRow(row);
            }
        } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " + e);
        }
    }




}
