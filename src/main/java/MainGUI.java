import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainGUI implements ActionListener, Refreshable {
        private JFrame f;
        public JPanel panel_L1,panel_L2,pn,panel_R1,panel_R2;
        private JButton b1,b2,b3,b4,bAdmin;
        public MenuPanel menuPanel;
        public CardLayout cardLayout;

        public MainGUI(){
            f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(1024,600);
            f.setResizable(false);
            f.setLocationRelativeTo(null); //แสดงหน้าต่างตรงกลาง

            // สร้าง CardLayout
            cardLayout = new CardLayout();
            panel_R2 = new JPanel(cardLayout);

            // สร้าง Panels จากคลาสอื่น
            
            menuPanel = new MenuPanel();
            JPanel memberPanel = new MemberPanel();
            JPanel tablePanel = new TablePanel(this, menuPanel);


            panel_L1 = new JPanel();
            panel_L2 = new JPanel();
            panel_R1 = new JPanel();
            pn = new JPanel();

             //////////// รูปภาพ ///////////////////////
            ImageIcon icon = new ImageIcon("src/main/resources/imggui/home.png");
            // ปรับขนาดของรูปภาพ
            Image image = icon.getImage();
            Image reImage = image.getScaledInstance(850, 600, Image.SCALE_SMOOTH);
            // สร้าง ImageIcon จากรูปภาพที่ปรับขนาดแล้ว
            ImageIcon resizedIcon = new ImageIcon(reImage);
            // สร้าง JLabel และแสดงรูปภาพที่ปรับขนาดแล้ว
            JLabel labelimg = new JLabel(resizedIcon);
            panel_R1.add(labelimg);

           

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


            //load


            // layout
            f.setLayout(new BorderLayout());
            panel_L1.setLayout(new BorderLayout());
            //p2.setLayout(new GridLayout(4,1));

            // Panel
            panel_L2.setBackground(Color.DARK_GRAY);
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
            panel_R2.add(memberPanel, "Member");

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
            b1.setBackground(Color.decode("#F14902"));
            b2.setBackground(Color.darkGray);
            b3.setBackground(Color.darkGray);
            bAdmin.setBackground(Color.DARK_GRAY);

        } else if (e.getSource() == b2) {
            cardLayout.show(panel_R2, "Menu");
            b1.setBackground(Color.darkGray);
            b2.setBackground(Color.decode("#F14902"));
            b3.setBackground(Color.darkGray);
            bAdmin.setBackground(Color.DARK_GRAY);

        } else if (e.getSource() == b3) {
            cardLayout.show(panel_R2, "Member");
            b1.setBackground(Color.darkGray);
            b2.setBackground(Color.DARK_GRAY);
            b3.setBackground(Color.decode("#F14902"));
            bAdmin.setBackground(Color.DARK_GRAY);

        } else if (e.getSource() == bAdmin) {
            cardLayout.show(panel_R2, "Member");
            b1.setBackground(Color.darkGray);
            b2.setBackground(Color.DARK_GRAY);
            b3.setBackground(Color.DARK_GRAY);
            bAdmin.setBackground(Color.decode("#F14902"));
        }
        else if (e.getSource() == b4) {
            int windowClose = JOptionPane.showConfirmDialog(f, "Are you sure you want to Logout", "", JOptionPane.YES_NO_OPTION);
            if (windowClose == JOptionPane.YES_OPTION){
                new LoginGUI();
                f.dispose();
            }
        }
    }

    
    public JPanel getPanel_L2() {
        return panel_L2;
    }

    public void setPanel_L2(JPanel panel_L2) {
        this.panel_L2 = panel_L2;
    }

    @Override
    public void refreshtable(ArrayList<Table> table) {
        System.out.println("main re fres hhh h asdds");
    }

   
}



