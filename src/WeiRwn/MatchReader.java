package WeiRwn;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A helper class for sports league. This class can read files from the file system
 * from a given folder with a specified suffix. It will interpret the file name as involved clubs
 * title information.
 * It is expected that file names of matches follow a standard format of two involved clubs
 * name,club1 and club2,separated by a dash. For example: newcastle-japan.
 * 
 * @author Ren Wei
 * @version 2015.10.29
 */
public class MatchReader
{
    /**
     * Create the track reader, ready to read tracks from the matches folder.
     */
    public MatchReader()
    {
        // Nothing to do here.
    }
    
    /**
     * Read match files from the given library folder
     * with the given suffix.
     * @param folder The folder to look for files.
     * @param suffix The suffix of the text type.
     */
    public ArrayList<Matches> readMatches(String folder, final String suffix)
    {
        File matchFolder = new File(folder);
        ArrayList<Matches> matches = new ArrayList<Matches>();
        File[] matchFiles = matchFolder.listFiles(new FilenameFilter()
        {
            /**
             * Accept files with matching suffix.
             * @param dir The directory containing the file.
             * @param name The name of the file.
             * @return true if the name ends with the suffix.
             */
            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(suffix);
            }
        });
        
        // Put all the matching files into the league.
        for(File file : matchFiles) {
            Matches matchDetails = decodeDetails(file);
            matches.add(matchDetails);
        }
        return matches;
    }

    /**
     * Try to decode details of the host club(club1) and the away club(club2)
     * from the file name.
     * It is assumed that the details are in the form:
     *     newcastle-japan.txt
     * @param file The match file.
     * @return A Match containing the details.
     */
    private Matches decodeDetails(File file)
    {
        // The information needed.
        String club1 = "unknown";
        String club2 = "unknown";
        String filename = file.getPath();
        
        // Look for club host(club1) and club away(club2) in the name of the file.
        String details = file.getName();
        String[] parts = details.split("-");
        
        if(parts.length == 2) {
            club1 = parts[0];
            String titlePart = parts[1];
            // Remove a file-type suffix.
            parts = titlePart.split("\\.");
            if(parts.length >= 1) {
                club2 = parts[0];
            }
            else {
                club2 = titlePart;
            }
        }
        return new Matches(club1,club2,filename);
    }
}
