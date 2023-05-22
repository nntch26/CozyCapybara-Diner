import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestSvgButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PNG Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            File imageFile = new File("src/main/resources/imggui/layer 4j.png"); // แทนที่ด้วยพาธของไฟล์ PNG ของคุณ
            BufferedImage image = ImageIO.read(imageFile);

            // ปรับขนาดรูปภาพให้เหมาะสมกับ JButton
            int width = 600;
            int height = 290;
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            // สร้าง JButton และตั้งค่ารูปภาพให้เป็นรูปภาพที่ปรับขนาดแล้ว
            JButton button = new JButton("Table 1",new ImageIcon(scaledImage));
            button.setPreferredSize(new Dimension(width, height));


            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);

            frame.getContentPane().add(button);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






