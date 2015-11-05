package YiweiJing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 19/10/2015 09:42
 * This is my assessment
 * Project name is league
 */
public class League extends Base{
    private String filepath = this.PROJECT_PATH + "\\database\\league";
    public static final League dao = new League();
    /* League has his own name */
    String name;//can not be the same, like league europa

    /* League has many clubs */
    List<Club> clubs;//can not be the same, like Newcastle United

    /* add a fixture to the league */
    List<Match> matches;//match yet to be played

    /**
    * Empty constructor.
     * Used for being invoked by external methods.
    * */
    public League(){};

    /**
     * constructor
     * create a league
     * */
    public League(String name) {
        this.name = name;
        this.clubs = new ArrayList<>();
        this.matches = new ArrayList<>();
    }


    /**
     * create a league
     * @param league A League Object to be created
     * */
    public void create(League league) throws Exception {
        if(exists(league.getName(),filepath)){
            create(league.getName(),filepath);
        }
        File file = new File(filepath+"\\"+league.getName()+this.FILE_SUFFIX);
        String content = league.getName();
        write(file,content);
        read(file);
        System.out.println("  Create a league successfully!");
        System.out.println("  League name ="+league.getName());
    }

    /**
    * set and get the name of the league
    * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }


    /**
    * add a club to the league
     * @param league A League Object to add a club
     * @param club A Club Object to be added
     * @return League Object
    * */
    public League addClub(League league,Club club){
        league.getClubs().add(club);
        return league;
    }

    /**
    * add a fixture to the league (i.e. a match yet to be played)
     * @param match A Match Object to be added to the league
    * */
    public void addMatch(Match match) throws Exception {
        Match.dao.create(match);
    }

    /**
     * record a result in the league (i.e. add details to a match once it has been played)
     * @param match A Match Object to be recorded the result
     * */
    public void recordResult(Match match) throws Exception {
        System.out.println("  Record result");
        match = Match.dao.modify(match);
        System.out.println("    list of players and each one scores");
        List<Player> players = match.getPlayers();
        for (int i=0;i<players.size();i++){
            if (players.get(i).getRole().equals("player")) {
                System.out.println("    "+players.get(i).getClubName() + ": " + players.get(i).getName() + " scored " + players.get(i).getMatchGoal() + " goal(s)");
            }
        }
    }

    /**
     * find the top team in the league
     * */
    public void findTopTeam() throws Exception {
        System.out.println("  Find top team");
        List<Club> clubs = Club.dao.list();
        Club club = clubs.get(0);
        for (int i=1;i<clubs.size();i++){
            if (club.getPoint()<clubs.get(i).getPoint()){
                club = clubs.get(i);
            }else if (club.getPoint()==clubs.get(i).getPoint()){
                if ( (club.getScoredGoal()-club.getConcededGoal()) < (clubs.get(i).getScoredGoal()-clubs.get(i).getConcededGoal())){
                    club = clubs.get(i);
                }
            }
        }
        System.out.println("  The top team in the league is "+club.getName()+" and it has "+club.getPoint()+" points and "+club.getScoredGoal()+" scored goals and "+club.getConcededGoal()+" conceded goals" );
    }

    /**
     * print out a league table
     * */
    public void printLeagueTable() throws Exception {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("print league table below");
        System.out.println("  Time                  Place                     ClubA                    ClubB");
        List<Match> matches = Match.dao.list();
        for (int i=0;i<matches.size();i++){
            Match match = matches.get(i);
            System.out.println("  "+match.getTime()+"           "+match.getPlace()+"             "+match.getClubA().getName()+"             "+match.getClubB().getName());
            Match.dao.modify(match);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
    * find the top scorer (Golden Boot) in the league
    * */
    public void findTopScorer() throws Exception {
        List<Player> players = Player.dao.list();
        Player player = players.get(0);
        for (int i=0;i<players.size();i++){
            if (player.getGoal()<=players.get(i).getGoal()){
                player = players.get(i);
            }
        }
        System.out.println("  The top scorer (Golden Boot) in the league is "+player.getName()+" and he has scored "+player.getGoal()+" goals and belongs to "+player.getClubName()+" and he is "+player.getHeight()+"cm high and his birthdate is "+player.getBirthdate() );
    }


    /**
     * @param league the league to be updated
     * */
    public void modify(League league) throws Exception {
        if(exists(league.getName(),filepath)){
            create(league.getName(),filepath);
        }
        File file = new File(filepath+"\\"+league.getName()+this.FILE_SUFFIX);
        String content = league.getName();
        System.out.println("name = "+league.getName());
        write(file,content);
        read(file);
    }

}
