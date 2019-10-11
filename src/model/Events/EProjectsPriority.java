package model.Events;

import model.exceptions.isZeroException;

public class EProjectsPriority {

    //private EventsProject eventsProject;
    public static final double maxScore = 10.0;

    public void addScores(int i, EventsProject eventsProject){
        if (0<=i && i<=maxScore){
            eventsProject.geteScoreList().add(i);
        }
    }


    public double projectScore(EventsProject eventsProject) throws isZeroException {
        int x = eventsProject.geteScoreList().size();
        double y = 0;
        if(x==0){
            throw new isZeroException();
        }
        for (Integer i: eventsProject.geteScoreList()){
            y = y + i;
        }
        return (y/x);
    }

    public String priority(EventsProject eventsProject) {
        try {
            if (0 <= projectScore(eventsProject) && projectScore(eventsProject) < 3){
                return "";
            } else if (eventsProject.getCountdown() >= 100 && projectScore(eventsProject) >= 3){
                return "*";
            } else if (3 < projectScore(eventsProject)  && eventsProject.getCountdown() < 100 && eventsProject.getCountdown() > 30){
                return "**";
            } else if (6 <= projectScore(eventsProject) && eventsProject.getCountdown() <= 30){
                return "***";
            } else{
                return "";
            }
        } catch (isZeroException e) {
            return "---";
        }
    }


    public String timeToStart(EventsProject eventsProject) {
        if (priority(eventsProject) == "" || priority(eventsProject) == "*"){
            return "Backup Suggestions";
        } else if (priority(eventsProject) == "**"){
            return "Not until next term";
        } else if (priority(eventsProject) == "***"){
            return "Start This Month";
        }else{
            return "Not in consideration";
        }
    }
}
