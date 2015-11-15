package AbdullahiAKawu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represent the Clubs in the League. The Class manages Club in the league
 * 
 * @Abdullahi Abubakar Kawu 
 * @30.10.2015
 */

public class Clubs
{
    //Fields for Class Players
     private ArrayList<Players> squad;
     private ArrayList<Players> team;
     private String clubName;
     private int totalGoalScored;
     private int totalGoalsConceded;
     private int goalDifference;
     private int pointsTally;
     private int numberOfPlayers;
     private int teamsize;
     private GoalKeeper goalie;
    
     
     
    /**
     * Constructor for objects of class Clubs
     * Creates a new club
     * @ param name: Name of the club
     * 
     */
    
    public Clubs(String name)
    {
        squad = new ArrayList<Players>();
        team = new ArrayList<Players>();
        clubName = name;
        totalGoalScored = 0;
        totalGoalsConceded = 0;
        goalDifference = 0;
        pointsTally = 0;
        teamsize = 0;
        goalie = new GoalKeeper("Mykeeper", 1.2, 2000, 12, 05);
       //goalie1 = new GoalKeeper("Elias", 1.2, 2000, 12, 05);
        
       // squad.add(goalie1);
       // squad.add(goalie2);
    }

         
    /**
     * Specifies the name of the club;
     * @ param name: Name of Club
     * 
     */
       
    public void setNameOfClub(String name)
    {
      clubName = name;
    }
    
    /**
     * Specifies the team size of the club;
     * @ param teamSize: Size of Team of Club
     * 
     */
       
    public void setTeamSize(int size)
    {
      teamsize = size;
    }
    
    /**
     * Change the Goalkeeper name in the club;
     * @ param name: 
     * 
     */
       
    public void setGoalkeeperName(String name)
    {
      this.goalie.setPlayerName(name);
    }
    
    
    /**
     * Retrieves the name of the club;
     * @ returns club name
     */
    
    public String getNameOfClub()
    {
        return clubName;
        
    }    
    
    
    
    /**
     * Retrieves the current team size of the club;
     * @ returns club team: Team is always a fixed size.
     */
    
    public int getTeamSize(int size)
    {
        return teamsize;
        
    }    
    
    /**
     * Adds to the goals scored tally of the club and returns the recent total goal scored by the club
     * @param NumOfGoal: Number of Goal Scored to be added.
     */
    public int getGoalScoredTally()
    {
        return totalGoalScored;
  
    }
    
    /**
     * Adds to the goals scored tally of the club and returns the recent total goal scored by the club
     * @param NumOfGoal: Number of Goal Scored to be added.
     */
    public void addGoalScoredTally()
    {
        totalGoalScored += 1;
  
    }
    
    /**
     * Adds to the goals conceded tally of the club and returns the recent total goal conceded by the club
     * @param NumOfGoal: Number of Goal Scored to be added to conceded goals.
     */
    public void addGoalConcededTally()
    {
        totalGoalsConceded += 1;
        
    }
   
    
    /**
     * Gets the goals conceded tally of the club and returns the total goal conceded by the club
     * @return goalconceded; Number of Goal Scored to be added to conceded goals.
     */
    public int getGoalConcededTally()
    {
        return totalGoalsConceded;
        
    }
    
    
     /**
     * Gets the goals difference of the club and returns total goal difference
     * @returns goalDifference - goal difference of the club
     */
    public int getGoalDifference()
    {
        goalDifference = totalGoalScored - totalGoalsConceded;
        return goalDifference;
    }
    
    
    
    /**
     * Adds to the point tally of the club and returns the newest total tally of club
     * @param newestTally; Represents new tally from a match that would be added to the existing tally
     */
    public void addPointTally(int newestTally)
    {
        pointsTally += newestTally;
        
    }
    
    /**
     * Gets the accumulated point tally of the club
     * @returns pointTally of the club;
     */
    
    public int getPointTally()
    {
        return pointsTally;
    }
    
     /**
     * Adds a player to the Club's Squad
     * @param player: - Object of Players
     */
    
    public void addPlayer(Players player)
    {
        
        this.squad.add(player);
    }    
   
