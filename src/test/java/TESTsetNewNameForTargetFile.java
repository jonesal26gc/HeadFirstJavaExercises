import FileHandling.PhotoRenaming;
import org.junit.Test;

public class TESTsetNewNameForTargetFile {

    @Test
    public void shouldFindComment(){

        System.out.println(PhotoRenaming.setNewNameForTargetFile("2017-01-04 Jan17 xxxxx","Picture [something in here] 0001.jpg",1));
        System.out.println(PhotoRenaming.setNewNameForTargetFile("2017-01-04 Jan17 xxxxx","Picture 0001.jpg",1));
        System.out.println(PhotoRenaming.setNewNameForTargetFile("2017-01-04 Jan17 xxxxx","[something in here].jpg",1));

    }

    @Test
    public void shouldGiveInvalidFileType() {

        PhotoRenaming.FileType ft;
        ft = PhotoRenaming.determineFileType("xxxx.jpg");
        System.out.println(ft.toString());
        ft = PhotoRenaming.determineFileType("xxxx.mov");
        System.out.println(ft.toString());
        ft = PhotoRenaming.determineFileType("xxxx.doc");
        System.out.println(ft.toString());
        ft = PhotoRenaming.determineFileType("xxxx.txt");
        System.out.println(ft.toString());
        ft = PhotoRenaming.determineFileType("xxxx.cbl");
        System.out.println(ft.toString());
    }
}
