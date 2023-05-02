import java.awt.*;
import javax.swing.*;

public class MemPanel extends JPanel {
    public JPanel p1, p2, puser, ppass, pamain, p1_1, p1_2, pn;
    public JLabel userText, passText;
    public JPasswordField pass;
    public JTextField user;
    public JButton login, cancel;
    public MemPanel() {
        p1 = new JPanel(); p2 = new JPanel();
        p1_1 = new JPanel(); p1_2 = new JPanel();
        puser = new JPanel(); ppass = new JPanel(); pn = new JPanel();
        
        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));
        setLayout(new BorderLayout());

        p1.setLayout(new GridLayout(2,1));

        /////พื้นที่เหลือด้ายล่าง/////////
        p1_2.setLayout(null);
        p1_2.setBackground(Color.decode("#deba83"));
        
        /////หน้าใส่ข้อมูล/////////
        p1_1.setLayout(new GridLayout(3, 1));
        p1_1.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.decode("#deba83")));
        pn.setPreferredSize(new Dimension(0, 100));

        userText = new JLabel("UserName : "); passText = new JLabel("Password : ");
        user = new JTextField(20); pass = new JPasswordField(20);

        userText.setFont(new Font("Tahoma", Font.BOLD, 16));
        passText.setFont(new Font("Tahoma", Font.BOLD, 16));
        user.setPreferredSize(new Dimension(50, 30));
        pass.setPreferredSize(new Dimension(50, 30));

        puser.setBackground(Color.decode("#deba83"));
        ppass.setBackground(Color.decode("#deba83"));
        pn.setBackground(Color.decode("#deba83"));
        puser.setLayout(new FlowLayout()); 
        ppass.setLayout(new FlowLayout());

        puser.add(userText); puser.add(user);
        ppass.add(passText); ppass.add(pass);


        /////หน้าปุ่ม////////
        p2.setLayout(new FlowLayout());
        p2.setBackground(Color.decode("#deba83"));


        login = new JButton("Login"); cancel = new JButton("Cancel");

        login.setForeground(Color.white);
        login.setBackground(Color.DARK_GRAY);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        login.setPreferredSize(new Dimension(100, 40));
        login.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 

        cancel.setForeground(Color.white);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        cancel.setPreferredSize(new Dimension(100, 40));
        cancel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 

        p2.add(login);
        p2.add(Box.createRigidArea(new Dimension(10,0)));
        p2.add(cancel);



        ////add thing/////
        p1.add(p1_1);
        p1.add(p1_2);
        p1_1.add(pn);
        p1_1.add(puser);
        p1_1.add(ppass);
        add(p1);
        add(p2, BorderLayout.SOUTH);
        
    }
}