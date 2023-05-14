import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Table_PopUp implements ActionListener, WindowListener, InternalFrameListener{

    private JFrame frame;
    private JDesktopPane desktopPane;
    private JPanel pBig, p1, psub_1, psub_2, psub_3, p_button;
    private JLabel labelName, labelTime, labelPhoneNumber;
    private JTextField tfName, tfTime, tfPhoneNumber;
    private JButton btn_yes, btn_no;
    private JInternalFrame internal_frame_1;
    private String nameToDatabase;
    private String timeToDatabase;
    private String phoneNumberToDatabase;


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
        labelName = new JLabel("Customer Name : ");
        labelTime = new JLabel("Time :                    ");
        labelPhoneNumber = new JLabel("Phone Number : ");
        tfName = new JTextField(20);
        tfTime = new JTextField(20);
        tfPhoneNumber = new JTextField(20);
        btn_yes = new JButton("YES");
        btn_no = new JButton("NO");
        internal_frame_1 = new JInternalFrame("TableNum", true, true, true, true);

        //SET LAYOUT
        pBig.setLayout(new GridLayout(4, 1));
        p1.setLayout(new GridLayout(3, 1));
        psub_1.setLayout(new FlowLayout());
        psub_2.setLayout(new FlowLayout());
        psub_3.setLayout(new FlowLayout());
        p_button.setLayout(new FlowLayout());

        //ADD
        psub_1.add(labelName);
        psub_1.add(tfName);
        psub_2.add(labelTime);
        psub_2.add(tfTime);
        psub_3.add(labelPhoneNumber);
        psub_3.add(tfPhoneNumber);
        p_button.add(Box.createRigidArea(new Dimension(5, 0)));
        p_button.add(btn_no);
        p_button.add(Box.createRigidArea(new Dimension(5, 0)));
        p_button.add(btn_yes);
        p_button.add(Box.createRigidArea(new Dimension(5, 0)));

        //INTERNAL FRAME SETTING
        int x1 = internal_frame_1.getX() + internal_frame_1.getWidth() + 10;
        int y1 = internal_frame_1.getY() + 40;
        internal_frame_1.setLocation(x1, y1);
        internal_frame_1.pack();
        internal_frame_1.setVisible(true);
        internal_frame_1.setSize(new Dimension(500, 300));

        //ADD TO Frame-Panel
        p1.add(psub_1);
        p1.add(psub_2);
        p1.add(psub_3);
        pBig.add(p1);
        pBig.add(p_button);
        internal_frame_1.add(pBig);
        desktopPane.add(internal_frame_1);
        frame.add(desktopPane);

        //ADD ACTIONLISTENER
        btn_yes.addActionListener(this);
        btn_no.addActionListener(this);
        frame.addWindowListener(this);
        internal_frame_1.addInternalFrameListener(this);

        frame.setSize(860, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btn_yes)) {
            nameToDatabase = tfName.getText(); //GET INFO
            phoneNumberToDatabase = tfPhoneNumber.getText(); //GET INFO
            timeToDatabase = tfTime.getText(); //GET INFO
            System.out.println(nameToDatabase + "______" + timeToDatabase + "_________" + phoneNumberToDatabase); //SEND INFO
            frame.dispose();
        } else if (ae.getSource().equals(btn_no)) {
            int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //DO NOTHING
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //DO NOTHING
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //DO NOTHING
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //DO NOTHING
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //DO NOTHING
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //DO NOTHING
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("Internal frame is closing");
            System.exit(0);
        }
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }
}