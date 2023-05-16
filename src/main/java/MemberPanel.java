import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class MemberPanel extends JPanel implements ActionListener {

    // Components
    private JTable memberTable;
    private JTextField searchField;
    private JButton addButton, deleteButton, editButton;

    // Table model
    private DefaultTableModel tableModel;
    private JLabel label1;

    public MemberPanel() {
        label1 = new JLabel("Members");
        memberTable = new JTable();
        searchField = new JTextField(20);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");

        // ใส่สีปุ่ม
        addButton.setForeground(Color.white);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        addButton.setPreferredSize(new Dimension(100, 50));
        addButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        addButton.setBackground(Color.DARK_GRAY);

        deleteButton.setForeground(Color.white);
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        deleteButton.setPreferredSize(new Dimension(100, 50));
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        deleteButton.setBackground(Color.DARK_GRAY);

        editButton.setForeground(Color.white);
        editButton.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        editButton.setPreferredSize(new Dimension(100, 50));
        editButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        editButton.setBackground(Color.DARK_GRAY);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);
        searchField.addActionListener(this);


        // MemberView
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("Tahoma", Font.BOLD, 56)); // กำหนดแบบอักษร และขนาด
        add(label1, BorderLayout.NORTH);

        // สร้าง table model Column
        tableModel = new DefaultTableModel();
        tableModel.addColumn("IDCustomer");
        tableModel.addColumn("Name");
        tableModel.addColumn("TelCustomer");
        tableModel.addColumn("Email");
        tableModel.addColumn("Point");
        memberTable.setModel(tableModel);

        // เพิ่มตาราง
        setLayout(new BorderLayout());
        add(new JScrollPane(memberTable), BorderLayout.CENTER);

        // เพิ่ม Panel ปุ่มต่างๆ
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(label1, FlowLayout.LEFT);
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);

        add(buttonPanel, BorderLayout.SOUTH);
        add(searchPanel, BorderLayout.NORTH);
        setSize(500, 300);
        setVisible(true);
    }

    // เพิ่มสมาชิก
    private void addMember(String id, String name, String tel, String emil, int point) {
        Object[] rowData = { id, name, tel, emil,point};
        tableModel.addRow(rowData);
    }

    // ลบสมาชิก
    private void deleteMember(int rowIndex) {
        tableModel.removeRow(rowIndex);
    }

    // แก้ไขสมาชิก
    private void editMember(int rowIndex,String id, String name, String tel, String emil, int point) {
        tableModel.setValueAt(id, rowIndex, 0);
        tableModel.setValueAt(name, rowIndex, 1);
        tableModel.setValueAt(tel, rowIndex, 2);
        tableModel.setValueAt(emil, rowIndex, 3);
        tableModel.setValueAt(point, rowIndex, 4);
    }

    // ค้นหารายชื่อสมาชิก
    private void searchMembers(String searchTerm) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String name = tableModel.getValueAt(i, 1).toString();
            if (name.contains(searchTerm)) {
                memberTable.setRowSelectionInterval(i, i);
                memberTable.scrollRectToVisible(memberTable.getCellRect(i, 0, true));
                break;
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == addButton) {
            String id = JOptionPane.showInputDialog("Enter ID :");
            String name = JOptionPane.showInputDialog("Enter name :");
            String tel = JOptionPane.showInputDialog("Enter Tel :");
            String em = JOptionPane.showInputDialog("Enter Email :");
            String pointString = JOptionPane.showInputDialog("Enter Point :");
            int point = Integer.parseInt(pointString);
            // เพิ่ม member ลงตาราง
            addMember(id, name,tel,em,point);
        }
        // ลบ member
        else if (e.getSource() == deleteButton) {
            int rowIndex = memberTable.getSelectedRow();
            if (rowIndex != -1) {
                deleteMember(rowIndex);
            }
        }
        // แก้ไข member ในตาราง
        else if (e.getSource() == editButton) {
            int rowIndex = memberTable.getSelectedRow();
            if (rowIndex != -1) {
                String id = JOptionPane.showInputDialog("Enter ID :");
                String name = JOptionPane.showInputDialog("Enter name :");
                String tel = JOptionPane.showInputDialog("Enter Tel :");
                String em = JOptionPane.showInputDialog("Enter Email :");
                String pointString = JOptionPane.showInputDialog("Enter Point :");
                int point = Integer.parseInt(pointString);
                editMember(rowIndex,id, name,tel,em,point);
            }
        }
        // Search
        else if (e.getSource() == searchField) {
            String searchTerm = searchField.getText();
            searchMembers(searchTerm);
        }
    }

}



