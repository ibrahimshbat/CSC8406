package LiguangCen;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * A helper class for League Management System. This class can read files from the file 
 * system from a given folder with a specified suffix. 
 * 
 * In clublist folder, it will interpret the file name as club name information, the 
 * file content as player members in the club file it opened. In matchlist folder, 
 * it will interpret the file content as match information
 * 
 * Club reader is compatible with file names contained dot (".") in the club name.
 * Player reader is expected that the content of file is in a standard format of
 * Player name, date of birth, height, keeper(optional)
 * 
 * Match reader is expected that the content of file is in a standard format of
 * match date, place, participators , match record(optional, automatically identified)
 * 
 * @author Liguang Cen
 * @version 2015.10.29
 */
public class DataReader
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class DataReader, ready to read data from specified folders
     */
    public DataReader()
    {

    }

    /**
     * Read clubs files from the given folder with given suffix
     * 
     * @param folder The folder to look for files.
     * @param suffix The suffix of the audio type.
     * @return a list of clubs with players details in.
     */
    public ArrayList<Club> readClubs(String folder, final String suffix)
    {
        File clubFolder = new File(folder);
        ArrayList<Club> clubs = new ArrayList<Club>();
        File[] clubFiles = clubFolder.listFiles(new FilenameFilter() {
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
        });//idea used from practical 4 music-organizer-v5

        // Put all the matching files into the organizer.
        for(File file : clubFiles) {
           Club clubDetails = decodeDetails(file);
           clubs.add(clubDetails);
           
           ArrayList<Player> newPlayerSquad = new ArrayList<Player>();
           newPlayerSquad = decodePlayerDetails(file);
           for(Player player : newPlayerSquad)
           {
               clubDetails.addPlayer(player);
           }
        }
        return clubs;
    }

    /**
     * Try to decode details of the club name
     * from the file name.
     * It is assumed that the details are in the form:
     * clubname.txt
     * @param file The club file.
     * @return A club containing the details.
     */
    private Club decodeDetails(File file)
    {
        // The information needed.
        String clubname;
        String filename = file.getPath();
        
        // Look for club name in the name of the file.
        String details = file.getName();
        String[] parts = details.split("\\.");//normal case, a dot exist between club name and file extension
        clubname = parts[0];
        // If club name contains one or more ".",extract the name without file suffix.
        if(parts.length > 2)//
        {
            int length = parts.length;                
            StringBuffer tempClubName = new StringBuffer("");                
            for(int i=0; i<length-1 ; i++)                
            {
                tempClubName.append(parts[i]);
            }
            clubname = tempClubName.toString();
        }
        return new Club(clubname);
    }
    
    /**
     * Try to decode details of players
     * from the file content.
     * It is assumed that the details are in the form: 
     *     Andrew James
     *     1990-05-09
     *     188
     *     keeper //optional
     *     **********
     * @param file The club file with players details.
     * @return A list of players containing the details.
     */
    private ArrayList<Player> decodePlayerDetails(File file)
    {
        BufferedReader reader = null;
        ArrayList<Player> newPlayerSquad = new ArrayList<Player>();
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            boolean playerDetailEnd = false;
            String tempPlayerName = "";
            int tempYear;
            int tempMonth;
            int tempDay;
            int tempHeight;
            
            //read line by line
            while ((tempString = reader.readLine()) != null) {
                if(!tempString.startsWith("***"))
                {
                    tempPlayerName = tempString;
                    tempString = reader.readLine();
                    if(!tempString.startsWith("***"))
                    {                        
                        String[] dob = tempString.split("-");
                        tempYear = Integer.parseInt(dob[0]);
                        tempMonth = Integer.parseInt(dob[1]);
                        tempDay = Integer.parseInt(dob[2]);
                        tempString = reader.readLine();
                        if(!tempString.startsWith("***"))
                        {
                            tempHeight = Integer.parseInt(tempString);
                            tempString = reader.readLine();
                            if(!tempString.startsWith("***") && tempString.trim().contains("keeper"))//keeper attribute is optional, if there is, create GoalKeeper instance
                            {
                                newPlayerSquad.add(new GoalKeeper(tempPlayerName, tempYear, tempMonth, tempDay, tempHeight));
                            }
                            else
                            {
                                newPlayerSquad.add(new Player(tempPlayerName, tempYear, tempMonth, tempDay, tempHeight));
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    continue;
                }
            }
            } catch (IOException e) {
                   e.printStackTrace();
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
           finally 
           {
               if (reader != null) 
               {
                   try 
                   {
                       reader.close();
                   } catch (IOException e1) 
                   {
                       System.out.println(e1);
                   }
               }
        }
        return newPlayerSquad;
    }
    
    /**
     * Read match files from the given library folder
     * with the given suffix.
     * @param folder The folder to look for files.
     * @param suffix The suffix of the text type.
     * @param ArrayList<Club> The clubs need to be updated due to operations within.
     */
    public ArrayList<Match> readMatches(String folder, final String suffix, ArrayList<Club> clubs)
    {
        File matchFolder = new File(folder);
        ArrayList<Match> matches = new ArrayList<Match>();
        File[] matchFiles = matchFolder.listFiles(new FilenameFilter() {
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
        });//idea used from practical 4 music-organizer-v5

        // Put all the matching files into the organizer.
        for(File file : matchFiles) {
           ArrayList<Match> matchDetails = decodeMatchDetails(file, clubs);
           matches.addAll(matchDetails);
           
        }
        return matches;
    }
    
    /**
     * Try to decode details of matches
     * from the file content.
     * It is assumed that the details are in the form:
     *     2015-10-09,16:00
     *     st.james, Newcastle
     *     Newcastle:Manchester
     *     3:1                  //optional below this line
     *     Newcastle won
     *     Goal records:
     *     Andrew James:0
     *     B B:1
     *     C C:2
     *     D D:0
     *     ---------------
     *     HAHAHA James:1
     * @param file The match list file.
     * @param clubs The clubs need to be updated.
     * @return A list of matches containing the details.
     */
    private ArrayList<Match> decodeMatchDetails(File file, ArrayList<Club> clubs)
    {
        BufferedReader reader = null;
        ArrayList<Match> newMatch = new ArrayList<Match>();
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int tempYear;
            int tempMonth;
            int tempDay;
            int tempHour;
            int tempMinute;
            int tempHomeScore;
            int tempAwayScore;
            Map<Player, Integer> homeRecordMap = new HashMap<Player, Integer>();
            Map<Player, Integer> awayRecordMap = new HashMap<Player, Integer>();
            String tempWonClub = null;
            String tempPlace = "";
            String homeClubName = "";
            String awayClubName = "";
            Club homeClub = null;
            Club awayClub = null;
            
            while ((tempString = reader.readLine()) != null) {
                if(!tempString.startsWith("***"))
                {
                    String[] matchDateTime = tempString.split(","); //split the line into two parts of date and time
                    String[] matchDate = matchDateTime[0].split("-");//split the date part into year, month and day
                    String[] matchTime = matchDateTime[1].split(":");//split the time part into hour and minute
                    tempYear = Integer.parseInt(matchDate[0]);
                    tempMonth = Integer.parseInt(matchDate[1]);
                    tempDay = Integer.parseInt(matchDate[2]);
                    tempHour = Integer.parseInt(matchTime[0]);
                    tempMinute = Integer.parseInt(matchTime[1]);                    
                    if((tempString = reader.readLine()) != null && !tempString.startsWith("***"))
                    {                        
                        tempPlace = tempString;
                        if((tempString = reader.readLine()) != null && !tempString.startsWith("***"))
                        {
                            String[] matchTeams = tempString.split(":");//home tead in first part
                            homeClubName = matchTeams[0];
                            awayClubName = matchTeams[1];
                            for(Club club : clubs)
                            {
                                if(club.getName().toLowerCase().equals(homeClubName.toLowerCase()))//retrieve the club Class by name matching
                                {
                                    homeClub = club;
                                }
                                if(club.getName().toLowerCase().equals(awayClubName.toLowerCase()))
                                {
                                    awayClub = club;
                                }
                            }
                            newMatch.add(new Match(tempYear, tempMonth, tempDay, tempHour, tempMinute, tempPlace, homeClub, awayClub)); //creat a match into arraylist
                            if((tempString = reader.readLine()) != null && !tempString.startsWith("***"))//examine if it is played
                            {
                                //System.out.println("check 1");
                                String[] scores = tempString.split(":");
                                tempHomeScore = Integer.parseInt(scores[0]);
                                tempAwayScore = Integer.parseInt(scores[1]);
                                if((tempString = reader.readLine()) != null && tempString.toLowerCase().contains("won"))
                                {
                                    String[] wonclub = tempString.split(":");
                                    tempWonClub = wonclub[0];
                                    if((tempString = reader.readLine()) != null && tempString.toLowerCase().contains("records"))
                                    {
                                        while((tempString = reader.readLine()) != null && !tempString.startsWith("---"))//above "---" are home team goal records
                                        {
                                            String[] record = tempString.split(":");                                            
                                            for(Player player : homeClub.getSquad())
                                            {
                                                if(player.getName().toLowerCase().equals(record[0].toLowerCase()))//lookup player by name
                                                {
                                                    player.addTally(Integer.parseInt(record[1]));
                                                    homeRecordMap.put(player, Integer.parseInt(record[1]));
                                                    
                                                }
                                            }
                                        }
                                        while((tempString = reader.readLine()) != null && !tempString.startsWith("***"))//below "---" are away team records
                                        {
                                            String[] record = tempString.split(":");
                                            //System.out.println("check 2");
                                            for(Player player : awayClub.getSquad())
                                            {
                                                if(player.getName().toLowerCase().equals(record[0].toLowerCase()))
                                                {
                                                    player.addTally(Integer.parseInt(record[1]));
                                                    awayRecordMap.put(player, Integer.parseInt(record[1]));
                                                    //System.out.println("datareader" + homeRecordMap.size());
                                                    
                                                }
                                            }
                                        }
                                        newMatch.get(newMatch.size() - 1).playMatch(tempHomeScore, tempAwayScore, homeRecordMap, awayRecordMap,clubs);//point to the last element to update the newest record
                                    }
                                    else
                                    {
                                        continue;//series of continue is the precation of incompleted records, to discard information and jump to next record
                                    }
                                }
                                else
                                {
                                    continue;
                                }
                            }
                            else
                            {
                                continue;
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    continue;
                }
            }
            } catch (IOException e) {
                   e.printStackTrace();
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
           finally 
           {
               if (reader != null) 
               {
                   try 
                   {
                       reader.close();
                   } catch (IOException e1) 
                   {
                       System.out.println(e1);
                   }
               }
        }
        return newMatch;
    }
}
