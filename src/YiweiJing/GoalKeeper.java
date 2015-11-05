package YiweiJing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 19/10/2015 09:51
 * This is my assessment
 * Project name is league
 */
public class GoalKeeper extends Player{
    public static final GoalKeeper dao = new GoalKeeper();
    /* Goals the goalkeeper has lost */
    Integer conceded;

    /**
     * Empty constructor.
     * Used for being invoked by external methods.
     * */
    public GoalKeeper(){}
    /**
     * constructor
     * @param name
     * @param birthdate
     * @param height
     * @param clubName
     * @param conceded
     * @param goal
     */
    public GoalKeeper(String name, String birthdate, int height, int goal, String clubName,Integer conceded) {
        super(name, birthdate, height, goal,clubName,"goalkeeper");
        this.conceded= conceded;
        this.role="goalkeeper";
    }

    /**
    * getter and setter
    * */
    public Integer getConceded() {
        return conceded;
    }

    public void setConceded(Integer conceded) {
        this.conceded = conceded;
    }

    /**
    * find the goalkeeper
    * */
    public void getGoalkeeper() throws Exception {
        List<Club> clubs = Club.dao.list();
        List<GoalKeeper> goalKeepers = new ArrayList<>();
        for (int i=0;i<clubs.size();i++){
            GoalKeeper goalKeeper = getGoalKeeperByClubname(clubs.get(i).getName());
            goalKeepers.add(goalKeeper);
        }
        System.out.println("      Clubname      Name      Conceded Goals");
        for (int i=0;i<goalKeepers.size();i++){
            GoalKeeper goalKeeper = goalKeepers.get(i);
            System.out.println("      "+goalKeeper.getClubName()+"      "+goalKeeper.getName()+"      "+goalKeeper.getConceded());
        }
    }

    /**
     *  Find the best goalkeeper in the league.
     *  At the end of the season the best goalkeeper is the one who has the most clean-sheets
     *  (i.e. matches in which the team concedes no goals).
     * */
    public void getBestGoalKeeper() throws Exception {
        List<Club> clubs = Club.dao.list();
        List<GoalKeeper> goalKeepers = new ArrayList<>();
        for (int i=0;i<clubs.size();i++){
            GoalKeeper goalKeeper = getGoalKeeperByClubname(clubs.get(i).getName());
            goalKeepers.add(goalKeeper);
        }
        System.out.println("      Best goal keeper in the league");
        System.out.println("      Clubname      Name      Conceded Goals");
        GoalKeeper best = goalKeepers.get(0);
        for (int i=1;i<goalKeepers.size();i++){
            GoalKeeper goalKeeper = goalKeepers.get(i);
            if (best.getConceded()>goalKeepers.get(i).getConceded()){
                best = goalKeepers.get(i);
            }
        }
        System.out.println("      "+best.getClubName()+"      "+best.getName()+"      "+best.getConceded());
    }

    /**
     * @param goalKeeper the goalKeeper to be updated
     * */
    public void modify(GoalKeeper goalKeeper) throws Exception {
        if(exists(goalKeeper.getName(),filepath)){
            create(goalKeeper.getName(),filepath);
        }
        File file = new File(filepath+"\\"+goalKeeper.getName()+ this.FILE_SUFFIX);
        String content = goalKeeper.getName()+","+goalKeeper.getBirthdate()+","+goalKeeper.getHeight()+","+goalKeeper.getConceded()+","+goalKeeper.getClubName()+","+goalKeeper.getRole();
        write(file,content);
        read(file);
    }

    /**
    * get the goal keeper by his club name
     * @param clubname  name of the club which the goal keeper belongs to
     * @return GoalKeeper Object
    * */
    public GoalKeeper getGoalKeeperByClubname(String clubname) throws Exception {
        List<Player> players = Player.dao.list();
        Player player = new Player();
        GoalKeeper goalKeeper = new GoalKeeper();
        for (int i=0;i<players.size();i++){
            player = players.get(i);
            if (player.getClubName().equals(clubname) && player.getRole().equals("goalkeeper")){
                 goalKeeper = get(this.filepath + "\\" + player.getName()+this.FILE_SUFFIX);
                break;
            }
        }
        return goalKeeper;
    }

    /**
     * get a GoalKeeper Object
     * @param filepath goal keeper file path
     * @return A GoalKeeper Object
     * */
    public GoalKeeper get(String filepath) throws Exception {
        File playerFile = new File(filepath);
        //content contains a string splitted by ","   name,birthdate,height,clubName
        String content = read(playerFile);
        String[] contents = content.split(",");
        String name = contents[0];
        String birthdate = contents[1];
        int height = Integer.parseInt(contents[2]);
        int goal = Integer.parseInt(contents[3]);
        String clubName = contents[4];
        Club club = Club.dao.exists(clubName);
        GoalKeeper goalKeeper = null;
        try {
            if (club!=null){
                goalKeeper = new GoalKeeper(name,birthdate,height,goal,clubName,goal);
            }else {
                throw new Exception("Club "+clubName+" not exists!");
            }
        }catch (Exception e){
            System.out.println("Error in returning a goldkeeper");
        }

        return goalKeeper;
    }
}
