import java.awt.*;
import javax.swing.*;

public class MemPanel extends JPanel {
    public MemPanel() {
        setBorder(BorderFactory.createTitledBorder("Contact Panel"));
        setLayout(new GridLayout(3, 2));
        
        // สร้างและเพิ่ม Component ลงในหน้าจอ
        JLabel userLabel = new JLabel("Username:");
        add(userLabel);
        JTextField userText = new JTextField();
        add(userText);
        JLabel passLabel = new JLabel("Password:");
        add(passLabel);
        JPasswordField passText = new JPasswordField();
        add(passText);
        JButton loginButton = new JButton("Login");
        add(loginButton);
        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);
    }
}