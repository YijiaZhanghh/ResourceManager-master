package Test;

import model.Administration.Members;
import model.Administration.MembersManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class testMembership {
    Members m;
    MembersManager mem;

    @BeforeEach
    public void setUp(){
        m = new Members("Maxwell",245,2018);
        mem = MembersManager.getInstance();
        mem.addMember(m);
    }

    @Test
    public void testCheckMembers(){
        assertEquals("Find a member with: \n" +
                "Name: Maxwell\n" +
                "Year: 2018\n" +
                "No: 245",mem.checkMembersExist("Maxwell"));
    }

}
