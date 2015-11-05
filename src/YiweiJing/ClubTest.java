package YiweiJing;

import java.util.Random;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 24/10/2015 23:21
 * This is my assessment
 * Project name is league
 */
public class ClubTest {
    public static void main(String[] args) throws Exception {
        //Create a club
        System.out.println("  Create a club");
        String league = "England league";
        String playerName = "Ben";
        String clubName = "Bristol";

        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            String role = "player";
            if (i==0){
                role = "goalkeeper";
            }
            Player player = new Player(playerName + (i + 1), "19" + (70 + random.nextInt(30)) + "-01-" + (10 + random.nextInt(20)), 170 + (random.nextInt(50)), 0, clubName,role);
            Player.dao.modify(player);
        }
        Club club = new Club(clubName, 0, 0, 0,league );

        System.out.println("  Create club successfully!Club name="+club.getName());

        // add to the goals-scored tally of the club;
        System.out.println("\n  add to the goals-scored tally of the club");
        System.out.println("  before adding,the scored goals of club"+club.getName()+" is "+club.getScoredGoal()+"\n  now we will add 5 goals");
        club = Club.dao.addScoredTally(club,5);
        System.out.println("  after adding,the scored goals of club"+club.getName()+" is "+club.getScoredGoal());


        // add to the goals-conceded tally of the club;
        System.out.println("\n  add to the goals-conceded tally of the club");
        System.out.println("  before adding,the conceded goals of club"+club.getName()+" is "+club.getConcededGoal()+"\n  now we will add 3 goals");
        club = Club.dao.addConcededTally(club,3);
        System.out.println("  after adding,the conceded goals of club"+club.getName()+" is "+club.getConcededGoal());

        // get the goal difference of the club;
        System.out.println("\n  get the goal difference of the club");
        int difference = Club.dao.getDifference(club);
        System.out.println("  The difference of the club is "+difference);

        // add to the points tally of the club;
        System.out.println("\n  add to the points tally of the club");
        System.out.println("  before adding,the points of club"+club.getName()+" is "+club.getPoint()+"\n  now we will add 15 points");
        club = Club.dao.addPointsTally(club, 15);
        System.out.println("  after adding,the points of club"+club.getName()+" is "+club.getPoint());

        // get the points tally of the club;
        System.out.println("\n  get the tally points of the club");
        int points = Club.dao.getPointsTally(club);
        System.out.println("  The tally points of the club is "+points);


        // add a player to the squad of the club;
        System.out.println("\n  add a player to the squad of the club");
        Player player = new Player(playerName,"1987-09-23",188,0,club.getName(),"player");
        Player.dao.modify(player);
        Club.dao.addPlayer2Club(club,player);

        // find out whether a player is in the club's squad;
        System.out.println("\n  find out whether a player is in the club's squad");
        Club.dao.playerExistsInClub(club,player.getName());
        System.out.println("  Now we input some random characters to see if the find method works or not");
        Club.dao.playerExistsInClub(club,"xxssddff");

        // find the average age of the squad;
        System.out.println("\n  find the average age of the squad");
        int aveAge = Club.dao.getAverageAge(club.getName());
        System.out.println("  the average age of the squad = "+aveAge);

        // find the average height of the squad.
        System.out.println("\n  find the average height of the squad");
        int aveHeight = Club.dao.getAverageHeight(club.getName());
        System.out.println("  the average height of the squad = "+aveHeight);

    }
}
