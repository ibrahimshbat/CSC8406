package AliAYAlssaiari;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * this Class is a Club Class . throught Club can be Construct in addition the Players of the Club can be Add through it. the Club Match team  wich is consist of 11 Players can be build through this Class 
 * 
 * @author (ALI ALSSAIARI ) 
 * @version (26-10-2015)
 */


public class Club {
    private String name;
    private int goalScored;
    private int goalConceded;
     private int goalDifference;
    private int points;
    private int ageAverage;
    private double heightAverage;
    private ArrayList<Player> squad = new ArrayList<Player>();
    private ArrayList<Player> team = new ArrayList<Player>();
    private ArrayList<Club> club = new ArrayList<Club>();

    public Club() {
        name = "";
        goalScored = 0;
        goalConceded = 0;
        points = 0;

    }

    public Club(String name) {
        this.name = name.trim();
        
    }
    
    public int getTeamSiz()
    {
     return team.size();
    }
    // test 
    public void setClub(Club e)
    { 
      club.add(e);
    
    }


    /**
   * @return the Club Name 
   */
   public String getName() {
    return name;
   }

   /** this method set the Club Name 
   * @param name the Club name to set
   */
   public void setName(String name) {
    this.name = name;
   }

    /**
     * Method getClubName : return the Club Name 
     *
     * @return The Club Name 
     */
    public String getClubName() {
        return name;
    }

    /**
     * Method addGoalsScored : add Goals to the Club a
     *
     * @param goals A parameter for goals Scored by the Club Players.
     */
    public void addGoalsScored(int goals) {

        this.goalScored += goals;

    }
    
    /**
     * Method getGoalsScored : return the goal Tally for the Club
     *
     * @return Thegoal Tally for the Club
     */
    public int getGoalsScored() {

        return this.goalScored ;

    }

 
    /**
     * Method addGoalsConceded : this method set the Club Conceded Goals
     *
     * @param goals A parameter of conceded Goals.
     */
    public void addGoalsConceded(int goals) {

        this.goalConceded += goals;

    }
    
    /**
     * Method getGoalsConceded : this method return the Club goal conceded
     *
     * @return The Club goals conceded
     */
    public int  getGoalsConceded() {

        return goalConceded;

    }


    
    /**
     * Method getGoalsDifference : this method Calculate and return the Goals difference for  the Club.
     *
     * @return The goal difference for the Club
     */
    public int getGoalsDifference() {
        return goalDifference = goalScored - goalConceded;

    }

    /**
     * Method addPoint : this method Add points for the Club. it's receive the points and update the points Tally
     *
     * @param point A parameter
     */
    public void addPoint(int point) {
        this.points += point;
    }

    /**
     * Method getPoint : this method Return the points Tally for a Club
     *
     * @return The points Tally for a Club
     */
    public int getPoint() {
        return points;
    }

    

