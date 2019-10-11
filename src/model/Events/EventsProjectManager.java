package model.Events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventsProjectManager {
    private static EventsProjectManager ourInstance = new EventsProjectManager();
    private List<EventsProject> projects;

    public static EventsProjectManager getInstance() {
        return ourInstance;
    }

    private EventsProjectManager() {
        projects = new ArrayList<>();
    }

    public void addProject(EventsProject project) {
        projects.add(project);
    }

    public void removeProject(String projectName) {
        for (EventsProject project : projects) {
            if (project.getPname().equals(projectName)) {
                projects.remove(projectName);
                return;
            }
        }
    }

    public List<EventsProject> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public EventsProject getProject(int index) {
        return projects.get(index);
    }

    public void addProjects(EventsProject p){
            if(!projects.contains(p)){
                projects.add(p);
            }
        }


    public String[] getProjectNames() {
        String[] names = new String[projects.size()];
        int i = 0;
        for (EventsProject project: projects) {
            names[i] = project.getPname();
            ++ i;
        }
        return names;
    }
}