    /**
     * Checks if a player is in the Club's Squad
     * @param player: - Object of Players
     */
    
    public boolean checkPlayerInSquad(Players player)
     {
         if (squad.contains(player)==true)
         {
         //    System.out.println("True, This player is in this Squad");
             return true;
         }
         
         else
         
         //System.out.println("False, This player is NOT in this Squad - Check with other clubs");
         return false;
     }
     
     
     /**
     * Checks if a player is in the Club's Team
     * @param player: - Object of Players in team ArrayList
     */
     
     public boolean checkPlayerInTeam(Players player)
     {
         if (team.contains(player)==true)
         {
            // System.out.println("True, This player is in this Squad");
             return true;
         }
         
         else
         
        // System.out.println("False, This player is NOT in this Squad - Check with other clubs");
         return false;
     }
    
     
     
     
     /**
     * Finds the average age of the Squad
     * @returns average - average age of the the squad;
     */
    public int averageSquadAge()
     {
         int i=0;
         int j=0;
         for(int k = 0; k<squad.size(); k++)
         {
            i += squad.get(k).getPlayerAge();
            j++;
         }   
          int average = i/j;
          System.out.println("Average Age of Squad is: " + average);
         return average;
          
     }
    
     
    /**
     * Finds the average height of the Squad
     * @returns average - average height of the the squad;
     */
     public double averageSquadHeight()
     {
         double i=0;
         double j=0;
         for(int k = 0; k<squad.size(); k++)
         {
            i += squad.get(k).getPlayerHeight();
            j++;
         }   
          double average = i/j;
          System.out.println("Average Height of Squad is : " + average + " years");
         return average;
          
     }
     
     
     /**
     * Adds a player to a selected team for a match; Player must be in Squad first;
     * @param player - player object from players (squad) array list
     */
    
      public void addPlayerToTeam(Players player) //Assuming Coach selects players for match
    {
        if (squad.contains(player)==true)
        {
          team.add(player);
        }
        
        else
        {
            System.out.println("Player is not in Squad pls - Add to Club Squad first"); //Throw exception instead.
        }
    }    
    
    /**
     * Removes a player from a selected team for a match; Player must be in Team first;
     * @param player - player object from team array list
     */
    
      public void removePlayerInTeam(Players player) //Assuming Coach selects players for match
    {
        if (team.contains(player)==true)
        {
          team.remove(player);
        }
        
        else
        {
            System.out.println("Player is not in Current Team pls"); //Throw exception instead.
        }
    }    

    /**
     * List and prints to console Players selected as part of the team in ArrayList of team;
     * @displays Arraylist of Players - player object from team array list
     */
   
    
    public void getPlayerInTeamOfAMatch()
    {
        //int playergoals = 0;
        String playername;
        for (int i=0; i<team.size(); i++)
        {
            
            playername = team.get(i).getPlayerName();
           // playergoals = team.get(i).getGoalTally();
            System.out.println(playername + " from " + this.getNameOfClub() + " played in the match ");
            
        }

       
    }
    
        
    /**
     * List and prints to console Players in the Club (the Squad);
     * @displays Arraylist of Players - player object from squad array list
     */
 
    
      public void getPlayersInSquadOfAClub()
    {
        //int playergoals = 0;
        String playername;
        for (int i=0; i<squad.size(); i++)
        {
            
            playername = squad.get(i).getPlayerName();
           // playergoals = team.get(i).getGoalTally();
            System.out.println(playername + " from  " + this.getNameOfClub() + " exist");
            
        }

       
    }

    
    /**
     * Adds a Goalkeeper to the Club (in the Squad);
     * @param Goalkeeper p: Goalkeeper is added to the club's squad;
     */
 
      public void addGoalKeeperToSquad(GoalKeeper goalie)
   {
       if (!squad.contains(goalie)==true)
        {
          squad.add(goalie);
        }
        
        else
        {
            System.out.println("Goalkeeper is already in squad pls - Add to Club Squad first"); //Throw exception instead.
        }
       squad.add(goalie);
   }
   
   
    /**
     * Provides index number of a Player in the Club or the Squad
     * @param Players p: p is a Player which may be present in the Club, through the club's squad;
     * @return index : index is index number or position of that player in the squad (ArrayList)
     */
   
