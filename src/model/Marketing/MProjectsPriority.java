package model.Marketing;

import model.exceptions.isZeroException;

public class MProjectsPriority {
    public static final double maxScore = 10.0;

    public void addScores(int i,MarketingProject marketingProject) {
        if (0 <= i && i <= maxScore) {
            marketingProject.getmScoreList().add(i);
        }
    }

    public double projectScore(MarketingProject marketingProject) throws isZeroException {
        int x = marketingProject.getmScoreList().size();
        double y = 0;
        if(x==0){
            throw new isZeroException();
        }
        for (Integer i : marketingProject.getmScoreList()) {
            y = y + i;
        }
        return (y / x);
    }


    public String priority(MarketingProject marketingProject) {
        try {
            if (0 <= projectScore(marketingProject) && projectScore(marketingProject) < 3) {
                return "";
            } else if (3 <= projectScore(marketingProject) && projectScore(marketingProject) < 6) {
                return "*";
            } else if (6 <= projectScore(marketingProject) && projectScore(marketingProject) < 9) {
                return "**";
            } else {
                return "***";
            }
        } catch (isZeroException e) {
            return "---";
        }
    }


    public String timeToStart(MarketingProject marketingProject) {
        if (priority(marketingProject) == "" || priority(marketingProject) == "*") {
            return "Backup Suggestions";
        } else if (priority(marketingProject) == "**") {
            return "Not until next term";
        } else {
            return "Start This Month";
        }
    }
}
