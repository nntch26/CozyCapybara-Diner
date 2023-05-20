
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;

public class CheckBillGUI implements ActionListener, WindowListener {
    private JFrame frame;
    private JPanel pTop, pShowNameCustomer, pMemberPhoneNum, pButton_Last, pCenter, pMoneyCal, pSubCenter;
    private JLabel labelTableID, namecus, totalJlable, phonemem, total, labelMoney, changeLabel;
    private JTextField tfTableID, tfGetCustomerName, tfGetPhoneNum, tfGetMoney;
    private JButton btn_FindMember, btn_UsePoint, btn_CheckBill, btn_Calculate;
    private JTextArea showdetail;
    private MenuPanel menuPanel;
    private Database db;
    private ArrayList<Member> member;

    private Double totalnum, change, pointuse;
    private Exchange exchange;
    private Member mem;

    public CheckBillGUI(MenuPanel menuPanel) {
        frame = new JFrame("Check Bill");
        db = new Database();
        // JPANEL
        pTop = new JPanel();
        pShowNameCustomer = new JPanel();
        pSubCenter = new JPanel();
        pMoneyCal = new JPanel();
        pMemberPhoneNum = new JPanel();
        pCenter = new JPanel();
        pButton_Last = new JPanel();
        this.menuPanel = menuPanel;
        // JLABEL
        labelTableID = new JLabel("Table ID");
        labelMoney = new JLabel("Money");
        namecus = new JLabel("Customer Name:");
        phonemem = new JLabel("Phone");
        total = new JLabel("total");
        changeLabel = new JLabel("Change");
        // JTEXTFIELD
        tfTableID = new JTextField(7);
        tfGetCustomerName = new JTextField("customer", 8);
        tfGetPhoneNum = new JTextField(7);
        tfGetMoney = new JTextField(8);
        // TEXTAREA
        showdetail = new JTextArea();
        showdetail.setSize(250, 100);
        // BUTTER เอ้ย BUTTON
        btn_FindMember = new JButton("find");
        btn_UsePoint = new JButton("UsePoint");
        btn_CheckBill = new JButton("CheckBill");
        btn_Calculate = new JButton("Calculate");

        // SET ENABLED
        btn_UsePoint.setEnabled(false);
        // tfGetCustomerName.setEditable(false);

        // NORTH PANEL
        pTop.setLayout(new BorderLayout());
        pTop.add(labelTableID, BorderLayout.NORTH); // ADD LABEL
        labelTableID.setHorizontalAlignment(JLabel.CENTER);
        // SHOW NAME CUSTOMER ***IN NORTH PANEL***
        pShowNameCustomer.add(namecus);
        pShowNameCustomer.add(tfGetCustomerName);
        pTop.add(pShowNameCustomer, BorderLayout.CENTER);
        // ADD BILL HERE
        pTop.add(showdetail, BorderLayout.SOUTH);

        // CENTER PANEL
        pCenter.setLayout(new BorderLayout());
        pCenter.add(total, BorderLayout.NORTH);
        total.setHorizontalAlignment(JLabel.CENTER);
        pCenter.add(pSubCenter, BorderLayout.CENTER);
        pCenter.add(pMemberPhoneNum, BorderLayout.SOUTH);
        // ***PHONE NUMBER PANEL***
        pMemberPhoneNum.setLayout(new FlowLayout());
        pMemberPhoneNum.add(phonemem);
        pMemberPhoneNum.add(tfGetPhoneNum);
        pMemberPhoneNum.add(btn_FindMember);
        // *** MONEY PANEL ***
        pMoneyCal.add(labelMoney);
        pMoneyCal.add(tfGetMoney);
        pMoneyCal.add(btn_Calculate);
        // PANEL เก็บ MONEY PANEL, เก็บ CHANGE (เงินทอน)
        pSubCenter.setLayout(new BorderLayout());
        pSubCenter.add(pMoneyCal, BorderLayout.NORTH);
        pSubCenter.add(changeLabel, BorderLayout.CENTER);
        changeLabel.setHorizontalAlignment(JLabel.CENTER);

        // totalnum = จำนวนเงินที่ต้องจ่าย
        totalnum = menuPanel.getSum();
        Exchange exchange = new Exchange() {
            @Override
            public double calculate(double total) { // คำนวณตังว่ารับมาพอจ่ายไหม
                if (Double.parseDouble(tfGetMoney.getText()) - totalnum < 0) {
                    JOptionPane.showMessageDialog(null, " minas");
                    return 0;
                }
                return Double.parseDouble(tfGetMoney.getText()) - totalnum;
            }
        };

        // กำหนดค่าให้กับตัวแปร calculator ใน CheckBillGUI
        this.setCalculator(exchange);

        // BUTTON PANEL PAY MONEY
        pButton_Last.add(btn_UsePoint);
        pButton_Last.add(btn_CheckBill);

        // ADD ACTION & WINDOW LISTENER
        frame.addWindowListener(this);
        btn_CheckBill.addActionListener(this);
        btn_FindMember.addActionListener(this);
        btn_UsePoint.addActionListener(this);
        btn_Calculate.addActionListener(this);

        // FRAME
        frame.setLayout(new BorderLayout());
        frame.add(pTop, BorderLayout.NORTH);
        frame.add(pCenter, BorderLayout.CENTER);
        frame.add(pButton_Last, BorderLayout.SOUTH);

        frame.setSize(250, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {
        MenuPanel menuPanel = new MenuPanel();
        new CheckBillGUI(menuPanel);
    }

    public void setCalculator(Exchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(mem);
        if (e.getSource().equals(btn_FindMember)) {
            totalnum = menuPanel.getSum();
            mem = db.searchmemberByphone(tfGetPhoneNum.getText());
            if (mem == null) {
                System.out.println("not found");
            } else {
                btn_UsePoint.setEnabled(true);

                total.setText("Total " + mem.culculatetotal(totalnum));
                totalnum = mem.culculatetotal(totalnum);
                JOptionPane.showMessageDialog(null, "" + mem.getInfocustomer(), "alert", JOptionPane.PLAIN_MESSAGE);

                tfGetCustomerName.setText(mem.getName());
                System.out.println(mem.getInfocustomer());
            }
        } else if (e.getSource().equals(btn_Calculate)) {
            tfGetMoney.getText();
            System.out.println(totalnum);
            // เช็คตรงนี้
            Double Ex = exchange.calculate(totalnum);
            ;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String formattedEx = String.format("%.2f", Ex);
            changeLabel.setText("Change " + formattedEx);
        } else if (e.getSource().equals(btn_CheckBill)) {
            if (mem != null & !(showdetail.getText().isEmpty())) {
                mem.culculatePoint(totalnum);

                db.memSetPoint(mem);
                System.out.println("After " + mem.getPoint());
                JOptionPane.showMessageDialog(null, "" + mem.getInfocustomer(), "Check Bill",
                        JOptionPane.PLAIN_MESSAGE);
                mem = null;
                frame.dispose();
            } else if (mem == null & !(showdetail.getText().isEmpty())) {
                Guest g = new Guest(tfGetCustomerName.getText());
                JOptionPane.showMessageDialog(null, "" + g.getInfocustomer() + " Check bill", "Check Bill",
                        JOptionPane.PLAIN_MESSAGE);

                frame.dispose();
            }
        } else if (e.getSource().equals(btn_UsePoint)) {
            System.out.println(menuPanel.getSum());
            if (mem.getPoint() > menuPanel.getSum()) {
                pointuse = menuPanel.getSum();
                int x = JOptionPane.showConfirmDialog(null, mem.getInfocustomer() + "You use point " + pointuse,
                        "choose one", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("User clicked button " + x);
                if (x == 0) {
                    mem.usePoint(pointuse);
                    JOptionPane.showMessageDialog(null, "" + mem.getInfocustomer() + " Have Point", "Point",
                            JOptionPane.PLAIN_MESSAGE);
                    db.memSetPoint(mem);
                    frame.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "" + mem.getInfocustomer() + " Have Point",
                        "member don't have Point", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public JButton getCheckBill() {
        return btn_CheckBill;
    }

    public void setCheckBill(JButton checkBill) {
        this.btn_CheckBill = checkBill;
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

    public JFrame getF() {
        return frame;
    }

    public void setF(JFrame f) {
        this.frame = f;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public JTextField gettfTableID() {
        return tfTableID;
    }

    public void settfTableID(JTextField tfTableID) {
        this.tfTableID = tfTableID;
    }

    public JLabel getlabelTableID() {
        return labelTableID;
    }

    public void setlabelTableID(JLabel labelTableID) {
        this.labelTableID = labelTableID;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("555");
        db.loadMember();
        member = db.getMember();
        System.out.println(member);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        mem = null;
        frame.dispose();
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
