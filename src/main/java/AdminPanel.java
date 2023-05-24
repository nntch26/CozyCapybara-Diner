import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class AdminPanel extends JFrame implements ActionListener, DataManagement{
    private JDesktopPane d;
    private JButton BtnAdd, BtnEdit, BtnDelete;
    private JInternalFrame f,f1,f2,f3;
    private JLabel lMenu, lPrice, lType;
    private JTextField tMenu, tPrice,tType;
    private JTable table;
    private DefaultTableModel model;

    private JMenuBar menuBar;
    private JMenu adminMenu, tableMenu,foodMenu,memMenu;
    private JMenuItem newAdminMenuItem , exit, tableMenuItem, foodMenuItem, memMenuItem,closeButton;
    private ArrayList<Menu> menulist;
    private ArrayList<Table> tablelist;
    private ArrayList<Member> memlist;
    private DatabaseConnect db;
    public AdminPanel(){

        try {
            db = new DatabaseConnect();
            menulist = db.getMenuList();
            memlist = db.getMemberList();
            tablelist = db.getTableList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
                adminFrame();
            }
        });
        adminMenu.add(newAdminMenuItem);

        tableMenu = new JMenu("Table");
        tableMenuItem = new JMenuItem("Table Data");
        tableMenuItem.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                tableFrame();
            }
        });
        tableMenu.add(tableMenuItem);

        foodMenu = new JMenu("MenuFood");
        foodMenuItem = new JMenuItem("Menu Management");
        foodMenuItem.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                menuFrame();
            }
        });
        foodMenu.add(foodMenuItem);

        memMenu = new JMenu("Member");
        memMenuItem = new JMenuItem("Member Data");
        memMenuItem.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                customerFrame();
            }
        });
        memMenu.add(memMenuItem);

        closeButton = new JMenuItem("Clear All Windows");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame[] internalFrames = d.getAllFrames();
                for (JInternalFrame internalFrame : internalFrames) {
                    internalFrame.dispose(); // ปิดหน้าต่างทั้งหมด
                }
            }
        });

        adminMenu.add(closeButton);


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

    // Admin InternalFrame
    public void adminFrame(){
        table = new JTable();
        f = new JInternalFrame("Admin Management System ", false, true, false, false);
        f.setLayout(new BorderLayout());

        JLabel label2 = new JLabel("Management System");
        label2.setFont(new Font("Tahoma", Font.BOLD, 18));
        label2.setForeground(Color.decode("#F14902"));

        JPanel pTop = new JPanel();
        JPanel pCenter = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        table = new JTable();


        pTop.setBackground(Color.LIGHT_GRAY);
        pCenter.setBackground(Color.LIGHT_GRAY);

        // All Food Items
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.decode("#303030"));
        p1.setPreferredSize(new Dimension(150, 120));
        int num1 = menulist.size();
        JLabel l1 = new JLabel("All Food Items");
        JLabel l11 = new JLabel("      "+num1);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setFont(new Font("Tahoma", Font.BOLD, 38));
        l1.setForeground(Color.WHITE);
        l11.setForeground(Color.decode("#F14902"));
        p1.add(l1, BorderLayout.NORTH);
        p1.add(l11, BorderLayout.CENTER);

        //All Tables
        p2.setLayout(new BorderLayout());
        p2.setBackground(Color.decode("#303030"));
        p2.setPreferredSize(new Dimension(150, 120));
        int num2 = tablelist.size();
        JLabel l2 = new JLabel("All Tables");
        JLabel l22 = new JLabel("      "+num2);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l22.setFont(new Font("Tahoma", Font.BOLD, 38));
        l2.setForeground(Color.WHITE);
        l22.setForeground(Color.decode("#F14902"));
        p2.add(l2, BorderLayout.NORTH);
        p2.add(l22, BorderLayout.CENTER);

        // All Members
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.decode("#303030"));
        p3.setPreferredSize(new Dimension(150, 120));
        int num3 = memlist.size();
        JLabel l3 = new JLabel("All Members");
        JLabel l33 = new JLabel("      "+num3);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l33.setFont(new Font("Tahoma", Font.BOLD, 38));
        l3.setForeground(Color.WHITE);
        l33.setForeground(Color.decode("#F14902"));
        p3.add(l3, BorderLayout.NORTH);
        p3.add(l33, BorderLayout.CENTER);

        // add Panel Top
        pTop.add(p1);
        pTop.add(p2);
        pTop.add(p3);


        pCenter.setLayout(new BorderLayout());
        Border compoundBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), //ระยะห่างขอบของเส้น
                BorderFactory.createLineBorder(Color.black, 2)
        );
        pCenter.setBorder(compoundBorder);
        JButton membtn = new JButton("View Members");
        JButton menubtn = new JButton("View Menu");
        JButton tablebtn = new JButton("View Tables");
        membtn.setPreferredSize(new Dimension(150, 120));
        menubtn.setPreferredSize(new Dimension(150, 120));
        tablebtn.setPreferredSize(new Dimension(150, 120));
        membtn.setForeground(Color.WHITE);
        menubtn.setForeground(Color.WHITE);
        tablebtn.setForeground(Color.WHITE);
        membtn.setBackground(Color.decode("#303030"));
        menubtn.setBackground(Color.decode("#303030"));
        tablebtn.setBackground(Color.decode("#303030"));

        ////////////////////// addActionListener ///////////////////////////
        membtn.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                customerFrame();
            }});

        menubtn.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                menuFrame();
            }
        });

        tablebtn.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                tableFrame();
            }
        });


        JLabel l4 = new JLabel("   View Data");
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 28));
        l4.setForeground(Color.decode("#F14902"));

        p.add(menubtn); p.add(membtn); p.add(tablebtn);
        pCenter.add(l4, BorderLayout.NORTH);
        pCenter.add(p,BorderLayout.CENTER);

        f.add(pTop, BorderLayout.NORTH);
        f.add(pCenter, BorderLayout.CENTER);
        f.setSize(600, 400);
        f.setVisible(true);
        d.add(f);

    }

    // TableList InternalFrame
    public void tableFrame(){
        TablelistTable Tablelist = new TablelistTable();
        Tablelist.loadFromDatabase("tablenumber");
        JScrollPane scrollPane = new JScrollPane(Tablelist);
        f2 = new JInternalFrame("Table Data", false, true, false, false);
        f2.setLayout(new BorderLayout());

        JLabel label2 = new JLabel("Table Data");
        label2.setFont(new Font("Tahoma", Font.BOLD, 24));
        label2.setForeground(Color.decode("#F14902"));

        JPanel searchPanel2 = new JPanel();
        searchPanel2.add(label2);

        f2.add(searchPanel2, BorderLayout.NORTH);
        f2.add(scrollPane, BorderLayout.CENTER);
        f2.setSize(600, 400);
        f2.setVisible(true);
        d.add(f2);

    }

    // Customerlist JInternalFrame
    public void customerFrame(){
        CustomerlistTable Customerlist = new CustomerlistTable();
        Customerlist.loadFromDatabase("customer");
        JScrollPane scrollPane = new JScrollPane(Customerlist);
        f3 = new JInternalFrame("Member Data", false, true, false, false);
        f3.setLayout(new BorderLayout());

        JLabel label = new JLabel("Member Data");
        label.setFont(new Font("Tahoma", Font.BOLD, 24));
        label.setForeground(Color.decode("#F14902"));

        JPanel searchPanel = new JPanel();
        searchPanel.add(label);

        f3.add(searchPanel, BorderLayout.NORTH);
        f3.add(scrollPane, BorderLayout.CENTER);

        f3.setSize(600, 400);
        f3.setVisible(true);
        d.add(f3);


    }

    // FoodFrame JInternalFrame
    public void menuFrame(){
        f1 = new JInternalFrame("Menu Data", false, true, false, false);
        f1.setLayout(new BorderLayout());
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

        ////f1addTable////
        setTable();

        // เพิ่มตาราง
        JScrollPane scrollPane = new JScrollPane(table);
        tempMain.add(scrollPane, BorderLayout.CENTER);

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

    @Override
    public void setTable() {
        String[] colname = {"ID", "FoodName", "Price", "Type"};
        model = new DefaultTableModel(colname,0);
        db = new DatabaseConnect();
        try {
            DatabaseConnect db = new DatabaseConnect();
            menulist = db.getMenuList();

            for (int i =0; i < menulist.size();i++){
                String id = String.valueOf(i+1);
                String name = menulist.get(i).getMenuName();
                String price = menulist.get(i).getMenuPrice();
                String type = menulist.get(i).getMenuType();
                Object[] rowData = { id, name,price, type};
                model.addRow(rowData);
                System.out.println("Show Table Successfully");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error " + e);
        }
        table.setModel(model);

    }

    // เพิ่มสมาชิก

    public void addData(String Menuname, String MenuPrice, String MenuType) {
        int memberId = menulist.size() + 1;
        Object[] rowData = { memberId,Menuname,MenuPrice,MenuType};
        model.addRow(rowData);

        menulist.add(new Menu(memberId,Menuname,MenuPrice,MenuType)); // แอดเข้า obj

        String s = String.format("'%s','%s','%s'",Menuname,MenuPrice,MenuType); // ข้อมูลใหม่ เพิ่มลง database
        try {
            db.insert("menulist","FoodName, Price, Type",s);
            setTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }


    @Override
    public void addData() {

    }


    // ลบสมาชิก
    @Override
    public void deleteData(int rowIndex) {
        try {
            String tel1 = menulist.get(rowIndex).getMenuName(); // ลบข้อมูลบน Database
            String query = String.format("FoodName ='%s'", tel1);
            db.delete("menulist",query);
            System.out.println("Delete Data Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.removeRow(rowIndex); //ลบแถวในตาราง


    }

    @Override
    public void editData(int rowIndex) {

    }


    // แก้ไขสมาชิก อัปเดทข้อมูลใหม่

    public void editData(int rowIndex, String Menuname, String MenuPrice, String MenuType) {
        try {
            String name2 = menulist.get(rowIndex).getMenuName(); // อัปเดทข้อมูลลง database
            String where = String.format("FoodName ='%s'", name2);
            String set = String.format("FoodName = '%s',Price = '%s',Type = '%s'",Menuname,MenuPrice,MenuType);
            db.update("menulist",set,where);
            System.out.println("Update Data Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // แก้ไขข้อมูลบนตาราง
        model.setValueAt(Menuname, rowIndex, 1);
        model.setValueAt(MenuPrice, rowIndex, 2);
        model.setValueAt(MenuType, rowIndex, 3);

    }





    ////////////////////// ActionEvent ///////////////////////////
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(BtnAdd)) {
            String menu = tMenu.getText();
            String price = tPrice.getText();
            String type  =tType.getText();
            addData(menu,price,type); // เพิ่มข้อมูลใหม่
            tMenu.setText("");
            tPrice.setText("");
            tType.setText("");
            setTable();


        }else if (ae.getSource().equals(BtnEdit)) {
            int rowIndex = table.getSelectedRow();
            if (rowIndex != -1) {
                String menu = tMenu.getText();
                String price = tPrice.getText();
                String type = tType.getText();
                editData(rowIndex, menu, price, type); // เพิ่มข้อมูลใหม่
                setTable();
            }

        }else if (ae.getSource().equals(BtnDelete)) {
            int rowIndex2 = table.getSelectedRow();
            if (rowIndex2 != -1) {
                deleteData(rowIndex2);
            }

        }
    }




}