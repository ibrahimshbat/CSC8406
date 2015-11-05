package YiweiJing;



import java.util.ArrayList;
import java.util.List;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 22/10/2015 15:49
 * This is my assessment
 * Project name is league
 */
public class LeagueTest {
    public static void main(String[] args) throws Exception {
        String leagueName = "England League";
        List<Club> clubs = Club.dao.list();
        List<Match> matches = Match.dao.list();

        System.out.println("\n");



        //create a league
        League league = new League(leagueName);
        League.dao.create(league);



        //add a club to the league;
        league = league.addClub(league,clubs.get(0));
        league = league.addClub(league,clubs.get(1));
        league = league.addClub(league,clubs.get(2));
        league = league.addClub(league,clubs.get(3));
        league = league.addClub(league,clubs.get(4));
        league = league.addClub(league,clubs.get(5));
        league = league.addClub(league,clubs.get(6));
        league = league.addClub(league,clubs.get(7));
        System.out.println("  All the clubs of league:"+league.getName()+" would be shown below:");
        for (int i=0;i<league.getClubs().size();i++){
            System.out.println("    "+league.getClubs().get(i).getName());
        }

        List<Player> players = new ArrayList<>();
        players.addAll(Player.dao.getPlayersByClubname(league.getClubs().get(0).getName()));
        System.out.println("\n");
        players.addAll(Player.dao.getPlayersByClubname(league.getClubs().get(1).getName()));
        System.out.println("\n");



        //add a fixture to the league (i.e. a match yet to be played);
        Match match = new Match("Newcastle","2015-11-13",league.getClubs().get(0),league.getClubs().get(1),players);
        League.dao.addMatch(match);

        System.out.println("  Match will happen in "+match.getPlace()+" at "+match.getTime());
        System.out.println("  "+match.getClubA().getName()+"  vs  "+match.getClubB().getName());
        System.out.println("  Create a match successfully!\n  These players would attend:");
        System.out.println("  Club            Name            role");
        for (int i=0;i<match.getPlayers().size();i++) {
            System.out.println("  " + match.getPlayers().get(i).getClubName() + "        " + match.getPlayers().get(i).getName()+"            "+match.getPlayers().get(i).getRole());
        }
        System.out.println("\n");




        //record a result in the league (i.e. add details to a match once it has been played);
        League.dao.recordResult(match);
        System.out.println("\n");




        //print out a league table;
        League.dao.printLeagueTable();
        System.out.println("\n");



        //find the top team in the league;
        League.dao.findTopTeam();
        System.out.println("\n");



        //find the top scorer (Golden Boot) in the league.
        League.dao.findTopScorer();
        System.out.println("\n");




        //find the goalkeeper
        GoalKeeper.dao.getGoalkeeper();
        System.out.println("\n");




        //Find the best goalkeeper in the league. At the end of the season the best goalkeeper is the one who has the most clean-sheets (i.e. matches in which the team concedes no goals).
        GoalKeeper.dao.getBestGoalKeeper();

    }
}
