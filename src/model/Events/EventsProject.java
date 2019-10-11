package model.Events;

import model.Marketing.OfficialAccount;
import model.Marketing.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Concrete Subject
public class EventsProject extends OfficialAccountSubject{
    //private List<OfficialAccount> officialAccounts;
    private String pname;
    private String pdate;
//    private Map<EventsProject,Executive> projectMap = new HashMap<>();
    private List<Post> posts;
    private EProjectsPriority eProjectsPriority;
    private List<Integer> eScoreList;
    private int countdown;

    public EventsProject(String pname, String pdate,List<Integer> eScoreList, EProjectsPriority eProjectsPriority, int countdown){
        //officialAccounts = new ArrayList<>();
        posts = new ArrayList<>();
        this.pname = pname;
        this.pdate = pdate;
        this.eProjectsPriority = eProjectsPriority;
        this.eScoreList = eScoreList;
        this.countdown = countdown;
        addObserver(OfficialAccount.getInstance());
//        printExe();
    }


    public void addPost(Post post){
        posts.add(post);
        notifyObservers(post);
    }

//    public void printExe(){
//        Executive e1 = new Executive();
//        projectMap.put(this,e1);
//        System.out.println(projectMap.get(this));
//    }


    public String getPname() {
        return pname;
    }

    public String getPdate() {
        return pdate;
    }

    public String getPriority(EventsProject eventsProject) {
        return eProjectsPriority.priority(eventsProject);
    }

    public String getTimesToStart(EventsProject eventsProject) {
        return eProjectsPriority.timeToStart(eventsProject);
    }

    public List<Integer> geteScoreList(){
        return eScoreList;
    }

    public int getCountdown(){
        return countdown;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsProject project = (EventsProject) o;
        return Objects.equals(pname, project.pname) &&
                Objects.equals(pdate, project.pdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pname, pdate);
    }
}
