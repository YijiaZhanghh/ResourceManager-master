package model;

import model.exceptions.isZeroException;

public interface Project {
    public void addScores(int i);
    public double projectScore(Project project) throws isZeroException;
}
