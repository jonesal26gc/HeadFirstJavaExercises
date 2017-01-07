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

    private String abbrev;
    private String fullName;
    private int seq;

    MonthName(String abbrev, String fullName, int seq) {
        this.abbrev = abbrev;
        this.fullName = fullName;
        this.seq = seq;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSeq() {
        return seq;
    }

    public static StringBuffer listMonths() {
        StringBuffer sb = new StringBuffer();

        for ( MonthName m : MonthName.values()) {
            sb.append(m.name() + ' ');
        }
        return sb;
    }
}
