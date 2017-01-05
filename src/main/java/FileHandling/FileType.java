package FileHandling;

// ENUM defines all the permanent instances of a Class upfront with all their
// instance variables.
// Getters, setters and constructors apply just the same as another class.
public enum FileType {
     JPG ("Picture", "Keep")
    ,MOV ("Video", "Keep")
    ,TXT ("Document", "Keep")
    ,DOC ("Document", "Keep")
    ,MPG ("Video", "Keep")
    ,MOFF ("Video Analysis", "Keep")
    ,MODD ("Video Analysis", "Keep")
    ,DB ("Rubbish Database", "Keep")
    ,BMP ("Picture", "Keep")
    ,M4V ("Video", "Keep")
    ,THM ("Thumbnail", "Keep")
    ,PNG ("Picture", "Keep")
    ,MP4 ("Video", "Keep")
    ,INI ("Rubbish", "Keep")
    ,XXX ("Rubbish", "Keep");

    private final String category;
    private final String action;
    private int count;

    FileType(String category, String action) {
        this.category = category;
        this.action = action;
    }

    public String getCategory() { return category; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "category='" + category + '\'' +
                ", count=" + count +
                '}';
    }
}

