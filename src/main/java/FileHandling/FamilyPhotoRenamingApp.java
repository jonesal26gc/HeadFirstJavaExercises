package FileHandling;

import java.io.File;

public class FamilyPhotoRenamingApp {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        /*********************************************************************
         * This program loops through the photo album and renames the files
         * more appropriately.
         */

        // Loop through the sub-folders of the parent folder.
        File parentFolder = new File("d:/Family Photo Library");
        if (parentFolder.isDirectory()) {

            // Iterate through the sub-folders of this parent directory.
            File[] listOfSubFolders = parentFolder.listFiles();
            for (File i : listOfSubFolders) {

                // Process each sub-folder.
                if (i.isDirectory()) {

                    //processSubFolder(i.getPath());

                    // display the sub-folder name.
                    System.out.println(NEW_LINE + "Sub-folder: " + i.getPath());

                    // Iterate through the files in the sub-folder.
                    File subFolder = new File(i.getPath());
                    File[] listOfFiles = subFolder.listFiles();
                    int fileNumber = 0;
                    for (File j : listOfFiles) {
                        if (j.isFile()) {
                            if (!j.getName().startsWith("Thumb")) {

                                // Increment the file counter.
                                fileNumber++;

                                // display the original filename.
                                //System.out.println("File " + String.format("%04d",fileNumber) + ": " + j.getName());

                                // Format the replacement filename.
                                String newFilenameString = i.getPath() + "\\" +
                                        j.getName().replace(j.getName().substring(0, j.getName().indexOf('.')), i.getName() +
                                                " " + String.format("%04d", fileNumber));

                                // Rename the file.
                                File newFilename = new File(newFilenameString);
                                System.out.println("New filename is: " + newFilename.getName());
                                //j.renameTo(newFilename);

                            } else {
                                System.out.println("inappropriate file - Deleting: " + j.getName());
                                //j.delete();
                            }
                        } else {
                            System.out.println("misplaced directory - expected file(s) only - skipping " + j.getName());
                        }
                    }
                } else {
                    System.out.println("misplaced file - expected sub-folder - skipping " + i.getName());
                }

            }
        } else {
            System.out.println("Parent library is not actually a folder.");
        }
    }

    private static void processSubFolder() {
    }

    public static File newFile(File oldFile){
        return oldFile;
    }

}
