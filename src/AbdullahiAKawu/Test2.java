package AbdullahiAKawu;


/**
 * Write a description of class Test1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test2
{
    public static void main(String[] args)
    {
        Players p1 = new Players("Musa", 1.2, 2010, 10, 06);
        Players p2 = new Players("Elias", 1.2, 2010, 12, 05);
        
        
        Clubs Club1 = new Clubs("Newcastle");
        Clubs Club2 = new Clubs("Man Utd");
        
        Club1.addPlayer(p1);
        Club1.addPlayer(p2);
        
        
       System.out.println(Club1.averageSquadAge());
      
       
    }
}
