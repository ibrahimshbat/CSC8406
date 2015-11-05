package YiweiJing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 19/10/2015 09:27
 * This is my assessment
 * Project name is league
 */
public class Match extends Base{
    private List<Match> matches;
    private String filepath = this.PROJECT_PATH + "\\database\\match";
    public static final Match dao = new Match();

    /* Match happens in a certain place */
    String place;//can not be the place, like Newcastle

    /* Match happens at a certain time */
    String time;// could be the same, like 2015-10-19

    /* Match has two clubs engaging like clubA */
    Club clubA;//could not be the same with the other in a match, like Newcastle

    /* Match has two clubs engaging like clubB */
    Club clubB;//could not be the same with the other in a match, like Manchester

    /* All players */
    List<Player> players;//could not be the same, like Player<Leon Best>,Player<Leon Worst>

    /**
     * Empty constructor.
     * Used for being invoked by external methods.
     * */
    public Match(){};

    /**
    * constructor
     * create a match
    * */
    public Match(String place, String time, Club clubA, Club clubB, List<Player> players) {
        this.place = place;
        this.time = time;
        this.clubA = clubA;
        this.clubB = clubB;
        this.players = players;
    }

    /**
     * create a match
     * @param match A Match Object to be created
     * */
    public void create(Match match) throws Exception {
        String filename = match.getPlace()+"_"+match.getTime();
        if(exists(filename,filepath)){
            create(filename, filepath);
        }
        File file = new File(filepath+"\\"+filename+this.FILE_SUFFIX);
        String playAndGoal = "";
        Random random = new Random();
        for (int i=0;i<match.getPlayers().size();i++){
            playAndGoal += match.getPlayers().get(i).getName()+":"+0;
            if (i!=match.getPlayers().size()-1){
                playAndGoal += ";";
            }
        }
        String content = match.getPlace()+","+match.getTime()+","+match.getClubA().getName()+","+match.getClubB().getName()+","+playAndGoal;
        write(file, content);
        read(file);
    }

    /**
    * set and get the time and place of the match
    * */
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * set and get the clubs playing in the match;
    * */

    public Club getClubA() {
        return clubA;
    }

    public void setClubA(Club clubA) {
        this.clubA = clubA;
    }

    public Club getClubB() {
        return clubB;
    }

    public void setClubB(Club clubB) {
        this.clubB = clubB;
    }

    /**
    * record which players played and how many goals each player scored
     * @param match A Match Object to record the scores by each player
    * */
    public void recordPlayersAndScores(Match match) throws Exception {
        System.out.println("\n  list of players and each one scores");
        List<Player> players = match.getPlayers();
        match = get(filepath+"\\"+match.getPlace()+"_"+match.getTime()+this.FILE_SUFFIX);
        for (int i=0;i<players.size();i++){
            System.out.println("  "+players.get(i).getClubName()+": "+players.get(i).getName()+" scored "+players.get(i).getMatchGoal()+" goal(s)");
        }
    }


    /**
     * get the final score (e.g. Sunderland 0 ? 1 Newcastle United)
     * @param match A Match Object to get the final score
     * */
    public void getFinalScore(Match match){
        int clubAGoals = eachClubGoal(match.players, match.getClubA().getName());
        int clubBGoals = eachClubGoal(match.players, match.getClubB().getName());
        System.out.println("\n  "+match.clubA.getName()+" "+clubAGoals+" - "+clubBGoals+" "+match.clubB.getName());
    }

    /**
     * get the final result (e.g. Newcastle win).
     * @param match A Match Object to get the final result
     * */
    public void getFinalResult(Match match){
        int clubAGoals = eachClubGoal(match.players, match.getClubA().getName());
        int clubBGoals = eachClubGoal(match.players,match.getClubB().getName());
        if (clubAGoals>clubBGoals){
            System.out.println("\n  "+match.clubA.getName()+" win");
        }else if (clubAGoals<clubBGoals){
            System.out.println("\n  "+match.clubB.getName()+" win");
        }else {
            System.out.println("\n  "+"Draw!");
        }
    }

    /**
     * list all the matches
     * @return the list of all matches
     * */
    public List<Match> list() throws Exception {
        this.matches = new ArrayList<>();
        File folder = new File(filepath);
        File[] files = folder.listFiles();
        for (int i = 0 ; i<files.length ; i++){
            if (files[i].isFile()){
                matches.add(i,get(filepath+"\\"+files[i].getName()));
            }
        }
        return matches;
    }

