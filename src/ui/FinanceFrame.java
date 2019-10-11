package ui;

import model.Finance.FinanceDepartment;
import model.exceptions.LoadFailException;
import model.exceptions.isNegException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class FinanceFrame extends StandardFrame implements ActionListener {
    private FinanceDepartment f = FinanceDepartment.getInstancce();

    private JTextField finfield;
    private JTextArea area;

    public FinanceFrame() {
        super("Finance");
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(300, 150, 20, 150));
        setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        getContentPane().setBackground(Color.white);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(0,1, 0, 30));
        leftPanel.setOpaque(false);
        rightPanel.setLayout(new GridLayout(0,1, 0, 80));
        rightPanel.setOpaque(false);

        finfield = new JTextField(15);
        finfield.setFont(DEPT_FONT);
        JButton income = new JButton("Income");
        income.setFont(BUTTON_FONT);
        income.setActionCommand("income");
        income.addActionListener(this);
        income.setContentAreaFilled(false);
        JButton expenditure = new JButton("Expenditure");
        expenditure.setActionCommand("expenditure");
        expenditure.addActionListener(this);
        expenditure.setContentAreaFilled(false);
        expenditure.setFont(BUTTON_FONT);
        JButton save = new JButton("Save");
        save.setActionCommand("save");
        save.setFont(BUTTON_FONT);
        save.addActionListener(this);
        save.setContentAreaFilled(false);
        JButton load = new JButton("Load");
        load.setFont(BUTTON_FONT);
        load.setActionCommand("load");
        load.addActionListener(this);
        load.setContentAreaFilled(false);
        area = new JTextArea();
        area.setFont(DEPT_FONT);
        area.setLineWrap(true);
        area.setBounds(100,200,100,200);
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        area.setEditable(false);
        area.setText("Balance"+"\n"+ 0 +"\n");

        leftPanel.add(income);
        leftPanel.add(expenditure);
        leftPanel.add(save);
        leftPanel.add(load);
        rightPanel.add(finfield);
        rightPanel.add(area);

        add(leftPanel);
        add(rightPanel);

        finfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    area.setText(area.getText() + "\n" + finfield.getText());
                    finfield.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
}


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "income":
                try {
                    f.addIn(Integer.valueOf(finfield.getText()));
                    playMusic("./source/mario.wav");
                } catch (isNegException exception) {
                    playMusic("./source/dang.wav");
                    JOptionPane.showMessageDialog(this, "Please enter number and try again.", "Negative Number Error", JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException exception) {
                    playMusic("./source/dang.wav");
                    JOptionPane.showMessageDialog(this, "Please enter number and try again.", "No Input Error", JOptionPane.WARNING_MESSAGE);
                }
                area.setText("Balance" + "\n" + f.getBalance() + "\n");
                finfield.setText("");
                break;
            case "expenditure":
                try {
                    f.minusIn(Integer.valueOf(finfield.getText()));
                    playMusic("./source/mario.wav");
                } catch (isNegException exception) {
                    playMusic("./source/dang.wav");
                    JOptionPane.showMessageDialog(this, "Please enter number and try again.", "Negative Number Error", JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException exception) {
                    playMusic("./source/dang.wav");
                    JOptionPane.showMessageDialog(this, "Please enter number and try again.", "No Input Error", JOptionPane.WARNING_MESSAGE);
                }
                area.setText("Balance" + "\n" + f.getBalance() + "\n");
                finfield.setText("");
                break;
            case "load":
                try {
                    String balanceString = f.load();
                    playMusic("./source/mario.wav");
                    area.setText("Balance" + "\n" + balanceString + "\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (LoadFailException e1) {
                    playMusic("./source/dang.wav");
                    JOptionPane.showMessageDialog(this, "Invalid Input. Please enter a number.", "Input Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "save":
                try {
                    f.save();
                    playMusic("./source/mario.wav");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
}
