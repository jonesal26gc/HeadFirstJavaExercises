package FileHandling;

// ENUM defines all the permanent instances of a Class upfront with all their
// instance variables.
// Getters, setters and constructors apply just the same as another class.
public enum FileType {
     JPG ("Photo")
    ,MOV ("Video")
    ,TXT ("Document")
    ,DOC ("Document")
    ,MPG ("Video")
    ,MOFF ("Video")
    ,MODD ("Video")
    ,DB ("Rubbish Database")
    ,BMP ("Photo")
    ,M4V ("Video")
    ,THM ("Thumbnail")
    ,PNG ("Photo")
    ,MP4 ("Video")
    ,INI ("Rubbish")
    ,XXX ("Rubbish");

    private final String category;
    private int count;

    FileType(String category) {
        this.category = category;
    }

    public String getCategory() { return category; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    @Override
    public String toString() {
        return "FileType{" +
                "category='" + category + '\'' +
                ", count=" + count +
                '}';
    }
}

