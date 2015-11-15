package DachengDeng;

import java.util.*;
import java.io.*;

/**
 * This class is used for add, set and print leagues details. Meanwhile find the top team and scorer and so on
 * 
 * @author Dacheng Deng
 * @version 2015.10.29
 */
public class Leagues extends Matches
{
    // instance variables - replace the example below with your own
    private String name;
    ArrayList<String> leagueList = new ArrayList<String>();
    ArrayList<String> clubsOfLeague = new ArrayList<String>();
    ArrayList<Integer> scoresOfClub = new ArrayList<Integer>();
    ArrayList<Integer> scoresOfClub2 = new ArrayList<Integer>();
    IO file=new IO();
    
    /**
     * Constructor for objects of class Leagues
     * Read players data to ArrayLists if the file exist, otherwise create the file.
     */
    public Leagues()throws IOException 
    {
        // initialise instance variables
        file.createFile("leagueList.txt"); 
        file.readData("leagueList.txt",leagueList);
    }

    /**
     * Create a league
     * @param name   name of the league
     */
    public void addLeagues(String name)throws IOException 
    {
        
        this.name=name;
        boolean exit = false; 
        for(int i=0;i<leagueList.size();i++){
            if(name.equals(leagueList.get(i))){
                System.out.println("Existed the league of "+name);
                exit = true;
                break;
            }
        }if(!exit){
            file.writeData("leagueList.txt",name);
            leagueList.add(name);
            String fileName = name+".txt";
            file.createFile(fileName);
        }
    }
    
    /**
     * Get all leagues from local stored file
     */
    public void getName()throws IOException 
    {
        file.readData("leagueList.txt",leagueList);
        for(String league:leagueList){
            System.out.println(league);
        }
    }
    
    /**
     * add a club to a league
     * @param league   name of the league
     * @param club   name of the club
     */
    public void addClub(String league,String club)throws IOException
    {
        int num=0;
        file.readData("clubFile.txt",clubsOfLeague);
        String fileName = league+".txt";
        for(int i = 0;i<clubsOfLeague.size();i++){
            if(club.equals(clubsOfLeague.get(i))){
                num=1;
                break;
            }
        }
        if(num==0){
                System.out.println("No such club exists, Please add in advance");
                return;
            }
        file.readData(fileName,clubsOfLeague);
        for(int j = 0;j<clubsOfLeague.size();j++){
            if(club.equals(clubsOfLeague.get(j))){
                num=3;
                break;
            }
        }
        if(num==3){
            System.out.println("Added this club before!");
            return;
        }else{
                file.writeData(fileName,club);
            }
        }
 
    
    /**
     * Get all club of a league
     * @param league   name of the league
     */
    public void getClubs(String league)throws IOException
    {
        String leagueName = league +".txt";
        file.readData(leagueName,clubsOfLeague);
        for(String clubs:clubsOfLeague){
                    System.out.println(clubs);
                }
    }
    
    /**
     * add a fixture to the league
     * @param place   place of the match
     * @param time   time of the match
     * @param league   name of the league
     */
    public void addFixture(String place,String time,String league)throws IOException
    {
        String fileName = place+time;
        super.fileReader(fileName);
        fileName=fileName+".txt";
        file.delFile(fileName);
        fileRewrite(time,place,super.club1,super.club2,league);
    }
    
    /**
     * Record results in the league
     * @param league   name of the league
     */
    public void addResult(String league)throws IOException
    {
       ArrayList<String> matchList = new ArrayList<String>();
       file.readData("matchList.txt",matchList);
       for(String match : matchList){
           super.fileReader(match);
           if(super.league.equals(league)){
               super.getAllMatch();
            }
        }
    }
    
    /**
     * Find the top team in the league
     * @param lea   name of the league
     */
    public void topTeam(String lea)throws IOException
    {
       int top = 0;
       allGoalsOfClubs(lea);
       if(scoresOfClub.size()>1){
           for(int i = 0;i<scoresOfClub.size();i++){
               if(scoresOfClub.get(i)>scoresOfClub.get(i+1)){
                   top=i;
               }
            }
        }
       System.out.println("The top team on the " +lea+" is "+clubsOfLeague.get(top));
    }
    
    /**
     * get the goal scored totally of all clubs in a league
     * @param league   name of the league
     */
    public void allGoalsOfClubs(String league)throws IOException
    {
       ArrayList<String> matchList = new ArrayList<String>();
       file.readData("matchList.txt",matchList);
       String leaFile = league +".txt";
       file.readData(leaFile,clubsOfLeague);
       for(String match : matchList){
           super.fileReader(match);
           if(super.league.equals(league)){
                for(String clb : clubsOfLeague){
                   if(clb.equals(super.club1)){
                       int index= clubsOfLeague.indexOf(clb);
                       scoresOfClub.add(index);
                       int index2= clubsOfLeague.indexOf(super.club2);
                       scoresOfClub.set(index,(int)scoresOfClub.get(index)+super.score1);
                       scoresOfClub2.set(index,(int)scoresOfClub2.get(index2)+super.score1);
                    }
                }
                for(String clb : clubsOfLeague){
                   if(clb.equals(super.club2)){
                       int index= clubsOfLeague.indexOf(clb);
                       scoresOfClub.add(index);
                       int index2= clubsOfLeague.indexOf(super.club1);
                       scoresOfClub.set(index,(int)scoresOfClub.get(index)+super.score2);
                       scoresOfClub2.set(index,(int)scoresOfClub2.get(index2)+super.score2);
                    }
                }
            }
        }
    }
    
    /**
     * Print out a league table
     * @param league   name of the league
     */
    public void printTable(String league)throws IOException
    {
        System.out.println(league);
        allGoalsOfClubs(league);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Team\t\tgoals-scored tally\t\tgoals-conceded tally");
        for(int i=0;i<clubsOfLeague.size();i++){
            System.out.println(clubsOfLeague.get(i)+"\t\t"+scoresOfClub.get(i)+"\t\t"+scoresOfClub2.get(i));
        }
        System.out.println("---------------------------------------------------------------------");
    }
    
    /**
     * find the top scorer (Golden Boot) in the league
     * @param league   name of the league
     */
    public void topScorer(String league)throws IOException
    {
        int top=0;
        ArrayList<String> playerNames = new ArrayList<String>();
        ArrayList<String> playerGoals = new ArrayList<String>();
        file.readData("PlayersName.txt",playerNames);
        file.readData("PlayersGoal.txt",playerGoals);
        if(playerGoals.size()>1){
            for(int i = 0;i<playerGoals.size()-1;i++){
                if(Integer.parseInt(playerGoals.get(i))>Integer.parseInt(playerGoals.get(i+1))){
                    top=i;
                }
            }
        }
        System.out.println("The top scorer (Golden Boot) is "+playerNames.get(top));
    }
}
