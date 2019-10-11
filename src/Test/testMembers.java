package Test;

import model.Administration.Members;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMembers {
    Members m;

    @BeforeEach
    public void setUp(){
        m = new Members("Maxwell",245,2018);
    }

    @Test
    public void testGetName(){
        assertEquals("Maxwell", m.getName());
    }

    @Test
    public void testGetYear(){
        assertEquals(2018, m.getYear());
    }

    @Test
    public void testGetNum(){
        assertEquals(245, m.getNum());
    }

}
