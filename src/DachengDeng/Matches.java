package DachengDeng;

import java.util.*;
import java.io.*;

/**
 * This class is used for record and search matches among all clubs
 * 
 * @author Dacheng Deng
 * @version 2015.10.29
 */
public class Matches
{
    // instance variables - replace the example below with your own
    ArrayList<String> matchList = new ArrayList<String>();
    ArrayList<String> index = new ArrayList<String>();
    String club1;
    String club2; 
    String date;
    String league;
    String place;
    int score1;
    int score2;
    String code;
    IO file = new IO();
    
    /**
     * Constructor for objects of class Matches
     */
    public Matches() throws IOException 
    {
        // initialise instance variables
        score1=0;
        score2=0;
        initialization();
    }
    
    /**
     * initialize of class : read all matches' detail if the file exist, otherwise create a new file to record
     */
    public void initialization() throws IOException 
    {
        file.createFile("matchList.txt"); 
        file.readData("matchList.txt",matchList);
    }

    /**
     * Create a match;
     * Time format：year+month+day_hour.minutes eg.(2015-10-30 6.30)
     * @param time   time of the match
     * @param location   playing filed of the match
     * @param team1   first team of the match
     * @param team2   second team of the match
     * @throws IOException if wrong to input or output 
     */
    public void addMatch(String time,String location,String team1,String team2) throws IOException 
    {
        // put your code here
        code=location+time;
        System.out.println(code);
        boolean exist = false;
        for(int i=0;i<matchList.size();i++){
            if(code.equals(matchList.get(i))){
                System.out.println("Fail to create: Exist a match at the place and time");
                exist = true;
                break;
            }
        }if(!exist){
            file.writeData("matchList.txt",code);
            matchList.add(code);
            String matchFile = code+".txt";
            file.createFile(matchFile);
            String matchPlayers1 = code+team1+".txt";
            file.createFile(matchPlayers1);
            String matchPlayers2 = code+team2+".txt";
            file.createFile(matchPlayers2);
            String matchPlayers3 = code+team1+"score.txt";
            file.createFile(matchPlayers3);
            String matchPlayers4 = code+team2+"score.txt";
            file.createFile(matchPlayers4);
            //write match information to matchFile
            file.writeData(matchFile,time);
            file.writeData(matchFile,location);
            file.writeData(matchFile,team1);
            file.writeData(matchFile,team2);
            file.writeData(matchFile,"none");
            //Add players on each club of this match
            System.out.println("Please add players for " + team1);
            String name = "unknown";
            for(int count=1;!name.equals("0");count++){
                System.out.println("Input the name of player" + count+" (input [0] to add next club):");
                Scanner sc = new Scanner(System.in);
                name = sc.next();
                file.writeData(matchPlayers1,name);
                file.writeData(matchPlayers3,"0");
            }
            System.out.println("Please add players for " + team2);
            name = "unknown";
            for(int count=1;!name.equals("0");count++){
                System.out.println("Input the name of player" + count+" (input [0] to finish):");
                Scanner sc = new Scanner(System.in);
                name = sc.next();
                file.writeData(matchPlayers2,name);
                file.writeData(matchPlayers4,"0");
            }
        }
    }
    
    /**
     * Set the time of a match
     * @param place  previous filed of the match
     * @param time   time of the match
     * @param newtime new time of the match 
     * Format：year-month-day_hour.minutes eg.(2015-10-30 6.30)
     */
    public void setTime(String place,String time,String newtime)throws IOException 
    {
        String fileName=place+time;
        fileReader(fileName);
        file.delFile(fileName);
        fileRewrite(newtime,place,club1,club2,"none");
    }
    
    /**
     * Set the place of a match
     * @param place  previous filed of the match
     * @param time   time of the match
     * @param newplace new filed of the match 
     */
    public void setPlace(String place,String time,String newplace)throws IOException 
    {
        String fileName=place+time;
        fileReader(fileName);
        file.delFile(fileName);
        fileRewrite(time,newplace,club1,club2,"none");
       
    }
    
