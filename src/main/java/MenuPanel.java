//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener, MouseListener{
        private JPanel pmenu, porderborder, pordermenu, pback, pshowtableid, toolpanel, totalpanel;
        private JLabel[] menulabels;
        private JLabel[] ordermenu, countmenushow;
        private JLabel tableid, totallabel;
        private JButton addmenu,refresh,checkBill;
        private  JTextField tableIDshow, total;
        private Database db;
        private ArrayList<Menu> Menu;
        private ArrayList<Table> tables;
        private TablePanel tablePanel;
        private String setTextBill = "";
        private CheckBillGUI checkBillGUI;
        private Double sum = 0.0;
        public MenuPanel() {
        pmenu = new JPanel();
        db = new Database();
        pback = new JPanel();
        
        toolpanel = new JPanel();
        totalpanel = new JPanel();
        pshowtableid = new JPanel();
        checkBill = new JButton("CheckBill");
        totallabel = new JLabel("Total");
        total = new JTextField(7);
        tableid = new JLabel("Table ID");
        tableIDshow = new JTextField("1");
        porderborder = new JPanel();
        pordermenu = new JPanel();
        //left panel menulist
        //tables = db.getTable();
        db.loadTable();
        tables = db.getTable();
        setlabel();
        
        //right panel table ordermenu
        porderborder.setLayout(new BorderLayout());
        pshowtableid.add(tableid);
        pshowtableid.add(tableIDshow);
        porderborder.add(pshowtableid, BorderLayout.NORTH);
        pordermenu.setLayout(new GridLayout(30,1));
        porderborder.add(pordermenu, BorderLayout.CENTER);
        totalpanel.setLayout(new FlowLayout());
        totalpanel.add(totallabel);
        totallabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        totalpanel.add(total);
        porderborder.add(totalpanel, BorderLayout.SOUTH);
        addmenu = new JButton("order Menu");
        addmenu.addActionListener(this);
        pback.setLayout(new GridLayout(1,2));
        pback.add(pmenu);
        pback.add(porderborder);
        //toolpanel
        toolpanel.add(addmenu);
        toolpanel.add(checkBill);
        
        checkBill.addActionListener(this);
        setLayout(new BorderLayout());
        add(pback, BorderLayout.CENTER);
        
        add(toolpanel, BorderLayout.SOUTH);
    }

    public JTextField getTableIDshow() {
        return tableIDshow;
    }

    public  void setTableIDshow(String id) {
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
        if(e.getSource().equals(addmenu)){
            db.setStatustable(""+t.getId(), "busy");
            pmenu.removeAll();
            
            setlabel();
        }else if(e.getSource().equals(checkBill)){
          
            t.getBill().countBill();
            setTextBill = "";
            HashMap<LinkedList<String>, Integer> countBill = t.getBill().getCountBill();
            sum = t.getBill().convertLinkedListToIntArray(t.getBill().getFoodBill());
            for (Map.Entry<LinkedList<String>, Integer> entry : countBill.entrySet()) {
            LinkedList<String> key = entry.getKey();
            Integer value = entry.getValue();
                String str = String.valueOf(key);
                String substring = str.substring(1, str.length() - 1);
           
                setTextBill += "\t"+ substring + "   amount: " + value + "\n"; 
}
            
             checkBillGUI = new CheckBillGUI(this);
             checkBillGUI.getTablelaJlable().setText("Table ID  " + idtable);
             checkBillGUI.getTotal().setText("Total "+sum);
             checkBillGUI.getCheckBill().addActionListener(this);
             checkBillGUI.getShowdetail().setText("");
            checkBillGUI.getShowdetail().setText(setTextBill);
            db.setStatustable(""+t.getId(),"free");
        }else if(e.getSource().equals(checkBillGUI.getCheckBill())){
            t.getBill().setFoodBill(new LinkedList<>());
            System.out.println("smfoe");
            pordermenu.removeAll();
            setlabelorder();
        }
     
    }

    public String getSetTextBill() {
        return setTextBill;
    }

    public void setSetTextBill(String setTextBill) {
        this.setTextBill = setTextBill;
    }
    public void setlabel(){
        
        db.loadMenu();
        
        Menu = db.getMenu();
        pmenu.removeAll();
        menulabels = new JLabel[Menu.size()];
        countmenushow = new JLabel[Menu.size()];
        pmenu.setLayout(new GridLayout(20, 1, 10 ,10));
        
        for (int i = 0; i < Menu.size(); i++) {
            menulabels[i] = new JLabel(Menu.get(i).getMenuName() + "   " + Menu.get(i).getMenuPrice());
            pmenu.add(menulabels[i]);
            menulabels[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            menulabels[i].addMouseListener(this);
        }
//        pmenu.setBackground(Color.red);
//        pmenu.setOpaque(true);
        revalidate();
        repaint();
    }
    public void setlabelorder(){
    pordermenu.removeAll();
    ordermenu = new JLabel[Menu.size()];
    int idtable = Integer.parseInt(tableIDshow.getText());
    Table t = db.searchTableById(idtable);
    if (t != null) {
        t.getBill().countBill();
        HashMap<LinkedList<String>, Integer> countBill = t.getBill().getCountBill();
        pordermenu.setLayout(new GridLayout(30, 2));
        int i = 0;
        for (LinkedList<String> key : countBill.keySet()) {
            String str = String.valueOf(key);
            String substring = str.substring(1, str.length() - 1);
            ordermenu[i] = new JLabel(substring+"");
            countmenushow[i] = new JLabel(substring+"     "+countBill.get(key));
            pordermenu.add(countmenushow[i]);
            countmenushow[i].addMouseListener(this);
            i++;

        }
    }else if(t == null){
                pordermenu.removeAll();
                }

    revalidate();
    repaint();
}
    
    @Override
    public void mouseClicked(MouseEvent e) {
    int idtable = Integer.parseInt(tableIDshow.getText());
    Table t = db.searchTableById(tables.get(idtable-1));
    LinkedList<String> tempBilltable = t.getBill().getFoodBill();
    for (int i = 0; i < Menu.size(); i++) {
        if (e.getSource() == countmenushow[i]) {
            tempBilltable.remove(ordermenu[i].getText());
            sum = t.getBill().convertLinkedListToIntArray(t.getBill().getFoodBill());
            total.setText(sum+"");
            setlabelorder();
        }
    }
    if(e.getSource().equals(addmenu)){
        pordermenu.removeAll();
        revalidate();
        repaint();
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
                
                Double sum = t.getBill().convertLinkedListToIntArray(t.getBill().getFoodBill());
                total.setText(sum+"");
                System.out.println(t.getBill().getFoodBill());
                
//                if (t.getBill().getFoodBill().size()==1){
//                    db.setStatustable(tableIDshow.getText()+"", "busy");
//                }
                
                setlabelorder();
                
            }
        } 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
        
}
    

