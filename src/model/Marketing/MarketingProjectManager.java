package model.Marketing;

import java.util.ArrayList;
import java.util.List;

public class MarketingProjectManager {
    private static MarketingProjectManager ourInstance = new MarketingProjectManager();
    private List<model.Marketing.MarketingProject> projects;

    public static MarketingProjectManager getInstance() {
        return ourInstance;
    }

    private MarketingProjectManager() {
        projects = new ArrayList<>();

    }

    public void addProject(MarketingProject p){
        if(!projects.contains(p)){
            projects.add(p);
        }
    }

    public MarketingProject getProject(int index) {
        return projects.get(index);
    }

    public String[] getProjectNames() {
        String[] names = new String[projects.size()];
        int i = 0;
        for (MarketingProject project: projects) {
            names[i] = project.getPname();
            ++ i;
        }
        return names;
    }
}
