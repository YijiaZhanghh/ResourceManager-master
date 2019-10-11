package Test;

import model.Events.EProjectsPriority;
import model.Events.EventsProject;
import model.Marketing.MProjectsPriority;
import model.Marketing.MarketingProject;
import model.exceptions.isZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testProject {
    private MarketingProject m;
    private EventsProject e;
    private EventsProject eventsProject;
    private MProjectsPriority mp;
    private EProjectsPriority ep;
    private List<Integer> intList;

    @BeforeEach
    public void setUp(){
        intList = new ArrayList<>();
        mp = new MProjectsPriority();
        ep = new EProjectsPriority();
        e = new EventsProject("Hi","2018.09.02",intList,ep,10);
        m = new MarketingProject("Hi","2018.09.02",intList,mp);
    }

    @Test
    public void testAddScores(){
        mp.addScores(0,m);
        assertEquals(1, m.getmScoreList().size());
        ep.addScores(11,e);
        assertFalse(e.geteScoreList().contains(11));
        mp.addScores(-1,m);
        assertFalse(m.getmScoreList().contains(-1));
    }

    @Test
    public void testProjectScore1(){
        mp.addScores(3,m);
        try{mp.projectScore(m);
        assertEquals(3,mp.projectScore(m));
        }
        catch (isZeroException e1) {
            fail("Shouldn't ever get here");
        }
    }


}
