package ui;

import model.Marketing.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketingFrame extends StandardFrame implements ActionListener{
    private MarketingProjectManager projectManager = MarketingProjectManager.getInstance();
    private OfficialAccount officialAccount = OfficialAccount.getInstance();
    private MarketingProject selectedProject;
    private JLabel projectName;
    private JLabel projectDate;
    private JLabel projectPriority;
    private JLabel projectTimesToStart;
    private JTextArea newPost;
    private JTextArea oldPost;

    public MarketingFrame(){
        super("Marketing");
        setLayout(null);

        listOfProjects();
        JList<String> marketingList = new JList<>();
        marketingList.setFont(DEPT_FONT);
        marketingList.setSize(100, 300);
        marketingList.setListData(projectManager.getProjectNames());
        marketingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        marketingList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<String> list = (JList<String>) e.getSource();
                selectedProject = projectManager.getProject(list.getSelectedIndex());
                projectChanged();
            }
        });
        JScrollPane listPane = new JScrollPane(marketingList);
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
        //topPanel.setBorder(new EmptyBorder(20, 100, 20, 100));
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
        bottomPanel.setLayout(new GridLayout(2,3, 30, 30));
        JLabel oldLabel = new JLabel("Old Post");
        oldLabel.setForeground(Color.RED);
        oldLabel.setFont(BUTTON_FONT);
        JLabel newLabel = new JLabel("New Post");
        newLabel.setForeground(Color.RED);
        newLabel.setFont(BUTTON_FONT);
        newPost = new JTextArea();
        oldPost = new JTextArea();
        newPost.setEditable(false);
        newPost.setLineWrap(true);
        newPost.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        oldPost.setEditable(false);
        oldPost.setLineWrap(true);
        oldPost.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        updatePosts();
        JButton addButton = new JButton("View");
        addButton.setActionCommand("view");
        addButton.setFont(BUTTON_FONT);
        addButton.addActionListener(this);
        addButton.setContentAreaFilled(false);
        bottomPanel.add(newLabel);
        bottomPanel.add(newPost);
        bottomPanel.add(addButton);
        bottomPanel.add(oldLabel);
        bottomPanel.add(oldPost);

        rightPanel.add(topPanel);
        rightPanel.add(bottomPanel);
        rightPanel.add(Box.createVerticalGlue());

        add(listPane);
        add(rightPanel);
    }

    private void updatePosts() {
        String newPosts = "";
        for (Post post: officialAccount.getNewPosts()) {
            newPosts += "Title: " + post.getTitle() + "\n";
            newPosts += "Content: " + post.getContent() + "\n";
            newPosts += "\n";
        }
        String oldPosts = "";
        for (Post post: officialAccount.getOldPosts()) {
            oldPosts += "Title: " + post.getTitle() + "\n";
            oldPosts += "Content: " + post.getContent() + "\n";
            oldPosts += "\n";
        }
        newPost.setText(newPosts);
        oldPost.setText(oldPosts);
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
        p1scores.add(10);
        p1scores.add(10);
        java.util.List<Integer> p2scores = new java.util.ArrayList<>();
        p2scores.add(5);
        p2scores.add(6);
        p2scores.add(9);
        p2scores.add(3);
        java.util.List<Integer> p3scores = new java.util.ArrayList<>();
        p3scores.add(2);
        p3scores.add(2);
        p3scores.add(3);
        p3scores.add(1);
        java.util.List<Integer> p4scores = new java.util.ArrayList<>();
        p4scores.add(8);
        p4scores.add(4);
        p4scores.add(6);
        p4scores.add(8);
        MarketingProject p1 = new MarketingProject("Weekly News", "2019.02.01", p1scores, new MProjectsPriority());
        projectManager.addProject(p1);
        MarketingProject p2 = new MarketingProject("Vancouver Foodie", "2018.12.21", p2scores, new MProjectsPriority());
        projectManager.addProject(p2);
        MarketingProject p3 = new MarketingProject("Fitness", "2019.02.13", p3scores, new MProjectsPriority());
        projectManager.addProject(p3);
        MarketingProject p4 = new MarketingProject("Recent Activities", "2019.01.01", p4scores, new MProjectsPriority());
        projectManager.addProject(p4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("view")) {
            playMusic("./source/japn.wav");
            officialAccount.viewPosts();
            updatePosts();
        }
    }

}

