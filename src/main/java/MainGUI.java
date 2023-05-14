import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI implements ActionListener {
    private JFrame f;
    private JPanel panel_L1, panel_L2, pn, panel_R1, panel_R2;
    private JButton b1, b2, b3, b4, bAdmin;
    private JLabel l1;
    private CardLayout cardLayout;

    public MainGUI() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1024, 600);
        f.setResizable(false);
        f.setLocationRelativeTo(null); //แสดงหน้าต่างตรงกลาง

        // สร้าง CardLayout
        cardLayout = new CardLayout();
        panel_R2 = new JPanel(cardLayout);

        // สร้าง Panels จากคลาสอื่น
        JPanel menuPanel = new MenuPanel();
        JPanel contactPanel = new MemPanel();
        JPanel tablePanel = new TablePanel();


        panel_L1 = new JPanel();
        panel_L2 = new JPanel();
        panel_R1 = new JPanel();
        pn = new JPanel();
        l1 = new JLabel("WELCOME");


        ////////////////// ปรับแต่งปุ่ม /////////////////////////

        b1 = new JButton("Table");
        b1.setForeground(Color.white);
        b1.setBackground(Color.DARK_GRAY);
        b1.setPreferredSize(new Dimension(200, 50));
        b1.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        b1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // กำหนดเส้นขอบ

        b2 = new JButton("Order");
        b2.setForeground(Color.white);
        b2.setBackground(Color.DARK_GRAY);
        b2.setPreferredSize(new Dimension(200, 50));
        b2.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        b2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // กำหนดเส้นขอบ

        b3 = new JButton("MemberShip");
        b3.setForeground(Color.white);
        b3.setBackground(Color.DARK_GRAY);
        b3.setPreferredSize(new Dimension(200, 50));
        b3.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        b3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // กำหนดเส้นขอบ

        b4 = new JButton("Logout");
        b4.setForeground(Color.white);
        b4.setBackground(Color.DARK_GRAY);
        b4.setPreferredSize(new Dimension(200, 50));
        b4.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        b4.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // กำหนดเส้นขอบ

        bAdmin = new JButton("Admin");
        bAdmin.setForeground(Color.white);
        bAdmin.setBackground(Color.DARK_GRAY);
        bAdmin.setPreferredSize(new Dimension(200, 50));
        bAdmin.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดแบบอักษร และขนาด
        bAdmin.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // กำหนดเส้นขอบ


        //////////// event /////////////////////
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        bAdmin.addActionListener(this);


        // layout
        f.setLayout(new BorderLayout());
        panel_L1.setLayout(new BorderLayout());
        //p2.setLayout(new GridLayout(4,1));

        // Panel
        panel_L2.setBackground(Color.DARK_GRAY);
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 56)); // กำหนดแบบอักษร และขนาด
        panel_R1.add(l1);


        // ขนาด Panel
        panel_L1.setPreferredSize(new Dimension(200, 100));

        //// กำหนดพื้นที่ภายใน
        panel_L1.add(pn, BorderLayout.NORTH);
        pn.setPreferredSize(new Dimension(200, 150)); // พื้นที่ด้านบน
        pn.setBackground(Color.DARK_GRAY);


        /////////////// เพิ่มเมนู /////////////////////

        panel_L2.add(b1);
        panel_L2.add(b2);
        panel_L2.add(b3);
        panel_L2.add(bAdmin);
        panel_L2.add(b4);
        panel_L1.add(panel_L2);


        // เพิ่มคลาสอื่น หน้าต่างอื่น ลง Panel CardLayou
        panel_R2.add(panel_R1, "Home");
        panel_R2.add(tablePanel, "Table");
        panel_R2.add(menuPanel, "Menu");
        panel_R2.add(contactPanel, "Member");

        f.add(panel_L1, BorderLayout.WEST);

        //f.add(panel_R1);
        f.add(panel_R2);
        //f.setContentPane(panel_R11);
        f.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            cardLayout.show(panel_R2, "Table");
        } else if (e.getSource() == b2) {
            cardLayout.show(panel_R2, "Menu");
        } else if (e.getSource() == b3) {
            cardLayout.show(panel_R2, "Member");
        } else if (e.getSource() == b4) {
            new LoginGUI();
            f.dispose();
        }
    }

}



