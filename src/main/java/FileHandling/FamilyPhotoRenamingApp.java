package FileHandling;

import java.io.File;

public class FamilyPhotoRenamingApp {
/********************************************************************
 * This program loops through the photo album and renames the files
 * more appropriately.
 */

    private static final boolean UPDATE_INDICATOR = true;
    private static final String NEW_LINE = "\n";
    public static final String [] MONTH_LABELS = {"Jan","Feb","Mar","Apr","May","Jun"
            ,"Jul","Aug","Sep","Oct","Nov","Dec","xxx"};

    public static void main(String[] args) {

        // Verify that the parent folder is actually a folder.
        File parentFolder = new File("d:/Family Photo Library");
        File[] listOfSubFolders = null;

        if ( ! parentFolder.isDirectory() ) {
            System.out.println("ERROR - Parent library is not actually a folder.");
        } else

        // Iterate through the sub-folders of this parent directory.
        listOfSubFolders = parentFolder.listFiles();
        for (File subFolder : listOfSubFolders) {

            // Process a sub-folder and the files within it.
            try {
                processSubFolder(subFolder);
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }

        }
    }

    private static void processSubFolder(File subFolder) throws Exception {
    /*******************************************************************
     * process a sub-folder and the files found within it.
     */
        // Say that the sub-folder name is OK.
        System.out.println("Sub-folder: " + subFolder.getName());

        // Check that this is actually a sub-folder.
        if ( ! (subFolder.isDirectory()) ) {
            throw new Exception("ERROR - expected sub-folder but found something else.");
        }

        // Check the sub-folder name format.
        if ( ! checkSubFolderFormat(subFolder.getName()) ) {
            if ( UPDATE_INDICATOR ) {
                throw new Exception("ERROR - sub-folder name format is invalid: " + subFolder.getName());
            } else {
                System.out.println("Error - sub-folder format is invalid: " + subFolder.getName());
            }
        } else {

            // Derive a new sub-folder name.
            String revisedSubFolderName = renameSubFolder(subFolder.getName());
            System.out.println("Revised sub-folder name is: " + revisedSubFolderName);

            // Rename this sub-folder.
            File revisedSubFolder;
            if ( UPDATE_INDICATOR ) {
                revisedSubFolder = new File(subFolder.getPath().replace(subFolder.getName()
                        , "").concat(revisedSubFolderName));
                subFolder.renameTo(revisedSubFolder);
            } else {
                revisedSubFolder = subFolder;
            }

            // Iterate through the files in the sub-folder.
            File[] listOfFiles = revisedSubFolder.listFiles();
            int fileNumber = 0;
            for (File targetFile : listOfFiles) {
                fileNumber++;
                processFile(revisedSubFolder, targetFile, fileNumber);
            }
        }
    }

    private static String renameSubFolder(String subFolderName) {

        // Split the original name into two parts.
        String part1 = subFolderName.substring(0,21);
        String part2 = subFolderName.substring(21);
        //System.out.println("'" + part1 + "'");
        //System.out.println("'" + part2 + "'");

        // Formulate the replacement part one.
        String revisedPart1 = part1.substring(0,4);
        revisedPart1 = revisedPart1 + part1.substring(5,7);
        revisedPart1 = revisedPart1 + part1.substring(8,14);
        revisedPart1 = revisedPart1 + part1.substring(15,16);
        revisedPart1 = revisedPart1 + part1.substring(16,19);

        // Return the revised name.
        return (revisedPart1 + part2);
    }

    private static boolean checkSubFolderFormat(String subFolderName) {
        SubFolderNameValidation s = new SubFolderNameValidation();
        return s.validate(subFolderName);
    }

    private static void processFile(File subFolder, File targetFile, int fileNumber) throws Exception {
    /**************************************************************************
     * Process a file within the sub-folder.
     */

        // Check that this is indeed a file.
        if ( ! targetFile.isFile() ) {
            throw new Exception("ERROR - expected file(s) but found sub-folder: " + targetFile.getName());
        }

        // Inappropriate files are be deleted.
        if ( targetFile.getName().startsWith("Thumb") ) {
            System.out.println("Warning - inappropriate file found - will delete: " + targetFile.getName());
            if (UPDATE_INDICATOR) {
                targetFile.delete();
            }
        } else {

            // display the original filename.
            System.out.println("File " + String.format("%04d",fileNumber) + ": " + targetFile.getName());

            String revisedTargetFileName = renameTargetFile(subFolder.getName(),targetFile.getName(),fileNumber);
            System.out.println("Revised file name is: " + revisedTargetFileName);

            // Format the replacement filename.
            File revisedTargetFile;
            if ( UPDATE_INDICATOR ) {
                revisedTargetFile = new File(targetFile.getPath()
                        .replace(targetFile.getName(),revisedTargetFileName));
                targetFile.renameTo(revisedTargetFile);
            } else {
                revisedTargetFile = targetFile;
            }
        }
    }

    private static String renameTargetFile(String folderName, String fileName, int fileNumber) {
        return ( folderName +
                String.format(" #%04d", fileNumber) +
                fileName.substring(fileName.indexOf('.')) ) ;
    }
}
