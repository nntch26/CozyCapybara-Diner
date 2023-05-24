import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TablelistTable extends DataTable {
    private ArrayList<Table> tablelist;
    public TablelistTable() {
        super(new Object[][]{}, new Object[]{"ID", "Cap", "Name","Tel","Time","Status"});
    }

    public void loadFromDatabase(String query) {
        // เพิ่มข้อมูลลงในตาราง
        tablelist = new ArrayList<>();
        try {
            DatabaseConnect db = new DatabaseConnect();
            tablelist = db.getTableList();

            for (int i =0; i < tablelist.size();i++){
                String num = String.valueOf(i);
                int cap = tablelist.get(i).getTableCap();
                String name = tablelist.get(i).getTableNameCus();
                String tel = tablelist.get(i).getTablePhoneCus();
                String time = tablelist.get(i).getTableTimeres();
                String status = tablelist.get(i).getTableStatus();
                String capString = String.valueOf(cap);
                String[] row = {num, capString, name,tel,time,status};
                model.addRow(row);
                System.out.println("Show Table Successfully");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error " + e);
        }

    }
}
