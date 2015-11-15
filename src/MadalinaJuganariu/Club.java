package MadalinaJuganariu;
import java.util.ArrayList;
/**
 * Store the details of a football club,
 * such as the name, games won, games lost, games drawn, 
 * goal scored, goals conceded
 * 
 * @author Madalina Juganariu
 * @version 21/10/2015
 */
public class Club implements Comparable<Club> {
    // Variable to store the club's name
    private String cName;
    // Variable to store the games' won
    private int gamesWon;
    // Variable to store the games' lost
    private int gamesLost;
    // Variable to store the games' drew
    private int gamesDrawn;
    // Variable to store the goals' scored
    private int goalsScored;
    // Variable to store the goals' conceded
    private int goalsConceded;
    // Arraylist to store the club's players
    private ArrayList < Player > players;
    //Variable to hold the player's name
    private String playerName;
    //Variable to store the sum of all the heights of the players that are part of the club
    private int sum;
    //Variable to store the average height
    private double averageHeight;
    //Variable to store the sum of all ages
    private int sumAge;
    //Variable to store the average height
    private int averageAge;
    //Variable to store the points of a club instance
    private int comparePoints;
    
    /**
     * Constructor for objects of class Club.
     * Set the club's name
     */

    public Club(String cName) {
        this.cName = cName;
        players = new ArrayList < Player > ();
    }
    /**
     * Method to create a player into the Club class
     */
    public void addPlayer(String pName, int height, int goalTally, int age) {
        players.add(new Player(pName, height, goalTally, age));
    }
    /**
     * Method to add an instance of a player class to the Club class
     */
    public void addPlayer(Player player) {
        //Check if the player the user wants to add is already part of the team
        if (players.contains(player)) {
            //Return to end further execution 
            return;
        }
        players.add(player);
    }
    /**
     * Method to display all players
     * Currently in the club
     */

    public void listAllPlayers() {
        //loop through the arraylist of players
        for (Player player: players) {
            //print out each player
            System.out.println("Name:" + " " + player.getName() + " " + "Height:" + " " + player.getHeight() + " " + "Age:" + " " + player.getAge()+ " " + "Goals scored:" + " " + player.getGoalTally());
        }
    }
     /**
     * Method to compare each clubs number of points
     * and return in a descending order
     */
    public int compareTo(Club compareClub) {
        int comparePoints=((Club)compareClub).getPoints();
        return comparePoints-this.getPoints();
    }

    /**
     * Method to return the number of players
     * Currently in the club
     * @return players.size()
     */

    public int getNumberOfPlayers() {
        return players.size();
    }
    /**
     * Method to get the top scorer player in the club
     */
    public Player getTopPlayer() {
        //Create a player object that will be assigned the top scorer
        Player maxScorer = new Player("top", 0, 0, 0);
        //loop through the array of players in the club
        for (Player player: players) {
            //check if any player in the array has a higher goal tally than the aux player declared above
            if (maxScorer.getGoalTally() < player.getGoalTally()) {
                //if true then the aux player becomes the top scorer
                maxScorer = player;
            }

        }
        //return the top scorer
        return maxScorer;
    }   
    /**
     * Method to calculate average height of all the players
     * Currently in the club
     */

    public void averageHeight() {
        //initialise a the sum variable with 0
        sum = 0;
        //loop through the array of players
        try{
        for (Player player: players) {
            //calculate the sum by adding all the heights from the club
            sum += player.getHeight();
            //calculate the average height
            averageHeight = (double) sum / players.size();
          
        }
       System.out.println("The average height for this club is:" + " " + averageHeight);
       }
       catch ( Exception err ) {
        System.out.println( err.getMessage( ) );
        }
    }
    /**
     * Method to calculate average age of the players
     * Currently in the club
     */

    public void averageAge() {
        //initialise a the sumAge variable with 0
        sumAge = 0;
        //loop through the array of players
        try{
        for (Player player: players) {
            //add all the ages in the club
            sumAge += player.getAge();
            //calculate the average age
            averageAge = sumAge / players.size();
        }
        System.out.println("The average age for this club is:" + " " + averageAge);
        }
        catch ( Exception err ) {
            System.out.println( err.getMessage( ) );
        }
    }
    
    /**
    *Instance method
    * 
    *Sets the number of games won
    */

    public void setWon(int gamesWon) {
        this.gamesWon = gamesWon;

    }
    /**
    *Instance method
    * 
    *Increase the number of games won
    */
    public void increaseWon() {
        gamesWon++;
    }
    /**
    *Instance method
    * 
    *Increase the number of games drawn
    */
    public void increaseDrawn() {
        gamesDrawn++;
    }
    /**
    *Instance method
    * 
    *Increase the number of games lost
    */
    public void increaseLost() {
        gamesLost++;
    }
    /**
     *Check if a player is part of the club
     */

    public void getContains(String playerName) {
        //Loop through the array list
        for (Player player: players) {
            //Check if the inputed value equals the value of one item from the array list
            if (player.getName().equalsIgnoreCase(playerName)) {
                //If the value is true print the Player found message otherwise print the player not found message
                System.out.println("Player" + " " + playerName + " is part of the club");
            } else {
                System.out.println("Player" + " " + playerName + " is not part of the club");
            }
        }

    }
    /**
     * Set the number of lost games
     */

    public void setLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    /** 
     * Set the number of drawn games
     */

    public void setDrew(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    /** 
     * Set the number of goals the club has conceded
     */

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    /** 
     * Return the number of won games
     * @return gamesWon
     */

    public int getWon() {
        return gamesWon;
    }

    /** 
     * Return the number of lost games
     * @return gamesLost
     */

    public int getLost() {
        return gamesLost;
    }

    /** 
     * Return the number of drawn games
     * @return gamesDrawn
     */
    public int getDrawn() {
        return gamesDrawn;
    }

    /** 
     * Return the number of goals the club has scored this season
     * By adding the goal tally of each player that plays for the club
     * @return goalsScored
     */

    public int getGoalsScored() {
        goalsScored = 0;
        for (Player player: players) {
            goalsScored += player.getGoalTally();
        }
        return goalsScored;
    }

    /** 
     * Return the number of goals conceded 
     * @return goalsConceded
     */

    public int getGoalsConceded() {
        return goalsConceded;
    }

    /** 
     * Return the number of games the club has played 
     * By adding all the games won, lost and drawn
     */

    public int getPlayed() {
        return this.getWon() + this.getLost() + this.getDrawn();
    }

    /** 
     * Return the clubs goal difference this season
     * By substracting from the goals scored tally the goals conceded tally
     */
    public int getGoalDifference() {
        return this.getGoalsScored() - this.getGoalsConceded();
    }

    /** 
     * Return the number of points gained this season
     * by multiplying the won games by 3 and adding the number of drawn matches
     */
    public int getPoints() {
        return this.getWon() * 3 + this.getDrawn();
    }
    /** 
     * Return the club's name
     * @return cName
     */
    public String getClubName() {
        return cName;
    }
}