import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailFrame extends JFrame implements ActionListener {

    private JLabel label1;
    private JLabel labelIdCustomer, labelName, labelTelCustomer, labelEmail, labelPoint;
    private JTextField tfIdCustomer, tfName, tfTelCustomer, tfEmail, tfPoint;
    private JButton saveButton, closeButton;

    public DetailFrame() {
        setTitle("Member");
        label1 = new JLabel("Member From");

        // Label Add Member
        label1.setBounds(100,20,200,30);
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("Tahoma", Font.BOLD, 24)); // กำหนดแบบอักษร และขนาด


        labelName = new JLabel("Name: ");
        labelTelCustomer = new JLabel("TelCustomer: ");
        labelEmail = new JLabel("Email: ");
        labelPoint = new JLabel("Points: ");

        tfName = new JTextField();
        tfTelCustomer = new JTextField();
        tfEmail = new JTextField();
        tfPoint = new JTextField();

        saveButton = new JButton("Save");
        closeButton = new JButton("Close");

        saveButton = new JButton("Save");
        saveButton.setForeground(Color.white);
        saveButton.setBackground(Color.DARK_GRAY);
        saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        closeButton = new JButton("Close");
        closeButton.setForeground(Color.white);
        closeButton.setBackground(Color.DARK_GRAY);
        closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));


        //SETBOUNDS LABEL
        labelName.setBounds(50,100,200,30);
        labelTelCustomer.setBounds(50,140,200,30);
        labelEmail.setBounds(50,180,200,30);
        labelPoint.setBounds(50,220,200,30);

        //SETBOUNDS TEXTFIELD
        tfName.setBounds(160,100,150,30);
        tfTelCustomer.setBounds(160,140,150,30);
        tfEmail.setBounds(160,180,150,30);
        tfPoint.setBounds(160,220,150,30);

        //SETBOUNDS BUTTONS
        saveButton.setBounds(140,290,75,30);
        closeButton.setBounds(230,290,75,30);

        //FRAME ADD
        add(label1);
        add(labelName);
        add(labelTelCustomer); add(labelEmail); add(labelPoint);
        add(tfName); add(tfTelCustomer);
        add(tfEmail); add(tfPoint);
        add(saveButton); add(closeButton);

        //ADD ACTIONLISTENER
        saveButton.addActionListener(this);
        closeButton.addActionListener(this);

        //FRAME SETTINGS
        setLayout(null);
        setResizable(false);
        setSize(370, 450);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MemberPanel member = new MemberPanel();
        if (e.getSource()== saveButton){
            // เก็บข้อมูลที่กรอกเข้าไป
            String name = tfName.getText();
            String phone = tfTelCustomer.getText();
            String email = tfEmail.getText();
            String pointString = tfPoint.getText();
            int point = Integer.parseInt(pointString);
            member.addMember(name,phone,email,point); // เพิ่มข้อมูลใหม่

        }else if (e.getSource() == closeButton){
            member.setTable();
            dispose();


        }

    }

}
