//import DBJava.Database;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TablePanel extends JPanel implements ActionListener, WindowListener, Refreshable {
    public JPanel Table_show, Table_butpanel, txtback, Table_Main, Table_Booking;
    public JButton[] tableButtons;
    public JButton b1, b2, bre;
    public JScrollPane s;
    private ArrayList<Table> tables;
    private Database db;
    private MainGUI mainGUI;
    private MenuPanel menuPanel;
    private JPanel[] tmp1, tmp2;

    public TablePanel(MainGUI mainGUI,MenuPanel menuPanel) {

        Table_butpanel = new JPanel();
        Table_show = new JPanel();
        Table_Main = new JPanel();
        Table_Booking = new JPanel();
        txtback = new JPanel();
        this.mainGUI = mainGUI;
        this.menuPanel = menuPanel;

        db = new Database();
        // loadtable
        db.addContactView(this);
        db.addContactView(mainGUI);
        db.loadTable();
        tables = db.getTable();
        System.out.println(tables.get(0).getId());
        // mainpanel show table
        setLayout(new BorderLayout());
        Table_Booking.setLayout(new BorderLayout());
        Table_Main.setLayout((new BorderLayout()));
        Table_show.setLayout(new GridLayout(2, 4, 20, 30));
        System.out.println(tables.size());
        tableButtons = new JButton[tables.size()];
        tmp2 = new JPanel[tables.size()];
        tmp1 = new JPanel[tables.size()];

        for (int i = 0; i < tables.size(); i++) {
            tmp1[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
            tmp2[i] = new JPanel(new GridLayout(2,1));
            tableButtons[i] = new JButton("Free");
            tableButtons[i].addActionListener(this);
            tmp2[i].add(tableButtons[i]);
            JLabel table = new JLabel("Table "+(i+1));
            table.setFont(new Font("Tahoma", Font.BOLD, 18));
            table.setForeground(Color.decode("#F14902"));
            table.setHorizontalAlignment(JLabel.CENTER);
            tmp2[i].add(table);
            tmp2[i].setForeground(Color.white);
            tmp1[i].add(tmp2[i]);
            Table_show.add(tmp1[i]);
            tmp1[i].setBackground(Color.decode("#303030"));
            tmp2[i].setBackground(Color.decode("#303030"));
            tableButtons[i].setPreferredSize(new Dimension(100, 55));
            tableButtons[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            setStausTable(tableButtons[i], tables.get(i).getTableStatus());
        }
        Table_Main.add(Table_show, BorderLayout.CENTER);
        Table_Main.add(Box.createRigidArea(new Dimension(60,0)), BorderLayout.WEST);
        Table_Main.add(Box.createRigidArea(new Dimension(60,0)), BorderLayout.EAST);
        Table_Main.add(Box.createRigidArea(new Dimension(0,30)), BorderLayout.NORTH);
        Table_Main.add(Box.createRigidArea(new Dimension(0,30)), BorderLayout.SOUTH);
        Table_Main.setBackground(Color.decode("#FFDEAD"));

        Table_Booking.add(Table_Main, BorderLayout.CENTER);
        Table_Booking.add(Box.createRigidArea(new Dimension(35,0)), BorderLayout.WEST);
        Table_Booking.add(Box.createRigidArea(new Dimension(35,0)), BorderLayout.EAST);
        Table_Booking.add(Box.createRigidArea(new Dimension(0,35)), BorderLayout.NORTH);
        Table_Booking.setBackground(Color.decode("#303030"));

        add(Table_Booking, BorderLayout.CENTER);
        JLabel tmp = new JLabel("       Booking Table");
        tmp.setFont(new Font("Tahoma", Font.BOLD, 35));
        tmp.setForeground(Color.decode("#F14902"));
        tmp.setPreferredSize(new Dimension(400,60));
        add(tmp, BorderLayout.NORTH);
        JPanel rigidArea = new JPanel();
        Border onlyBottom = new EmptyBorder(40, 0, 30, 0);
        Table_butpanel.setBorder(onlyBottom);
        setBackground(Color.decode("#FFDEAD"));


        Table_show.setBackground(Color.decode("#FFDEAD"));

        //bupanel
        Table_butpanel.setLayout(new FlowLayout());

        b1 = new JButton("Booking Table");
        b2 = new JButton("Busy Table");
        bre = new JButton("REFRESH");
        b1.setPreferredSize(new Dimension(200, 50));
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.decode("#2ECC71"));
        bre.setPreferredSize(new Dimension(200, 50));
        bre.setFont(new Font("Tahoma", Font.BOLD, 15));
        bre.setBackground(Color.DARK_GRAY);
        bre.setForeground(Color.WHITE);
        bre.addActionListener(this);
        b1.addActionListener(this);
        Table_butpanel.add(b1);
        Table_butpanel.add(Box.createRigidArea(new Dimension(10,0)));
        Table_butpanel.add(bre);
        Table_butpanel.add(Box.createRigidArea(new Dimension(10,0)));
        Table_butpanel.setBackground(Color.decode("#303030"));
        Table_Booking.add(Table_butpanel, BorderLayout.SOUTH);

    }
    public void setTablespanel(){
        tableButtons = new JButton[tables.size()];
        Table_show.removeAll();
        for (int i = 0; i < tables.size(); i++) {
            tableButtons[i] = new JButton("Ayo what tha dog doing");
            tableButtons[i].addActionListener(this);
            Table_show.add(tableButtons[i]);
            tableButtons[i].setPreferredSize(new Dimension(200, 175));
            tableButtons[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            tableButtons[i].setBackground(Color.decode("#deba83"));
            setStausTable(tableButtons[i], tables.get(i).getTableStatus());
            tableButtons[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));
        }
        Table_show.revalidate(); // เพิ่มบรรทัดนี้เพื่อเปลี่ยนแปลงเล็กน้อยในส่วนของ JPanel
        Table_show.repaint();
    }

    public void setStausTable(JButton j, String status) {

        if ("busy".equals(status) | "Busy".equals(status)) {
//             j.setIcon(icon);
            j.setText("Busy");
        } else if ("free".equals(status)  | "Free".equals(status)) {
            //j.setIcon(resizedIcon);
            j.setText("Free");
        } else if ("closed".equals(status) | "Closed".equals(status)) {
            //j.setIcon(resizedIcon);
            j.setText("close");
        } else if ("booked".equals(status) | "Booked".equals(status))  {
//            j.setIcon(icon1);
            j.setText("booked");
        }
    }

    public void actionPerformed(ActionEvent e) {
        Dimension buttonSize = tableButtons[0].getSize();
        System.out.println(buttonSize);
        for (int i = 0; i < tables.size(); i++) {
            if (e.getSource() == tableButtons[i]) {
                mainGUI.cardLayout.show(mainGUI.panel_R2, "Menu");
                mainGUI.setMenuPanelColor();
                menuPanel.setTableid("Table ("+tables.get(i).getTableStatus()+")" );
                menuPanel.setTableIDshow(""+tables.get(i).getId());
                menuPanel.setTotalcliked();
                menuPanel.setLabelOrder();
                //menuPanel2
            }

        }
        if (e.getSource() == bre) {
            //checkFoodBillInTable();
            db.loadTable();
            tables = db.getTable();
            for (int i = 0; i < tables.size(); i++){
                setStausTable(tableButtons[i], tables.get(i).getTableStatus());}
        }else if(e.getSource().equals(b1)){
            new Table_PopUp(this);
            db.addContactView(this);
        }
    }



    public static void main(String[] args) {
        new MainGUI();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("sdfsdfsdfewlrk");
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void refreshtable(ArrayList<Table> tables) {
        this.tables = tables;
        for (int i = 0; i < tables.size(); i++){
            setStausTable(tableButtons[i], tables.get(i).getTableStatus());}
    }

}