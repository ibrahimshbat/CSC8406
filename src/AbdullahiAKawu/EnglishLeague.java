package AbdullahiAKawu;


/**
 * Write a description of class EnglishLeague here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnglishLeague
{
     
        //Creating objects of players and clubs
        // 2 Clubs, 2 Players
       public static void main(String[] args)
       
       {
           
           //Setup a league for two clubs
       Leagues league = new Leagues("FA Cup", 3);
        
       //Setup the two clubs
        Clubs Club1 = new Clubs("Club1");
        Clubs Club2 = new Clubs("Club2");
        Clubs Club3 = new Clubs("Club3");
        
        //Setup the players for the two clubs (p1 - p4)
        Players p1 = new Players("Isah", 1.4, 1980, 10, 06);
        Players p2 = new Players("Elias", 1.2, 1990, 12, 05);
        Players p3 = new Players("Martha", 1.2, 1979, 10, 06);
        Players p4 = new Players("John", 1.2, 2000, 12, 05); 
        Players p5 = new Players("Ali", 1.2, 1979, 10, 06);
        Players p6 = new Players("Musa", 1.2, 2000, 12, 05); 
        
        //Adds p1, p2 players to club1
        Club1.addPlayer(p1);
        Club1.addPlayer(p2);
          
         //Adds p3, p4 players to club2
        Club2.addPlayer(p3);
        Club2.addPlayer(p4);
        
         //Adds p5, p6 players to club2
        Club3.addPlayer(p5);
        Club3.addPlayer(p6);
        
        //Adds p1, p2 players to club1
        Club1.addPlayerToTeam(p1);
        Club1.addPlayerToTeam(p2);
        
        //Adds p1, p2 players to club1
        Club2.addPlayerToTeam(p3);
        Club2.addPlayerToTeam(p4);
        
       //Adds p1, p2 players to club1
        Club3.addPlayerToTeam(p6);
        Club3.addPlayerToTeam(p5);

        
         
        //Adds Clubs to League
       league.addClubToLeague(Club1);
       league.addClubToLeague(Club2);
       league.addClubToLeague(Club3);
    
       //Match setup
       Matches match1 = new Matches("Old Traford", 22, 44, league.LeagueClubs.get(0), league.LeagueClubs.get(1));        
       Matches match2 = new Matches("Emirates", 10, 44, league.LeagueClubs.get(1), league.LeagueClubs.get(0));
       Matches match3 = new Matches("Newcastle", 10, 23, league.LeagueClubs.get(1), league.LeagueClubs.get(2));
       Matches match4 = new Matches("Old Traford", 10, 23, league.LeagueClubs.get(0), league.LeagueClubs.get(2));
       
        //Adds Match to League
       league.addMatchToLeague(match1);
       league.addMatchToLeague(match2);
       //league.addMatchToLeague(match3);
    
       //View fixtures - match not yet played; we expect 2 list of matches
       league.viewFixtures();
       
       //league.LeagueMatches.get(0).setMatchAsEndedOrPlayed();
       
       
       //Add goals to players
       league.LeagueMatches.get(0).playerScored(p3);
       league.LeagueMatches.get(0).playerScored(p3);
       league.LeagueMatches.get(0).playerScored(p4);
      //league.LeagueMatches.get(0).playerScored(p2);
       //match1.playerScored(p3);
       
      league.LeagueMatches.get(0).setMatchAsEndedOrPlayed();
      // league.LeagueMatches.get(1).setMatchAsEndedOrPlayed();
       
       System.out.println("**************Testing- 1st Match Only expected***************************************");
       league.endAMatch(match3);
       
       //league.LeagueMatches.get(0).getPlayersPlayedAndGoals();
       
       //View fixtures - match not yet played; - we expect only 1 club
       league.viewFixtures();
       
       //View status of ended match by getting league result 
       league.leagueResults();
       
       //View Top team or Club
       league.topClubInLeague();
       
       System.out.println("\n");
        
       //Print League table
       league.printLeagueTable();
       
       System.out.println("\n");
       
        //View top scorer;
       league.topScorer();
       
       league.LeagueClubs.get(0).setGoalkeeperName("Musa");
       league.bestGoalKeeper();
      
              
    } 
}
