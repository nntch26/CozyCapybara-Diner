import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TableInputInfo implements ActionListener{
    private JFrame f;
    private JPanel pmain, p1, p2, p3, p4;
    private JLabel l1, l2, l3;
    private JTextField t1, t2, t3;
    private JButton b1, b2;
    public TableInputInfo(){
        f = new JFrame();
        pmain = new JPanel();

        f.setLayout(new BorderLayout());
        pmain.setLayout(new GridLayout(3,1,0,0));
        pmain.setBackground(Color.decode("#deba83"));
        /////input info///////
        p1 = new JPanel(); p2 = new JPanel(); p3 = new JPanel();

        l1 = new JLabel("Customer name : "); l2 = new JLabel("Time : "); l3 = new JLabel("Phone Number : ");
        t1 = new JTextField("", 15); t2 = new JTextField("", 15); t3 = new JTextField("", 15);

        p1.setLayout(new FlowLayout(FlowLayout.RIGHT)); p1.setBackground(Color.decode("#deba83"));
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT)); p2.setBackground(Color.decode("#deba83"));
        p3.setLayout(new FlowLayout(FlowLayout.RIGHT)); p3.setBackground(Color.decode("#deba83"));

        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setPreferredSize(new Dimension(50, 30));
        t2.setPreferredSize(new Dimension(50, 30));
        t3.setPreferredSize(new Dimension(50, 30));


        p1.add(l1); p1.add(t1);
        p2.add(l2); p2.add(t2);
        p3.add(l3); p3.add(t3);

        ////button////
        p4 = new JPanel(); p4.setBackground(Color.decode("#deba83"));

        b1 = new JButton("Cancel");
        b2 = new JButton("OK");

        b1.setForeground(Color.white);
        b1.setBackground(Color.DARK_GRAY);
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.setPreferredSize(new Dimension(70, 40));
        b1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        b2.setForeground(Color.white);
        b2.setBackground(Color.DARK_GRAY);
        b2.setFont(new Font("Tahoma", Font.BOLD, 16));
        b2.setPreferredSize(new Dimension(70, 40));
        b2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 

        p4.add(b1); p4.add(b2);

        ////addthing/////
        pmain.add(p1);
        pmain.add(p2);
        pmain.add(p3);
        f.add(pmain);
        f.add(p4, BorderLayout.SOUTH);

        b1.addActionListener(this);
        b2.addActionListener(this);


        f.setSize(320, 230);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(b1)){
            f.dispose();
        }else if (ae.getSource().equals(b2)){
            f.dispose();
        }
    }
}
