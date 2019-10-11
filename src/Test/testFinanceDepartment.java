package Test;

import model.Finance.FinanceDepartment;
import model.exceptions.isNegException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class testFinanceDepartment {
    FinanceDepartment f;

    @BeforeEach
    public void beforeEach(){
        f = FinanceDepartment.getInstancce();
    }

    @Test
    public void testOp(){

    }

    @Test
    public void testAddIn(){
        try{
            f.addIn(1);
            assertEquals(2, f.addIn(1));
        }catch (isNegException e){
            fail(" ");
        }
    }

    @Test
    public void testAddIn1() {
        try {
            f.addIn(-1235246);
            fail(" ");
        } catch (isNegException e) {
        }
    }

    @Test
    public void testMinusIn() {
        try {
            f.minusIn( -1);
            fail(" ");
        } catch (isNegException e) {
        }
    }

        @Test
        public void testMinusIn1(){
            try {
                f.minusIn(1);
                assertEquals(-2,f.minusIn(1));
            }catch (isNegException e) {
                fail(" ");
            }

    }

    }