    /**
     * Record goals for each player scored
     * @param place  previous filed of the match
     * @param time   time of the match
     * @param club   the name of a club
     * @param player the name of a player
     * @param goal the goal of a player got in this match
     */
    public void addGoals(String place,String time,String club,String player,int goal)throws IOException 
    {
        Clubs clubs = new Clubs();
        clubs.addGoalsScored(club,goal);
        Players players1=new Players();
        players1.setGoalTally(player,goal);
        
        String players=place+time+club+".txt";
        String scores=place+time+club+"score.txt";
        
        index.clear();
        file.readData(players,index);
        int queal=index.indexOf(player); 
        file.rewrite(players,index,queal);
        
        index.clear();
        file.readData(scores,index);
        index.set(queal,String.valueOf(goal));
        file.rewrite(scores,index,queal);
    }
    
    /**
     * get all matches
     */
    public void getAllMatch() throws IOException
    {
         for(int i=0;i<matchList.size();i++){
            fileReader(matchList.get(i));
            System.out.println("");
            System.out.println(club1+"  VS  "+club2);
            System.out.println("Place: "+place);
            System.out.println("Time: "+date);
    }
    }
    
    /**
     * get the final score (e.g. Sunderland 0 – 1 Newcastle United)
     * @param place  previous filed of the match
     * @param time   time of the match
     */
    public void getFinalScore(String place,String time) throws IOException
    {
        String fileName=place+time;
        fileReader(fileName);
        String fileScores1=place+time+club1+"score.txt";
        String fileScores2=place+time+club2+"score.txt";
        score1=getTotalGoals(fileScores1);
        score2=getTotalGoals(fileScores2);
        System.out.println("");
        System.out.println(club1+" " +score1+"  -  "+score2+" "+club2);
        
    }
    
    /**
     * get the final result (e.g. Newcastle win)
     * @param place  previous filed of the match
     * @param time   time of the match
     */
    public void getResult(String place,String time) throws IOException
    {
        String fileName=place+time;
        fileReader(fileName);
        String fileScores1=place+time+club1+"score.txt";
        String fileScores2=place+time+club2+"score.txt";
        score1=getTotalGoals(fileScores1);
        score2=getTotalGoals(fileScores2);
        if(score1>score2){
        System.out.println(club1+" win!");
    }else if(score1<score2){
        System.out.println(club2+" win!");
    }else{
        System.out.println(club1+" Draw "+club2);
    }
    }
    
    /**
     * get the one club's goals totally
     * @param file  name of the club
     * @return s goals totally of the club
     */
    public int getTotalGoals(String file)throws IOException
    {
        int s=0;
        try{
             String path="D:"+File.separator+"blueJ"+File.separator+file;
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
             for (String line = br.readLine(); line != null; line = br.readLine()) {
                 s +=  Integer.parseInt(line);
                }
                br.close();
            }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }
    
    /**
     * Read single text document of one club
     * @param match  name of the club
     */
    public void fileReader(String match) throws IOException
    {
        index.clear();
        try{
             String path="D:"+File.separator+"blueJ"+File.separator+match+".txt";
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
             for (String line = br.readLine(); line != null; line = br.readLine()) {  
                    index.add(line);
                    }
                    date = index.get(0);
                    place = index.get(1);
                    club1 = index.get(2);
                    club2 = index.get(3);
                    league =index.get(4);
                    br.close();
            }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Rewrite single Text document of one match
     * @param time   time of the match
     * @param place   playing filed of the match
     * @param team1   first team of the match
     * @param team2   second team of the match
     * @param league   league of match if exist, otherwise input "none"
     */
    public void fileRewrite(String time,String place,String team1,String team2,String league)throws IOException
    {
        String fileName=place+time+".txt";
        file.createFile(fileName); 
        file.writeData(fileName,time);
        file.writeData(fileName,place);
        file.writeData(fileName,team1);
        file.writeData(fileName,team2);
        file.writeData(fileName,league);
    }
}
