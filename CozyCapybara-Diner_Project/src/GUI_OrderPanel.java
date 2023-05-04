import javax.swing.*;
import java.awt.*;




public class GUI_OrderPanel {
    private JFrame frame;
    private JPanel p1,p2,p3, pb1_sub1, pb1_sub2, pb1_sub3, pb2_sub1, pb2_sub2, pb2_sub3, pb3_sub1, pb3_sub2, pb3_sub3 ,pb_1, pb_2, pb_3;
    private JLabel foodname_1, foodname_2, foodname_3, foodname_4, foodname_5, foodname_6, foodname_7, foodname_8, foodname_9;
    private JLabel foodprice_1, foodprice_2, foodprice_3, foodprice_4, foodprice_5, foodprice_6, foodprice_7, foodprice_8, foodprice_9;
    private JTextField countfood_1, countfood_2, countfood_3, countfood_4, countfood_5, countfood_6, countfood_7, countfood_8, countfood_9;
    private JButton plus_1, plus_2, plus_3, plus_4, plus_5, plus_6, plus_7, plus_8, plus_9;
    private JButton minus, reset, total;
    public GUI_OrderPanel(){
        frame = new JFrame();
        //SET JPANEL P1
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        pb_1 = new JPanel(); pb_2 = new JPanel(); pb_3 = new JPanel();
        pb1_sub1 = new JPanel(); pb1_sub2 = new JPanel(); pb1_sub3 = new JPanel();
        pb2_sub1 = new JPanel(); pb2_sub2 = new JPanel(); pb2_sub3 = new JPanel();
        pb3_sub1 = new JPanel(); pb3_sub2 = new JPanel(); pb3_sub3 = new JPanel();
        //SET LABEL FOODNAME
        foodname_1 = new JLabel("THIS IS FOOD 1"); foodname_2 = new JLabel("THIS IS FOOD 2"); foodname_3 = new JLabel("THIS IS FOOD 3");       
        foodname_4 = new JLabel("THIS IS NAME 1"); foodname_5 = new JLabel("THIS IS NAME 2"); foodname_6 = new JLabel("THIS IS NAME 3");      
        foodname_7 = new JLabel("MONKEY 1"); foodname_8 = new JLabel("MONKEY 2"); foodname_9 = new JLabel("MONKEY 3");
        //SET LABEL FOODPRICE
        foodprice_1 = new JLabel("15 BAHT"); foodprice_2 = new JLabel("16 BAHT"); foodprice_3 = new JLabel("17 BAHT");
        foodprice_4 = new JLabel("18 BAHT"); foodprice_5 = new JLabel("19 BAHT"); foodprice_6 = new JLabel("20 BAHT");
        foodprice_7 = new JLabel("21 BAHT"); foodprice_8 = new JLabel("22 BAHT"); foodprice_9 = new JLabel("23 BAHT");
        //SET JTEXTFIELD
        countfood_1 = new JTextField(); countfood_2 = new JTextField(); countfood_3 = new JTextField();
        countfood_4 = new JTextField(); countfood_5 = new JTextField(); countfood_6 = new JTextField();
        countfood_7 = new JTextField(); countfood_8 = new JTextField(); countfood_9 = new JTextField();
        //SET BUTTON P1
        plus_1 = new JButton(); plus_2 = new JButton(); plus_3 = new JButton();       
        plus_4 = new JButton(); plus_5 = new JButton(); plus_6 = new JButton();       
        plus_7 = new JButton(); plus_8 = new JButton(); plus_9 = new JButton();

        //SET FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        
        //SET LAYOUT
        frame.setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(1,2));
        p2.setLayout(new GridLayout(3,1));
        p3.setLayout(new GridLayout(2,1));
        //LAYOUT PBX
        pb_1.setLayout(new GridLayout(3,1)); pb_2.setLayout(new GridLayout(3,1)); pb_3.setLayout(new GridLayout(3,1));
        //LAYOUT PBX_SUBX
        pb1_sub1.setLayout(new GridLayout(2,2)); pb1_sub2.setLayout(new GridLayout(2,2)); pb1_sub3.setLayout(new GridLayout(2,2));
        pb2_sub1.setLayout(new GridLayout(2,2)); pb2_sub2.setLayout(new GridLayout(2,2)); pb2_sub3.setLayout(new GridLayout(2,2));
        pb3_sub1.setLayout(new GridLayout(2,2)); pb3_sub2.setLayout(new GridLayout(2,2)); pb3_sub3.setLayout(new GridLayout(2,2));
        
        //ADD PB1_SUB1
        pb1_sub1.add(foodname_1); pb1_sub1.add(foodprice_1); pb1_sub1.add(countfood_1); pb1_sub1.add(plus_1);
        pb_1.add(pb1_sub1); //sub add to big
        //ADD PB1_SUB2
        pb1_sub2.add(foodname_2); pb1_sub2.add(foodprice_2); pb1_sub2.add(countfood_2); pb1_sub2.add(plus_2);
        pb_1.add(pb1_sub2); //sub add to big
        //ADD PB1_SUB3
        pb1_sub3.add(foodname_3); pb1_sub3.add(foodprice_3); pb1_sub3.add(countfood_3); pb1_sub3.add(plus_3);
        pb_1.add(pb1_sub3); //sub add to big
        //ADD PB2_SUB1
        pb2_sub1.add(foodname_4); pb2_sub1.add(foodprice_4); pb2_sub1.add(countfood_4); pb2_sub1.add(plus_4);
        pb_2.add(pb2_sub1); //sub add to big
        //ADD PB2_SUB2
        pb2_sub2.add(foodname_5); pb2_sub2.add(foodprice_5); pb2_sub2.add(countfood_5); pb2_sub2.add(plus_5);
        pb_2.add(pb2_sub2); //sub add to big
        //ADD PB2_SUB3
        pb2_sub3.add(foodname_6); pb2_sub3.add(foodprice_6); pb2_sub3.add(countfood_6); pb2_sub3.add(plus_6);
        pb_2.add(pb2_sub3); //sub add to big
        //ADD PB3_SUB1
        pb3_sub1.add(foodname_7); pb3_sub1.add(foodprice_7); pb3_sub1.add(countfood_7); pb3_sub1.add(plus_7);
        pb_3.add(pb3_sub1); //sub add to big
        //ADD PB3_SUB2
        pb3_sub2.add(foodname_8); pb3_sub2.add(foodprice_8); pb3_sub2.add(countfood_8); pb3_sub2.add(plus_8);
        pb_3.add(pb3_sub2); //sub add to big
        //ADD PB3_SUB3
        pb3_sub3.add(foodname_9); pb3_sub3.add(foodprice_9); pb3_sub3.add(countfood_9); pb3_sub3.add(plus_9);
        pb_3.add(pb3_sub3); //sub add to big
        //BIG ADD TO MAIN PANEL
        p2.add(pb_1);
        p2.add(pb_2);
        p2.add(pb_3);
        //MAIN PANEL
        p1.add(p2); p1.add(p3);
        //ADD TO FRAME *TEST RUN ONLY*
        frame.add(p1);
    }
}
