package DachengDeng;

import java.util.*;
import java.io.*;

/**
 * This class is used for set all clubs information and get all details of a club
 * 
 * @author Dacheng Deng
 * @version 2015.10.29
 */
public class Clubs
{
    ArrayList<String> clubList = new ArrayList<String>();
    ArrayList<String> socres = new ArrayList<String>();
    private String name;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    IO file = new IO();
    
    /**
     * Initialize clubs class
     */
    public Clubs() throws IOException 
    {
        // initialise instance variables
        goalsScored = 0;
        goalsConceded = 0;
        points = 0;
        initialization();
    }
    
    /**
     * try to read all clubs information if the files exist, otherwise create the file
     */
    public void initialization() throws IOException 
    {
        file.createFile("clubFile.txt"); 
        file.readData("clubFile.txt",clubList);
    }
    
    /**
     * create a club
     * @param newName   name of club
     */
    public void addClub(String newName) throws IOException
    {
        boolean exit = false;
        for(int i=0;i<clubList.size();i++){
            if(newName.equals(clubList.get(i))){
                System.out.println("Existed the club named "+newName);
                exit = true;
                break;
            }
        }if(!exit){
            file.writeData("clubFile.txt",newName);
            clubList.add(newName);
            String clubFile = newName+".txt";
            file.createFile(clubFile);
            file.writeData(clubFile,"0");
            file.writeData(clubFile,"0");
            file.writeData(clubFile,"0");
        }
    }
    
    /**
     * get information of all clubs
     */
    public void getAllClubs()throws IOException
    {
        for(int i=0;i<clubList.size();i++){
            fileReader(clubList.get(i));
            System.out.println("\r\nClub: "+clubList.get(i));
            System.out.println("goalsScored: "+goalsScored);
            System.out.println("goalsConceded: "+goalsConceded);
            System.out.println("points: "+points);
            System.out.println("");  
    }
    }
    
    /**
     * add the goals scored of the club
     * @param name   name of club
     * @param goal   goal scored of club
     */
    public void addGoalsScored(String name,int goal)throws IOException
    {
        // put your code here
        fileReader(name);
        goalsScored += goal;
        fileRewrite(name,goalsScored,goalsConceded,points);
        System.out.println("Club: "+name);
        System.out.println("newest goalsScored: "+goalsScored);
    }
    
    /**
     * add the goals-conceded tally of the club
     * @param name   name of club
     * @param goal   goal conceded of club
     */
    public void addGoalsConceded(String name,int goal)throws IOException
    {
        // put your code here
        fileReader(name);
        goalsConceded += goal;
        fileRewrite(name,goalsScored,goalsConceded,points);
        System.out.println("Club: "+name);
        System.out.println("newest goalsConceded: "+goalsConceded);
    }
    
    /**
     * get the goal difference of the club
     * @param name   name of club
     * @return diff     the goal difference of the club
     */
    public int getGoalDiff(String name)throws IOException
    {
        // put your code here
        int diff;
        fileReader(name);
        diff = goalsScored - goalsConceded;
        return diff;
    }
    

    /**
     * Get the points tally of the club
     * @param name   name of club
     * @return points     the goal difference of the club
     */
    public int getPoints(String name)throws IOException
    {
        // put your code here
        fileReader(name);
        return points;
    }

    /**
     * add to the points tally of the club;
     * @param name   name of club
     * @param points   points of club
     */
    public void addPoints(String name,int points)throws IOException
    {
        // put your code 
        fileReader(name);
        this.points += points;
        fileRewrite(name,goalsScored,goalsConceded,this.points);
        System.out.println("Newest points: "+this.points);
    }
    
    /**
     * List all players in the club
     * @param clubName   name of club
     */
    public void listAllPlayers(String clubName) throws IOException
    {
        Players player= new Players();
        player.getPlayersInClub(clubName);
    }
    
    /**
     * Find the average age of the squad;
     * @param clubName   name of club
     */
    public void avgAge(String clubName) throws IOException
    {
        Players player= new Players();
        int avg = player.getPlayersAge(clubName);
        System.out.println("Average age of the squad of"+clubName+" is: "+avg);
    }
    
    /**
     * Find the average height of the squad;
     * @param clubName   name of club
     */
    public void avgHeight(String clubName) throws IOException
    {
        Players player= new Players();
        float avg = player.getPlayersHeight(clubName);
        System.out.println("Average height of the squad of "+clubName+" is: "+avg);
    }
    
    /**
     * Read single Text document of one club
     * @param club   name of club
     */
    public void fileReader(String club) throws IOException
    {
        socres.clear();
        try{
             String path="D:"+File.separator+"blueJ"+File.separator+club+".txt";
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
             for (String line = br.readLine(); line != null; line = br.readLine()) {
                     socres.add(line);
                    }
                    goalsScored = Integer.parseInt(socres.get(0));
                    goalsConceded = Integer.parseInt(socres.get(1));
                    points = Integer.parseInt(socres.get(2));
                    br.close();
            }catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
    }
    
    /**
     * Rewrite single Text document of one club
     * @param clubfile   name of club
     * @param gs   goals scored of club
     * @param gc   goals conceded of club
     * @param pnt  points of club
     */
    public void fileRewrite(String clubfile,int gs,int gc,int pnt)throws IOException
    {
        String fileName=clubfile+".txt";
        file.delFile(fileName);
        file.createFile(fileName); 
        file.writeData(fileName,String.valueOf(gs));
        file.writeData(fileName,String.valueOf(gc));
        file.writeData(fileName,String.valueOf(pnt));
    }
}
