package AliAYAlssaiari;

    import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
/**
 * Wthis Class is a tester Calss for the Project it has main method to test All Class
 * 
 * 
 * @author (ALI ALSSAIARI) 
 * @version (30-10-2015)
 */
public class SaudiLeague
{


	public static void main(String[] args) {
		
		League league = new League("Primer  League");
		Club  manchester =  new Club("Manchester");
		Club newcastle  = new Club("Newcastle");
		Club  Chelse =  new Club("Chelse");
		Club totenhame =  new Club("totenhame");
		Club sunderland = new Club ("Sunderland");
		Club bradford = new Club("Bradford");
		Club arsenal = new Club ("Arsenal"); 
		
		Player player1 = new Player ("Rony ", "Stricker",1.75,1985,11,10);
		Player player2 =  new Player ("tevis ", "Stricker",1.75,1985,11,10);
		Player player3 = new Player ("henery ", "Stricker",1.75,1985,11,10);
		Player player4 = new Player ("davids ", "Goalkeepr",1.75,1985,11,10);
		Player player5 = new Player ("edward ", "Stricker",1.75,1980,11,10);
		Player player6 = new Player ("jhon ", "defence",1.75,1975,11,10);
		Player player7 = new Player ("frank ", "defence",1.75,1985,11,10);
		Player player8 = new Player ("mikle ", "defence",1.75,1985,11,10);
		Player player9 = new Player ("ali ", "midlle",1.75,1985,11,10);
		Player player10 = new Player ("mohamad ", "midlle",1.75,1985,11,10);
		Player player11= new Player ("bader ", "midlle",1.75,1985,11,10);
		Player player12 = new Player ("ahmad ", "midlle",1.75,1985,11,10);
		Player player13 = new Player ("nigle ", "midlle",1.75,1985,11,10);
		
		manchester.addPlayerToClubSquad(player1);
		manchester.addPlayerToClubSquad(player2);
		manchester.addPlayerToClubSquad(player3);
		manchester.addPlayerToClubSquad(player4);
		manchester.addPlayerToClubSquad(player5);
		manchester.addPlayerToClubSquad(player6);
		manchester.addPlayerToClubSquad(player7);
		manchester.addPlayerToClubSquad(player8);
		manchester.addPlayerToClubSquad(player9);
		manchester.addPlayerToClubSquad(player10);
		manchester.addPlayerToClubSquad(player11);
		manchester.addPlayerToClubSquad(player12);
		manchester.addPlayerToTeam();
		
		//System.out.println(league.getName());
		
		//System.out.println("Adding Clubs To the League  ");
		league.addClubToLeague(manchester);
		league.addClubToLeague(newcastle);
		league.addClubToLeague(Chelse);
		league.addClubToLeague(totenhame);
		league.addClubToLeague(sunderland);
		System.out.println("//////////////////////////////////////////////");
		 league.fixture();
		 System.out.println("Print the League Fixture ");
		 System.out.println("//////////////////////////////////////////////");
		 league.getVixture();
		// Adding the Result to a match when it's Played
		Match m = new Match("Manchester",19,20,manchester,newcastle);
		// Send the Match with Teams Score to the update the match
		league.playedMatchs(m, 2, 1);
		System.out.println("//////////////////////////////////////////////");
		System.out.println("the First Club in the Match "+ m.getFirstClub().getName());
		System.out.println("The Secound Club in the MAtch."+ m.getSecoundClub().getName());
		System.out.println("//////////////////////////////////////////////");
		System.out.println("the Final Score  ");
	    	m.getFinallScore();
	    	System.out.println("//////////////////////////////////////////////");
			System.out.println("the Final result  ");
		      m.getFinalResult();
		      System.out.println("//////////////////////////////////////////////");
		      
				System.out.println("the Club Points  ");

		System.out.println(manchester.getPoint());
		System.out.println("//////////////////////////////////////////////");
		System.out.println("the Final Score");
	    m.getFinallScore();
	   
	    System.out.println("//////////////////////////////////////////////");
	    System.out.println("the league Table ");
	    System.out.println("//////////////////////////////////////////////");
	    league.leagueTbale();
	//	System.out.println(m.getFirstteamgoals());
				//System.out.println(manchester.getGoalsScored());
				//System.out.println(manchester.getPoint());
		//System.out.println("there are  " + league.getleaguecClubsCount() + "    Clubs in the League.");
		//league.addClubToLeague(manchester);
		//System.out.println("Firstly we need to Create Clubs   ");
		
		//System.out.println("the Club Name is :"+ manchester.getName() );
		//System.out.println("//////////////////////////////////////////////////// ");
		//System.out.println("Updating the Club Name ");
		//manchester.setName("Manchestre 2");
		//System.out.println("the Club updated Name Now is  :"+ manchester.getName() );
		//System.out.println("Now Adding the Club to the League Using ");
		//league.addClubToLeague(manchester);
		//league.addClubToLeague(newcastle);
		//league.addClubToLeague(newcastle);
		//league.addClubToLeague(newcastle);
		//league.addClubToLeague(newcastle);
		//System.out.println("there are  " + league.getleaguecClubsCount() + "    Clubs in the League.");
		
		
		//System.out.println("there are  " + league.getleaguecClubsCount() + "    Clubs in the League.");
		
		/*
		Club x1 = new Club();
		x1.setName("Newcastle");
		
		Club x2 = new Club();
		x2.setName("Sunderland");
		
		s.addclubtoleague(x);
		s.addclubtoleague(x1);
		s.addclubtoleague(x2);
		
		
		
		Player y1 = new Player ("Ali","midlle ",1.77,2000,12,23);
		Player y2 = new Player ("mohammad","midlle",1.77,2000,12,23);
		Player y3 = new Player ("d5","defence",1.77,2010,12,23);
		Player y4 = new Player ("d1","defence",1.77,2012,12,23);
		Player y5 = new Player ("d2","defence",1.77,2008,12,23);
		Player y6 = new Player ("d3","defence",1.77,2009,12,23);
		Player y7 = new Player ("d4","defence",1.77,2001,12,23);
		Player y8 = new Player ("turky","goalkeepr",1.77,2003,12,23);
		Player y9 = new Player ("ali","goalkeepr",1.77,2000,11,23);
		Player y10 = new Player ("bader","midlle",1.77,2015,2,23);
		Player y11= new Player ("bader","midlle",1.77,2006,3,23);
		Player y12= new Player ("bader","attack",1.77,2002,4,23);
		Player y13= new Player ("bader","attack",1.77,2004,6,23);
		Goalkeeper g = new Goalkeeper("al85858i","goalkeepr",1.77,2000,11,23);
		//x.addPlayerToClubSquad(g);
	///x.getAllPlayerInSquad();
		//	/s.addPlayers(x1, y1);
			//s.addPlayers(x1, y1);
		x.addPlayerToClubSquad(y1);
			x.addPlayerToClubSquad(y2);
			x.addPlayerToClubSquad(y3);
			x.addPlayerToClubSquad(y4);
			x.addPlayerToClubSquad(y5);
			x.addPlayerToClubSquad(y6);
			x.addPlayerToClubSquad(y7);
			x.addPlayerToClubSquad(y8);
			x.addPlayerToClubSquad(y9);
			x.addPlayerToClubSquad(y10);
			x.addPlayerToClubSquad(y11);
			x.addPlayerToClubSquad(y12);
			
			Player y22= new Player ("wadi","midlle",1.77,2006,3,23);
			Player y23= new Player ("nooor","attack",1.77,2002,4,23);
			Player y24= new Player ("saad","goalkeepr"
					+ "",1.77,2004,6,23);
			x1.addPlayerToClubSquad(y22);
			x1.addPlayerToClubSquad(y23);
			x1.addPlayerToClubSquad(y24);
			
		//	x.getAllPlayerInSquad();
			x.addPlayerToTeam();
			//x1.addPlayerToTeam();
			
			
			x.getAllPlayerInTeam();
			//x1.getAllPlayerInTeam();
			
		//	s.fixture();
		//x.getAveragHeight();
		//System.out.println(x.squadAverageAge());
		//    Match m = new Match( "Manchester" ,1999,x,x1 );
		  //  x.getAplayer().setGoals(5);
		//    y1.setGoals(5);
		//    y2.setGoals(7);
		  // System.out.println("the match Player are ");
		  // m.setMatchPlayers();
		//  m.getMatchPlayer();
		// s.getLeagueInfo();
	//	 s.playedMatchs(m, 1, 2);
		//s.getToClub();
		//s.getTopKeepr();
		   //  m.playedMatch(20, 30);
		 // s.getTopPlayer();
		
//m.playedMatch(12, 2);
		
	//	m.getFinalResult();
	//	m.getFinallScore();
	
	/*	String s1 = "2014-05-01";
		String e = "2014-05-10";
		LocalDate start = LocalDate.parse(s1);
		LocalDate end = LocalDate.parse(e);
		ArrayList<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.plusDays(1);
		}
		System.out.println(start.getDayOfMonth()+ "\t" + start.getMonthValue()+ "\t" +start.getYear());
		
		
	//	x.getAllPlayerInTeam();*/
		
		
	}
	}




