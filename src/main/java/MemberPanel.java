import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import java.util.*;


public class MemberPanel extends JPanel implements ActionListener {

    public JTable memberTable;
    public DefaultTableModel tableModel;
    public JTextField searchField;
    public JButton addButton, deleteButton, editButton, allButton, searchButton;
    private TableRowSorter<DefaultTableModel> rowSorter;

    public JLabel label1;
    private ArrayList<Member> memlist;
    public DBConnect db;

    public MemberPanel() {

        setLayout(new FlowLayout());
        memberTable = new JTable();
        tableModel = new DefaultTableModel();
        searchField = new JTextField(10);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        allButton = new JButton("All");
        searchButton = new JButton("Search");


        // ตกแต่ง ใส่สี

        JLabel label2 = new JLabel("Search: ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.white);

        // MemberView
        label1 = new JLabel("MemberShip");
        label1.setForeground(Color.decode("#E67E22"));
        label1.setFont(new Font("Tahoma", Font.BOLD, 48)); // กำหนดแบบอักษร และขนาด
        label1.setBounds(200,100,200,30);

        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        addButton.setPreferredSize(new Dimension(100, 40));
        addButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        addButton.setBackground(Color.DARK_GRAY);


        deleteButton.setForeground(Color.white);
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        deleteButton.setPreferredSize(new Dimension(100, 40));
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        deleteButton.setBackground(Color.DARK_GRAY);

        editButton.setForeground(Color.white);
        editButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        editButton.setPreferredSize(new Dimension(100, 40));
        editButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        editButton.setBackground(Color.DARK_GRAY);

        allButton.setForeground(Color.white);
        allButton.setFont(new Font("Tahoma", Font.BOLD, 14)); // กำหนดแบบอักษร และขนาด
        allButton.setPreferredSize(new Dimension(80, 30));
        allButton.setBorder(BorderFactory.createLineBorder(Color.decode("#E67E22")));
        allButton.setBackground(Color.DARK_GRAY);


        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 14)); // กำหนดแบบอักษร และขนาด
        searchButton.setPreferredSize(new Dimension(80, 30));
        searchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#E67E22")));
        searchButton.setBackground(Color.DARK_GRAY);

        // ตกแต่งตาราง
        memberTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        memberTable.getTableHeader().setBackground(Color.DARK_GRAY);
        memberTable.getTableHeader().setForeground(Color.white);
        memberTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());



        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);
        searchButton.addActionListener(this);
        allButton.addActionListener(this);



        // สร้าง table
        setTable();

        // เพิ่มตาราง
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(memberTable);
        add(scrollPane, BorderLayout.CENTER);

        // เพิ่ม Panel ปุ่มต่างๆ
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);


        // ส่วนคนหา รายชื่อ ด้านบน
        JPanel searchPanel = new JPanel();
        JPanel searchPanel2 = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setPreferredSize(new Dimension(700, 80));
        searchPanel.setBackground(Color.darkGray);
        searchPanel2.setBackground(Color.darkGray);

        searchPanel.add(label1);
        searchPanel2.add(label2);
        searchPanel2.add(searchField);
        searchPanel2.add(searchButton);
        searchPanel2.add(allButton);
        searchPanel.add(searchPanel2);




        add(searchPanel, BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);
        setSize(500, 300);
        setVisible(true);
    }

