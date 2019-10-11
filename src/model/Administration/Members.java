package model.Administration;


import model.Marketing.MarketingProject;

import java.util.ArrayList;
import java.util.List;

public class Members  {

    private String name;
    private int num;
    private int year;
    private List<MarketingProject> project;

    public Members(String name, int num, int year){
        this.name = name;
        this.num = num;
        this.year = year;
        project = new ArrayList<>();
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: return the name of members
    public String getName() {return name;}
    //REQUIRES:
    //MODIFIES:
    //EFFECTS: return registration number of members
    public int getNum(){return num;}
    //REQUIRES:
    //MODIFIES:
    //EFFECTS: return registration year of members
    public int getYear(){return year;}


}
