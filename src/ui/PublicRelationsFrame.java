package ui;

import model.PR.PRDepartment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicRelationsFrame extends StandardFrame{
    private static final Font LABEL_FONT = new Font("Arial",Font.BOLD,16);
    private PRDepartment prDepartment;

    public PublicRelationsFrame(){
        super("Public Relations");
        prDepartment = new PRDepartment();
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(250, 200, 100, 200));
        setLayout(new GridLayout(0,1,20,20));
        JTextField nameField = new JTextField();
        nameField.setFont(DEPT_FONT);
        JTextArea infoArea = new JTextArea();
        infoArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        infoArea.setEditable(false);
        infoArea.setFont(DEPT_FONT);
        JLabel searchLabel = new JLabel("Search: ");
        searchLabel.setFont(LABEL_FONT);
        JLabel infoLabel = new JLabel("\n Information: ");
        infoLabel.setFont(LABEL_FONT);
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.white);
        searchButton.setActionCommand("search");
        searchButton.setFont(BUTTON_FONT);
        add(searchLabel);
        add(nameField);
        add(infoLabel);
        add(infoArea);
        add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand()=="search"){
                    playMusic("./source/walawala.wav");
                    infoArea.setText(prDepartment.display(nameField.getText()));
                    nameField.setText("");
                }
            }
        });


    }

}
