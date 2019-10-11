package ui;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Visual extends JFrame implements ActionListener, WindowFocusListener {
    private static final String BACKGROUND_IMAGE_PATH = "./source/background.png";
    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 600;
    private static final Font BUTTON_FONT = new Font("Arial",Font.BOLD,15);
    private static final Font LABEL_FONT = new Font("Arial",Font.BOLD,17);
    private Clip clip;

public Visual() {
        super("CSSA Resource Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));
        ((JPanel) getContentPane()).setOpaque(false);
        getContentPane().setBackground(Color.white);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel topPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(2, 4, 40, 40));
        buttonPanel.setSize(FRAME_WIDTH, FRAME_HEIGHT * 4 / 5);
        buttonPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setOpaque(false);

        JButton aca = new JButton("Academics");
        aca.setActionCommand("aca");
        aca.setContentAreaFilled(false);
        aca.addActionListener(this);
        aca.setFont(BUTTON_FONT);
        JButton adm = new JButton("Administration");
        adm.setActionCommand("adm");
        adm.setContentAreaFilled(false);
        adm.addActionListener(this);
        adm.setFont(BUTTON_FONT);
        JButton er = new JButton("External Relationships");
        er.setActionCommand("er");
        er.setContentAreaFilled(false);
        er.addActionListener(this);
        er.setFont(BUTTON_FONT);
        JButton ev = new JButton("Events");
        ev.setActionCommand("ev");
        ev.setContentAreaFilled(false);
        ev.addActionListener(this);
        ev.setFont(BUTTON_FONT);
        JButton fin = new JButton("Finance");
        fin.setActionCommand("fin");
        fin.setContentAreaFilled(false);
        fin.addActionListener(this);
        fin.setFont(BUTTON_FONT);
        JButton mkt = new JButton("Marketing");
        mkt.setActionCommand("mkt");
        mkt.setContentAreaFilled(false);
        mkt.addActionListener(this);
        mkt.setFont(BUTTON_FONT);
        JButton pr = new JButton("Public Relationships");
        pr.setActionCommand("pr");
        pr.setContentAreaFilled(false);
        pr.addActionListener(this);
        pr.setFont(BUTTON_FONT);
        JButton srv = new JButton("Services");
        srv.setActionCommand("srv");
        srv.setContentAreaFilled(false);
        srv.addActionListener(this);
        srv.setFont(BUTTON_FONT);

        JLabel topLabel = new JLabel("The Chinese Students and Scholars Association at UBC", JLabel.CENTER);
        topLabel.setFont(LABEL_FONT);
        JLabel bottomLabel = new JLabel("Serving Chinese Students, Creating Global Connections", JLabel.CENTER);
        bottomLabel.setFont(LABEL_FONT);
        topLabel.setOpaque(false);
        bottomLabel.setOpaque(false);

        topPanel.add(topLabel);
        bottomPanel.add(bottomLabel);
        buttonPanel.add(adm);
        buttonPanel.add(aca);
        buttonPanel.add(er);
        buttonPanel.add(ev);
        buttonPanel.add(fin);
        buttonPanel.add(mkt);
        buttonPanel.add(pr);
        buttonPanel.add(srv);

        add(Box.createGlue());
        getContentPane().add(topPanel);
        getContentPane().add(buttonPanel);
        add(Box.createGlue());
        add(bottomPanel);

        addWindowFocusListener(this);
        //playMusic("./source/bgm.wav");
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
        imageLabel.setBounds(FRAME_WIDTH / 2 - background.getIconWidth() / 2, FRAME_HEIGHT / 2 - background.getIconHeight() / 2, background.getIconWidth(), background.getIconHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stopMusic();
        playMusic("./source/walawala.wav");
        switch (e.getActionCommand()) {
            case "aca":
                new AcademicsFrame();
                break;
            case "adm":
                new AdminFrame();
                break;
            case "er":
                new ExternalRelationshipsFrame();
                break;
            case "ev":
                new EventsFrame();
                break;
            case "fin":
                new FinanceFrame();
                break;
            case "mkt":
                new MarketingFrame();
                break;
            case "pr":
                new PublicRelationsFrame();
                break;
            default:
                new ServicesFrame();
                break;
        }
    }

    private void playMusic(String musicPath) {
        File musicFile = new File(musicPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
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

    private void stopMusic() {
        if (clip.isRunning()) clip.stop();
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        if (clip == null || !clip.isRunning()) {
            playMusic("./source/bgm.wav");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {

    }
}
