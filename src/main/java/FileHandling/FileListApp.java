package FileHandling;

import java.io.File;

/**
 * Created by xm39 on 29/12/2016.
 */
public class FileListApp {

    public static void main(String[] args) {

        File folder = new File("d:/Family Photo Library");
        File [] listOfFiles = folder.listFiles();

        for ( File fileToProcess : listOfFiles ){
            if ( fileToProcess.isFile() ) {
                //System.out.println("File: " + fileToProcess.getName());
                if ( fileToProcess.getName().equals("JI0786.idy")) {
                    System.out.println("File: " + fileToProcess.getName());
                    System.out.println(fileToProcess.getPath());
                    System.out.println(fileToProcess.getPath().replaceFirst(fileToProcess.getName(),"001.jpg"));
                    //File newFile = newFile(fileToProcess);
                    //        new File("JI0786.CBL.renamed");
                    //if (fileToProcess.renameTo(newFile)) {
                    //    System.out.println("file was renamed to: " + fileToProcess.getName());
                    //}

                }
            }

        }
    }

    public static File newFile(File oldFile){
        return oldFile;
    }

}
