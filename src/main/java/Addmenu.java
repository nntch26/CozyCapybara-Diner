
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;


public class Addmenu implements ActionListener{
    private JFrame j1;
    private JPanel p1;
    private JTextField t1,t2,t3;
    private JButton B1;
    private Database db;
    
    public Addmenu(){
        j1 = new JFrame("Inw za 007");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        B1 = new JButton("sss");
        db = new Database();
        j1.setLayout(new GridLayout(4,1));
        
        
        
        B1.addActionListener(this);
        j1.add(t1);
        j1.add(t2);
        j1.add(t3);
        j1.add(B1);
        j1.pack();
        j1.setVisible(true);
        
    }
    public static void main(String[] args) {
         new Addmenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(B1)){
            db.addMenu2(this);
        }
    }

    public JTextField getT1() {
        return t1;
    }

    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public JTextField getT2() {
        return t2;
    }

    public void setT2(JTextField t2) {
        this.t2 = t2;
    }

    public JTextField getT3() {
        return t3;
    }

    public void setT3(JTextField t3) {
        this.t3 = t3;
    }
    
    
}
