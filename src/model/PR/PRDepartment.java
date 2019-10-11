package model.PR;

import java.util.ArrayList;
import java.util.List;

//Composite
public class PRDepartment{
    private List<PRMailingList> prm;

    public PRDepartment(){
        super();
        prm = new ArrayList<>();
        PRMailingList ml1 = new ArtsMailingList("Nakata","Arts",true,false);
        PRMailingList ml2 = new CommMailingList("YM","Commerce",true, true);
        PRMailingList ml3 = new ScienceMailingList("Anthony", "Science",false, false);
        prm.add(ml1);
        prm.add(ml2);
        prm.add(ml3);
    }

    public void addMailingList(PRMailingList pr){
        prm.add(pr);
    }

    public String display(String name) {
        for (PRMailingList pr : prm) {
            if (pr.getName().equals(name))
                return pr.display();
        }
        return "Not Found";
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: print statement "Public Relations"
//    public void titlep() {
//        System.out.println("Public Relations");
//    }


}
