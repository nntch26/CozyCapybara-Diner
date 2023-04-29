import java.awt.*;
import javax.swing.*;

public class TablePanel extends JPanel {
    public TablePanel() {
        setBorder(BorderFactory.createTitledBorder("Table Panel"));
        setBackground(Color.PINK);
        setLayout(new GridLayout(2, 2));
        add(new JLabel("Table1"));
        add(new JLabel("Table2"));
        add(new JLabel("Table3"));
        add(new JLabel("Table4"));
    }
    
}
