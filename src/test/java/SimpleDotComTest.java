import SimpleDotCom.SimpleDotCom;
import Utilities.*;
import org.junit.*;

/**
 * Created by xm39 on 05/12/2016.
 */

public class SimpleDotComTest {

    public static void main(String[] args) {

        // instantiate and set locations.
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {1,2,3};
        dot.setLocationCells(locations);

        // have some guesses.
        String testResult = "";
        testResult = dot.checkYourself("1");

        if (testResult == "Hit") {
            System.out.println("passed");
        }

        // test the capability to retrieve user input.
        UserInput input = new UserInput();
        String inputString = input.getUserInputString("Please give me a number to shoot at!");
        System.out.println("'"+inputString+"'");

    }

}