    /**
     * @param match the match to be updated
     * */
    public Match modify(Match match) throws Exception {
        String filename = match.getPlace()+"_"+match.getTime();
        if(exists(filename,filepath)){
            create(filename, filepath);
        }
        File file = new File(filepath+"\\"+filename+this.FILE_SUFFIX);
        String playAndGoal = "";
        Random random = new Random();
        Club clubA = match.getClubA();
        Club clubB = match.getClubB();
        Integer scoreA = 0;
        Integer scoreB = 0;
        for (int i=0;i<match.getPlayers().size();i++){
            int goal = (1+random.nextInt(20))/20;
            playAndGoal += match.getPlayers().get(i).getName()+":"+goal;
            if (i!=match.getPlayers().size()-1){
                playAndGoal += ";";
            }
            match.getPlayers().get(i).setMatchGoal(goal);

            Player player = Player.dao.getByName(match.getPlayers(), match.getPlayers().get(i).getName());
            if (player.getRole().equals("player")) {
                player.setGoal(player.getGoal() + goal);
                Player.dao.modify(player);
                if (player.getClubName().equals(clubA.getName())) {
                    scoreA += goal;
                } else if (player.getClubName().equals(clubB.getName())) {
                    scoreB += goal;
                }
            }
        }
        clubA.setScoredGoal(clubA.getScoredGoal()+scoreA);
        clubA.setConcededGoal(clubA.getConcededGoal()+scoreB);
        GoalKeeper clubAGoalKeeper = GoalKeeper.dao.getGoalKeeperByClubname(clubA.getName());
        clubAGoalKeeper.setConceded(clubAGoalKeeper.getConceded()+scoreB);
        GoalKeeper.dao.modify(clubAGoalKeeper);

        clubB.setScoredGoal(clubB.getScoredGoal()+scoreB);
        clubB.setConcededGoal(clubB.getConcededGoal()+scoreA);
        GoalKeeper clubBGoalKeeper = GoalKeeper.dao.getGoalKeeperByClubname(clubB.getName());
        clubBGoalKeeper.setConceded(clubBGoalKeeper.getConceded()+scoreA);
        GoalKeeper.dao.modify(clubBGoalKeeper);


        if (scoreA>scoreB){
            clubA.setPoint(clubA.getPoint()+3);
        }else if (scoreA<scoreB){
            clubB.setPoint(clubB.getPoint()+3);
        }else if (scoreA==scoreB){
            clubA.setPoint(clubA.getPoint()+1);
            clubB.setPoint(clubB.getPoint()+1);
        }
        Club.dao.modify(clubA);
        Club.dao.modify(clubB);
        String content = match.getPlace()+","+match.getTime()+","+match.getClubA().getName()+","+match.getClubB().getName()+","+playAndGoal;
        write(file,content);
        read(file);
        return match;
    }

    /**
     * get a Match Object
     * @param filepath the Match Object file path
     * @return A Match Object
     * */
    public Match get(String filepath) throws Exception {
        File matchFile = new File(filepath);
        //content contains a string splitted by ","   name,concededGoal,scoredGoal,point
        String content = read(matchFile);
        String[] contents = content.split(",");
        String place = contents[0];
        String time = contents[1];
        String clubA_Name = contents[2];
        String clubB_Name = contents[3];
        String playerList = contents[4];
        List<Club> clubs = Club.dao.list();

        Club clubA = Club.dao.getByName(clubs,clubA_Name);
        Club clubB = Club.dao.getByName(clubs,clubB_Name);
        List<Player> players = eachPlayerGoal(playerList);
        Match match = new Match();
        match.setClubA(clubA);
        match.setClubB(clubB);
        match.setPlace(place);
        match.setTime(time);
        match.setPlayers(players);
        return match;
    }

    /**
     * set the goals which players have scored in the match
    * @param content each player's scored goals(like:  name:score )
     * @return the list of all players
    * */
    public List<Player> eachPlayerGoal(String content) throws Exception {
        String[] contents = content.split(";");//contents[i]= name:score
        List<Player> players = new ArrayList<>();
        List<Player> allPlayers = Player.dao.list();
        for (int i=0;i<contents.length;i++){
            String[] playerInfo = contents[i].split(":");
            String playerName = playerInfo[0];
            Integer scores = Integer.valueOf(playerInfo[1]);
            Player player = Player.dao.getByName(allPlayers,playerName);
            player.setMatchGoal(scores);
            players.add(player);
        }
        return players;
    }

    /**
     * get the total goals of a club by club name
    * @param players All the players
     * @param clubName A Club Object name
     * @return each player's scored goals
    * */
    public int eachClubGoal(List<Player> players,String clubName){
        int goals = 0;
        for (int i=0;i<players.size();i++){
            if (players.get(i).getClubName().equals(clubName)){
                goals += players.get(i).getMatchGoal();
            }
        }
        return goals;
    }

}
