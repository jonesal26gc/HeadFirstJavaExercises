package FileHandling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubFolderNameValidation {

        private Pattern pattern;
        private Matcher matcher;
        private static final String FILENAME_PATTERN =
        //        "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
            "(19|20)[0-9][0-9]-[0-9][0-9]-[0-9][0-9] (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) '[0-9][0-9] - .*";

        public SubFolderNameValidation() {
            pattern = Pattern.compile(FILENAME_PATTERN);
        }

        public boolean validate(final String subFolderName) {
            matcher = pattern.matcher(subFolderName);
            return matcher.matches();
        }




}
