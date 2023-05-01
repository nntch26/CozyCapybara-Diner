import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuTable implements ActionListener{
    public JFrame f;
    public JPanel p1, p2, p3, p4;
    public JButton[] buttons = new JButton[4];
    public MenuTable(){
        f = new JFrame("");
        p1 = new JPanel(); p2 = new JPanel(); p3 = new JPanel(); p4 = new JPanel();
        
        f.setLayout(new GridLayout(2,1));
        
        ///////////////////////////////////////////////////////
        
        p1.setLayout(new FlowLayout());
        p1.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.red));
        
        for(int i=0 ; i<4 ; i++){
            JButton btn = new JButton("");
            btn.setPreferredSize(new Dimension(190,250));
            buttons[i] = btn;
            btn.addActionListener(this);
            p1.add(Box.createRigidArea(new Dimension(5,0)));
            p1.add(btn);
    }
        p1.add(Box.createRigidArea(new Dimension(5,0)));
        
        /////////////////////////////////////////////////////
        
        p2.setLayout(new FlowLayout());
        p2.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.red));
        
        for(int i=4 ; i<8 ; i++){
            JButton btn = new JButton("");
            btn.setPreferredSize(new Dimension(190,250));
            p2.add(Box.createRigidArea(new Dimension(5,0)));
            p2.add(btn);     
    }
        p2.add(Box.createRigidArea(new Dimension(5,0)));
        
        ///////////////////////////////////////////////////////////////
        f.add(p1);
        f.add(p2);
        
        f.setSize(860, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(buttons[0])){
            buttons[0].setBackground(Color.red);
            new Table_PopUp();
        }
    }
}
