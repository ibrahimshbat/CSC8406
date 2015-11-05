package YiweiJing;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 26/10/2015 16:22
 * This is my assessment
 * Project name is league
 */
public class MatchTest {
    public static void main(String[] args) throws Exception {
        String matchPlace = "London,Newcastle,Chelsea,Sunderland,Ireland,Scotland";
        String[] matchPlaces = matchPlace.split(",");
        Random random = new Random();

        List<Club> clubs = Club.dao.list();

        List<Player> players = new ArrayList<>();
        players.addAll(Player.dao.getPlayersByClubname(clubs.get(3).getName()));
        players.addAll(Player.dao.getPlayersByClubname(clubs.get(4).getName()));
        //create a match
        System.out.println("  Create a match");
        Match match = new Match(matchPlaces[1],"2015-11-30",clubs.get(3),clubs.get(4),players);
        Match.dao.create(match);
        System.out.println("  Create a match successfully!");
        System.out.println("  The match is " + match.getPlace() + " " + match.getTime() + " " + match.getClubA().getName() + " " + match.getClubB().getName());

        //get the list of the all matches
        List<Match> matches1 = Match.dao.list();

        //first test
        System.out.println("  The first of match is "+matches1.get(0).getPlace()+" "+matches1.get(0).getTime()+" "+matches1.get(0).getClubA().getName()+" "+matches1.get(0).getClubB().getName());

        //record which players played and how many goals each player scored
        Match.dao.recordPlayersAndScores(matches1.get(0));

        //get the final score (e.g. Sunderland 0 ? 1 Newcastle United);
        Match.dao.getFinalScore(matches1.get(0));

        //get the final result (e.g. Newcastle win).
        Match.dao.getFinalResult(matches1.get(0));



        //second test
        System.out.println("\n\n  The second of match is "+matches1.get(1).getPlace()+" "+matches1.get(1).getTime()+" "+matches1.get(1).getClubA().getName()+" "+matches1.get(1).getClubB().getName());

        //record which players played and how many goals each player scored
        Match.dao.recordPlayersAndScores(matches1.get(1));

        //get the final score (e.g. Sunderland 0 ? 1 Newcastle United);
        Match.dao.getFinalScore(matches1.get(1));

        //get the final result (e.g. Newcastle win).
        Match.dao.getFinalResult(matches1.get(1));

    }



}