    /**
     * Method addPlayerToClubSquad : this method taking a Player object and check if it's not in the Club Squad add it to the Squad. and if he is alrady registerd with this Club Show a message to the user and do not add the Player to the Squad . this method Call the  checkPlayer()in this Class  and depend on it's return Value 
     *
     * @param p A parameter of Type Player object.
     */
    public void addPlayerToClubSquad( Player p) {
     
        if(!checkPlayer( p)){
        this.squad.add(p);
        }
        else System.out.println("the Player Already Playing with this Club");

    }
    
    
    /**
     * Method checkPlayer : this Methos Check if the Player is in the Club Squad or not 
     *
     * @param p A parameter of Player type.
     * @return return true if the Player exist in the Club  Squad or return fals if the Player not in the Club Squad 
     */
    public boolean checkPlayer(Player p)
    {
        
        if (squad.contains(p)) 
        {
            return true ;
        }
        return false;
        
    }
 
    
     /**
     * Method addPlayerToTeam : this method Automatically go throght the Club Squad and Choice 11 Players to the Team for the Match. and Add them to team ArrayList 
     *
     */
     public void addPlayerToTeam() {
        int forward=0;
        int defense = 0;
        int midfilder = 0;
        int stricker = 0;
        int goalkeepr=0;
        if (squad.size() >= 11) {

            for (int i = 0; i < squad.size(); i++) {
                if((squad.get(i).getname().equalsIgnoreCase("Goalkeepr") && (goalkeepr<1)))
                {
                        if(!team.contains(squad.get(i))){
                             team.add(squad.get(i));
                             goalkeepr++;
                        }
                }
                if(squad.get(i).getPlayerPosition()=="defence" && defense<3)
                {
                    if(!team.contains(squad.get(i)))
                    {
                        team.add(squad.get(i));
                        defense++;
                    }
                }               
                if(squad.get(i).getPlayerPosition().equals("midlle") && midfilder<3)
                {
                    if(!team.contains(squad.get(i)))
                    {
                        team.add(squad.get(i));
                        midfilder++;
                    }
                }
                if(squad.get(i).getPlayerPosition()=="stricker" && forward<2)
                {
                    if(!team.contains(squad.get(i)))
                    {
                        team.add(squad.get(i));
                        forward++;
                    }  
                }
            
                if (team.size() == 11) {
                    i=squad.size();
                }
            }
        } else {
            System.out.println(
                    "To build a team  for the Match  for any Club you should firstly have  11 Players or more than 11 Playaers in the Club Squad. \n So, you need to More Players to the Club Squad in Order to  build a team ");
        }
    }

 /**
    * Method getAllPlayerInSquad : this method Print the information For All players in the Club  Squad 
    *
    */
    public void getAllPlayerInSquad() {
        Iterator<Player> it = squad.iterator();
        while (it.hasNext()) {
            Player player = (Player) it.next();
            player.info();
            

        }
    }

 public Player   getAplayer()
    {
        Player p1 = null;
        for ( Player p : squad)
        {
            
            if(p.getPlayerPosition()=="goalkeepr" )
            {
                p1=p;
            }
        }
        
        return p1;
    }
 
    /**
     * Method getAllPlayerInTeam : this Method Print the information for All Player in the Team
     *
     */
 public void   getAllPlayerInTeam() {
        Iterator<Player> it = team.iterator();
        while (it.hasNext()) {
            Player player = (Player) it.next();
             player.info();
        }
    
    }

     
    
     /**
      * Method isAclubPlayer : check if a player in the club or not. it's receive a parameter of Player o   bject and Check if this Player exist in the Club Squad Return true and if he is not in the Club Sqaud return False
      *
      * @param b A parameter of type Player 
      * @return  true if the Player exist or False if the Player not exist in the Club Squad
     */
 public boolean isAclubPlayer(Player b){
     
     if(squad.contains(b))
     {
         return true;
     }
     else return false;
     }

 

    /**
  * Method squadAverageAge : Calculating the Average Age of all Players in  the Club Squad 
  *
  * @return return the Average Age for All Players in the Club Squad. 
  */
 public int squadAverageAge() {
        ageAverage =0;
        int ages = 0;
        int playersCount = 0;
        
        Iterator<Player> it = squad.iterator();
        while (it.hasNext()) {
            Player player = (Player) it.next();
            playersCount++;
            ages += player.getAge();
            
        }
        ageAverage = ages / playersCount;
        return ageAverage;
    }

    
    /**
  * Method getAveragHeight: this method Calculate the Average Height for All Players in the Club Squad. it's iterat through all the Club squad Players and call the Method getHeight() for each Player and store all players heights in a variable then get the average by dividing the total heights on the Player number 
  *
  * @return The Average height for all Players 
  */
 public double getAveragHeight() {
         heightAverage = 0;
        double heightTotal=0;
        int playersCount = 0;
        
        Iterator<Player> it = squad.iterator();
        while (it.hasNext()) {
            Player player = (Player) it.next();
            playersCount++;
            heightTotal = heightTotal + player.getHeight();
        }
        heightAverage = heightTotal/playersCount;
        return heightAverage;
    }

    // adding Players to the team should be 11 Players chosen from the Squad
    public void clubTeam() {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Club)) {
            return false;
        }
        Club other = (Club) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    
    
    
    
 

}
