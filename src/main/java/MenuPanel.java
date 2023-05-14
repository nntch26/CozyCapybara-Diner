import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel {
    private DefaultListModel<String> foodListModel;
    private JList<String> foodList;
    private DefaultListModel<String> selectedFoodListModel;
    private JList<String> selectedFoodList;
    public MenuPanel() {
        setBorder(BorderFactory.createTitledBorder("Menu Panel"));
        add(new JLabel("Menu items go here"));
        // สร้างรายการอาหาร
        foodListModel = new DefaultListModel<String>();
        foodListModel.addElement("aaa");
        foodListModel.addElement("bbb");
        foodListModel.addElement("cccc");
        foodListModel.addElement("dddd");
        foodListModel.addElement("uuuuu");

        // สร้าง JList ของรายการอาหาร
        foodList = new JList<String>(foodListModel);
        JScrollPane foodScrollPane = new JScrollPane(foodList);
        foodScrollPane.setPreferredSize(new Dimension(250, 0));
        JPanel foodListPanel = new JPanel(new BorderLayout());
        foodListPanel.add(new JLabel("รายการอาหาร"), BorderLayout.NORTH);
        foodListPanel.add(foodScrollPane, BorderLayout.CENTER);

        // สร้างรายการอาหารที่เลือก
        selectedFoodListModel = new DefaultListModel<String>();

        // สร้าง JList ของรายการอาหารที่เลือก
        selectedFoodList = new JList<String>(selectedFoodListModel);
        JScrollPane selectedFoodScrollPane = new JScrollPane(selectedFoodList);
        selectedFoodScrollPane.setPreferredSize(new Dimension(250, 0));
        JPanel selectedFoodListPanel = new JPanel(new BorderLayout());
        selectedFoodListPanel.add(new JLabel("รายการอาหารที่เลือก"), BorderLayout.NORTH);
        selectedFoodListPanel.add(selectedFoodScrollPane, BorderLayout.CENTER);

        // สร้างปุ่มเพิ่มอาหาร
        JButton addButton = new JButton("add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedFood = foodList.getSelectedValue();
                if (selectedFood != null) {
                    foodListModel.removeElement(selectedFood);
                    selectedFoodListModel.addElement(selectedFood);
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        // สร้าง GUI
        setLayout(new BorderLayout());
        add(foodListPanel, BorderLayout.WEST);
        add(selectedFoodListPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
        //add(mainPanel);
    }
}
    

