import javax.swing.*;
import static javax.swing.UIManager.*;


public class Main {
    public static void main(String[] args) {
        try {
            new LoginGUI();

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

    }
}
