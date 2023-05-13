import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TablePanel extends JPanel implements ActionListener {
    public JPanel Table_Row1, Table_Row2, Table_Row3, Table, hugePanel, Table_Row4, txt, showPanel1, showPanel2;
    public JButton[] buttons_R1 = new JButton[4], buttons_R2 = new JButton[4], buttons_R3 = new JButton[4];
    public JScrollPane s;
    public JLabel showLabel1, showLabel2;

    public TablePanel() {
        Table = new JPanel();
        hugePanel = new JPanel();
        Table_Row1 = new JPanel();
        Table_Row2 = new JPanel();
        Table_Row3 = new JPanel();
        Table_Row4 = new JPanel();
        txt = new JPanel();


        setLayout(new BorderLayout());
        ////////////
        txt.setLayout(new GridLayout(1, 2));

        /////mainTable/////////

        Table.setLayout(new GridLayout(3, 1));

        ///scrollbar////
        s = new JScrollPane(Table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //////Table Row1///////

        Table_Row1.setLayout(new FlowLayout());
        Table_Row1.setBackground(Color.decode("#FFDEAD"));
        Table_Row1.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.decode("#deba83")));

        for (int i = 0; i < 3; i++) {
            JButton btn = new JButton("Table" + (i + 1));

            btn.setPreferredSize(new Dimension(240, 175));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));

            buttons_R1[i] = btn;
            btn.addActionListener(this);
            Table_Row1.add(Box.createRigidArea(new Dimension(5, 0)));
            Table_Row1.add(btn);
        }
        Table_Row1.add(Box.createRigidArea(new Dimension(5, 0)));

        ////Table Row 2////////

        Table_Row2.setLayout(new FlowLayout());
        Table_Row2.setBackground(Color.decode("#FFDEAD"));
        Table_Row2.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.decode("#deba83")));

        for (int i = 0; i < 3; i++) {
            JButton btn = new JButton("Table" + (i + 4));

            btn.setPreferredSize(new Dimension(240, 175));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));

            buttons_R2[i] = btn;
            btn.addActionListener(this);
            Table_Row2.add(Box.createRigidArea(new Dimension(5, 0)));
            Table_Row2.add(btn);
        }
        Table_Row2.add(Box.createRigidArea(new Dimension(5, 0)));

        ////Table Row 3////////

        Table_Row3.setLayout(new FlowLayout());
        Table_Row3.setBackground(Color.decode("#FFDEAD"));
        Table_Row3.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.decode("#deba83")));

        for (int i = 0; i < 3; i++) {
            JButton btn = new JButton("Table" + (i + 7));

            btn.setPreferredSize(new Dimension(240, 175));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));

            buttons_R3[i] = btn;
            btn.addActionListener(this);
            Table_Row3.add(Box.createRigidArea(new Dimension(5, 0)));
            Table_Row3.add(btn);
        }
        Table_Row3.add(Box.createRigidArea(new Dimension(5, 0)));

        ////Menu Row 4////////

        hugePanel.setLayout(new GridLayout(1,2));
        showLabel1 = new JLabel("Free Table");
        showLabel2 = new JLabel("Busy Table");

        Table_Row4.setLayout(new GridLayout(1, 2));
        Table_Row4.setBackground(Color.decode("#FFDEAD"));
        Table_Row4.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.decode("#deba83")));

        showPanel1 = new JPanel();
        showPanel2 = new JPanel();
        showPanel1.setPreferredSize(new Dimension(240,100));
        showLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
        showPanel1.setBackground(Color.decode("#deba83"));
        showLabel1.setVerticalAlignment(SwingConstants.TOP);
        showPanel1.add(showLabel1);

        showPanel2.setPreferredSize(new Dimension(240,100));
        showLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
        showPanel2.setBackground(Color.decode("#deba83"));
        showLabel2.setVerticalAlignment(SwingConstants.TOP);
        showPanel2.add(showLabel2);



        hugePanel.add(showPanel1); hugePanel.add(showPanel2);
        Table_Row4.add(hugePanel);



        ///Add Thing///

        Table.add(Table_Row1);
        Table.add(Table_Row2);
        Table.add(Table_Row3);
        txt.add(s);
        add(txt);
        add(Table_Row4, BorderLayout.SOUTH);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(buttons_R1[0])) {
            buttons_R1[0].setBackground(Color.red);
            new Table_PopUp();
        }
    }
}
