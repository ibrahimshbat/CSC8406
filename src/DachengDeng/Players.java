package DachengDeng;

import java.util.*;
import java.io.*;

/**
 * This class is used for save all players information and alter players details in different methods
 * 
 * @author Dacheng Deng
 * @version 2015.10.29
 */
public class Players
{
    // store name of all players
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> birth = new ArrayList<String>();
    ArrayList<String> height = new ArrayList<String>();
    ArrayList<String> club = new ArrayList<String>();
    ArrayList<String> position = new ArrayList<String>();
    ArrayList<String> goal = new ArrayList<String>();
    //store path of .txt files 
    String path;
    IO file=new IO();
    
    /**
     * Initialize players class
     */
    public Players() throws IOException 
    {
        // initialise instance variables
        initialization();
    }    
    
    /**
     * Clear all ArrayLists.
     * Create files for store data. 
     * Read players data to ArrayLists if files exist.
     * @throws IOException
     */
    public void initialization() throws IOException 
    {
        name.clear();
        birth.clear();
        height.clear();
        club.clear();
        position.clear();
        goal.clear();
        file.createFile("PlayersName.txt");
        file.createFile("PlayersBirthday.txt");
        file.createFile("PlayersHeight.txt");
        file.createFile("PlayersClub.txt");
        file.createFile("PlayersPosition.txt");
        file.createFile("PlayersGoal.txt");
        file.readData("PlayersName.txt",name);
        file. readData("PlayersBirthday.txt",birth);
        file.readData("PlayersHeight.txt",height);
        file.readData("PlayersClub.txt",club);
        file.readData("PlayersPosition.txt",position);
        file.readData("PlayersGoal.txt",goal);
    }

    
    /**
     * Add a player to list and save in file
     * @param newname   name of player
     * @param newbirth   birthday of player
     * @param newheight   heirht of player
     * @param newposition   position of player
     * @param newgoal   goal tally of player
     * @return     the sum of x and y
     * @throws IOException if fail to read or write 
     *  i.e.("Messi","19870624",169,"Barcelona","forward",16)
     */
    public void addPlayer(String newname, String newbirth, int newheight,String newposition, int newgoal)throws IOException
    {
        // Save players information
        String newclub="unknown";        
        name.add(newname);
        file.writeData("PlayersName.txt",newname);
        birth.add(newbirth);
        file.writeData("PlayersBirthday.txt",newbirth);
        height.add(String.valueOf(newheight));
        file.writeData("PlayersHeight.txt",String.valueOf(newheight));
        club.add(newclub);
        file.writeData("PlayersClub.txt",newclub);
        position.add(newposition);
        file.writeData("PlayersPosition.txt",newposition);
        goal.add(String.valueOf(newgoal));
        file.writeData("PlayersGoal.txt",String.valueOf(newgoal));
    }
    
    /**
     * Delete a player from file
     * @param newname   name of player 
     * @throws IOException if fail to read or write 
     */
    public void delPlayer(String newname)throws IOException
    {
        try{
            int index=name.indexOf(newname);
            file.rewrite("PlayersName.txt",name,index);
            file.rewrite("PlayersBirthday.txt",birth,index);
            file.rewrite("PlayersHeight.txt",height,index);
            file.rewrite("PlayersClub.txt",club,index);
            file.rewrite("PlayersPosition.txt",position,index);
            file.rewrite("PlayersGoal.txt",goal,index);
        }catch(Exception e){
            System.out.println("Not found ["+newname+"] in Players list.");
            e.printStackTrace();
        }
    } 
    
    /**
     * Renew a player's goal: Input new record of the goal tally
     * @param inputName    name of a player
     * @param goalTally    the goal tally of a player
     * @throws IOException if fail to read or write 
     */
    public void setGoalTally(String inputName,int goalTally) throws IOException
    {
       try{
           int index=name.indexOf(inputName);
           goalTally=goalTally+Integer.parseInt(goal.get(index));
           goal.set(index,String.valueOf(goalTally));
           file.delFile("PlayersGoal.txt");
           file.createFile("PlayersGoal.txt");
           for(int i=0;i<goal.size();i++){
                file.writeData("PlayersGoal.txt",goal.get(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    /**
     * Renew a player's club squad: Input player's name and new club 
     * @param inputName    name of a player
     * @param squad    name of the player's club
     * @throws IOException if fail to read or write 
     */
    public void setSquad(String inputName,String squad) throws IOException
    {
        boolean df = false;
        for(String ply : name){
            if(ply.equals(inputName)){
                try{
                    int index=name.indexOf(inputName); 
                    club.set(index,String.valueOf(squad));
                    file.delFile("PlayersClub.txt");
                    file.createFile("PlayersClub.txt");
                    for(int i=0;i<club.size();i++){
                        file.writeData("PlayersClub.txt",club.get(i));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                df = true;
                break;  
            }
        }
        if(df){
            System.out.println("Success to add "+inputName+" to club "+squad);
        }else{
             System.out.println("Not found ["+inputName+"] in Players list.");
        }
    }
    
     /**
     * Get a player's information through name
     * @param inputName    name of a player
     */
    public void getPlayer(String inputName)
    {
        try{
            int index=name.indexOf(inputName);
            System.out.println("\nname:"+name.get(index));
            System.out.println("Birth:"+birth.get(index));
            System.out.println("Height:"+height.get(index));
            System.out.println("Club:"+club.get(index));
            System.out.println("Position:"+position.get(index));
            System.out.println("Goal:"+goal.get(index));
        }catch(Exception e){
            System.out.println("Cannot find the player of ["+inputName+"]. Please confirm that the name is correctï¼�");
            e.printStackTrace();
        }
    }     
    
    /**
     * Get a player's index through club's name
     * @param clubName name of the player's club
     */
    public void getPlayersInClub(String clubName)
    {
        for(int i=0;i<club.size();i++)
        {
            if(clubName.equals(club.get(i))){
                System.out.println("name:"+name.get(i));
            }
        }
    }
    
    /**
     * Get player's average age through club's name
     * @param clubName  name of the player's club
     * @return years/num    average age of the club
     */
    public int getPlayersAge(String clubName)
    {
        String age;
        int year;
        int years = 0;
        int num = 0;
        for(int i=0;i<club.size();i++)
        {
            if(clubName.equals(club.get(i))){
                age = birth.get(i);
                year = 2015 - Integer.parseInt(age.substring(0,4));
                years += year;
                num++;
                System.out.println(age);
                System.out.println(year);
                System.out.println(years);
                System.out.println(num);
            }
        }
        return years/num;
    }   
    
    /**
     * Get all player's average height through club's name
     * @param clubName  name of the player's club
     * @return allht/num    average height of the club
     */
    public float getPlayersHeight(String clubName)
    {
        float ht;
        float allht = 0.0f;
        int num = 0;
        for(int i=0;i<club.size();i++)
        {
            if(clubName.equals(club.get(i))){
                ht = Float.parseFloat(height.get(i));
                allht += ht;
                num++;
                System.out.println(ht);
                System.out.println(allht);
                System.out.println(num);
            }
        }
        return allht/num;
    }
    
    /**
     * Get name of all goalkeepers
     */
    public void getGoalkeepers()
    {
        for(int i=0;i<position.size();i++)
        {
            if(position.get(i).equals("goalkeeper")){
                System.out.println("name:"+name.get(i));
            }
        }
    }

}
