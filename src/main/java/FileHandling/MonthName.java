package FileHandling;

/**
 * Created by xm39 on 06/01/2017.
 */
public enum MonthName {
     JAN ("Jan", "January", 1)
    ,FEB ("Feb", "February", 2)
    ,MAR ("Mar", "March", 3)
    ,APR ("Apr", "April", 4)
    ,MAY ("May", "May", 5)
    ,JUN ("Jun", "June", 6)
    ,JUL ("Jul", "July", 7)
    ,AUG ("Aug", "August", 8)
    ,SEP ("Sep", "September", 9)
    ,OCT ("Oct", "October", 10)
    ,NOV ("Nov", "November", 11)
    ,DEC ("Dec", "December", 12);

    private String abbreviatedName;
    private String fullName;
    private int number;

    MonthName(String abbrev, String fullName, int number) {
        this.abbreviatedName = abbrev;
        this.fullName = fullName;
        this.number = number;
    }

    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getNumber() {
        return number;
    }

    public static StringBuffer listMonths() {
        StringBuffer sb = new StringBuffer();

        for ( MonthName m : MonthName.values()) {
            sb.append(m.name() + ' ');
        }
        return sb;
    }

    public static String findAbbreviatedName(int number){

        for ( MonthName m : MonthName.values()){
            if ( m.getNumber() == number ) {
                return m.getAbbreviatedName();
            }
        }
        return "xxx";
    }

    public static String findAbbreviatedName(String nonNumber) {
        try {
            return findAbbreviatedName(Integer.parseInt(nonNumber));
        } catch ( NumberFormatException ex ) {
            return findAbbreviatedName(0);
        }
    }

}
