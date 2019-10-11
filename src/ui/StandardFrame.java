package ui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class StandardFrame extends JFrame {
    private static final String BACKGROUND_IMAGE_PATH = "./source/background.png";
    protected static final Font BUTTON_FONT = new Font("Arial",Font.BOLD,17);
    protected static final Font DEPT_FONT = new Font("Arial",Font.PLAIN,17);
    protected static final int FRAME_WIDTH = 1200;
    protected static final int FRAME_HEIGHT = 900;

    public StandardFrame(String title){
        super(title);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        ((JPanel) getContentPane()).setOpaque(false);

        setBackground();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void setBackground() {
        ImageIcon background = new ImageIcon(BACKGROUND_IMAGE_PATH);
        JLabel imageLabel = new JLabel(background);
        JPanel whitePanel = new JPanel();
        whitePanel.setBounds(0,0,FRAME_WIDTH, FRAME_HEIGHT);
        whitePanel.setBackground(Color.white);
        this.getLayeredPane().add(whitePanel, new Integer(Integer.MIN_VALUE));
        this.getLayeredPane().add(imageLabel, new Integer(Integer.MIN_VALUE + 1));
        imageLabel.setBounds(FRAME_WIDTH / 2 - background.getIconWidth() / 2, 0, background.getIconWidth(), background.getIconHeight());
    }

    protected void playMusic(String musicPath) {
        File musicFile = new File(musicPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException e) {
            //
        } catch (IOException e) {
            //
        } catch (UnsupportedAudioFileException e) {
            //
        }
    }
}
