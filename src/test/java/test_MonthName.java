import FileHandling.MonthName;
import org.junit.Test;

/**
 * Created by xm39 on 06/01/2017.
 */
public class test_MonthName {

    @Test
    public void should_display_month_names() {
        System.out.println(MonthName.listMonths());
    }

    @Test
    public void should_find_month_seq(){

        for (MonthName m : MonthName.values()) {
            if ( m.getNumber() == 10 ) {
                System.out.println("Month 10 is " + m.getFullName());
            }
        }

    }

    @Test
    public void should_return_abbreivatedName(){
        System.out.println(MonthName.findAbbreviatedName(2));
        System.out.println(MonthName.findAbbreviatedName("A"));
        System.out.println(MonthName.findAbbreviatedName("AAAAAAA 1"));
    }



}
