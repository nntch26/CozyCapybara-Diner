import javax.swing.*;
import static javax.swing.UIManager.*;
import com.formdev.flatlaf.FlatLightLaf;


public class Main {
    public static void main(String[] args) {
        try {
           setLookAndFeel(new FlatLightLaf() );
            new MainGUI();

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

    }
}
