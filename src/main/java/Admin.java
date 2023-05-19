import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Admin extends JFrame implements ActionListener{
    private JDesktopPane d;
    private JButton BtnAdd, BtnEdit, BtnDelete;
    private JInternalFrame f1;
    private JLabel lMenu, lPrice;
    private JTextField tMenu, tPrice;

    private JTable table;
    private DefaultTableModel tableModel;
    public Admin(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            e.printStackTrace();
            }
        d = new JDesktopPane();

        ////f1/////
        f1 = new JInternalFrame("", false, false, false, false);
        lMenu = new JLabel("Menu  :  "); lPrice = new JLabel("Price  :  ");
        tMenu = new JTextField("",20); tPrice = new JTextField("",20);
        BtnAdd = new JButton("Add"); BtnEdit = new JButton("Edit"); BtnDelete = new JButton("Delete");
        
        f1.setLayout(new BorderLayout());

        ///f1addinfo///
        JPanel tempMain = new JPanel();
        JPanel temp1 = new JPanel();
        JPanel temp1_1 = new JPanel(); JPanel temp1_2 = new JPanel();

        tempMain.setLayout(new BorderLayout(3, 3));
        temp1.setLayout(new GridLayout(2,1,5,5));
        temp1.setBorder(BorderFactory.createRaisedBevelBorder());
        tMenu.setPreferredSize(new Dimension(5, 25)); tPrice.setPreferredSize(new Dimension(5, 25));
        lMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lPrice.setFont(new Font("Tahoma", Font.BOLD, 13));

        temp1_1.add(lMenu); temp1_1.add(tMenu); 
        temp1_2.add(lPrice); temp1_2.add(tPrice);
        temp1.add(temp1_1);
        temp1.add(temp1_2);

        tempMain.add(temp1, BorderLayout.NORTH);

        f1.add(tempMain, BorderLayout.CENTER);

        tMenu.setEditable(false); tPrice.setEditable(false);

        ////f1addTable////
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setBorder(BorderFactory.createRaisedBevelBorder());

        tableModel.addColumn("MenuName");
        tableModel.addColumn("MenuPrice");
        tableModel.addColumn("Type");
        table.setModel(tableModel);
        
        tempMain.add(new JScrollPane(table), BorderLayout.CENTER);

        //f1addbutton////
        JPanel temp2 = new JPanel();

        BtnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        BtnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
        BtnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));

        temp2.add(BtnAdd); temp2.add(BtnEdit); temp2.add(BtnDelete);
        f1.add(temp2, BorderLayout.SOUTH);


        ///f1setting////
        f1.add(Box.createRigidArea(new Dimension(1,10)), BorderLayout.NORTH);
        f1.add(Box.createRigidArea(new Dimension(10,1)), BorderLayout.WEST);
        f1.add(Box.createRigidArea(new Dimension(10,1)), BorderLayout.EAST);
        f1.setSize(400, 400);
        f1.setVisible(true);
        int x1 = f1.getX();
        int y1 = f1.getY();
        f1.setLocation(x1+125, y1+50);

        BtnAdd.addActionListener(this);
        BtnEdit.addActionListener(this);
        BtnDelete.addActionListener(this);



        ///addthing///
        d.add(f1);
        add(d);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(BtnAdd)){
            AdminAddMenu menuAdd = new AdminAddMenu();
            d.add(menuAdd);
            int x2 = menuAdd.getX();
            int y2 = menuAdd.getY();
            menuAdd.setLocation(x2+600, y2+100);

        }else if(ae.getSource().equals(BtnEdit) && BtnEdit.getText() == "Edit"){
            tMenu.setEditable(true); tPrice.setEditable(true);
            BtnEdit.setText("Done");
        }else if(ae.getSource().equals(BtnEdit) && BtnEdit.getText() == "Done"){
            tMenu.setEditable(false); tPrice.setEditable(false);
            BtnEdit.setText("Edit");
        }
    }

}