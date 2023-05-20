import javax.swing.*;
import java.awt.*;
public class BillPanel {
    private JFrame f;
    private JPanel p1, p2, p3;
    private JTextArea ta, ta2;
    private String str;
    public BillPanel(){
        f = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        p1.setBackground(Color.WHITE);
        p2.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);

        ta = new JTextArea();
        ta2 = new JTextArea();


        String str = String.format("---------------------------------------------------------------------------------\n " +
                "Item                                                Qty                      Price\n" +
                "---------------------------------------------------------------------------------\n" +
                "information naaaaaaaaaaa\n" +
                "---------------------------------------------------------------------------------\n" +
                "Sub Total : %d\nCash : %d\nBalance : %d\n" +
                "---------------------------------------------------------------------------------\n" +
                "               Thanks for coming to Cozy-Capybara Diner");


        ta2.setText(str);

        f.setLayout(new BorderLayout());
        p1.add(ta);
        f.add(p1, BorderLayout.NORTH);
        p2.add(ta2);
        f.add(p2, BorderLayout.CENTER);
        f.add(p3, BorderLayout.SOUTH);
        f.setSize(350, 400);
        f.setVisible(true);
    }

}

