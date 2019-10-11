package model.Administration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MembersManager implements Iterable<Members>{
    private static MembersManager instance = new MembersManager();
    private List<Members> members;

    public static MembersManager getInstance() {
        return instance;
    }

    private MembersManager(){
        members = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        Members m1 = new Members("Yijia",1,2017);
        members.add(m1);
        Members m2 = new Members("Jetty",2,2017);
        members.add(m2);
        Members m3 = new Members("Mic", 3,2016);
        members.add(m3);
        Members m4 = new Members("Fendi",4,2016);
        members.add(m4);
        Members m5 = new Members("Kimberley",5,2016);
        members.add(m5);
    }

    //REQUIRES:
    //MODIFIES: this.
    //EFFECTS: add member m to the list members
    public void addMember(Members m){
        members.add(m);
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: for next member in the list, check if the name equals the name of the member
    // return true and print statement if true, else return false
    public String checkMembersExist(String name){
        for (Members next: members){
            if (next.getName().equals(name)){
                return ("Find a member with: "+"\n"+"Name: "+ next.getName()+"\n"+"Year: "+next.getYear()+"\n"+"No: "+next.getNum());
            }
        }
        return ("Member Not Found");
    }


    @Override
    public Iterator<Members> iterator() {
        return members.iterator();
    }
}




























