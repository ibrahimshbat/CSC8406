package AbdullahiAKawu;

import java.time.LocalDate;
/**
 * This Test1 Class confirms if our Class Players is working independently.
 * We would try to create a player object and we test out some of its parameters through its methods to ensure compliance.
 * Specifically, method getPlayerName(), getPlayerHeight(), 
 * @Abdullahi Abubakar Kawu 
 * @30.10.15
 * @param name, height, day, month, year
 */
public class Test1
{
    public static void main(String[] args)
    {
        Players myplayer = new Players("Marta", 1.4, 2003, 10,21);
              
        //The following codes displays the name, date of birth and height of the new player (newly created object) 
        //calling the getPlayerName(), getPlayerHeight(), getPlayerDOB() methods
        //Details before any method invocation
        System.out.println("Player Name:" + myplayer.getPlayerName());
        System.out.println("Player Height:" + myplayer.getPlayerHeight()); 
        System.out.println("Player Date of Birth:" + myplayer.getPlayerDOB()); 
        
        // Changing the name of the current player to 'Martins' using the setPlayerName() method (setters)
        // Changing Height, DOB  
        // Invoking the setPlayerName(), setPlayerHeight(), setPlayerDOB() methods
        
        
         myplayer.setPlayerName("Martins");
         myplayer.setPlayerHeight(1.8);
         myplayer.setPlayerDOB(2000,8,01);
         
        // Details after method invocation
        //See the player's details changed now;
        
         myplayer.setPlayerName("Martins");
         myplayer.setPlayerHeight(1.8);
         myplayer.setPlayerDOB(2000,8,01);
         System.out.println("*************************************************");
         
         
         //Prints to console the player's details as changed now;
        System.out.println("Player Name:" + myplayer.getPlayerName());
        System.out.println("Player Height:" + myplayer.getPlayerHeight()); 
        System.out.println("Player Date of Birth:" + myplayer.getPlayerDOB());
       
    }
   
}
