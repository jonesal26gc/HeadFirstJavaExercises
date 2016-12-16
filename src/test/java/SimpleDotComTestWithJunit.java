import SimpleDotCom.SimpleDotCom;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by xm39 on 16/12/2016.
 */
public class SimpleDotComTestWithJunit {

    @Test
    public void shouldSetLocationCells() {
        int [] a = {0,1,2};
        SimpleDotCom s = new SimpleDotCom();
        s.setLocationCells(a);
        assertEquals("wrong"
                ,"SimpleDotCom{locationCells=[0, 1, 2], numOfHits=0} ArrayList Contents=0 1 2 "
                ,s.toString());

    }

}
