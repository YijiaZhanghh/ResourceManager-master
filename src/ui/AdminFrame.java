package ui;

import model.Administration.ExecutiveManager;
import model.Administration.MembersManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class AdminFrame extends StandardFrame{

    private MembersManager mm = MembersManager.getInstance();

    public AdminFrame() {
        super("Administration");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.white);
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setOpaque(false);

        JLabel adml = new JLabel("Members Manager");
        topPanel.add(adml);
        adml.setFont(BUTTON_FONT);
        JTextField admfield = new JTextField(10);

        topPanel.add(admfield);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        JTextArea adma = new JTextArea();
        adma.setLineWrap(true);
        adma.setBorder(border);
        adma.setBounds(400,300,400,300);
        adma.setEditable(false);
        adma.setOpaque(false);
        //JScrollPane scPane = new JScrollPane(area);
        adma.setText("\n");
        topPanel.add(adma);
        JLabel adml2 = new JLabel("Executives Manager");
        adml2.setFont(BUTTON_FONT);
        bottomPanel.add(adml2);
        JTextField admfield1 = new JTextField(10);
        bottomPanel.add(admfield1);
        JTextArea adma1 = new JTextArea();
        admfield.setFont(DEPT_FONT);
        admfield1.setFont(DEPT_FONT);

        adma1.setLineWrap(true);
        adma1.setBounds(400,300,400,300);
        adma1.setBorder(border);
        adma1.setEditable(false);
        //JScrollPane scPane = new JScrollPane(area);
        adma1.setText("\n");
        bottomPanel.add(adma1);
        admfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    adma.setText(mm.checkMembersExist(admfield.getText()));
                    admfield.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        admfield1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    try {
                        adma1.setText(ExecutiveManager.displayer(admfield1.getText()));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    admfield1.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(topPanel);
        add(bottomPanel);
        //add(Box.createVerticalGlue());

    }

}