/////////////// ส่วนจัดการ เพิ่ม ลบ แก้ไขข้อมูลบน Table /////////////////////

    // ตั่งค่าตารางในการแสดงผล
    public void setTable(){
        String[] colname = {"IDCustomer","Name","TelCustomer","Email","Point"};
        tableModel = new DefaultTableModel(colname,0);
        db = new DBConnect();
        try {
            memlist = db.getMemberList();
            // ดึงข้อมูลใส่ตาราง
            for (int i =0; i < memlist.size();i++){
                String id = String.valueOf(i+1);
                String name = memlist.get(i).getName();
                String tel = memlist.get(i).getTelcus();
                String em = memlist.get(i).getEmail();
                Double point = memlist.get(i).getPoint();
                Object[] rowData = { id, name, tel, em,point};
                tableModel.addRow(rowData);
                System.out.println("Show Table Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        memberTable.setModel(tableModel);
    }


    // เพิ่มสมาชิก
    public void addMember(String name, String tel, String emil, int point) {
        int memberId = memlist.size() + 1;
        Object[] rowData = { memberId,name, tel, emil,point};
        tableModel.addRow(rowData);

        memlist.add(new Member(memberId, name,tel,emil,point)); // แอดเข้า obj

        String s = String.format("'%s','%s', '%s',%d",name,tel,emil,point); // ข้อมูลใหม่ เพิ่มลง database
        try {
            db.insert("customer","NameCustomer, TelCustomer, Email, Point",s);
            setTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // ลบสมาชิก
    public void deleteMember(int rowIndex) {
        try {
            String tel1 = memlist.get(rowIndex).getTelcus(); // ลบข้อมูลบน Database
            String query = String.format("TelCustomer ='%s'", tel1);
            db.delete("customer",query);
            System.out.println("Delete Data Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableModel.removeRow(rowIndex); //ลบแถวในตาราง
    }

    // แก้ไขสมาชิก อัปเดทข้อมูลใหม่
    public void editMember(int rowIndex, String name, String tel, String emil, int point) {
        try {
            String tel2 = memlist.get(rowIndex).getTelcus(); // อัปเดทข้อมูลลง database
            String where = String.format("TelCustomer ='%s'", tel2);
            String set = String.format("NameCustomer = '%s',TelCustomer = '%s',Email = '%s',Point = '%d'",name,tel,emil,point);
            db.update("customer",set,where);
            System.out.println("Update Data Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // แก้ไขข้อมูลบนตาราง
        tableModel.setValueAt(name, rowIndex, 1);
        tableModel.setValueAt(tel, rowIndex, 2);
        tableModel.setValueAt(emil, rowIndex, 3);
        tableModel.setValueAt(point, rowIndex, 4);
    }

    // ค้นหาข้อมูล

    private void searchMembers(String kw) {
        rowSorter = new TableRowSorter<>(tableModel);
        memberTable.setRowSorter(rowSorter);
        if (kw.isEmpty()) {
            rowSorter.setRowFilter(null); // ล้างตัวกรองแถว
        } else {
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter(kw);
            rowSorter.setRowFilter(rowFilter);
        }
    }





///////////////////// ActionEvent ////////////////////////////

    public void actionPerformed(ActionEvent e){
        // เพิ่มข้อมูล member
        if (e.getSource() == addButton) {
            new DetailFrame(); // เรียกหน้าต่างกรอกฟอร์ม
            setTable();
        }

        // ลบข้อมูล member
        else if (e.getSource() == deleteButton) {
            int rowIndex = memberTable.getSelectedRow();
            if (rowIndex != -1) {
                deleteMember(rowIndex);
            }
        }

        // แก้ไขข้อมูล member ในตาราง
        else if (e.getSource() == editButton) {
            int rowIndex = memberTable.getSelectedRow();
            if (rowIndex != -1) {
                String name = JOptionPane.showInputDialog("Enter name :");
                String tel = JOptionPane.showInputDialog("Enter Tel :");
                String em = JOptionPane.showInputDialog("Enter Email :");
                String pointString = JOptionPane.showInputDialog("Enter Point :");
                int point = Integer.parseInt(pointString);
                editMember(rowIndex,name,tel,em,point);
            }
        }

        // Search ค้นหาข้อมูล
        else if (e.getSource() == searchButton) {
            String kw = searchField.getText();
            searchMembers(kw);
            searchField.setText("");
        }
        // AllButton แสดงข้อมูลทั้งหมด
        else if (e.getSource() == allButton) {
            setTable();
        }

    }

    // ตกแต่งส่วน row ของ table
    static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            component.setFont(new Font("Tahoma", Font.BOLD, 12));
            // ใส่สีพื้นหลังของ row
            if (row % 2 == 0) {
                component.setBackground(Color.decode("#E5E8E8"));
            } else {
                component.setBackground(Color.WHITE);
            }
            component.setForeground(Color.DARK_GRAY);

            return component;
        }
    }


}

