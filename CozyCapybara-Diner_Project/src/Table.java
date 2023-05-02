import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Table extends JPanel implements ActionListener{
    public JPanel Table_Row1, Table_Row2, Table_Row3, Table;
    public JButton[] buttons_R1 = new JButton[12];
    public JScrollPane s;
    public Table(){
        Table = new JPanel();
        Table_Row1 = new JPanel();
        setLayout(new GridLayout(1,2));

        /////mainTable/////////
        Table.setLayout(new FlowLayout());
        Table.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#deba83")));
        Table.setBackground(Color.decode("#FFDEAD"));

        ///scrollbar////
        s = new JScrollPane(Table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //////Table Row1///////
        
        Table_Row1.setLayout(new GridLayout(3,4));
        Table_Row1.setBackground(Color.decode("#FFDEAD"));
        
        for(int i=0 ; i<12 ; i++){
            JButton btn = new JButton("Table"+(i+1));

            btn.setPreferredSize(new Dimension(175,240));
            btn.setFont(new Font("Tahoma", Font.BOLD, 12));
            btn.setBackground(Color.decode("#deba83"));
            btn.setVerticalAlignment(SwingConstants.TOP);
            btn.setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.decode("#FFDEAD")));

            buttons_R1[i] = btn;
            btn.addActionListener(this);
            Table_Row1.add(btn);
    }
    
        
        ///Add Thing///
        
        Table.add(Table_Row1);
        add(s);
             
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(buttons_R1[0])){
            buttons_R1[0].setBackground(Color.red);
            new Table_PopUp();
        }
    }
}




