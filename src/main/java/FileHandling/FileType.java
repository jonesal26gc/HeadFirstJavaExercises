package FileHandling;

// ENUM defines all the permanent instances of a Class upfront with all their
// instance variables.
// Getters, setters and constructors apply just the same as another class.
public enum FileType {
     JPG (FileCategory.PHOTO)
    ,MOV (FileCategory.VIDEO)
    ,TXT (FileCategory.DOCUMENT)
    ,DOC (FileCategory.DOCUMENT)
    ,DOCX (FileCategory.DOCUMENT)
    ,MPG (FileCategory.VIDEO)
    ,MOFF (FileCategory.VIDEO)
    ,MODD (FileCategory.VIDEO)
    ,DB (FileCategory.RUBBISH)
    ,BMP (FileCategory.PHOTO)
    ,M4V (FileCategory.VIDEO)
    ,THM (FileCategory.THUMBNAIL)
    ,PNG (FileCategory.PHOTO)
    ,MP4 (FileCategory.VIDEO)
    ,INI (FileCategory.RUBBISH)
    ,XXX (FileCategory.RUBBISH)
    ,MP3 (FileCategory.MUSIC);

    private final FileCategory fileCategory;
    private int count;

    FileType(FileCategory fileCategory) {
        this.fileCategory = fileCategory;
    }

    public FileCategory getFileCategory() {
        return fileCategory;
    }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public static FileType findFileTypeFromFilename(String filename){

        if ( filename.lastIndexOf('.') >= 0 ) {
            String fileExtension = filename.substring(filename.lastIndexOf('.')+1).toUpperCase();
            for ( FileType i : FileType.values()) {
                if ( i.name().equals(fileExtension) ) {
                    return i;
                }
            }
        }
        return FileType.XXX;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "fileCategory=" + fileCategory +
                ", count=" + count +
                '}';
    }
}

