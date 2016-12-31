package FileHandling;

import java.io.File;

public class FamilyPhotoRenamingApp {
/********************************************************************
 * This program loops through the photo album and renames the files
 * more appropriately.
 */

    private static final boolean UPDATE_INDICATOR = false;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {

        // Verify that the parent folder is actually a folder.
        File parentFolder = new File("d:/Family Photo Library");
        File[] listOfSubFolders = null;

        if ( ! parentFolder.isDirectory() ) {
            System.out.println("ERROR - Parent library is not actually a folder.");
        } else

        // Iterate through the sub-folders of this parent directory.
        listOfSubFolders = parentFolder.listFiles();
        for (File i : listOfSubFolders) {

            // Process a sub-folder and the files within it.
            try {
                processSubFolder(i);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }


    private static void processSubFolder(File i) throws Exception {
    /*******************************************************************
     * process a sub-folder and the files found within it.
     */

        // Check that this is actually a sub-folder.
        if ( ! (i.isDirectory()) ) {
            throw new Exception("ERROR - expected sub-folder but found file: " + i.getName());
        }

        checkSubFolderFormat();

        // display the sub-folder name.
        System.out.println(NEW_LINE + "Sub-folder: " + i.getPath());

        // Iterate through the files in the sub-folder.
        File subFolder = new File(i.getPath());
        File[] listOfFiles = subFolder.listFiles();
        int fileNumber = 0;
        for (File j : listOfFiles) {

            fileNumber++;

            try {
                processFile(i, j, fileNumber);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void checkSubFolderFormat() {
    }

    private static void processFile(File i, File j, int fileNumber) throws Exception {
    /**************************************************************************
     * Process a file within the sub-folder.
     */

        if ( ! j.isFile() ) {
            throw new Exception("ERROR - expected file(s) but found sub-folder: " + j.getName());
        }

        // Invalid files will be deleted, whilst others will be renamed.
        if ( j.getName().startsWith("Thumb") ) {
            System.out.println("Warning - inappropriate file found - will delete: " + j.getName());
            if (UPDATE_INDICATOR) {
                j.delete();
            }
        } else {

            // display the original filename.
            //System.out.println("File " + String.format("%04d",fileNumber) + ": " + j.getName());

            // Format the replacement filename.
            String newFilenameString = i.getPath() + "\\" +
                    j.getName().replace(j.getName().substring(0, j.getName().indexOf('.')), i.getName() +
                            " " + String.format("%04d", fileNumber));

            // Display the filename.
            System.out.println("New filename is: " + newFilenameString);

            // Rename the file.
            if (UPDATE_INDICATOR) {
                File newFilename = new File(newFilenameString);
                j.renameTo(newFilename);
            }

        }
    }

}
