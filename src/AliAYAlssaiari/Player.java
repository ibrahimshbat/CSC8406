package AliAYAlssaiari;

import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Scanner;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
/**
 * Write a description of class Player here.
 * 
 * @author (ALI ALSSAIARI ) 
 * @version (26-10-2015)
 */
public class Player
{
    
    
     private String name;
     private String playerPostion;
     private double height;
     private int year;
     private int month;
     private int day;
     private int goals;
     private int playerAge;
   
    private Period p;
    private LocalDate dateOfBirth;
    private LocalDate today = LocalDate.now();
     
   
    /**
     * Player Constructor with No Parameter to initialise Values 
     *
     */
    public Player()
    {
        name="";
        playerPostion="";
        goals=0;
        year=0;
        month=0;
        day=0;

    }
    
  
     /**
      * Player Constructor has  6 Parameters . 
      *
      * @param name A parameter of type String 
      * @param playerPostion A parameter of type String 
      * @param height A parameter of type Double 
      * @param year A parameter of Type Int
      * @param month A parameter  of Type Int
      * @param day A parameter  of Type Int
      */
     public Player(String name, String playerPostion,double height, int year,int month, int day)
    {
        if(( year<=0)||(month>12)||(month<=0)||(day<=0))
          {
            System.out.println("please check date values month and day can not be less or equals to 0 . in addtion months can be more than 12");
         }
        else{
         this.height= height;
         this.name= name;
         this.playerPostion = playerPostion;
         this.day=day;
         this.year= year;
        dateOfBirth = LocalDate.of(year, month, day);
         setPlayerAge();
        }
        }
      
      
   
   /**
    * Method setName it is responsible for set the Player Name 
    *
    * @param name A parameter
    */
   
   public void setName(String name)
   {
       this.name= name;
   }
   
   /**
    * Method setDateOfBirth
    *this method is taking the date of Birth in a format of day-month-year it has 3 Int Parameter then set the Date of Birth.
    * @param day A parameter
    * @param month A parameter
    * @param year A parameter
    */
   public void setDateOfBirth(int day, int month, int year)
   {
        if(( year<=0)||(month>12)||(month<=0)||(day<=0))
        {
            System.out.println("please check date values month and day can not be less or equals to 0 . in addtion months can be more than 12");
        }
        else{
              this.day= day;
              this.month=month;
              this.year=year;
              dateOfBirth = LocalDate.of(year, month, day);
              setPlayerAge();
            }
   }
  
   /**
    * Method setPlayerAge : this method will calculate the Player Age. But first you have to enter the Date of birth using the Consturcture Player(). or you have to call the method setDateOfBirth() . before Calling this method 
    * does not return any value . to access it's result you need to Call the method getAge().
    */
   public void setPlayerAge()
   {
       
        Period age = Period.between(dateOfBirth, today);
         playerAge =age.getYears();
    }
    
   /**
    * Method getDateOfBirth : this Methoud retuen the Date of Birth for the Palayer .the return taype is LocalDate.
    *
    * @return dateOfBirth 
    */
   public LocalDate getDateOfBirth()
   {
       return dateOfBirth;
   }
  
    /**
     * Method getname : this method return the Player Name 
     *
     * @return name;
     */
    public String getname(){
        
        return name;
        
    }
    /**
     * Method setHeight : this method set the Player Height . it's take one Parameter of type Double.
     *
     * @param y A parameter
     */
    public void setHeight(Double y)
    {
        this.height=y;
    }
    
     /**
      * Method getHeight: this metoud Return the Player height . the return type is Double .
      *
      * @return height.
      */
     public double getHeight()
    {
      return height;
    }
    

    /**
     * Method getAge : retuern the Player Age.
     * @return the Player age as Int .
     */
    public int getAge()
    {
        
 
        return  playerAge;
    }
    
    /**
     * Method setGoals : this method set the Goals for the Player and update his Goal Tally Record.
     *
     * @param goals A parameter
     */
    public void setGoals(int goals){
        this.goals+=goals;
    }
    /**
     * Method getGoals return the Goal Tally for the Player
     *
     * @return  the Goal Tally for the Player as Int.
     */
    public int getGoals()
    {
        
        return goals;
    }
    /**
     * Method getPlayerPosition : return the Position of the Player 
     *
     * @return return the Position of the Player as String .
     */
    public String getPlayerPosition()
    {
        return playerPostion;
    }
    

    
    public void info()
    {
         System.out.println( " the Player Name is : \t" + "the Player age is \t");
          System.out.println( "  \t" + name + "\t\t" + playerAge);
      
    }
    
    /**
     * Method getDay : get the Day 
     *
     * @return The return value
     */
    public int getDay()
    {
        return day;
    }
    
   
    
    /**
     * Method equals : this metoud Overriden here  from the Object Class . to Compare a Player objects ( using the object Vlaue not object refernce )and return true if the objects exist. So it's recieve an Object of Any type and if this Object Not Instance of Player  return False 
     * Directly. but if it's a Player compare this object with the Player and if they are same Return True.
     *
     * @param obj A parameter of Object Type 
     * @return The return value
     */
    @Override 
    public boolean equals( Object obj)
    {
        if(!(obj instanceof Player)){
        return false;
        }
        
        Player  otherPlayer= (Player) obj;
        if((this.name.equals(otherPlayer.name)) && (this.day== otherPlayer.day) && (this.year == otherPlayer.year) )
            {
             
              return true;
            
            }
        else return false;
    }
        

    /**
     * Method hashCode : overriden HashCode to met the equals method requirments.
     *
     * @return hashCode.
     */
    @Override 
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 37 + this.name.hashCode()+ day  ; 
       
        
        return hashCode;
    }
    
  
    
  
}
