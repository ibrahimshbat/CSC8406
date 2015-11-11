package JiacanLi;
import java.util.*;
public class Test1 {
	
	public static void main(String[] args){
		ArrayList<League> league=new ArrayList<League>();
	    ArrayList<Club> club=new ArrayList<Club>();
		while(true){
			int i=0;
			System.out.println("--------------------");
			System.out.println("1.Creat a league:");
			System.out.println("2.Creat a Club");
			System.out.println("3.Simulat match");
			Scanner scan=new Scanner(System.in);
			i=scan.nextInt();
			
			switch(i){
			case 1:
				if(league.size()==1){
				System.out.println("One league has created ");
				 break;
				
			}
				System.out.println("Type the name of the league: ");
			    Scanner league_name=new Scanner(System.in);
			    String name=league_name.next();
			    league.add(new League(name));
			    System.out.println(name+" is ceated!");
			    break;
			
			case 2:
				if(league.size()==0){
				System.out.println("Please creat a League first");
				System.out.println("--------------------");
				 break;	
			}
				  System.out.println("Type the name of the club: ");
				  Scanner club_name=new Scanner(System.in);
				  name=club_name.next();
				  Club c=new Club(name);
				  club.add(c);
				  league.get(0).addClub(c);
				  System.out.println("Club "+name+" has created");
				  for(int j=0;j<15;j++){
					   Player p=new Player(name+"-palyer"+j,c);
					   c.addPlayer(p);
					   System.out.println(name+"-palyer"+j+" has created");
					   
				   }
				  break;
				  
			case 3:
				if(league.isEmpty()){
				System.out.println("Please creat a League first ");
				break;
			}		
			if(club.isEmpty()){
				System.out.println("Please add some clubs to the league ");
				break;
			}
			  Simulation_match.doSimulate(league.get(0));    //simulate all matches;
			  break;
			
				  default:break;
			}
		}
		
	}

}
