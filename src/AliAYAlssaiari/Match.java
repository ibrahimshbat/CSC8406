package AliAYAlssaiari;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.time.LocalTime;

public class Match {
	private String matchPlace;
	private LocalTime matchTime;
	private Club firstClub;
	private Club secoundClub;
	private int minutes;
	private int hourse ;
	private String finalResult;
	private int team1goals;
	private int team2goals;
	private boolean isplayed;
	private ArrayList<Club> matchClub = new ArrayList<Club>();

	public Match() {

	}

	
	/**
  * Match Constructor :  which Construct the match it has 6 parameters.
  *
  * @param matchPlace A parameter to specify the match Place 
  * @param hourse A parameter to specify which hour this match will played in 
  * @param mintues A parameter to specify which minute  this match will played in 
  * @param firstClub A parameter the First Club in the Match 
  * @param secoundClub A parameter the Secound Club in the Match 
  */
 public Match(String matchPlace, int hourse , int mintues, Club firstClub,Club secoundClub) {

		this.matchPlace = matchPlace.trim().toLowerCase();
		this.hourse = hourse;
		this.minutes = minutes;
		this.firstClub = firstClub;
		this.secoundClub = secoundClub;
		matchClub.add(firstClub);
		matchClub.add(secoundClub);
		matchTime= LocalTime.of(hourse, mintues);

	}

	/**
  * Method setMatchTime : this method set the Match Time in hourse and minutes 
  *
  * @param hourse A parameter to specify the match hour
  * @param minutes A parameter to specifiy the match minuts
  */
 public void setMatchTime(int hourse , int minutes)
	{
	    if(hourse >23 || hourse<0 || minutes >59 || minutes <0)
	    { System.out.println("Please check the time. hourse should not be more than 23 or less than 0 . Minutes should not be more than 59 or Less than 0");
	    }
	    else matchTime = LocalTime.of(hourse, minutes);
     }
     
    /**
     * Method getMatchTime : return the Match Time. in hours and Minutes 
     *
     * @return The Match Time 
     */
    public LocalTime getMatchTime()
     {
         return matchTime;
         
     }
        
	/**
	 * this Method print All Players information  in the Match from both Clubs 
	 * 
	 */
	public void getMatchPlayer()
	{
		firstClub.getAllPlayerInTeam();
		secoundClub.getAllPlayerInTeam();
	}
	

	// return if the match playes or not  
	public boolean matchStatues(Match m) {
		return isplayed;
	}
// register goals to the match 
	/**
  * Method playedMatch : this method when Match Played , receive the match Result for  both Club and Update the match Statues to be Played CALL method UpdateGoallTallyandPointsTally()  
  *
  * @param team1goals A parameter to the first Club Goals 
  * @param team2goals A parameter to the Secound Club Goals
  */
 public void playedMatch(int team1goals, int team2goals) {
	 matchClub.get(0).addGoalsScored(team1goals);
	 matchClub.get(1).addGoalsScored(team2goals);
	 matchClub.get(0).addGoalsConceded(team2goals);
	 matchClub.get(1).addGoalsConceded(team1goals);

	 this.isplayed = true;

	 team1goals = matchClub.get(0).getGoalsScored();
	 team2goals = matchClub.get(1).getGoalsScored();
	 
	UpdateGoallTallyandPointsTally();

	}

	/**
  * Method UpdateGoallTallyandPointsTally : set the Goals for Each Club in addition to that update the Points tally for the Winner Club or for both Club in Case they are draw.
  *
  */
 public void UpdateGoallTallyandPointsTally()
	{
		if (matchClub.get(0).getGoalsScored() >matchClub.get(1).getGoalsScored())
			matchClub.get(0).addPoint(3);
		else if (matchClub.get(0).getGoalsScored() <matchClub.get(1).getGoalsScored())
			this.secoundClub.addPoint(3);

		else {
			this.secoundClub.addPoint(1);
			this.firstClub.addPoint(1);
		}
	   }
	  
	/** 
	* this method set the first Club in the Match
	* @param firstClub
    *           
   */
public void setFirstClub(Club firstClub) {
		this.firstClub = firstClub;
	}
	
	/**
  * Method getFirstClub : return First Club in the Match 
  *
  * @return The First Club in the Match
  */
 public Club getFirstClub() {
		return firstClub;

	}

	
/** this method get the Secound Club in the Match
* 
*/
	public Club getSecoundClub() {
		return secoundClub;
	}

/**
 * this method Set the Secound Club in the Match.
 * @param secoundClub
 *          
 */
public void setsecoundClub(Club secoundClub) {
		this.secoundClub = secoundClub;
	} 
	
/**
 * this method return the FirstTeam Goals.
 * @return the finalResult
 */
public int getFirstteamgoals() {
		return this.team1goals;
	}

/**
 * Method getSecoundteamgoals
 *
 * @return The return value
 */
public int getSecoundteamgoals() {
		return team2goals;
	}
	
/**
  * Method getMatchPlace : this methos return the Match Place 
  *
  * @return The  Match Place
  */
 public String getMatchPlace() {
		return matchPlace;
	}

/** this Method  Set the Place of the Match 
 * @param matchPlace
 *            
 */
public void setMatchPlace(String matchPlace) {
		this.matchPlace = matchPlace;
	}

/**
 *  return the Finall Result of the Match.
 * 
 * @param finalResult
 *            the finalResult to set
 */
public void getFinallScore()
{
	System.out.println(firstClub.getName() + matchClub.get(0).getGoalsScored() + "-" +matchClub.get(1).getGoalsScored() + secoundClub.getName());
}
public void getFinalResult() {
	if(matchClub.get(0).getGoalsScored() > matchClub.get(1).getGoalsScored())
	{
		System.out.println(firstClub.getClubName() + "\t Win" );
	}
	else if(matchClub.get(0).getGoalsScored() < matchClub.get(1).getGoalsScored())
	{
		System.out.println(secoundClub.getClubName() + "Win" );
	}
	else System.out.println("No Winer ");
}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstClub == null) ? 0 : firstClub.hashCode());
		result = prime * result
				+ ((matchPlace == null) ? 0 : matchPlace.hashCode());
		result = prime * result
				+ ((secoundClub == null) ? 0 : secoundClub.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (!(obj instanceof Match)) {
			return false;
		}
		Match other = (Match) obj;
		if (firstClub == null) {
			if (other.firstClub != null) {
				return false;
			}
		} else if (!firstClub.equals(other.firstClub)) {
			return false;
		}
		if (matchPlace == null) {
			if (other.matchPlace != null) {
				return false;
			}
		} else if (!matchPlace.equals(other.matchPlace)) {
			return false;
		}
		if (secoundClub == null) {
			if (other.secoundClub != null) {
				return false;
			}
		} else if (!secoundClub.equals(other.secoundClub)) {
			return false;
		}
		return true;
	}



	

}
