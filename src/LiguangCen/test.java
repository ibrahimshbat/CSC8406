package LiguangCen;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * Provide a simple demonstration of running league scenario. 
 * @author Liguang Cen
 * @version 2015.10.30
 */
public class test
{
    // instance variables - replace the example below with your own
    public static void main()
    {
        League league1 = new League("EU",32);
        String opt = "";
        System.out.println("1: print match table");
        System.out.println("2: find golden boot player");
        System.out.println("3: find best goalkeeper");
        System.out.println("4: print league table");
        System.out.println("5: list clubs");
        System.out.println("bye: exit");
        Scanner reader=new Scanner(System.in);
       while(reader.hasNextLine()&& !opt.equals("bye"))
        {  
            opt = reader.nextLine();
            switch(opt)
            {
                case "1": league1.printMatchTable();break;
                case "2": league1.displayGoldenBoot();break;
                case "3": league1.displayBestKeeper();break;
                case "4": league1.displayLeagueTable();break;
                case "5": league1.listClubs();break;
                case "bye": System.exit(0);
                default: System.out.println("invalid selection");
                
            }
        }
        reader.close();
        
    }
    
    
}
