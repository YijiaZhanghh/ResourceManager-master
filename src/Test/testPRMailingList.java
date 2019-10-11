package Test;

import model.PR.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPRMailingList {
    private PRMailingList cm;
    private PRMailingList cm1;
    private PRMailingList am;
    private PRMailingList am1;
    private PRMailingList sm;
    private PRMailingList sm1;

    @BeforeEach
    public void setUp(){
        cm = new CommMailingList("A","Commerce",true,true);
        cm1 = new CommMailingList("d","Commesdf",true,true);
        am = new ArtsMailingList("B","Arts",false,false);
        am1 = new CommMailingList("e","Aergf",true,true);
        sm = new ScienceMailingList("C","Science",true,false);
        sm1 = new ScienceMailingList("f","Scasdf",true,false);
    }

    @Test
    public void testDidReceive(){
        assertTrue(cm.didReceive());
        assertFalse(am.didReceive());
        assertTrue(sm1.didReceive());
    }

    @Test
    public void testWillAttend(){
        assertTrue(cm.willAttend());
        assertFalse(am.willAttend());
        assertFalse(sm.willAttend());
    }

    @Test
    public void testVerified(){
        assertTrue(cm.verified());
        assertFalse(cm1.verified());
        assertTrue(am.verified());
        assertFalse(am1.verified());
        assertTrue(sm.verified());
        assertFalse(sm1.verified());
    }


}
