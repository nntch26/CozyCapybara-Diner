
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminAddMenu extends JInternalFrame implements ActionListener{
    private JButton BtnOk, BtnCancel;
    private JLabel lMenu, lPrice;
    private JTextField tMenu, tPrice; 
    public AdminAddMenu(){
    
        ////f2/////
        lMenu = new JLabel("Menu  :  "); lPrice = new JLabel("Price  :  ");
        tMenu = new JTextField("",20); tPrice = new JTextField("",20);
        BtnOk = new JButton("OK"); BtnCancel = new JButton("Cancel");

        setLayout(new BorderLayout());

        /////f2info//////
        JPanel temp1 = new JPanel();
        JPanel temp1_1 = new JPanel(); JPanel temp1_2 = new JPanel();

        temp1.setLayout(new GridLayout(2,1,5,5));
        temp1.setBorder(BorderFactory.createRaisedBevelBorder());
        tMenu.setPreferredSize(new Dimension(5, 25)); tPrice.setPreferredSize(new Dimension(5, 25));
        lMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lPrice.setFont(new Font("Tahoma", Font.BOLD, 13));

        temp1_1.add(lMenu); temp1_1.add(tMenu); 
        temp1_2.add(lPrice); temp1_2.add(tPrice);
        temp1.add(temp1_1);
        temp1.add(temp1_2);

        add(temp1, BorderLayout.CENTER);

        ////f2addbutton/////
        JPanel temp2 = new JPanel();

        BtnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
        BtnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));

        temp2.add(BtnOk); temp2.add(BtnCancel);
        add(temp2, BorderLayout.SOUTH);

        ////f2setting/////
        setSize(300, 150);
        setVisible(true);

        BtnOk.addActionListener(this);
        BtnCancel.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(BtnOk)){
            dispose();
        }else if (ae.getSource().equals(BtnCancel)){
            dispose();
        }
    }
}
