import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuTable extends JPanel implements ActionListener{
    public JPanel Table_Row1, Table_Row2, Table_Row3, Table;
    public JButton[] buttons_R1 = new JButton[4],buttons_R2 = new JButton[4] ,buttons_R3 = new JButton[4];
    public JScrollPane s;
    public MenuTable(){
        Table = new JPanel();
        Table_Row1 = new JPanel(); Table_Row2 = new JPanel(); Table_Row3 = new JPanel();
        
        setLayout(new GridLayout(1,2));

        /////mainTable/////////
        Table.setLayout(new GridLayout(3, 1));

        ///scrollbar////
        s = new JScrollPane(Table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //////Table Row1///////
        
        Table_Row1.setLayout(new FlowLayout());
        Table_Row1.setBackground(Color.decode("#FFDEAD"));
        Table_Row1.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.decode("#deba83")));
        
        for(int i=0 ; i<4 ; i++){
            JButton btn = new JButton("Table"+(i+1));

            btn.setPreferredSize(new Dimension(175,240));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));

            buttons_R1[i] = btn;
            btn.addActionListener(this);
            Table_Row1.add(Box.createRigidArea(new Dimension(5,0)));
            Table_Row1.add(btn);
    }
        Table_Row1.add(Box.createRigidArea(new Dimension(5,0)));
    
        ////Table Row 2////////
        
        Table_Row2.setLayout(new FlowLayout());
        Table_Row2.setBackground(Color.decode("#FFDEAD"));
        Table_Row2.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.decode("#deba83")));
        
        for(int i=0 ; i<4 ; i++){
            JButton btn = new JButton("Table"+(i+5));

            btn.setPreferredSize(new Dimension(175,240));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));

            buttons_R2[i] = btn;
            btn.addActionListener(this);
            Table_Row2.add(Box.createRigidArea(new Dimension(5,0)));
            Table_Row2.add(btn);     
    }
        Table_Row2.add(Box.createRigidArea(new Dimension(5,0)));

        ////Table Row 3////////
        
        Table_Row3.setLayout(new FlowLayout());
        Table_Row3.setBackground(Color.decode("#FFDEAD"));
        Table_Row3.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.decode("#deba83")));
        
        for(int i=0 ; i<4 ; i++){
            JButton btn = new JButton("Table"+(i+9));

            btn.setPreferredSize(new Dimension(175,240));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#c29d65")));

            buttons_R3[i] = btn;
            btn.addActionListener(this);
            Table_Row3.add(Box.createRigidArea(new Dimension(5,0)));
            Table_Row3.add(btn);     
    }
        Table_Row3.add(Box.createRigidArea(new Dimension(5,0)));

        
        ///Add Thing///
        
        Table.add(Table_Row1);
        Table.add(Table_Row2);
        Table.add(Table_Row3);
        add(s);
             
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(buttons_R1[0])){
            buttons_R1[0].setBackground(Color.red);
            new Table_PopUp();
        }
    }
}


