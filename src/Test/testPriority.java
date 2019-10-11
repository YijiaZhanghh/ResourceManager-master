package Test;


import model.Events.EProjectsPriority;
import model.Events.EventsProject;
import model.Marketing.MProjectsPriority;
import model.Marketing.MarketingProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPriority {
    private MarketingProject m;
    private EventsProject e;
    private MProjectsPriority mp;
    private EProjectsPriority ep;
    private List<Integer> scoreList;

    @BeforeEach
    public void setUp(){
        scoreList = new ArrayList<>();
        scoreList.add(10);
        scoreList.add(8);
        scoreList.add(9);
        m = new MarketingProject("Hello","2018.09.02",scoreList,mp);
        e = new EventsProject("Hi","2018.09.02",scoreList,ep,30);
        mp = new MProjectsPriority();
        ep = new EProjectsPriority();
    }

    @Test
    public void testMPriority(){
        mp.addScores(10,m);
        assertEquals("***",mp.priority(m));
        mp.addScores(5,m);
        assertEquals("**",mp.priority(m));
        mp.addScores(1,m);
        assertEquals("**",mp.priority(m));
    }

    @Test
    public void testEPriority(){
        ep.addScores(10,e);
        assertEquals("***",ep.priority(e));
        ep.addScores(0,e);
        assertEquals("***",ep.priority(e));
        ep.addScores(0,e);
        assertEquals("***",ep.priority(e));
        ep.addScores(0,e);
        assertEquals("",ep.priority(e));
    }

    @Test
    public void testMTimeToStart1(){
        mp.addScores(1,m);
        assertEquals("Not until next term",mp.timeToStart(m));
        mp.addScores(5,m);
        assertEquals("Not until next term",mp.timeToStart(m));

    }

    @Test
    public void testMTimeToStart2(){
        mp.addScores(10,m);
        assertEquals("Start This Month",mp.timeToStart(m));
    }

    @Test
    public void testMTimeToStart3(){
        mp.addScores(7,m);
        assertEquals("Not until next term",mp.timeToStart(m));
    }
}
