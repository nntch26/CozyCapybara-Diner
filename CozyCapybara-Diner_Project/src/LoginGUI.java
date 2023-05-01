


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;



public class LoginGUI implements ActionListener {
    private JFrame f;
    private JPanel panelLogin1,panelLogin2,panelLogin3,p1,p2,p3,pn,pi;
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton b1;

    public LoginGUI() {
        f = new JFrame();
        f.setTitle("Login");
        f.setSize(1024, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setResizable(false);
        f.setLocationRelativeTo(null); //แสดงหน้าต่างตรงกลาง


        panelLogin1 = new JPanel();
        panelLogin2 = new JPanel();
        panelLogin3 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        pi = new JPanel();
        pn = new JPanel();

        ///////// ชื่อร้าน /////////////
        JLabel welcome = new JLabel("WELCOME TO");
        JLabel welcome1 = new JLabel("COZY CAPYBARA DINER");
        welcome.setFont(new Font("Tahoma", Font.BOLD, 24)); // กำหนดแบบอักษร และขนาด
        welcome.setHorizontalAlignment(JTextField.CENTER);
        welcome1.setFont(new Font("Tahoma", Font.BOLD, 30)); // กำหนดแบบอักษร และขนาด
        welcome1.setHorizontalAlignment(JTextField.CENTER);

        //////////// รูปภาพ ///////////////////////
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("CozyCapybara-Diner_Project\\src\\imggui\\imgtest.jpg"));

        } catch (IOException e) {
            System.out.printf("Can't find the image, please check the path of the image.");
        }

        ImageIcon icon = new ImageIcon(img);
        // ปรับขนาดของรูปภาพ
        Image image = icon.getImage();
        Image reImage = image.getScaledInstance(530, 500, Image.SCALE_SMOOTH);
        // สร้าง ImageIcon จากรูปภาพที่ปรับขนาดแล้ว
        ImageIcon resizedIcon = new ImageIcon(reImage);
        // สร้าง JLabel และแสดงรูปภาพที่ปรับขนาดแล้ว
        JLabel labelimg = new JLabel(resizedIcon);
        




        p1.setPreferredSize(new Dimension(500, 100));
        p2.setPreferredSize(new Dimension(600, 100));


        p1.setLayout(new GridLayout(3,1));
        p2.setLayout(new GridLayout(2,1));
        p3.setLayout(new GridLayout(5,1));
        panelLogin1.setLayout(new FlowLayout());
        panelLogin2.setLayout(new FlowLayout());

        pi.setBackground(Color.decode("#FFDEAD"));





        JLabel lblUser = new JLabel("Username: ");
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        txtUser = new JTextField(20);
        txtUser.setPreferredSize(new Dimension(50, 30));

        JLabel lblPass = new JLabel("Password: ");
        lblPass.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        txtPass = new JPasswordField(20);
        txtPass.setPreferredSize(new Dimension(50, 30));

        b1 = new JButton("Login");
        b1.setForeground(Color.white);
        b1.setBackground(Color.DARK_GRAY);
        b1.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        b1.setPreferredSize(new Dimension(100, 40));
        b1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // กำหนดเส้นขอบ

        b1.addActionListener(this);

        //// กำหนดพื้นที่ภายใน
        pn.setPreferredSize(new Dimension(200, 150)); // พื้นที่ด้านบน

        //ADD THINGS

        p1.add(pn);
        p1.add(welcome);
        p1.add(welcome1);
        panelLogin1.add(lblUser);
        panelLogin1.add(txtUser);
        panelLogin2.add(lblPass);
        panelLogin2.add(txtPass);
        p2.add(panelLogin1);
        p2.add(panelLogin2);
        panelLogin3.add(b1);


        //ADD TO FRAME
        p3.add(pn);
        p3.add(p1);
        p3.add(p2);
        p3.add(panelLogin3);

        //pi.add(pn);
        pi.add(labelimg);

        f.add(p3, BorderLayout.EAST);
        f.add(pi);

        f.setVisible(true);
    }

    /////////////////// event //////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = txtUser.getText();
        String password = String.valueOf(txtPass.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Welcome " + username + "!");
            // เปิดหน้าต่าง Main ร้านอาหาร
            new MainGUI();
            f.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    
}
