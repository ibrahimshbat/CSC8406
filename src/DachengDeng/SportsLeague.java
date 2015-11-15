package DachengDeng;

import java.util.*;
import java.io.*;
/**
 * Write a description of class Players here.
 * 
 * @author Dacheng Deng
 * @version 2015.10.29
 */
public class SportsLeague
{
    // instance variables - replace the example below with your own
    
    public static void main() 
    {
        SportsLeague sport = new SportsLeague();
        sport.printWelcome();
    }
    
    /**
     * Constructor for objects of class SportsLeague
     */
    public SportsLeague()
    {
        
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the Sports League System.");
        System.out.println(); 
        System.out.println("Please input number[0-4] to continue:");
        System.out.println("1 - Players");
        System.out.println("2 - Clubs");
        System.out.println("3 - Matches");
        System.out.println("4 - Leagues");
        System.out.println("0 - Exit");
        try{
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            while(a>4 || a<0){
            System.out.println("Illegal inputï¼�");
            a = input.nextInt();
            }
            switch(a){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    playersCall();
                    break;
                case 2:
                    clubsCall();
                    break;
                case 3:
                    matchesCall();
                    break;
                case 4:
                    leaguesCall();
                    break;
                default:
                    break;
            }
        }catch(Exception e){
                System.out.println("Illegal inputï¼�");
                printWelcome();
            }
    }
    
    /**
     *Call Players class
     */
    private void playersCall()throws IOException
    {
        Players player = new Players();
        System.out.println("Please input number to continue:");
        System.out.println("1 - Create a player");
        System.out.println("2 - Remove a player");
        System.out.println("3 - Search a player");
        System.out.println("4 - Change a player's club");
        System.out.println("5 - Get all players of a club");
        System.out.println("6 - Add a player's goal number");
        System.out.println("0 - Return main");
        try{
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            while(a>6 || a<0){
            System.out.println("Wrong input!");
            a = input.nextInt();
            }
            switch(a){
                case 0:
                    printWelcome();
                    break;
                case 1:
                    System.out.println("Please input player's name:");
                    String name = input.next();
                    System.out.println("Please input "+name+"'s birth(i.e.19910101):");
                    String birth = input.next();
                    System.out.println("Please input "+name+"'s height:");
                    int height = input.nextInt();
                    System.out.println("Please input "+name+"'s position:");
                    String position = input.next();
                    System.out.println("Please input "+name+"'s goal tally:");
                    int goal = input.nextInt();
                    player.addPlayer(name,birth,height,position,goal);
                    System.out.println("Added successfully");
                    break;
                case 2:
                    System.out.println("Please input the player's name:");
                    name = input.next();
                    player.delPlayer(name);
                    break;
                case 3:
                    System.out.println("Please input the player's name:");
                    name = input.next();
                    player.getPlayer(name);
                    break;
                case 4:
                    System.out.println("Please input the player's name:");
                    name = input.next();
                    System.out.println("Please input "+name+"'s new club name:");
                    String squad = input.next();
                    player.setSquad(name,squad);
                    break;
                case 5:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    player.getPlayersInClub(name);
                    break;
                case 6:
                    System.out.println("Please input the player's name:");
                    name = input.next();
                    System.out.println("Please input goals :");
                    goal = input.nextInt();
                    player.setGoalTally(name,goal);
                    break;
                default:
                    break;
            }
            playersCall();
        }catch(Exception e){
                System.out.println("Wrong input!");
                printWelcome();
            }
        
    }

    /**
     * Call Clubs class
     */
    private void clubsCall()throws IOException
    {
        Clubs clubs = new Clubs();
        int goal=0;
        System.out.println("Please input number to continue:");
        System.out.println("1 - Create a club");
        System.out.println("2 - Get all clubs");
        System.out.println("3 - Add new goals scored to a club");
        System.out.println("4 - Get the goal difference of a club");
        System.out.println("5 - Get the points tally of a club");
        System.out.println("6 - Add the points tally of a club");
        System.out.println("7 - Get all players in a club");
        System.out.println("8 - Get the average age of the squad");
        System.out.println("9 - Get the average height of the squad");
        System.out.println("0 - Return main");
        try{
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            while(a>9 || a<0){
            System.out.println("Wrong input!");
            a = input.nextInt();
            }
            switch(a){
                case 0:
                    printWelcome();
                    break;
                case 1:
                    System.out.println("Please input the club's name:");
                    String name = input.next();
                    clubs.addClub(name);
                    break;
                case 2:
                    clubs.getAllClubs();
                    break;
                case 3:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    System.out.println("Please input new goals scored of the club:");
                    goal = input.nextInt();
                    clubs.addGoalsScored(name,goal);
                    break;
                case 4:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    goal = clubs.getGoalDiff(name);
                    System.out.println("the goal difference of "+name+" is: "+goal);
                    break;
                case 5:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    goal=clubs.getPoints(name);
                    System.out.println("the goal difference of "+name+" is: "+goal);
                    break;
                case 6:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    System.out.println("Please input points:");
                    int points = input.nextInt();
                    clubs.addPoints(name,points);
                    break;
                case 7:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    clubs.listAllPlayers(name);
                    break;
                case 8:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    clubs.avgAge(name);
                    break;
                case 9:
                    System.out.println("Please input the club's name:");
                    name = input.next();
                    clubs.avgHeight(name);
                    break;
                default:
                    break;
            }
            clubsCall();
        }catch(Exception e){
                System.out.println("Wrong input!");
                printWelcome();
            }
    }
    
