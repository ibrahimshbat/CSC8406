package MadalinaJuganariu;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the main class
 * All the programm's methods will be called here
 * in order to demonstrate that the program has been tested
 * @author (Madalina Juganariu) 
 * @version (28/10/2015)
 */
public class Main {
    public static void main(String [] args)    {
        //Here there are defined all the clubs
        Club club1 = new Club("Tottenham");
        Club club = new Club("Arsenal");
        Club club2 = new Club("Swansea");
        Club club4 = new Club("Manchester United");
        //Variable to access the top team function
        Club club3 = new Club("top team");
        //Create the League and give it a name
        League league = new League("Premier League");
        //aux player that will be used to call the top scorer method
        Player player50 = new Player("", 0, 0, 0);
        //Define all the players
        Player player10 = new Player("Chris Massey", 170, 0, 23);
        Player player = new Player("Vlad Chiriches", 190, 0, 21);
        Player player1 = new Player("Alistair Carter", 172, 1, 23);
        Player player2 = new Player("Dan Williams", 166, 0, 25);
        Player player3 = new Player("Alan Iverson", 180, 1, 29);
        Player player4 = new Player("Alexis Sanchez", 190, 2, 26);
        Player player5 = new Player("Theo Walcott", 165, 1, 24);
        Player player6 = new Player("Leon Best", 168, 2, 21);
        Player player7 = new Player("Mesut Ozil", 180, 0, 22);
        Player player8 = new Player("Lionel Messi", 163, 5, 28);
        Player player9 = new Player("Cristiano Ronaldo", 175, 0, 27);
        Player player11 = new Player("Constantinos Samaras", 183, 0, 31);
        Player player12 = new Player("Bryan Dabo", 180, 2, 26);
        Player player13 = new Player("Filip Daems", 164, 0, 23);
        Player player14 = new Player("Jonas Damborg", 173, 1, 22);
        Player player15 = new Player("James Dalton", 182, 0, 29);
        Player player16 = new Player("Rob Earnshaw", 165, 0, 27);
        Player player17 = new Player("Brian Easton", 182, 1, 23);
        Player player18 = new Player("Thomas Ebner", 163, 0, 29);
        Player player19 = new Player("Fabian Eberle", 170, 0, 22);
        Player player20 = new Player("Fabio", 176, 0, 24);
        Player player21 = new Player("Fabrice", 164, 0, 29);
        Player player22 = new Player("Radamel Falcao", 175, 1, 29);
        Player player23 = new Player("Erik Falkenburg", 172, 0, 21);
        Player player24 = new Player("Verena Faisst", 163, 0, 26);
        Player player25 = new Player("Danny Gabbidon", 190, 0, 22);
        Player player26 = new Player("Gabi", 182, 0, 25);
        Player player27 = new Player("Gabriel Lima", 170, 0, 21);
        Player player28 = new Player("Milan Gajic", 167, 0, 23);
        Player player29 = new Player("Istvan Gal", 195, 0, 22);
        Player player30 = new Player("Justin Haber", 185, 0, 26);
        Player player31 = new Player("Sebastian Ianc", 174, 0, 21);
        Player player32 = new Player("Gomez Ibai", 178, 0, 29);
        Player player33 = new Player("Renato Ibarra", 169, 0, 24);
        Player player34 = new Player("Jon Jones", 192, 1, 26);
        Player player35 = new Player("Yoel Romero", 195, 0, 28);
        Player player36 = new Player("Dan Vicente", 174, 0, 29);
        Player player37 = new Player("Ibrahim Ozturk", 183, 0, 32);
        Player player38 = new Player("Stefan Maag", 182, 1, 31);
        Player player39 = new Player("Peter McDonald", 183, 0, 21);
        Player player40 = new Player("Scott Mackain", 191, 2, 30);
        //Define the goalkeepers
        Goalkeeper goalkeeper = new Goalkeeper(0,"Christian Abbiati", 181, 0, 35);
        Goalkeeper goalkeeper1 = new Goalkeeper(0,"Scott Bain", 180, 0, 20);
        Goalkeeper goalkeeper2 = new Goalkeeper(0,"Audrey Baldwin", 175, 0, 26);
        Goalkeeper goalkeeper3 = new Goalkeeper(0,"Karl Balzan", 183, 0, 21);
        //define the matches
        Match match1 = new Match("Wembley Stadium");
        Match match2 = new Match("Anfield");
        Match match3 = new Match("St James Park");
        Match match4 = new Match("Allianz Arena");
        Match match5 = new Match("Santiago Bernabeu");
        Match match6 = new Match("Stadium of light");
        //Add the players to the clubs
        club.addPlayer(player);
        club.addPlayer(player1);
        club.addPlayer(player2);
        club.addPlayer(player3);
        club.addPlayer(player10);
        club.addPlayer(player11);
        club.addPlayer(player12);
        club.addPlayer(player13);
        club.addPlayer(player14);
        club.addPlayer(player15);
        club.addPlayer(goalkeeper1);
        club1.addPlayer(player4);
        club1.addPlayer(player5);
        club1.addPlayer(player6);
        club1.addPlayer(player7);
        club1.addPlayer(player20);
        club1.addPlayer(player21);
        club1.addPlayer(player22);
        club1.addPlayer(player17);
        club1.addPlayer(player18);
        club1.addPlayer(player19);
        club1.addPlayer(goalkeeper);
        club2.addPlayer(player8);
        club2.addPlayer(player9);
        club2.addPlayer(player23);
        club2.addPlayer(player24);
        club2.addPlayer(player25);
        club2.addPlayer(player26);
        club2.addPlayer(player27);
        club2.addPlayer(player28);
        club2.addPlayer(player29);
        club2.addPlayer(player30);
        club2.addPlayer(goalkeeper2);
        club4.addPlayer(player31);
        club4.addPlayer(player32);
        club4.addPlayer(player33);
        club4.addPlayer(player34);
        club4.addPlayer(player35);
        club4.addPlayer(player36);
        club4.addPlayer(player37);
        club4.addPlayer(player38);
        club4.addPlayer(player39);
        club4.addPlayer(player40);
        club4.addPlayer(goalkeeper3);
        //Add Clubs to the matches
        match1.addClub(club1);
        match1.addClub(club2);
        match2.addClub(club);
        match2.addClub(club1);
        match3.addClub(club);
        match3.addClub(club2);
        match4.addClub(club1);
        match4.addClub(club4);
        match5.addClub(club2);
        match5.addClub(club4);
        match6.addClub(club);
        match6.addClub(club4);
        //Add clubs to the league
        league.addClub(club);
        league.addClub(club2);
        league.addClub(club1);
        league.addClub(club4);
        //Show fixtures for the league
        System.out.println("These are all the fixtures for" + " " + league.getLeagueName());
        league.leagueFixtures();
        //Show the results of the matches along with details about teams 
        System.out.println("These are the results in" + " " + league.getLeagueName());
        System.out.println("This match has been played at:" + " " + match1.matchPlace());
        System.out.println();
        match1.playMatches();
        System.out.println("This match has been played at:" + " " + match2.matchPlace());
        System.out.println();
        match2.playMatches();
        System.out.println("This match has been played at:" + " " + match3.matchPlace());
        System.out.println();
        match3.playMatches();
        System.out.println("This match has been played at:" + " " + match4.matchPlace());
        System.out.println();
        match4.playMatches();
        System.out.println("This match has been played at:" + " " + match5.matchPlace());
        System.out.println();
        match5.playMatches();
        System.out.println("This match has been played at:" + " " + match6.matchPlace());
        System.out.println();
        match6.playMatches();
        System.out.println();
        //show the league's top scorer
        player50 = league.findTopScorer();
        System.out.println("The top scorer in the league is:" + " " +player50.getName());
        System.out.println();
        //show the league's top team and its details
        club3 = league.findTopTeam();
        System.out.println("The top team in the league is" + " " +club3.getClubName()+ " " + "with" + " " + club3.getPoints() + " "+ "points");
        club3.averageAge();
        club3.averageHeight();
        System.out.println("The total goals scored tally of " + " " +club3.getClubName()+ " " + "is" + " " + club3.getGoalsScored());
        System.out.println();
        //print the league's table
       league.printLeagueTable();
    }
}