   public int indexOfPlayer(Players p){
        //    if (LeagueMatches.contains(match)==true)
    
            for (int i=0; i<squad.size(); i++)
        {
            if(this.squad.get(i).equals(p)) 
            {
               return squad.indexOf(p);   
            }
            
        }
        
        return -1;
     }

     /**
     * Provides index number of a Player in the Club or the Squad
     * @param Players p: p is a Player which may be present in the Club, through the club's squad;
     * @return index : index is index number or position of that player in the squad (ArrayList)
     */
   
   public int indexOfPlayer1(Players p){
        //    if (LeagueMatches.contains(match)==true)
    
            for (int i=0; i<team.size(); i++)
        {
            if(this.team.get(i).equals(p)) 
            {
               return team.indexOf(p);   
            }
            
        }
        
        return -1;
     }
     
     
     
    /**
     * The top striker goals in the Club is recorded here
     * @return p: goals so far scored by the top striker is returned;
     */
     
     public int topStrikerGoals()
    {
        int max = squad.get(0).getGoalTally();
        int tracker = 0;
        for (int i = 0; i < squad.size(); i++)
        {
            if (squad.get(i).getGoalTally() > max)
            {
                max =squad.get(i).getGoalTally();
                tracker = i;
            }
        }
    
       return max;
        // Golden Boot in League - Scores highest
    }

    
    /**
     * Shows Name of the Top Striker in the Club (or Squad);
     * @return getPlayerName(): This methods reveals player's name;
     */
    
    
     public String revealTopStriker()
    {
        int max = squad.get(0).getGoalTally();
        int tracker = 0;
        for (int i = 0; i < squad.size(); i++)
        {
            if (squad.get(i).getGoalTally() > max)
            {
                max =squad.get(i).getGoalTally();
                tracker = i;
            }
        }
    
       return squad.get(tracker).getPlayerName();//+ + " is Top Scorer : " + " with " + max + " goals" + "from " + this.NameOfClub() );
       // Golden Boot in League - Scores highest
    }
     
    
    /**
     * Adds a Goalkeeper to the Club (in the Squad);
     * @param Goalkeeper p: Goalkeeper is added to the club's squad;
     */
     public void clubTopScorer()
    {
        int max = squad.get(0).getGoalTally();
        int tracker = 0;
        for (int i = 0; i < squad.size(); i++)
        {
            if (squad.get(i).getGoalTally() > max)
            {
                max =squad.get(i).getGoalTally();
                tracker = i;
            }
        }
        System.out.println(squad.get(tracker).getPlayerName()+ " with " + max + " goals is the Top Scorer in " + this.clubName);
  
        // Used to obtain a printout for Highest Goal Scorer in Club 
    }
     
    /**
     * Updates a player's goal tally within the club/squad;
     * @param Players p: Players ;
     */

    public void updatePlayerSquadGoal(Players p)
    {
         if (squad.contains(p)==true && indexOfPlayer(p)!=-1)
         {
             squad.get(indexOfPlayer(p)).addGoalTally();
         }
    } 
    
    /**
     * Updates a player's goal tally within the club/squad;
     * @param Players p: Players ;
     */

    public void updatePlayerTeamGoal(Players p)
    {
         if (team.contains(p)==true && indexOfPlayer1(p)!=-1)
         {
             team.get(indexOfPlayer1(p)).addGoalTally();
         }
    } 
    
    
    
    /**
     * Updates goalkeepers cleansheet record
     * 
     */
    
    public void updateGoalKeeperCleanSheet()
    {
        if (squad.contains(goalie)==true)
         {
                goalie.addCleanSheet();
         }

    }
    
    /**
     * Retrieves current cleansheet record of the goalkeeper
     * @return goalkeepers cleansheet
     */
    
    public int cleansheet()
    {
        return goalie.getcleansheet();
    }
    
    
    /**
     * Retrieves current goalkeeper name
     * @return goalkeeper's name
     */
    
    public String getGoalkeeperName()
    {
        return goalie.getPlayerName();
    }
    

}

