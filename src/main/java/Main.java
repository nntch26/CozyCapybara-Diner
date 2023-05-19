import com.formdev.flatlaf.FlatLightLaf;

import static javax.swing.UIManager.setLookAndFeel;


public class Main {
    public static void main(String[] args) {
        try {
            setLookAndFeel(new FlatLightLaf());
            new MainGUI();

        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

    }
}
