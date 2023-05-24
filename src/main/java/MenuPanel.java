import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MenuPanel extends JPanel implements ActionListener, MouseListener {
    private JPanel pMenuLeftside, pOrderRightside, pOrderMenu, pMain, pShowTableID, pButton, pTotal, pShowMenu, pTopRightside;
    private JLabel[] menulabels, ordermenu, countmenushow;
    private JLabel tableid, totallabel, labelMenu, orderingMenu, labelCurrency;
    private JButton addmenu, refresh, checkBill;
    private JTextField tableIDshow, total;
    private Database db;
    private ArrayList<Menu> Menu;
    private ArrayList<Table> tables;
    private TablePanel tablePanel;
    private String setTextBill = "";
    private CheckBillGUI checkBillGUI;
    private Double sum = 0.0;

    public MenuPanel() {
        //DATABASE
        db = new Database();
        //PANEL
        pMenuLeftside = new JPanel(); //SUBMAIN LEFTSIDE
        pShowMenu = new JPanel(); //SHOW MENU CENTER LEFT SIDE
        pOrderRightside = new JPanel(); //SUBMAIN RIGHTSIDE
        pOrderMenu = new JPanel(); //CENTER OF SUBMAIN RIGHTSIDE
        pMain = new JPanel(); //MAIN PANEL
        pButton = new JPanel(); //BUTTON PANEL
        pTotal = new JPanel(); //TOTAL FOR PAY PANEL
        pShowTableID = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //SHOW TABLE ID PANEL (NORTH OF SUBMAIN RIGHT SIDE)
        pTopRightside = new JPanel(new BorderLayout());
        //JBUTTON
        checkBill = new JButton("CheckBill");
        addmenu = new JButton("Order Menu");
        //JLABEL
        labelMenu = new JLabel("Menu");
        totallabel = new JLabel("Total : ");
        orderingMenu = new JLabel("  Ordering Menu");
        tableid = new JLabel("Table ID");
        labelCurrency = new JLabel("฿");
        //JTEXTFIELD
        tableIDshow = new JTextField("1");
        total = new JTextField(10);
        tableIDshow.setEditable(false);
        total.setEditable(false);
        //JSCROLLPANE
        JScrollPane ScrollpLeft = new JScrollPane();
        JScrollPane ScrollpRight = new JScrollPane();

        //SUBMAIN LEFT SIDE
        db.loadTable();
        tables = db.getTable();
        pMenuLeftside.setLayout(new BorderLayout());
        setLabel(); //ADD MENU METHOD
        //CUSTOM
        Border PanelBorder = new EmptyBorder(15, 15, 15, 15);
        Border ptotalBorder = new EmptyBorder(5, 5, 5, 5);
        Border onlyBottom = new EmptyBorder(0, 0, 10, 0);
        Border GridBorder = BorderFactory.createLineBorder(Color.decode("#F14902"), 2);
        pMenuLeftside.setFont(new Font("Tahoma", Font.BOLD, 12));
        pMenuLeftside.setBorder(PanelBorder);
        pShowMenu.setBorder(BorderFactory.createCompoundBorder(GridBorder, PanelBorder));
        //BACKGROUND COLORS
        pShowMenu.setBackground(Color.decode("#F6E7D8"));
        pMenuLeftside.setBackground(Color.decode("#303030"));
        //TEXT COLORS
        labelMenu.setFont(new Font("Tahoma", Font.BOLD, 24)); // กำหนดแบบอักษร และขนาด
        labelMenu.setHorizontalAlignment(JTextField.CENTER);
        labelMenu.setForeground(Color.WHITE);
        labelMenu.setBorder(onlyBottom);
        //ScrollPane
        ScrollpLeft.setViewportView(pShowMenu);
        //ADD**
        pMenuLeftside.add(labelMenu, BorderLayout.NORTH);
        pMenuLeftside.add(ScrollpLeft, BorderLayout.CENTER);


        //SUBMAIN RIGHT SIDE
        pOrderRightside.setLayout(new BorderLayout());
        pOrderRightside.setBackground(Color.decode("#303030"));
        pOrderRightside.setBorder(PanelBorder);
        //ADD SHOW TABLE ID (NORTH OF SUBMAIN RIGHT SIDE)
        pTopRightside.add(orderingMenu, BorderLayout.WEST);
        pTopRightside.add(pShowTableID, BorderLayout.EAST);
        pTopRightside.setBackground(Color.decode("#303030"));
        pTopRightside.setBorder(onlyBottom);
        orderingMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
        orderingMenu.setForeground(Color.WHITE);
        tableid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pShowTableID.add(tableid);
        pShowTableID.add(tableIDshow);
        pShowTableID.setBackground(Color.decode("#303030"));
        tableid.setForeground(Color.WHITE);
        pOrderRightside.add(pTopRightside, BorderLayout.NORTH);

        //ORDER MENU (CENTER OF SUBMAIN RIGHT SIDE)
        pShowMenu.setLayout(new GridLayout(20, 1, 10, 10));
        pOrderMenu.setLayout(new GridLayout(20, 1, 10, 10));
        pOrderMenu.setBackground(Color.decode("#F6E7D8"));
        pOrderMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
        pOrderMenu.setBorder(BorderFactory.createCompoundBorder(GridBorder, PanelBorder));
        ScrollpRight.setViewportView(pOrderMenu);
        pOrderRightside.add(ScrollpRight, BorderLayout.CENTER);


        //ADD pTotal
        pTotal.setLayout(new FlowLayout(FlowLayout.LEFT));
        pTotal.add(totallabel);
        totallabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelCurrency.setFont(new Font("Tahoma", Font.PLAIN, 16));
        totallabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pTotal.add(total);
        pTotal.add(labelCurrency);
        pTotal.setBackground(Color.decode("#F6E7D8"));
        pTotal.setBorder(BorderFactory.createCompoundBorder(GridBorder, ptotalBorder));
        pOrderRightside.add(pTotal, BorderLayout.SOUTH);

        //ADD pButton
        pButton.setBackground(Color.decode("#303030"));
        pButton.setBorder(onlyBottom);
        addmenu.setPreferredSize(new Dimension(120, 40));
        checkBill.setPreferredSize(new Dimension(120, 40));
        checkBill.setFont(new Font("Tahoma", Font.BOLD, 14));
        addmenu.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkBill.setForeground(Color.WHITE);
        addmenu.setBackground(Color.decode("#F6E7D8"));
        checkBill.setBackground(Color.decode("#F14902"));
        pButton.add(addmenu);
        pButton.add(checkBill);

        //ADD ACTIONLISTENERS
        addmenu.addActionListener(this);
        checkBill.addActionListener(this);

        //MAIN PANEL
        pMain.setLayout(new GridLayout(1, 2));
        pMain.add(pMenuLeftside); //ADD SUBMAIN LEFT
        pMain.add(pOrderRightside); //ADD SUBMAIN RIGHT

        //THE MAINPAGE ADD
        setLayout(new BorderLayout());
        add(pMain, BorderLayout.CENTER); // ADD MAIN PANEL
        add(pButton, BorderLayout.SOUTH);// ADD pButton
    }

    public JTextField getTableIDshow() {
        return tableIDshow;
    }

    public void setTableIDshow(String id) {
        tableIDshow.setText(id);
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idtable = Integer.parseInt(tableIDshow.getText());
        Table t = db.searchTableById(idtable);
        if (e.getSource().equals(addmenu)) {
            db.setStatustable("" + t.getId(), "busy");
            tableid.setText("Table (busy)");
            pShowMenu.removeAll();
            setLabel();
//            pMenuLeftside.revalidate(); // Revalidate the panel
//            pMenuLeftside.repaint(); //
        } else if (e.getSource().equals(checkBill)) {

            t.getBill().countBill();
            setTextBill = "";
            HashMap<LinkedList<String>, Integer> countBill = t.getBill().getCountBill();
            sum = t.getBill().convertLinkedListToIntArray(t.getBill().getFoodBill());
            for (Map.Entry<LinkedList<String>, Integer> entry : countBill.entrySet()) {
                LinkedList<String> key = entry.getKey();
                Integer value = entry.getValue();
                String str = String.valueOf(key);
                String substring = str.substring(1, str.length() - 1);

                setTextBill += "   " + substring + "\t\t" + "x" + value + "\n";
            }

            checkBillGUI = new CheckBillGUI(this);
            checkBillGUI.getlabelTableID().setText("Table ID : " + idtable);
            checkBillGUI.getTotal().setText("Total : " + sum + " ฿");
            checkBillGUI.getCheckBill().addActionListener(this);
            checkBillGUI.getShowdetail().setText("");
            checkBillGUI.getShowdetail().setText(setTextBill);

        } else if (e.getSource().equals(checkBillGUI.getCheckBill())) {
            clearOrder();
        }
    }

    public void setLabel() { //ALL MENUS รายการอาหารทั้งหมด
        db.loadMenu();
        Menu = db.getMenu();
        pShowMenu.removeAll();
        menulabels = new JLabel[Menu.size()];
        countmenushow = new JLabel[Menu.size()];

        for (int i = 0; i < Menu.size(); i++) {
            menulabels[i] = new JLabel(Menu.get(i).getMenuName() + "         " + Menu.get(i).getMenuPrice());
            pShowMenu.add(menulabels[i]);
            menulabels[i].setFont(new Font("Tahoma", Font.BOLD, 14));
            menulabels[i].addMouseListener(this);
        }
        revalidate();
        repaint();
    }

    public void setLabelOrder() {
        pOrderMenu.removeAll();
        ordermenu = new JLabel[Menu.size()];
        int idtable = Integer.parseInt(tableIDshow.getText());
        Table t = db.searchTableById(idtable);
        if (t != null) {
            t.getBill().countBill();
            HashMap<LinkedList<String>, Integer> countBill = t.getBill().getCountBill();
            int i = 0;
            for (LinkedList<String> key : countBill.keySet()) {
                String str = String.valueOf(key);
                String substring = str.substring(1, str.length() - 1);
                ordermenu[i] = new JLabel(substring + "");
                countmenushow[i] = new JLabel(substring + " x" + countBill.get(key));
                pOrderMenu.add(countmenushow[i]);
                countmenushow[i].setFont(new Font("Tahoma", Font.BOLD, 14));
                countmenushow[i].addMouseListener(this);
                i++;
            }
        } else if (t == null) {
            pOrderMenu.removeAll();
        }
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int idtable = Integer.parseInt(tableIDshow.getText());
        Table t = db.searchTableById(idtable);
        LinkedList<String> tempBilltable = t.getBill().getFoodBill();
        for (int i = 0; i < Menu.size(); i++) {
            if (e.getSource() == countmenushow[i]) {
                tempBilltable.remove(ordermenu[i].getText());
                sum = t.getBill().convertLinkedListToIntArray(t.getBill().getFoodBill());
                total.setText(sum + "");
                setLabelOrder();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(Menu.size());
        for (int i = 0; i < Menu.size(); i++) {
            if (e.getSource() == menulabels[i]) {
                Table t = db.searchTableById(Integer.parseInt(tableIDshow.getText()));
                t.getBill().addFoodToBill(menulabels[i].getText());

                setTotalcliked();
                System.out.println(t.getBill().getFoodBill());

//                if (t.getBill().getFoodBill().size()==1){
//                    db.setStatustable(tableIDshow.getText()+"", "busy");
//                }

                setLabelOrder();

            }
        }
    }

    public void setTotalcliked(){
        Table t = db.searchTableById(Integer.parseInt(tableIDshow.getText()));
        Double sum = t.getBill().convertLinkedListToIntArray(t.getBill().getFoodBill());
        total.setText(sum + "");
    }

    public void clearOrder(){
        int idtable = Integer.parseInt(tableIDshow.getText());
        Table t = db.searchTableById(idtable);
        System.out.println("in in in ");
        t.getBill().setFoodBill(new LinkedList<>());
        System.out.println("smfoe");
        db.clearTable(""+t.getId());
        tableid.setText("Table (free)");
        pOrderMenu.removeAll();
        setTotalcliked();
        setLabelOrder();
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //SETTER GETTER HERE
    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getSetTextBill() {
        return setTextBill;
    }

    public void setSetTextBill(String setTextBill) {
        this.setTextBill = setTextBill;
    }

    public void setTableid(String setTextTable) {
        tableid.setText(setTextTable);
    }


}
    

