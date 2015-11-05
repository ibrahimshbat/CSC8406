package YiweiJing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 19/10/2015 09:12
 * This is my assessment
 * Project name is league
 */
public class Player extends Base{
    private List<Player> players;
    public static final Player dao = new Player();
    protected String filepath = this.PROJECT_PATH + "\\database\\player";

    /* player has his own name */
    String name;//can not be the same, like John

    /* player has his own role */
    String role;// a player is a goalkeepper or just a player

    /* player has his own birthdate */
    String birthdate;// could be the same, like 2015-10-19

    /* player has his own height */
    Integer height;//could be the same, like 180   (cm)

    /* player has his own total goal */
    Integer goal;

    /* player has his own goal in one match */
    Integer matchGoal;

    /* player has his own clubName */
    String clubName;

    /* player belongs to a club */
    Club club;



    /**
    * constructor
     * create a player
    * */
    public Player(String name,String birthdate,int height,int goal,String clubName,String role){
        this.name = name;
        this.birthdate = birthdate;
        this.height = height;
        this.goal = goal;
        this.clubName = clubName;
        this.role = role;
    }

    /**
     * Empty constructor.
     * Used for being invoked by external methods.
     * */
    public Player(){

    }


    /**
    * set and get the name, date of birth and height of the player
    * */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Integer getMatchGoal() {
        return matchGoal;
    }

    public void setMatchGoal(Integer matchGoal) {
        this.matchGoal = matchGoal;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    /**
     * add to the goal tally of a player
     * */
    public Player addGoalTally(Player player,int goals) throws Exception {
        player.setGoal(player.getGoal()+goals);
        Player.dao.modify(player);
        return player;
    }


    /**
     * get the goal tally of a player
     * */
    public int getGoalTally(Player player){
        return player.getGoal();
    }

    /**
     * list all the clubs
     * @return the list of all players
     * */
    public List<Player> list() throws Exception {
        this.players = new ArrayList<>();
        File folder = new File(filepath);
        File[] files = folder.listFiles();
        for (int i = 0 ; i<files.length ; i++){
            if (files[i].isFile()){
                players.add(i,get(filepath+"\\"+files[i].getName()));
            }
        }
        return players;
    }

    /**
     * @param player the player to be updated
     * */
    public void modify(Player player) throws Exception {
        if(exists(player.getName(),filepath)){
            create(player.getName(),filepath);
        }
        File file = new File(filepath+"\\"+player.getName()+this.FILE_SUFFIX);
        String content = player.getName()+","+player.getBirthdate()+","+player.getHeight()+","+player.getGoal()+","+player.getClubName()+","+player.getRole();
        write(file,content);
        read(file);
    }



    /**
     * get a Player Object
     * @param filepath the player file path
     * @return A Player Object
     * */
    public Player get(String filepath) throws Exception {
        File playerFile = new File(filepath);
        //content contains a string splitted by ","   name,birthdate,height,clubName
        String content = read(playerFile);
//        System.out.println(filepath+"'s content="+content);
        String[] contents = content.split(",");
        String name = contents[0];
        String birthdate = contents[1];
        int height = Integer.parseInt(contents[2]);
        int goal = Integer.parseInt(contents[3]);
        String clubName = contents[4];
        String role = contents[5];
//        System.out.println("name="+name+",birthdate="+birthdate+",height="+height+",clubName="+clubName+",role="+role);
        Club club = Club.dao.exists(clubName);
        Player player = null;
        try {
            if (club!=null){
                player = new Player(name,birthdate,height,goal,clubName,role);
            }else {
                throw new Exception("Club "+clubName+" not exists!");
            }
        }catch (Exception e){
            System.out.println("Error in returning a player");
        }

        return player;
    }

    /**
    * @param name a player's name to be searched in all players
     * @param players a list of players
     * @return A Player Object
    * */
    public Player getByName(List<Player> players,String name){
        Player player =null;
        for (int i=0;i<players.size();i++){
            if (players.get(i).getName().equals(name.trim())){
                player = players.get(i);
            }
        }
        return player;
    }

    /**
    * @param clubName a clubname to get all players
     *@return a list of players who belong to the club
    * */
    public List<Player> getPlayersByClubname(String clubName) throws Exception {
        List<Player> allPlayers = Player.dao.list();
        List<Player> neededPlayers = new ArrayList<>();
        int counter = 0;
        for (int i=0;i<allPlayers.size();i++){
            if (allPlayers.get(i).getClubName().equals(clubName) && allPlayers.get(i).getRole().equals("goalkeeper")){
                neededPlayers.add(allPlayers.get(i));
                break;
            }
        }
        for (int i=0;i<allPlayers.size();i++){
            if (allPlayers.get(i).getClubName().equals(clubName) && allPlayers.get(i).getRole().equals("player")){
                neededPlayers.add(allPlayers.get(i));
                counter +=1;
            }
            if (counter==11){
                break;
            }
        }
        return neededPlayers;
    }

}
