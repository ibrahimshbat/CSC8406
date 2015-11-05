package YiweiJing;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 19/10/2015 09:12
 * This is my assessment
 * Project name is league
 */
public class Club extends Base{
    private String filepath = this.PROJECT_PATH + "\\database\\club";
    public static final Club dao = new Club();

    /* club has his own name */
    String name;//can not be the same, like Newcastle United

    /* club has his own concededGoal which means how many goals he lost */
    int concededGoal;//could be the same, like 12

    /* club has his own scoredGoal which means how many goals he scored */
    int scoredGoal;//could be the same, like 99

    /* club has his own point ,win 3;draw 1;lost 0 */
    int point;//could be the same, like 39

    /* which league does the club belong to */
    String league;//could be the same, like England League

    /**
     * constructor
     * create a club
     */
    public Club(String name, int concededGoal, int scoredGoal, int point, String league) {
        this.name = name;
        this.concededGoal = concededGoal;
        this.scoredGoal = scoredGoal;
        this.point = point;
        this.league = league;
    }

    /**
     * Empty constructor.
     * Used for being invoked by external methods.
     * */
    public Club(){}

    /**
    * set and get the name of the club
    * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConcededGoal() {
        return concededGoal;
    }

    public void setConcededGoal(int concededGoal) {
        this.concededGoal = concededGoal;
    }

    public int getScoredGoal() {
        return scoredGoal;
    }

    public void setScoredGoal(int scoredGoal) {
        this.scoredGoal = scoredGoal;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    /**
     * add to the goals-scored tally of the club
     * @param club a Club object to add scored goals tally
     * @param goals the scored goal
     * @return A Club Object
    * */
    public Club addScoredTally(Club club,int goals) throws Exception {
        club.setScoredGoal(club.getScoredGoal()+goals);
        Club.dao.modify(club);
        return club;
    }

    /**
     * add to the goals-conceded tally of the club
     * @param club A Club object to add conceded goals tally
     * @param goals the conceded goal
     * @return A Club Object
     * */
    public Club addConcededTally(Club club,int goals) throws Exception {
        club.setConcededGoal(club.getConcededGoal() + goals);
        Club.dao.modify(club);
        return club;
    }

    /**
    * get the goal difference of the club
     * @param club a Club object
     * @return difference : the difference of the club
    * */
    public int getDifference(Club club){
        int difference = club.getScoredGoal()-club.getConcededGoal();
        return difference;
    }

    /**
     * add to the points tally of the club
     * @param club a Club object to add points tally
     * @param points the points which should be add tally
     * @return A Club Object
     * */
    public Club addPointsTally(Club club,int points) throws Exception {
        club.setPoint(club.getPoint() + points);
        Club.dao.modify(club);
        return club;
    }

    /**
     * get the points tally of the club
     * @param club a Club object to get points
     * @return points:the points of the club
     * */
    public int getPointsTally(Club club){
        return club.getPoint();
    }

    /**
     * add a player to the squad of the club
     * @param club a Club Object to add a player
     * @param player a Player Object to be added
     * */
    public void addPlayer2Club(Club club,Player player) throws Exception {
        System.out.println("  add player "+player.getName()+" to club "+club.getName());
        player.setClub(club);
        Player.dao.modify(player);
    }

    /**
     * find out whether a player is in the club's squad
     * @param club a Club Object to judge if a player exists in the club
     * @param playerName a player name to be judged if he exists in the given club
     * */
    public void playerExistsInClub(Club club,String playerName) throws Exception {
        List<Player> players = Player.dao.list();
        Player player = Player.dao.getByName(players,playerName);
        if (player!=null){
            if (club.getName().equals(player.getClubName())){
                System.out.println("  Player "+playerName+" is in the club "+club.getName());
            }else {
                System.out.println("  Player "+playerName+" is not in the club "+club.getName()+" , but in the club "+player.getClubName());
            }
        }else {
            System.out.println("  Player "+playerName+" is not in the league!");
        }
    }

