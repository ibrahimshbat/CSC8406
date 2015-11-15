package WeiRwn;

import java.io.*;
import java.util.*;
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   public static void main(String[]args)throws FileNotFoundException
   {
       try{
           String pathname = "E:\\input.txt";
           File filename = new File(pathname);
           
           InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
           BufferedReader br = new BufferedReader(reader);
           String line = "";
           line = br.readLine();
           
           while(line!= null){
               line = br .readLine();
            }
           File writename = new File(".\\result.txt");
           writename.createNewFile();
           BufferedWriter out = new BufferedWriter(new FileWriter(writename));
           out.write("sda");
           out.flush();
           out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        League myLeague = new League("");
        myLeague.listLeague();
    }
           
           
       
   }