    /**
     * Call Matches class
     */
    private void matchesCall()throws IOException
    {
        Matches matches = new Matches();
        System.out.println("Please input number to continue:");
        System.out.println("1 - Create a match");
        System.out.println("2 - Change the time of the match");
        System.out.println("3 - Change the place of the match");
        System.out.println("4 - Add a player's goals scored in one match ");
        System.out.println("5 - Print all matches");
        System.out.println("6 - Get the final score ");
        System.out.println("7 - Get the final result");
        System.out.println("0 - Return main");
        try{
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            while(a>7 || a<0){
            System.out.println("Wrong input!");
            a = input.nextInt();
            }
            switch(a){
                case 0:
                    printWelcome();
                    break;
                case 1:
                    System.out.println("Please input the name of first team:");
                    String team1 = input.next();
                    System.out.println("Please input the name of second team:");
                    String team2 = input.next();
                    System.out.println("Please input time of this match eg.(2015-10-30 6.30):");
                    String time = input.next();
                    System.out.println("Please input field of the match:");
                    String location = input.next();
                    matches.addMatch(time,location,team1,team2);
                    System.out.println("Added successfully");
                    break;
                case 2:
                    System.out.println("Please input field of the match:");
                    location = input.next();
                    System.out.println("Please input privious time of this match eg.(2015-10-30 6.30):");
                    time = input.next();
                    System.out.println("Please input new time of this match:");
                    String time2 = input.next();
                    matches.setTime(location,time,time2);
                    break;
                case 3:
                    System.out.println("Please input field of the match:");
                    location = input.next();
                    System.out.println("Please input privious time of this match eg.(2015-10-30 6.30):");
                    time = input.next();
                    System.out.println("Please input new place of this match:");
                    time2 = input.next();
                    matches.setPlace(location,time,time2);
                    break;
                case 4:
                    System.out.println("Please input place of the match:");
                    location = input.next();
                    System.out.println("Please input privious time of this match eg.(2015-10-30 6.30):");
                    time = input.next();
                    System.out.println("Please input field of player's club:");
                    String club = input.next();
                    System.out.println("Please input name of player:");
                    String player = input.next();
                    System.out.println("Please input goals scored:");
                    int goal = input.nextInt();
                    matches.addGoals(location,time,club,player,goal);
                    break;
                case 5:
                    matches.getAllMatch();
                    break;
                case 6:
                    System.out.println("Please input place of the match:");
                    location = input.next();
                    System.out.println("Please input privious time of this match eg.(2015-10-30 6.30):");
                    time = input.next();
                    matches.getFinalScore(location,time);
                    break;
                case 7:
                    System.out.println("Please input place of the match:");
                    location = input.next();
                    System.out.println("Please input privious time of this match eg.(2015-10-30 6.30):");
                    time = input.next();
                    matches.getResult(location,time);
                    break;
                default:
                    break;
            }
            matchesCall();
        }catch(Exception e){
                System.out.println("Wrong input!");
                printWelcome();
            }
    }

    /**
     * Call Leagues class
     */
    private void leaguesCall()throws IOException
    {
        Leagues leagues = new Leagues();
        System.out.println("Please input number to continue:");
        System.out.println("1 - Create a league");
        System.out.println("2 - Print all existed leagues");
        System.out.println("3 - Add a club to a league");
        System.out.println("4 - Get all club of a league");
        System.out.println("5 - Add a fixture to a league");
        System.out.println("6 - Record results in a league");
        System.out.println("7 - Print the topTeam");
        System.out.println("8 - Print out the top topScorer");
        System.out.println("9 - Print out a league table");
        System.out.println("0 - Return");
        try{
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            while(a>4 || a<0){
            System.out.println("Wrong input!");
            a = input.nextInt();
            }
            switch(a){
                case 0:
                    printWelcome(); 
                    break;
                case 1:
                    System.out.println("Please input name of the league:");
                    String name = input.next();
                    leagues.addLeagues(name);
                    break;
                case 2:
                    leagues.getName();
                    break;
                case 3:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    System.out.println("Please input name of the club:");
                    String club = input.next();
                    leagues.addClub(name,club);
                    break;
                case 4:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    leagues.getClubs(name);
                    break;
                case 5:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    System.out.println("Please input place of the fixture:");
                    String place = input.next();
                    System.out.println("Please input time of the fixture:");
                    String time = input.next();
                    leagues.addFixture(place,time,name);
                    break;
                case 6:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    leagues.addResult(name);
                    break;
                case 7:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    leagues.topTeam(name);
                    break;
                case 8:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    leagues.topScorer(name);
                    break;
                case 9:
                    System.out.println("Please input name of the league:");
                    name = input.next();
                    leagues.printTable(name);
                    break;
                default:
                    break;
            }
            leaguesCall();
        }catch(Exception e){
                System.out.println("Wrong input!");
                printWelcome();
            }
    }
}