    /**
     * find the average age of the squad
     * @param clubName a club name to get the average age
     * @return average age of the club
     * */
    public int getAverageAge(String clubName) throws Exception {
        int sum = 0;
        int number = 0;
        List<Player> players = Player.dao.list();
        for (int i=0;i<players.size();i++){
            if (players.get(i).getClubName().equals(clubName.trim())){
                sum += date2age(players.get(i).getBirthdate());
                number++;
            }
        }
        return sum/number;
    }

    /**
     * find the average age of the height
     * @param clubName a club name to get the average height
     * @return average height of the club
     * */
    public int getAverageHeight(String clubName) throws Exception {
        int sum = 0;
        int number = 0;
        List<Player> players = Player.dao.list();
        for (int i=0;i<players.size();i++){
            if (players.get(i).getClubName().equals(clubName.trim())){
                sum += players.get(i).getHeight();
                number++;
            }
        }
        return sum/number;
    }

    /**
     * list all the clubs
     * @return the list of all clubs
     * */
    public List<Club> list() throws Exception {
        List<Club> clubs = new ArrayList<>();
        File folder = new File(filepath);
        File[] files = folder.listFiles();
        for (int i = 0 ; i<files.length ; i++){
            if (files[i].isFile()){
                clubs.add(i,get(filepath+"\\"+files[i].getName()));
            }
        }
        return clubs;
    }

    /**
    * @param club the club which needs to be updated
    * */
    public void modify(Club club) throws Exception {
        if(exists(club.getName(),filepath)){
            create(club.getName(),filepath);
        }
        File file = new File(filepath+"\\"+club.getName()+this.FILE_SUFFIX);
        String content = club.getName()+","+club.getConcededGoal()+","+club.getScoredGoal()+","+club.getPoint()+","+club.getLeague();
        write(file,content);
        read(file);
    }

    /**
    * judge if a club exists
     * @param clubName a club name to judge if a club exists
     * @return A Club Object
    * */
    public Club exists(String clubName) throws Exception {
        List<Club> clubs = list();
        Club club = null;
        for (int i = 0 ; i < clubs.size() ; i++){
            if (clubs.get(i).getName().equals(clubName.trim())){
                club = clubs.get(i);
                break;
            }
        }
        return club;
    }

    /**
     * get a Club Object
     * @param filepath the club file path
     * @return A Club Object
     * */
    public Club get(String filepath) throws Exception {
        File clubFile = new File(filepath);
        //content contains a string splitted by ","   name,concededGoal,scoredGoal,point
        String content = read(clubFile);
        String[] contents = content.split(",");
        String name = contents[0];
        int concededGoal = Integer.parseInt(contents[1]);
        int scoredGoal = Integer.parseInt(contents[2]);
        int point = Integer.parseInt(contents[3]);
        String league = contents[4];
        Club club = new Club(name,concededGoal,scoredGoal,point,league);
        return club;
    }

    /**
    * create club file
     * @param name a club name to create a club file
     * @param content club content
    * */
    public void createFile(String name,String content) throws IOException {
        File file = new File(filepath+"\\"+name+this.FILE_SUFFIX);
        create(name,filepath);
        write(file,content);
    }

    /**
    * @param clubs a list of clubs
     *@param clubName a club name to get
     *@return A Club Object
    * */
    public Club getByName(List<Club> clubs,String clubName){
        Club club =null;
        for (int i=0;i<clubs.size();i++){
            if (clubs.get(i).getName().equals(clubName.trim())){
                club = clubs.get(i);
            }
        }
        return club;
    }

    /**
    * @param birthdate a player birth date (like:2015-10-11)
     * @return the age of the player
    * */
    public int date2age(String birthdate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int now_year = Integer.parseInt(sdf.format(date));
        String[] dates = birthdate.split("-");
        int birth_year = Integer.parseInt(dates[0]);
        return now_year-birth_year;
    }
}
