
import java.awt.*;
import javax.swing.*;

public class Table_PopUp{

    private JFrame frame;
    private JDesktopPane desktopPane;
    private JPanel pBig, p1, psub_1, psub_2, psub_3, p_button;
    private JLabel txt_name, txt_time, txt_phoneNum;
    private JTextField take_name, take_time, take_phoneNum;
    private JButton btn_yes, btn_no;

    public Table_PopUp() {
        frame = new JFrame();
        frame.setBackground(Color.yellow);
        desktopPane = new JDesktopPane();
        pBig = new JPanel();
        p1 = new JPanel();
        psub_1 = new JPanel();
        psub_2 = new JPanel();
        psub_3 = new JPanel();
        p_button = new JPanel();
        txt_name = new JLabel("Customer Name : ");
        txt_time = new JLabel("Time :                    ");
        txt_phoneNum = new JLabel("Phone Number : ");
        take_name = new JTextField(20);
        take_time = new JTextField(20);
        take_phoneNum = new JTextField(20);
        btn_yes = new JButton("YES");
        btn_no = new JButton("NO");
        
        //SET LAYOUT
        pBig.setLayout(new GridLayout(4,1));
        p1.setLayout(new GridLayout(3,1));
        psub_1.setLayout(new FlowLayout());
        psub_2.setLayout(new FlowLayout());
        psub_3.setLayout(new FlowLayout());
        p_button.setLayout(new FlowLayout());
        
        //ADD
        psub_1.add(txt_name);
        psub_1.add(take_name);
        psub_2.add(txt_time);
        psub_2.add(take_time);
        psub_3.add(txt_phoneNum);
        psub_3.add(take_phoneNum);
        p_button.add(Box.createRigidArea(new Dimension(5,0)));
        p_button.add(btn_no);
        p_button.add(Box.createRigidArea(new Dimension(5,0)));
        p_button.add(btn_yes);
        p_button.add(Box.createRigidArea(new Dimension(5,0)));
        //ADD TO Frame-Panel
        p1.add(psub_1);
        p1.add(psub_2);
        p1.add(psub_3);
        pBig.add(p1);
        pBig.add(p_button);
        frame.add(pBig, BorderLayout.NORTH);

        frame.setSize(860, 600);
        frame.setVisible(true);
    }

}