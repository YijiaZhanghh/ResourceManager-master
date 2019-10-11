package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaintingFrame extends StandardFrame implements MouseMotionListener, MouseListener, ActionListener {
    public static final int RAINBOW_MODE = 1;

    private int prevX;
    private int prevY;
    private int currX;
    private int currY;
//    private Color[] colors = {new Color(179, 81, 81), new Color(179, 95, 81), new Color(179, 109, 81)
//            , new Color(179, 123, 81), new Color(179, 139, 81), new Color(179, 153, 81), new Color(179, 167, 81)
//            , new Color(179, 179, 81), new Color(165, 179, 81), new Color(151, 179, 81), new Color(135, 179, 81)
//            , new Color(121, 179, 81), new Color(107, 179, 81), new Color(93, 179, 81), new Color(81, 179, 83)
//            , new Color(81, 179, 97), new Color(81, 179, 114), new Color(81, 179, 128), new Color(81, 179, 142)
//            , new Color(81, 179, 156), new Color(81, 179, 170), new Color(81, 177, 179), new Color(81, 160, 179)
//            , new Color(81, 146, 179), new Color(81, 132, 179), new Color(81, 118, 179), new Color(81, 104, 179)
//            , new Color(81, 90, 179), new Color(86, 81, 179), new Color(102, 81, 179), new Color(116, 81, 179)
//            , new Color(130, 81, 179), new Color(144, 81, 179), new Color(158, 81, 179), new Color(172, 81, 179)
//            , new Color(179, 81, 179), new Color(179, 81, 158), new Color(179, 81, 130), new Color(179, 81, 116)
//            , new Color(179, 81, 102), new Color(179, 81, 86), new Color(179, 81, 81)};
    private Color[] colors = {new Color(255, 0, 0), new Color(255, 30, 0), new Color(255, 60, 0)
        , new Color(255, 90, 0), new Color(255, 120, 0), new Color(255, 150, 0), new Color(255, 165, 0)
        , new Color(255, 195, 0), new Color(255, 225, 0), new Color(255, 255, 0), new Color(225, 255, 0)
        , new Color(195, 255, 0), new Color(165, 255, 0), new Color(135, 255, 0), new Color(105, 255, 0)
        , new Color(75, 255, 0), new Color(45, 255, 0), new Color(30, 255, 0), new Color(0, 255, 0)
        , new Color(0, 225, 0), new Color(0, 195, 0), new Color(0, 165, 0), new Color(0, 127, 0)
        , new Color(0, 127, 30), new Color(0, 127, 90), new Color(0, 127, 120), new Color(0, 127, 150)
        , new Color(0, 127, 180), new Color(0, 127, 210), new Color(0, 127, 255), new Color(0, 97, 255)
        , new Color(0, 67, 255), new Color(0, 37, 255), new Color(0, 0, 255)
        , new Color(30, 0, 255), new Color(60, 0, 255), new Color(75, 0, 255), new Color(90, 0, 255)
        , new Color(95, 0, 255), new Color(110, 0, 255), new Color(139, 0, 255)};
//    private Color[] colors = {new Color(255, 0, 0), new Color(255, 165, 0), new Color(255, 255, 0)
//            , new Color(0, 255, 0), new Color(0, 127, 255), new Color(0, 0, 255), new Color(139, 0, 255)};
    private int currentColorIndex;
    private JButton saveButton;
    private int mode;
    //private JPanel paintingPanel;

    public PaintingFrame(String title, String imagePath) {
        super(title);
        initializePainting();
        mode = 0;
        ImageIcon background = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(background);
        this.getLayeredPane().add(imageLabel, new Integer(Integer.MIN_VALUE + 1));
        imageLabel.setBounds(FRAME_WIDTH / 2 - background.getIconWidth() / 2, FRAME_HEIGHT / 2 - background.getIconHeight() / 3, background.getIconWidth(), background.getIconHeight());
        addMouseMotionListener(this);
        addMouseListener(this);

        setLayout(null);
        saveButton = new JButton("SAVE");
        saveButton.setBounds(FRAME_WIDTH / 2 - 45, FRAME_HEIGHT - 100, 90, 50);
        saveButton.setContentAreaFilled(false);
        saveButton.addActionListener(this);
        saveButton.setFont(BUTTON_FONT);
        saveButton.setActionCommand("save");
        //add(saveButton);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (prevX == -1 || prevY == -1) {
            prevX = e.getX();
            prevY = e.getY();
        } else {
            Graphics2D g = (Graphics2D) getGraphics();
            currX = e.getX();
            currY = e.getY();
            currentColorIndex ++;
            currentColorIndex %= colors.length;
            g.setColor(colors[currentColorIndex]);
            g.setStroke(new BasicStroke(3.0f));
            g.drawLine(prevX, prevY, currX, currY);
//            Graphics2D paintingG = (Graphics2D) paintingPanel.getGraphics();
//            paintingG.setColor(colors[currentColorIndex]);
//            paintingG.setStroke(new BasicStroke(3.0f));
//            paintingG.drawLine(prevX, prevY, currX, currY);
            if (mode != RAINBOW_MODE) {
                prevX = currX;
                prevY = currY;
            }

        }
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    private void initializePainting() {
        prevX = -1;
        prevY = -1;
        currentColorIndex = 0;
//        paintingPanel = new JPanel();
//        paintingPanel.setVisible(true);
//        paintingPanel.setBounds(getBounds());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("I am flying");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        initializePainting();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("save")) {
            saveButton.setVisible(false);
//            Container container = getContentPane();
//            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
//            Graphics2D graphics2D = image.createGraphics();
//            container.printAll(graphics2D);
//            File file = new File("ss.jpg");
//            //File file = new File("./screenshots/" + new Date().toString() + ".jpg");
//            try {
//                ImageIO.write(image, "jpg", file);
//            } catch (IOException e1) {
//                JOptionPane.showMessageDialog(this, "Save Image fails.", "Error", JOptionPane.WARNING_MESSAGE);
//            }
//            graphics2D.dispose();
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//            BufferedImage paintingImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//            paintingPanel.paint(paintingImage.createGraphics());
            Graphics2D graphics2D = image.createGraphics();
            paint(graphics2D);
//            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            try {
                ImageIO.write(image, "PNG", new File("ss.png"));
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this, "Save Image fails.", "Error", JOptionPane.WARNING_MESSAGE);
            }
            graphics2D.dispose();
            saveButton.setVisible(true);
        }
    }
}
