package ui;

import model.Events.EProjectsPriority;
import model.Events.EventsProject;
import model.Events.EventsProjectManager;
import model.Marketing.Post;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventsFrame extends StandardFrame implements ActionListener {

    private EventsProjectManager eventsProjectManager = EventsProjectManager.getInstance();
    private EventsProject selectedProject;
    private JLabel projectName;
    private JLabel projectDate;
    private JLabel projectPriority;
    private JLabel projectTimesToStart;
    private JTextField postTitle;
    private JTextField postContent;

    public EventsFrame(){
        super("Events");
        setLayout(null);
        listOfProjects();
        JList<String> eventList = new JList<>();
        eventList.setFont(DEPT_FONT);
        eventList.setSize(100, 300);
        eventList.setListData(eventsProjectManager.getProjectNames());
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<String> list = (JList<String>) e.getSource();
                selectedProject = eventsProjectManager.getProject(list.getSelectedIndex());
                projectChanged();
            }
        });
        JScrollPane listPane = new JScrollPane(eventList);
        listPane.setOpaque(false);
        listPane.setBounds(0,280,FRAME_WIDTH / 3, FRAME_HEIGHT - 250);
        // right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(FRAME_WIDTH / 3, 250, FRAME_WIDTH * 2 / 3, FRAME_HEIGHT - 250);
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // right panel
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(2, 2, 50, 10));
        topPanel.setBorder(new EmptyBorder(20, 100, 20, 100));
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBorder(new EmptyBorder(20, 150, 20, 150));
        // top panel on right
        projectName = new JLabel("name: ", JLabel.CENTER);
        projectName.setFont(DEPT_FONT);
        projectDate = new JLabel("date: ", JLabel.CENTER);
        projectDate.setFont(DEPT_FONT);
        projectPriority = new JLabel("priority: ", JLabel.CENTER);
        projectPriority.setFont(DEPT_FONT);
        projectTimesToStart = new JLabel("time to start: ", JLabel.CENTER);
        projectTimesToStart.setFont(DEPT_FONT);
        topPanel.add(projectName);
        topPanel.add(projectDate);
        topPanel.add(projectPriority);
        topPanel.add(projectTimesToStart);
        // bottom panel on right
        postTitle = new JTextField(8);
        postTitle.setText("title");
        postTitle.setFont(DEPT_FONT);
        postContent = new JTextField( 20);
        postContent.setText("content");
        postContent.setFont(DEPT_FONT);
        JButton addButton = new JButton("Add");
        addButton.setActionCommand("add");
        addButton.addActionListener(this);
        addButton.setBackground(Color.white);
        addButton.setFont(BUTTON_FONT);
        bottomPanel.add(postTitle);
        bottomPanel.add(postContent);
        bottomPanel.add(addButton);
        rightPanel.add(topPanel);
        rightPanel.add(bottomPanel);
        rightPanel.add(Box.createVerticalGlue());

        add(listPane);
        add(rightPanel);
    }

    private void projectChanged() {
        if (selectedProject != null) {
            projectName.setText("name: " + selectedProject.getPname());
            projectDate.setText("date: " + selectedProject.getPdate());
            projectPriority.setText("priority: " + selectedProject.getPriority(selectedProject));
            projectTimesToStart.setText("time to start: " + selectedProject.getTimesToStart(selectedProject));
        }
    }

    private void listOfProjects() {
        java.util.List<Integer> p1scores = new java.util.ArrayList<>();
        p1scores.add(10);
        p1scores.add(10);
        java.util.List<Integer> p2scores = new java.util.ArrayList<>();
        p2scores.add(5);
        p2scores.add(6);
        java.util.List<Integer> p3scores = new java.util.ArrayList<>();
        p3scores.add(8);
        p3scores.add(9);
        EventsProject p1 = new EventsProject("LiuSheng Cup", "2019.11.11", p1scores, new EProjectsPriority(), 300);
        EventsProject p2 = new EventsProject("BBQ Party", "2018.12.01", p2scores, new EProjectsPriority(), 7);
        EventsProject p3 = new EventsProject("New Year Party", "2019.1.01", p3scores, new EProjectsPriority(), 40);
        eventsProjectManager.addProjects(p1);
        eventsProjectManager.addProjects(p2);
        eventsProjectManager.addProjects(p3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {

            if (selectedProject == null) {
                playMusic("./source/dang.wav");
                JOptionPane.showMessageDialog(this, "No project is selected. Please select a project and try again.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (postTitle.getText().equals("")) {
                playMusic("./source/dang.wav");
                JOptionPane.showMessageDialog(this, "Title should not be empty. Please enter title and try again.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (postContent.getText().equals("")) {
                playMusic("./source/dang.wav");
                JOptionPane.showMessageDialog(this, "Title should not be empty. Please enter title and try again.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                selectedProject.addPost(new Post(postTitle.getText(), postContent.getText()));
                postTitle.setText("");
                postContent.setText("");
                playMusic("./source/walawala.wav");
                JOptionPane.showMessageDialog(this, "You are all set.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
