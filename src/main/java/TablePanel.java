//import DBJava.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TablePanel extends JPanel implements ActionListener, WindowListener, Refreshable {
    public JPanel Table_show, Table_butpanel, txtback;
    public JButton[] tableButtons;
    public JButton b1, b2, bre;
    public JScrollPane s;
    private ArrayList<Table> tables;
    private Database db;
    private MainGUI mainGUI;
    private MenuPanel menuPanel;
    private ArrayList<java.awt.Menu> Menu ;
    public TablePanel(MainGUI mainGUI,MenuPanel menuPanel) {
        //////////// รูปภาพ ///////////////////////
        ImageIcon icon = new ImageIcon("src/main/resources/imggui/imgtest.jpg");
        // ปรับขนาดของรูปภาพ
        Image image = icon.getImage();
        Image reImage = image.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        // สร้าง ImageIcon จากรูปภาพที่ปรับขนาดแล้ว
        ImageIcon resizedIcon = new ImageIcon(reImage);

        Table_butpanel = new JPanel();
        Table_show = new JPanel();
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
        Table_show.setLayout(new GridLayout(3, 3, 5, 5));
        System.out.println(tables.size());
        tableButtons = new JButton[tables.size()];
        for (int i = 0; i < tables.size(); i++) {
            tableButtons[i] = new JButton(resizedIcon);
            tableButtons[i].addActionListener(this);
            Table_show.add(tableButtons[i]);
            tableButtons[i].setPreferredSize(new Dimension(200, 175));
            tableButtons[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            setStausTable(tableButtons[i], tables.get(i).getTableStatus());
            tableButtons[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));
        }
        add(Table_show, BorderLayout.CENTER);
        Table_show.setBackground(Color.decode("#FFDEAD"));

        //bupanel 
        Table_butpanel.setLayout(new FlowLayout());

        b1 = new JButton("Free Table");
        b2 = new JButton("Busy Table");
        bre = new JButton("REFRESH");
        b1.setPreferredSize(new Dimension(240, 100));
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBackground(Color.decode("#deba83"));
        b1.setVerticalAlignment(SwingConstants.TOP);
        b1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));
        b2.setPreferredSize(new Dimension(240, 100));
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBackground(Color.decode("#deba83"));
        b2.setVerticalAlignment(SwingConstants.TOP);
        b2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));
        bre.setPreferredSize(new Dimension(240, 100));
        bre.setFont(new Font("Tahoma", Font.BOLD, 12));
        bre.setBackground(Color.decode("#deba83"));
        bre.setVerticalAlignment(SwingConstants.TOP);
        bre.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));
        bre.addActionListener(this);
        b1.addActionListener(this);
        Table_butpanel.add(b1);
        Table_butpanel.add(bre);
        Table_butpanel.add(b2);
        Table_butpanel.setBackground(Color.decode("#FFDEAD"));
        add(Table_butpanel, BorderLayout.SOUTH);

    }

    public void setStausTable(JButton j, String status) {
        if ("busy".equals(status)) {
            System.out.println("seetsss");
             j.setBackground(Color.red);
        } else if ("free".equals(status)) {
            j.setBackground(Color.green);
        } else if ("close".equals(status)) {
            j.setBackground(Color.gray);
        } else if ("booked".equals(status)) {

            j.setBackground(Color.yellow);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < tables.size(); i++) {
            if (e.getSource() == tableButtons[i]) {
                mainGUI.cardLayout.show(mainGUI.panel_R2, "Menu");
                menuPanel.setTableIDshow(""+tables.get(i).getId());
                menuPanel.setlabelorder();
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
   
//    public void checkFoodBillInTable(){
//        
//        Table t;
//        tables = menuPanel.getTables();
//        for (int i = 0; i < tables.size(); i++){
//            t = tables.get(i);
//            if (!t.getBill().getFoodBill().isEmpty() & !t.getTableStatus().equals("booked")){
//                db.setStatustable(t.getId()+"", "busy");
//            }else if(t.getBill().getFoodBill().isEmpty()& !t.getTableStatus().equals("booked")){
//                System.out.println("in");
//                db.setStatustable(t.getId()+"","free");
//            }
//            
//        }
//        }
        

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
            //System.out.println(tables.get(i).getId()+ "   in loop set"+tables.get(i).getTableStatus());
            setStausTable(tableButtons[i], tables.get(i).getTableStatus());}
        }
    
}
