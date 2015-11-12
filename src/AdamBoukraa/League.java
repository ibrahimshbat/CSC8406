package AdamBoukraa;

/** 
* Class League implements java.io.Serailizable,
extends java.awt.Button 
*/ 

import java.util.Vector;
import java.util.Collections;
 

/**
 * League class that deals with storing and showing results 
 * 
 * @author Adam Boukraa
 * @version Version 3
 */
public class League {
 
    Vector<Club> clubs;
 
    String [] list1 = {"BC Barcelona", "RM Real Madrid", "GT Getafe", "AR Arsenal"};
    
  /*
     * Constructor for league. Vector is used because the array can be any size and therfore does not need to be pre-defined.
     */
    
 
    public League() {
    clubs = new Vector<Club>();
    }
 
  /*
     * Method to set up division and uses an array to find values contained within these variables.
     */
    public void setupDiv () {
    for (int i=0; i<list1.length; i++) {
        String cname = list1[i].substring(3);
        String AB = list1[i].substring(0,2);
        addClub(1, cname, AB);
    } 
    }
 
  /*
   * This method allows you to add a club including variables ; Divison, Club Name and AB.
   */
   public void addClub (int division, String cname, String AB) {
    Club aClub = new Club(division, cname, AB);
    clubs.add(aClub);
    }
 
  /*
   * This method allows the user to search for a club stored in the array.
   */
    public Club findClub(String AB) {
        Club aClub = null;
        for (int i=0; i<clubs.size(); i++) {
            aClub = clubs.get(i);
            if (aClub.AB.equals (AB))break;
        }// end for i
        return aClub;
    }
 
 
 
  public void addResult(String results){
    String hAB = "BC";
    String aAB = "RM";
    int hScore = 5;
    int aScore = 0;
 
    Club homeClub = this.findClub(hAB);
    homeClub.addHomeResult(hScore,aScore);
 
    Club awayClub = this.findClub(aAB);
    awayClub.addAwayResult(hScore,aScore);
    }
    
    
 
    
  public void print() {
        for (Club aClub: clubs) {
            aClub.print();
        }
    }
 
}