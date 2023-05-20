import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class AdminPanel extends JFrame implements ActionListener{
    private JDesktopPane d;
    private JButton BtnAdd, BtnEdit, BtnDelete, searchButton, searchButton2;
    private JInternalFrame f1,f2,f3;
    private JLabel lMenu, lPrice, lType;
    private JTextField tMenu, tPrice,tType,searchField, searchField2 ;

    private DefaultTableModel menuTable;



    private JMenuBar menuBar;
    private JMenu adminMenu, tableMenu,foodMenu,memMenu;
    private JMenuItem newAdminMenuItem , exit, tableMenuItem, foodMenuItem, memMenuItem;
    private ArrayList<Menu> menulist;
    private DBConnect db;
    public AdminPanel(){
        d = new JDesktopPane();
        d.setBackground(Color.decode("#303030"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,600);
        setResizable(false);
        setLocationRelativeTo(null); //แสดงหน้าต่างตรงกลาง



        menuBar = new JMenuBar();
        adminMenu = new JMenu("Admin");
        newAdminMenuItem = new JMenuItem("New Admin");
        newAdminMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //createNewAdminForm();
            }
        });
        adminMenu.add(newAdminMenuItem);

        tableMenu = new JMenu("Table");
        tableMenuItem = new JMenuItem("Booking Table");
        tableMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableFrame();
            }
        });
        tableMenu.add(tableMenuItem);

        foodMenu = new JMenu("MenuFood");
        foodMenuItem = new JMenuItem("Menu Management");
        foodMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFrame();
            }
        });
        foodMenu.add(foodMenuItem);

        memMenu = new JMenu("Member");
        memMenuItem = new JMenuItem("Member Table");
        memMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customerFrame();
            }
        });
        memMenu.add(memMenuItem);

        exit = new JMenuItem ("Exit Admin");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainGUI();
            }
        });
        adminMenu.add(exit);


        menuBar.add(adminMenu);
        menuBar.add(tableMenu);
        menuBar.add(foodMenu);
        menuBar.add(memMenu);
        setJMenuBar(menuBar);

        ///addthing///
        add(d);
        setVisible(true);
    }

    public void tableFrame(){
        // TableList InternalFrame
        DataTable Tablelist = new TablelistTable();
        Tablelist.loadFromDatabase("tablenumber");
        JScrollPane scrollPane = new JScrollPane(Tablelist);
        f2 = new JInternalFrame("", false, true, false, false);
        f2.setLayout(new BorderLayout());

        JLabel label2 = new JLabel("Search: ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.decode("#F14902"));

        searchButton2 = new JButton("Search");
        searchButton2.setForeground(Color.white);
        searchButton2.setFont(new Font("Tahoma", Font.BOLD, 14)); // กำหนดแบบอักษร และขนาด
        searchButton2.setPreferredSize(new Dimension(80, 30));
        searchButton2.setBorder(BorderFactory.createLineBorder(Color.decode("#E67E22")));
        searchButton2.setBackground(Color.DARK_GRAY);

        searchField2 = new JTextField(10);
        JPanel searchPanel2 = new JPanel();
        searchPanel2.add(label2);
        searchPanel2.add(searchField2);
        searchPanel2.add(searchButton2);

        f2.add(searchPanel2, BorderLayout.NORTH);
        f2.add(scrollPane, BorderLayout.CENTER);
        f2.setSize(600, 400);
        f2.setVisible(true);
        d.add(f2);

    }

    public void customerFrame(){
        // Customerlist JInternalFrame
        DataTable Customerlist = new CustomerlistTable();
        Customerlist.loadFromDatabase("customer");
        JScrollPane scrollPane = new JScrollPane(Customerlist);
        f3 = new JInternalFrame("", false, true, false, false);
        f3.setLayout(new BorderLayout());

        JLabel label = new JLabel("Search: ");
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.setForeground(Color.decode("#F14902"));

        searchButton = new JButton("Search");
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 14)); // กำหนดแบบอักษร และขนาด
        searchButton.setPreferredSize(new Dimension(80, 30));
        searchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#E67E22")));
        searchButton.setBackground(Color.DARK_GRAY);

        searchField = new JTextField(10);
        JPanel searchPanel = new JPanel();
        searchPanel.add(label);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        f3.add(searchPanel, BorderLayout.NORTH);
        f3.add(scrollPane, BorderLayout.CENTER);

        f3.setSize(600, 400);
        f3.setVisible(true);
        d.add(f3);


    }

    public void menuFrame(){
        // FoodFrame JInternalFrame
        f1 = new JInternalFrame("", false, true, false, false);
        lMenu = new JLabel("Menu  :  ");
        lPrice = new JLabel("Price  :  ");
        lType = new JLabel("Type  :  ");
        tMenu = new JTextField("",20);
        tPrice = new JTextField("",20);
        tType = new JTextField("",20);
        BtnAdd = new JButton("Add");
        BtnEdit = new JButton("Edit");
        BtnDelete = new JButton("Delete");

        BtnAdd.setBackground(Color.decode("#F14902"));
        BtnEdit.setBackground(Color.decode("#F14902"));
        BtnDelete.setBackground(Color.decode("#F14902"));


        f1.setLayout(new BorderLayout());

        ///f1addinfo///
        JPanel tempMain = new JPanel();
        JPanel temp1 = new JPanel();
        JPanel temp1_1 = new JPanel(); JPanel temp1_2 = new JPanel(); JPanel temp1_3 = new JPanel();

        tempMain.setLayout(new BorderLayout(3, 3));
        temp1.setLayout(new GridLayout(3,1,5,5));
        temp1.setBorder(BorderFactory.createRaisedBevelBorder());
        tMenu.setPreferredSize(new Dimension(5, 25));
        tPrice.setPreferredSize(new Dimension(5, 25));
        tType.setPreferredSize(new Dimension(5, 25));
        lMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
        lType.setFont(new Font("Tahoma", Font.BOLD, 13));

        temp1_1.add(lMenu); temp1_1.add(tMenu);
        temp1_2.add(lPrice); temp1_2.add(tPrice);
        temp1_3.add(lType); temp1_3.add(tType);
        temp1.add(temp1_1);
        temp1.add(temp1_2);
        temp1.add(temp1_3);

        tempMain.add(temp1, BorderLayout.NORTH);
        f1.add(tempMain, BorderLayout.CENTER);
        tMenu.setEditable(false); tPrice.setEditable(false); tType.setEditable(false);

        ////f1addTable////
        DataTable menuTable = new MenulistTable();
        menuTable.loadFromDatabase("menulist");
        menuTable.getTableHeader().setBackground(Color.decode("#303030"));
        menuTable.getTableHeader().setForeground(Color.white);
        tempMain.add(new JScrollPane(menuTable), BorderLayout.CENTER);

        //f1addbutton////
        JPanel temp2 = new JPanel();
        BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        BtnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
        BtnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));

        temp2.add(BtnAdd); temp2.add(BtnEdit); temp2.add(BtnDelete);
        f1.add(temp2, BorderLayout.SOUTH);


        ///f1setting////
        f1.add(Box.createRigidArea(new Dimension(1,10)), BorderLayout.NORTH);
        f1.add(Box.createRigidArea(new Dimension(10,1)), BorderLayout.WEST);
        f1.add(Box.createRigidArea(new Dimension(10,1)), BorderLayout.EAST);
        int x1 = f1.getX();
        int y1 = f1.getY();
        f1.setLocation(x1+50, y1+50);

        BtnAdd.addActionListener(this);
        BtnEdit.addActionListener(this);
        BtnDelete.addActionListener(this);

        f1.setSize(600, 400);
        f1.setVisible(true);
        d.add(f1);
    }



    /////////////// ส่วนจัดการ เพิ่ม ลบ แก้ไข ข้อมูล ///////////////////////////////////////////////

    // เพิ่มสมาชิก
    public void addFood(String Menuname,String MenuPrice,String MenuType) {
        int memberId = menulist.size() + 1;
        Object[] rowData = { memberId,Menuname,MenuPrice,MenuType};
        menuTable.addRow(rowData);

        menulist.add(new Menu(memberId,Menuname,MenuPrice,MenuType)); // แอดเข้า obj

        String s = String.format("'%s','%s','%s'",Menuname,MenuPrice,MenuType); // ข้อมูลใหม่ เพิ่มลง database
        try {
            db.insert("menulist","FoodName, Price, Type",s);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // ลบสมาชิก
    public void deleteFood(int rowIndex) {
        try {
            String tel1 = menulist.get(rowIndex).getMenuName(); // ลบข้อมูลบน Database
            String query = String.format("TelCustomer ='%s'", tel1);
            db.delete("customer",query);
            System.out.println("Delete Data Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        menuTable.removeRow(rowIndex); //ลบแถวในตาราง
    }

    // แก้ไขสมาชิก อัปเดทข้อมูลใหม่
    public void editFood(int rowIndex, String Menuname,String MenuPrice,String MenuType) {
        try {
            String name2 = menulist.get(rowIndex).getMenuName(); // อัปเดทข้อมูลลง database
            String where = String.format("FoodName ='%s'", name2);
            String set = String.format("FoodName = '%s',Price = '%s',Type = '%s'",Menuname,MenuPrice,MenuType);
            db.update("customer",set,where);
            System.out.println("Update Data Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // แก้ไขข้อมูลบนตาราง
        menuTable.setValueAt(Menuname, rowIndex, 1);
        menuTable.setValueAt(MenuPrice, rowIndex, 2);
        menuTable.setValueAt(MenuType, rowIndex, 3);
    }




    ////////////////////// ActionEvent ///////////////////////////
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(BtnAdd)){
            AdminAddMenu menuAdd = new AdminAddMenu();
            d.add(menuAdd);
            int x2 = menuAdd.getX();
            int y2 = menuAdd.getY();
            menuAdd.setLocation(x2+670, y2+100);

        }else if(ae.getSource().equals(BtnEdit) && BtnEdit.getText() == "Edit"){
            tMenu.setEditable(true); tPrice.setEditable(true); tType.setEditable(true);
            BtnEdit.setText("Done");

        }else if(ae.getSource().equals(BtnEdit) && BtnEdit.getText() == "Done"){
            tMenu.setEditable(false); tPrice.setEditable(false); tType.setEditable(false);
            BtnEdit.setText("Edit");
        }
    }





}