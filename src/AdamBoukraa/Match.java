package AdamBoukraa;

/** 
* Class Match implements java.io.Serailizable,
extends java.awt.Button 
*/ 

import java.util.*;

/**
 * Class for creating Matches
 * 
 * @author Adam Boukraa 
 * @version V2
 */
public class Match
{
   private String KO;
   private String ground ;
  
    
    private Club clubH;
    private Club clubA;
    
    
    private List<Player> club1;
    private List<Player> club2;
    
    private int club1Score;
    private int club2Score;
    
    /**
     * Method for creating a match.
     */
    
    public Match(String day, String ground , Club clubH, Club clubA)
    {
	    club1Score = 0;
	    club2Score = 0;	
        this.ground  = ground ;
        this.KO = KO;
        this.clubH = clubH;
        this.clubA = clubA;
    }
   
    /**
     * Method for setting ground
     */
    public void setground (String ground )
    {
        this.ground  = ground ;
    }
    
    
    /**
     * Method for getting ground
     */
    public String getground ()
    {
       return ground ;
    }
    
    /**
     * Method for setting KickOff
     */
    public void setKO(String KO)
    {
		this.KO = KO;
    }
    
   /**
     * Method for getting KickOff
     */ 
    public String getKO()
    {
        return KO;
    }
    
   
    public void setclubH(Club clubH)
    {
        this.clubH = clubH;
    }
    
    public void setclubA(Club clubA)
    {
        this.clubA = clubA;
    }
    
    public String getclubH()
    {
        return clubH + " vs " + clubA;
    }
    
    
    
    
    
    
    
    
}