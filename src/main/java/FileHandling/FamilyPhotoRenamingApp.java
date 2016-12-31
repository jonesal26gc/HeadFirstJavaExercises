package FileHandling;

import java.io.File;

public class FamilyPhotoRenamingApp {

    public static void main(String[] args) {
        /*********************************************************************
         * This program loops through the photo album and renames the files
         * more appropriately.
         */

        // Loop through the sub-foldrs of the parent folder.
        File parentFolder = new File("d:/Family Photo Library");
        File [] listOfSubFolders = parentFolder.listFiles();

        for ( File i : listOfSubFolders ){

            // Process each sub-folder.
            if ( i.isDirectory() ) {

                // display the sub-folder name.
                System.out.println("Sub-folder: " + i.getPath());

                // Get the files within the sub-folder.
                if ( i.isDirectory() ) {

                    File subFolder = new File(i.getPath());
                    File[] listOfFiles = subFolder.listFiles();
                    int fileNumber = 0;
                    for (File j : listOfFiles) {
                        if (j.isFile()){
                            if (! j.getName().startsWith("Thumb")) {

                                // Increment the file counter.
                                fileNumber++;

                                // display the original filename.
                                System.out.println("\nFile " + String.format("%04d",fileNumber) + ": " + j.getName());

                                // Format the replacement filename.
                                String newFilenameString = i.getPath() + "\\" +
                                        j.getName().replace(j.getName().substring(0,j.getName().indexOf('.')),i.getName() + " - " + String.format("%04d",fileNumber));

                                File newFilename = new File(newFilenameString);
                                System.out.println("New filename is: " + newFilename.getName());
                                j.renameTo(newFilename);
                            } else {
                                System.out.println("Deleting file: " + j.getName());
                                j.delete();
                            }
                        }
                    }
                } else {
                    System.out.println("misplaced file - expected sub-folder - skipping " + i.getName());
                }
            }

        }
    }

    public static File newFile(File oldFile){
        return oldFile;
    }

}
