import java.awt.*;
import javax.swing.*;
import DBJava.SQLquery;
import java.awt.event.*;
import java.sql.SQLException;

public class MenuPanel extends JPanel implements ActionListener {
    private DefaultListModel<String> foodListModel;
    private JList<String> foodList;
    private DefaultListModel<String> selectedFoodListModel;
    private JList<String> selectedFoodList;
    private JButton addButton, reButton;
    private JLabel lID , lTotal;
    private JTextField tID, tTotal;
    private SQLquery db = new SQLquery();

    public MenuPanel() {
        //setBorder(BorderFactory.createTitledBorder("Menu Panel"));
        //add(new JLabel("Menu items go here"));
        // สร้างรายการอาหาร
        /*String fname = "";
        try {
            fname = db.getMenuList().get(0).getMenuName();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        foodListModel = new DefaultListModel<String>();
        foodListModel.addElement(" Beef steak");
        foodListModel.addElement(" Lobster Thermidor");
        foodListModel.addElement(" Braised Pork Ribs with Honey");
        foodListModel.addElement(" Duck breast a l' Orange");
        foodListModel.addElement(" Grilled Sea Bass with Garlic Butter");
        //foodListModel.addElement(""+ fname);

        //เลขโต๊ะและข้อมูล
        //บนสุด
        JPanel Panelinfo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lID = new JLabel("Table ID : "); 
        tID = new JTextField("",5); tID.setEditable(false);
        Panelinfo.add(lID); Panelinfo.add(tID);
        //ล่างสุด
        JPanel PanelTotal = new JPanel(new FlowLayout());
        lTotal = new JLabel("Total : ");
        tTotal = new JTextField("",5); tTotal.setEditable(false);
        PanelTotal.add(lTotal); PanelTotal.add(tTotal);

        // สร้าง JList ของรายการอาหาร
        foodList = new JList<String>(foodListModel);
        JScrollPane foodScrollPane = new JScrollPane(foodList);
        foodScrollPane.setPreferredSize(new Dimension(270, 0));
        JPanel foodListPanel = new JPanel(new BorderLayout());
        foodListPanel.add(new JLabel("Menu All"), BorderLayout.NORTH);
        foodListPanel.add(foodScrollPane, BorderLayout.CENTER);

        // สร้างรายการอาหารที่เลือก
        selectedFoodListModel = new DefaultListModel<String>();

        // สร้าง JList ของรายการอาหารที่เลือก
        selectedFoodList = new JList<String>(selectedFoodListModel);
        JScrollPane selectedFoodScrollPane = new JScrollPane(selectedFoodList);
        selectedFoodScrollPane.setPreferredSize(new Dimension(270,0 ));
        JPanel selectedFoodListPanel = new JPanel(new BorderLayout());
        selectedFoodListPanel.add(new JLabel("Selected Food Items"), BorderLayout.NORTH);
        selectedFoodListPanel.add(selectedFoodScrollPane, BorderLayout.CENTER);

        // สร้างปุ่มเพิ่มอาหาร และ ล้างรายการ และ 
        addButton = new JButton("Add");
        reButton = new JButton("Reset");

        addButton.addActionListener(this);
        reButton.addActionListener(this);
           
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(reButton);

        // สร้าง GUI
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        //mainPanel.setPreferredSize(new Dimension(600, 450)); // พื้นที่ด้านบน
        mainPanel.add(foodListPanel, BorderLayout.WEST);
        mainPanel.add(selectedFoodListPanel, BorderLayout.EAST);
        mainPanel.add(PanelTotal , BorderLayout.SOUTH);
        add(Panelinfo,BorderLayout.NORTH);
        add(mainPanel,BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(70, 5)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(70, 5)), BorderLayout.WEST);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedFood = foodList.getSelectedValue();
        int num = 1;
        if (e.getSource().equals(addButton)){
            if (selectedFood != null) {
                //foodListModel.removeElement(selectedFood);
                selectedFoodListModel.addElement(selectedFood+" x "+num);
            }

        }else if (e.getSource().equals(reButton)){
            selectedFoodListModel.removeAllElements();
        }
        
        
        
    }
}
    

