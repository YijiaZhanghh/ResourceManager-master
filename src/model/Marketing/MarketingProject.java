package model.Marketing;

import java.util.List;
import java.util.Objects;

public class MarketingProject {
    //private List<OfficialAccount> officialAccounts;
    private String pname;
    private String pdate;
    //private List<Post> posts;
    private MProjectsPriority mProjectsPriority;
    private List<Integer> mScoreList;

    public MarketingProject(String pname, String pdate,List<Integer> eScoreList, MProjectsPriority mProjectsPriority){
        //posts = new ArrayList<>();
        this.pname = pname;
        this.pdate = pdate;
        this.mProjectsPriority = mProjectsPriority;
        this.mScoreList = eScoreList;
    }


    public String getPname() {
        return pname;
    }

    public String getPdate() {
        return pdate;
    }

    public String getPriority(MarketingProject marketingProject) {
        return mProjectsPriority.priority(marketingProject);
    }

    public String getTimesToStart(MarketingProject marketingProject) {
        return mProjectsPriority.timeToStart(marketingProject);
    }

    public List<Integer> getmScoreList(){
        return mScoreList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketingProject that = (MarketingProject) o;
        return Objects.equals(pname, that.pname) &&
                Objects.equals(pdate, that.pdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pname, pdate);
    }
}
