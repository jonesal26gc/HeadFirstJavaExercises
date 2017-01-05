package FileHandling;

public class PhotoCountApp {

    public static void main(String[] args) {

        String parentFolderName;

        if ( args.length == 1) {
            parentFolderName = args[0];
        } else {
            parentFolderName = "f:/Family Photo Library";
        }

        PhotoCounting.doIt(parentFolderName);
    }
}
