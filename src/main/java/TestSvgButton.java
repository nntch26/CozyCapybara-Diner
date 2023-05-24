//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import org.apache.batik.dom.svg.SVGDOMImplementation;
//import org.apache.batik.svggen.SVGGraphics2D;
//import org.apache.batik.*;
//import org.apache.batik.util.SVGConstants;
//import org.w3c.dom.DOMImplementation;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//public class TestSvgButton {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("PNG Button Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JButton button = new JButton();
//        button.setSize(200, 200);
//
//        // Read SVG file
//        String svgFilePath = "imggui/Layer 4.svg";
//        File svgFile = new File(svgFilePath);
//
//        try {
//            // Convert SVG to BufferedImage
//            BufferedImage image = convertSVGToImage(svgFile, button.getWidth(), button.getHeight());
//
//            // Create Icon from BufferedImage
//            Icon icon = new ImageIcon(image);
//
//            // Set Icon to JButton
//            button.setIcon(icon);
//
//            // Add JButton to JFrame
//            frame.getContentPane().add(button);
//            frame.pack();
//            frame.setVisible(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static BufferedImage convertSVGToImage(File svgFile, int width, int height) throws IOException {
//        // Create SVG Document
//        DOMImplementation domImpl = SVGDOMImplementation.getDOMImplementation();
//        String svgNS = SVGConstants.SVG_NAMESPACE_URI;
//        Document document = domImpl.createDocument(svgNS, "svg", null);
//        SVGGraphics2D svgGraphics = new SVGGraphics2D(document);
//
//        // Read SVG file
//        svgGraphics.setSVGCanvasSize(new java.awt.Dimension(width, height));
//        svgGraphics.getTransform().scale(width / 1000.0, height / 1000.0);
//        svgGraphics.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
//                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
//        svgGraphics.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
//                java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        svgGraphics.setRenderingHint(java.awt.RenderingHints.KEY_FRACTIONALMETRICS,
//                java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//        svgGraphics.setRenderingHint(java.awt.RenderingHints.KEY_RENDERING,
//                java.awt.RenderingHints.VALUE_RENDER_QUALITY);
//
//        // Read SVG file and paint to SVGGraphics2D
//        org.apache.batik.transcoder.TranscoderInput transcoderInput = new org.apache.batik.transcoder.TranscoderInput(
//                svgFile.toURI().toString());
//        org.apache.batik.transcoder.Transcoder transcoder = new org.apache.batik.transcoder.image.ImageTranscoder();
//        transcoder.addTranscodingHint(org.apache.batik.transcoder.image.ImageTranscoder.KEY_DOM_IMPLEMENTATION,
//                domImpl);
//        transcoder.transcode(transcoderInput, null);
//        Element root = svgGraphics.getRoot();
//        root.appendChild(transcoder.getInput());
//
//        // Convert SVGGraphics2D to BufferedImage
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D graphics = image.createGraphics();
//        svgGraphics.paint(graphics);
//        graphics.dispose();
//
//        return image;
//    }
//}
//
//
//
//
//
