
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;


public class CheckBillGUI implements ActionListener, WindowListener{
    private JFrame f;
    private JPanel pshowTop,pshownamecus, pallmember, panelcheckbill, panelcenter;
    private JLabel tablelaJlable, namecus, totalJlable, phonemem, total;
    private JTextField tableid, namecusshow, getphonemem;
    private JButton findmem, usePoint, checkBill;
    private JTextArea showdetail;
    private MenuPanel menuPanel;
    private Database db;
    private ArrayList<Member> member;
    public CheckBillGUI(MenuPanel menuPanel){
        f = new JFrame("Check Bill");
        pshowTop = new JPanel();
        pshownamecus = new JPanel();
        this.menuPanel = menuPanel;
        tablelaJlable = new JLabel("Table ID");
        pallmember = new JPanel();
        tableid = new JTextField(7);
        db = new Database();
        panelcenter = new JPanel();
        panelcheckbill = new JPanel();
        namecusshow = new JTextField("customer",8);
        namecus = new JLabel("namecustomer");
        phonemem = new JLabel("Phone");
        total = new JLabel("total");
        getphonemem = new JTextField(7);
        findmem = new JButton("find");
        usePoint = new JButton("usePoint");
        checkBill = new JButton("checkBill");
        showdetail = new JTextArea();
        
        showdetail.setSize(250, 100);
//        namecusshow.setEditable(false);
        
        pshowTop.setLayout(new BorderLayout());
        pshowTop.add(tablelaJlable, BorderLayout.NORTH);
        tablelaJlable.setHorizontalAlignment(JLabel.CENTER);
         
        pshowTop.add(showdetail, BorderLayout.SOUTH);
                
        
        pshownamecus.add(namecus);
        pshownamecus.add(namecusshow);
        pshowTop.add(pshownamecus, BorderLayout.CENTER);
        
        panelcenter.setLayout(new BorderLayout());
        pallmember.setLayout(new FlowLayout());
        pallmember.add(phonemem);
        pallmember.add(getphonemem);
        pallmember.add(findmem);
        panelcenter.add(total, BorderLayout.NORTH);
        total.setHorizontalAlignment(JLabel.CENTER);
        panelcenter.add(pallmember, BorderLayout.CENTER);
        usePoint.setEnabled(false);
       
        panelcheckbill.add(usePoint);
        panelcheckbill.add(checkBill);
        f.addWindowListener(this);
        checkBill.addActionListener(this);
        findmem.addActionListener(this);
        f.setLayout(new BorderLayout());
        f.add(pshowTop, BorderLayout.NORTH);
        f.add(panelcenter, BorderLayout.CENTER);
        f.add(panelcheckbill, BorderLayout.SOUTH);
        f.setSize(300, 250);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        MenuPanel menuPanel = new MenuPanel();
        new CheckBillGUI(menuPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(findmem)){
            Member mem = db.searchmemberByphone(getphonemem.getText());
            if (mem == null){
                System.out.println("not found");
            }else{
                usePoint.setEnabled(true);
                total.setText("Total "+ mem.culculatetotal(menuPanel.getSum()));
                JOptionPane.showMessageDialog(null, "Name "+mem.getName()+" have Point "+mem.getPoint(), "alert", JOptionPane.PLAIN_MESSAGE);
                System.out.println(menuPanel.getSum());
                
                namecusshow.setText(mem.getName());
            System.out.println(mem.getInfocustomer());}
        }
    }

    public JButton getCheckBill() {
        return checkBill;
    }

    public void setCheckBill(JButton checkBill) {
        this.checkBill = checkBill;
    }

    public JTextArea getShowdetail() {
        return showdetail;
    }

    public void setShowdetail(JTextArea showdetail) {
        this.showdetail = showdetail;
    }

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public JTextField getTableid() {
        return tableid;
    }

    public void setTableid(JTextField tableid) {
        this.tableid = tableid;
    }

    public JLabel getTablelaJlable() {
        return tablelaJlable;
    }

    public void setTablelaJlable(JLabel tablelaJlable) {
        this.tablelaJlable = tablelaJlable;
    }
    

    @Override
    public void windowOpened(WindowEvent e){
        System.out.println("555");
        db.loadMember();
        member = db.getMember();
        System.out.println(member);
        
        
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        showdetail.setText("");
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
    
    
}
