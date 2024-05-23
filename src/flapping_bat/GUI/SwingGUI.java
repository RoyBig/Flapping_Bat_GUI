package flapping_bat.GUI;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import flapping_bat.AppMVC;
import flapping_bat.model.Position;
import flapping_bat.model.enums.AppStatus;
import flapping_bat.model.enums.Colors;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


    public class SwingGUI {

        public static final int HEIGHT = 560;
        public static final int WIDTH = 496;

        private JFrame jFrame;
        private JLabel jLabelFrame;

        public SwingGUI() {
            this.jFrame = new JFrame("Flapping Bat");
            this.jLabelFrame = new JLabel();
            jFrame.setSize(WIDTH, HEIGHT + 16);
            jLabelFrame.setSize(WIDTH, HEIGHT + 16);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setResizable(false);
            jFrame.add(jLabelFrame);
            jFrame.setVisible(false);
            jLabelFrame.setVisible(false);
        }

        public void drawImage(int x, int y, String imagePath, int xSize, int ySize) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            JLabel jLabel = new JLabel(imageIcon);
            jLabel.setBounds(x, y, xSize, ySize);
            jLabelFrame.add(jLabel);
        }
        public void drawRectangle(int x, int y, int width, int height, String imagePath) {
            for(int a = x; a < x + width; a++){
                for(int b = y; b < y + height; b++){
                    drawImage(a,b,imagePath,16,16);
                }

            }
            drawImage(x,y,imagePath,width,height);
        }

        public void setVisible() {
            jFrame.setVisible(true);
            jLabelFrame.setVisible(true);
        }
        public void addText(String text, Font font, int x, int y, int x_size, int y_size, Color color){
            JLabel textLabel = new JLabel(text);
            textLabel.setFont(font);
            textLabel.setForeground(color);
            textLabel.setBounds(x,y, x_size, y_size);
            jLabelFrame.add(textLabel);
        }
        public void addButton(String pathToGraphics, int x, int y, ActionListener actionListener){
            ImageIcon imageIcon = new ImageIcon(pathToGraphics);
            JButton jButton = new JButton(imageIcon);
            jButton.setBorderPainted(false);
            jButton.setContentAreaFilled(false);
            jButton.setBounds(x,y,imageIcon.getIconWidth(), imageIcon.getIconHeight());
            jButton.addActionListener(actionListener);
            jLabelFrame.add(jButton);
        }
        public void addTextLabel(int x, int y,String text, Font font, DocumentListener documentListener){
            JTextArea jTextArea = new JTextArea(1,10);
            jTextArea.setBounds(x,y,250,40);
            jTextArea.setFont(font);
            jTextArea.getDocument().addDocumentListener(documentListener);
            jTextArea.setText(text);
            jLabelFrame.add(jTextArea);
        }

        public void paintBackground(String pathToGraphic) {
            ImageIcon backgroundIcon = new ImageIcon(pathToGraphic);
            JLabel backgroundLabel = new JLabel(backgroundIcon);
            backgroundLabel.setBounds(0, 0, WIDTH, HEIGHT);
            jFrame.add(backgroundLabel);
        }

        public void clear(){
            jFrame.getContentPane().removeAll();
            this.jLabelFrame = new JLabel();
            jFrame.setSize(WIDTH, HEIGHT + 16);
            jLabelFrame.setSize(WIDTH, HEIGHT + 16);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setResizable(false);
            jFrame.getContentPane().add(jLabelFrame);
            jFrame.setVisible(true);
            jLabelFrame.setVisible(true);
        }
        public void addKeyListener(KeyListener keyListener){
            jFrame.addKeyListener(keyListener);
            jFrame.setFocusable(true);
        }

        public void refresh(){

        }
        public void dispose(){
            jFrame.dispose();
        }
        public int getWidth()
        {
            return WIDTH;
        }
        public int getHeight(){
            return HEIGHT;
        }
        public void close(){
            jFrame.dispose();
        }

    }

