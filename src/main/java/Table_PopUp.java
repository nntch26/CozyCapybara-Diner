import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

public class Table_PopUp implements ActionListener, WindowListener, InternalFrameListener, Refreshtable {

    private JFrame frame;
    private JDesktopPane desktopPane;
    private JPanel pBig, p1, p2, psub_1, psub_2, psub_3, p_button, pID;
    private JLabel labelID, labelName, labelTime, labelPhoneNumber;
    private JTextField tfName, tfTime, tfPhoneNumber, take_idTable;
    private JButton btn_yes, btn_no;
    private JInternalFrame internal_frame_1, internal_frame_2;
    private JComboBox selectStatus;
    private JTable tabledetails;
    private Database db;
    private TablePanel tablePanel;
    private MenuPanel menuPanel;
    private ArrayList<Table> tables;
    private MainGUI mainGUI;


    public Table_PopUp(TablePanel tablePanel) {
         db = new Database();
        frame = new JFrame();
        frame.setBackground(Color.yellow);
        desktopPane = new JDesktopPane();
        this.tablePanel = tablePanel;
        pBig = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        pID = new JPanel();
        psub_1 = new JPanel();
        psub_2 = new JPanel();
        psub_3 = new JPanel();
        p_button = new JPanel();
        labelID = new JLabel("ID Table               :");
        labelName = new JLabel("Customer Name : ");
        labelTime = new JLabel("Time :                    ");
        labelPhoneNumber = new JLabel("Phone Number : ");
        tfName = new JTextField(20);
        tfTime = new JTextField(20);
        tfPhoneNumber = new JTextField(20);
        take_idTable = new JTextField(20);
        btn_yes = new JButton("YES");
        btn_no = new JButton("NO");
        tabledetails = new JTable();
        selectStatus = new JComboBox();
        selectStatus.addItem("FREE");
        selectStatus.addItem("BOOKED");
        selectStatus.addItem("CLOSED");
        internal_frame_1 = new JInternalFrame("TableNum", true, true, true, true);
        internal_frame_2 = new JInternalFrame("JTableNum", true, true, true, true);
        
        
        //SET LAYOUT
        pBig.setLayout(new GridLayout(4, 1));
        p1.setLayout(new GridLayout(4, 1));
        psub_1.setLayout(new FlowLayout());
        psub_2.setLayout(new FlowLayout());
        psub_3.setLayout(new FlowLayout());
        p_button.setLayout(new FlowLayout());

        //ADD
        pID.add(labelID);
        pID.add(take_idTable);
        p2.add(selectStatus);
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
        internal_frame_1.setSize(new Dimension(700, 500));
        internal_frame_2.setLocation(x1+ 50, y1+ 50);
        internal_frame_2.setVisible(true);
        internal_frame_2.setSize(new Dimension(500, 500));

        //ADD TO Frame-Panel
        p1.add(pID);
        p1.add(psub_1);
        p1.add(psub_2);
        p1.add(psub_3);
        pBig.add(p1);
        pBig.add(p2);
        pBig.add(p_button);
        internal_frame_1.add(pBig);
        desktopPane.add(internal_frame_1);
        desktopPane.add(internal_frame_2);
        frame.add(desktopPane);

        //ADD ACTIONLISTENER
        btn_yes.addActionListener(this);
        btn_no.addActionListener(this);
        frame.addWindowListener(this);
        internal_frame_1.addInternalFrameListener(this);
        internal_frame_2.addInternalFrameListener(this);

       // JTABLE
         DefaultTableModel model = (DefaultTableModel)tabledetails.getModel();
          db.loadTable();
         tables = db.getTable();
         setJTable();
         JScrollPane scrollPane = new JScrollPane(tabledetails);
         internal_frame_2.add(scrollPane);
        tablePanel = new TablePanel(mainGUI, menuPanel);
        db.addContactView(this);
//        db.addContactView(tablePanel);
        
        
        frame.setSize(860, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        internal_frame_1.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        internal_frame_2.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
    }

    public JTextField getTake_idTable() {
        return take_idTable;
    }

    public void setTake_idTable(JTextField take_idTable) {
        this.take_idTable = take_idTable;
    }

     public void setJTable() {
         DefaultTableModel model = (DefaultTableModel) tabledetails.getModel();
         model.setRowCount(0);
         Object[] columnsName = new Object[5];
         columnsName[0] = "Id";
         columnsName[1] = "Cap";
         columnsName[2] = "Name";
         columnsName[3] = "Status";
         columnsName[4] = "Date";
         System.out.println(tables.get(4).getTableStatus());
         model.setColumnIdentifiers(columnsName);
         Object[] rowData = new Object[5];
//         db.loadTable();
//         tables = db.getTable();
        
         for (int i = 0; i < tables.size(); i++) {
             rowData[0] = tables.get(i).getId();
             rowData[1] = tables.get(i).getTableNameCus();
             rowData[2] = tables.get(i).getTableCap();
             rowData[3] = tables.get(i).getTableStatus();
             rowData[4] = tables.get(i).getTableTimeres();
             model.addRow(rowData);
         }
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btn_yes)) {
            if((take_idTable.getText().equals("")) || (tfName.getText().equals("")) || (tfPhoneNumber.getText().equals("")) || (tfTime.getText().equals(""))){
                JOptionPane.showMessageDialog(null, " Please fill the form."); //show message
            }else {
                System.out.println("what");
                db.reserveTable(take_idTable.getText(), tfName.getText(), tfPhoneNumber.getText(), tfTime.getText()); //ADD TO TABLE
                db.addContactView(tablePanel);
                db.updateModel(tables);
                
//               tablePanel.refreshtable(tables);
              
                //frame.dispose();
            }
        } else if (ae.getSource().equals(btn_no)) {
            int windowClose = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
            if (windowClose == JOptionPane.YES_OPTION) {
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
            frame.dispose();
        } else {
            return;
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
        int internalClose = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this application?", "Confirm Close", JOptionPane.YES_NO_OPTION);
        if (internalClose == JOptionPane.YES_OPTION) {
            frame.dispose();
        } else {
            return;
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

    @Override
    public void refreshtable(ArrayList<Table> tables) {
        this.tables = tables;
        setJTable();
    }
}