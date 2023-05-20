
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminAddMenu extends JInternalFrame implements ActionListener{
    private JButton BtnOk, BtnCancel;
    private JLabel lMenu, lPrice, lType;
    private JTextField tMenu, tPrice, tType;
    public AdminAddMenu(){

        ////f2/////
        lMenu = new JLabel("Menu  :  "); lPrice = new JLabel("Price  :  "); lType = new JLabel("Type  :  ");
        tMenu = new JTextField("",15); tPrice = new JTextField("",15); tType = new JTextField("", 15);
        BtnOk = new JButton("OK"); BtnCancel = new JButton("Cancel");

        setLayout(new BorderLayout());

        /////f2info//////
        JPanel temp1 = new JPanel();
        JPanel temp1_1 = new JPanel(); JPanel temp1_2 = new JPanel(); JPanel temp1_3 = new JPanel();

        temp1.setLayout(new GridLayout(3,1,5,5));
        temp1.setBorder(BorderFactory.createRaisedBevelBorder());
        tMenu.setPreferredSize(new Dimension(5, 25)); tPrice.setPreferredSize(new Dimension(5, 25)); tType.setPreferredSize(new Dimension(5, 25));
        lMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
        lType.setFont(new Font("Tahoma", Font.BOLD, 13));

        temp1_1.add(lMenu); temp1_1.add(tMenu);
        temp1_2.add(lPrice); temp1_2.add(tPrice);
        temp1_3.add(lType); temp1_3.add(tType);
        temp1.add(temp1_1);
        temp1.add(temp1_2);
        temp1.add(temp1_3);

        add(temp1, BorderLayout.CENTER);

        ////f2addbutton/////
        JPanel temp2 = new JPanel();

        BtnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
        BtnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));

        temp2.add(BtnOk); temp2.add(BtnCancel);
        add(temp2, BorderLayout.SOUTH);

        ////f2setting/////
        setSize(300, 200);
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