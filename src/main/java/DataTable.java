import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class DataTable extends JTable {
    protected DefaultTableModel model;

    public DataTable(Object[][] data, Object[] columnNames) {
        model = new DefaultTableModel(data, columnNames);
        setModel(model);
    }

    public abstract void loadFromDatabase(String query);  // เมธอดที่คลาสลูกจะต้องสร้างข้อมูลในตารางเอง



}

