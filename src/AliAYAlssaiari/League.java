package AliAYAlssaiari;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class League {
	private String leagueName;
	private  final int MAX_NUMBER_OF_CLUBS= 5;
	
	private ArrayList<Club> leagueClub = new ArrayList<Club>();
	// private ArrayList<Player> existPlayers = new ArrayList<Player>();
	 private ArrayList<Match> matchs = new ArrayList<Match>();
	 
	public League(){
	   leagueName ="";
	   }
	public League(String leagueName) {
		
		this.leagueName = leagueName;
		
	}
	
	
	/**
  * This method will set the Name for the League 
  *
  * @param name A parameter for leage Name 
  */
 public void setName(String name)
	{
		this.leagueName= name;
	}
	
	/**
  * this method return the League Name 
  *
  */
 public String getName()
	{
		return leagueName;
	}
	public int  getleaguecClubsCount(){
		
	     return leagueClub.size();
	
		
	}
	
	public void getTopPlayer()
	{
		Player p = new Player ();
		//String topTam="";
		for( Club c: leagueClub)
		{
			
			if(c.getAplayer().getGoals()> p.getGoals())
				{
					p = c.getAplayer();
					
				}
		}
		System.out.println(" the Top Plaer  " + p.getname() + "the Total points is :" + p.getGoals());
	}
	
	/**
  * this method Print out the Top Team in the League 
  *
  */
 public void getTopClub()
	{
		int tempPointHolder = 0;
		String topTeam="";
		for( Club club: leagueClub)
		{
			if(club.getPoint()> tempPointHolder)
				{
					tempPointHolder=club.getPoint();
					topTeam=club.getClubName();
				}
		}
		System.out.println(" the Top Team in the League " + topTeam + "it's total Points are :" +tempPointHolder);
	}
	
	public void getTopKeepr()
	{
		
		int temp =leagueClub.get(0).getGoalsConceded() ;
		String topTam="";
		for( int i = 1;i<leagueClub.size(); i++)
		{
			
			if(temp>leagueClub.get(i).getGoalsConceded())
			{
				temp=leagueClub.get(i).getGoalsConceded();
				topTam= leagueClub.get(i).getName();
				
				
			}
			
		}
		for ( Club c : leagueClub){
			if(c.getName()==topTam){
			if(c.getAplayer().getPlayerPosition()=="goalkeepr"){
			  c.getAplayer().info();
			}}
				
		}
		
		System.out.println("the Top Goal Keeper is " +topTam + " Goal Conceded " + temp );
		
		
	}
	
	
	public void leagueTbale ()
	{
		System.out.println("the Team \t" +  "  Goals  " + "\t"+ "Goals Conceded \t" + "Goals Difference "  + " \t" + "Team Points " );
		for( Club  m: leagueClub)
		{
			
			
			//if(!m.matchStatues(m))
			System.out.println( m.getClubName()+"\t\t"+ m.getGoalsScored() +"\t\t" + m.getGoalsConceded() + "\t\t"+ m.getGoalsDifference() +"\t\t"+ m.getPoint());
		
			}
	}
	
	
	public void addMatch(Match match){
		if(!matchs.contains(match))
		{
			          matchs.add(match);
		}
		else System.out.println("match in table");
	}
	
	
	public void playedMatchs(Match m, int team1goals, int team2goals){
		//if(matchs.contains(m))
	//	{ 
			if(!m.matchStatues(m)){
			for( int i =0; i<matchs.size();i++)
			{
				if(matchs.get(i).equals(m))
				{
					matchs.get(i).playedMatch(team1goals, team2goals);
					//matchs.get(i).getFinallScore();
				}
			
			}
			}
		
		      // add last night 
		   /*   	for (int i= 0 ; i<=team1goals ; i++)
	      	{
	      		System.out.println("Enter the player name scored " + i+1 +" for team 1 " );
	      		Scanner s = new Scanner(System.in);
	      	
	      	     String 	y = s.next();
	      	   if (existPlayers.get(i).getname() == y){
	      		   int g = s.nextInt();
	      		 existPlayers.get(i).setGoals(g);
	      		 		      		 
	      	   }
	      	}
	      	 for (int i= 0 ; i<=team2goals ; i++)
		      	{
	      		System.out.println("Enter the player name scored " + i + " for team 2 " );
	      		Scanner s1 = new Scanner(System.in);
		      	     String 	y = s1.next();
		      	   if (existPlayers.get(i).getname() == y){
		      		   int g = s1.nextInt();
		      		 existPlayers.get(i).setGoals(g);
		      		 		      		 
		      	   }
	      		
		      	}*/
	      	 
			//}
		//else  	System.out.println("the Match is Already Played ");
			
			
		
		}
		
	
	///else System.out.println("the Match is not in the Table ");
	
	//}

		      	
		      	 
			
			
	
	


	/**
   *  This Fixture methos is Go through All Regesterd Clubs in the League and build the fixture using the Match Class. So, each match constructed with the firat Club and the secound Club 
   *
   */
    public void fixture ()
	  {

		setFirsthalfFixture();
		setSecoundhalfFixture();
    	
	 }
	public void setFirsthalfFixture()
	{
		
		for(int i = 0; i< leagueClub.size(); i++)
		{ 
		    String Place = leagueClub.get(i).getName().toLowerCase();
				for (int j = i; j< leagueClub.size();j++){
				    
				if(!(leagueClub.get(i)==leagueClub.get(j))){
				Match m = new Match( Place,19,20,leagueClub.get(i),leagueClub.get(j) );
				addMatch(m);}
			}
		}
		
	   }
	   
	   public void setSecoundhalfFixture()
	   {
		   
		  
	     for(int i = leagueClub.size()-1;i>=0; i--)
		  { 
		        String Place = leagueClub.get(i).getName();
				for (int j = i; j>=0;j--){
				if(!(leagueClub.get(i).equals(leagueClub.get(j)))) {
				Match m = new Match( Place,19,35,leagueClub.get(i),leagueClub.get(j) );
				addMatch(m);}
			}}
		
	   }
	
	
	  /**
    * this method take a Club and a player and add the Player to the Club
    *
    * @param club A parameter of type Club 
    * @param player A parameter of Type Player
    */
   public void  addPlayers(Club club ,Player player)
	    {
		
			  for( Club c : leagueClub)
			  {
				  if(c.checkPlayer(player))
				  {
					  System.out.println("Player is Alrady registerd with " +c.getName());
				  }
			  }
			  club.addPlayerToClubSquad(player);
	    }
	
	  /**
    * this method adding a cLub to the League 
    *
    * @param object A parameter
    */
   public void addClubToLeague(Club club)
	{
	   if(leagueClub.size()<MAX_NUMBER_OF_CLUBS)
	   {
		  if(!leagueClub.contains(club))
		   {
		   leagueClub.add(club);
		   }
		    else System.out.println("Club already in the League ");
		  }
	   else System.out.println("Club Can not be Added to the League as the Maximum Numbers of Clubs Excided. the Maximum number of Clubs in the League is  " +  MAX_NUMBER_OF_CLUBS);
	   }
	 
	
	
 public ArrayList<Club> getClubsByName()
 {
	 return leagueClub;
 }
 
	
	/**
  * print out all Clubs in the League 
  *
  */
 public void getLeagueInfo()
	{ for(Club cl:leagueClub ){
			
			System.out.println(cl.getClubName());
			
		     }
		
		// Match in the Fixture 
            
	
	}
  public void getVixture()
  {
           for(Match m:matchs ){
			
			System.out.println(m.getMatchPlace()+" Stadume"+ " \t" +m.getFirstClub().getClubName() + " VS " + m.getSecoundClub().getClubName() );
           }
	
  }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leagueClub == null) ? 0 : leagueClub.hashCode());
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
		if (!(obj instanceof League)) {
			return false;
		}
		League other = (League) obj;
		if (leagueClub == null) {
			if (other.leagueClub != null) {
				return false;
			}
		} else if (!leagueClub.equals(other.leagueClub)) {
			return false;
		}
		return true;
	}
		
	
	
	

}
