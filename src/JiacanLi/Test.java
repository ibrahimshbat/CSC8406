package JiacanLi;
import java.util.*;


public class Test {
   public static void main(String[] args){
	   
	   System.out.println("Please type the name of league: ");
	   Scanner scan=new Scanner(System.in);
	   String league_name=scan.nextLine();
	   League league=new League(league_name);
	   System.out.println("The league "+league_name+" is created!");
	   System.out.println("type the number of clubs in this league");
	   Scanner scan1=new Scanner(System.in);
	   int club=scan.nextInt();//NUMBER OF CLUB IN THIS LEAGUE
	   for(int i=0;i<club;i++){
		   Club c=new Club("Club"+i);
		   for(int j=0;j<15;j++){
			   Player p=new Player("Club"+i+"-player"+j,c);
			   c.addPlayer(p);
			   
		   }
		   league.addClub(c);
		   System.out.println(league.getClub().get(i).getName()+" is created");
		   
	   }
	  // System.out.println(league.getClub().get(0).getPlayer().get(0).getName());
	 
	   
	   //模拟比赛
	   
	   System.out.println("--------Here are the matches--------");
	   
	   
	   
	   for(int a=0;a<league.getClub().size();a++){
		
		   random r1=new random();
		   ArrayList a1=r1.random(11, 15);//11 recorded players in one match;
		   random r2=new random();
		   ArrayList a2=r2.random(11, 15);//
		   for(int b=a+1;b<league.getClub().size();b++){
			   Match m=new Match();
			   Club c1=(Club) league.getClub().get(a);
			   Club c2=(Club) league.getClub().get(b);
			   m.setmatchClub(c1,c2);
			  
			   for(int c=0;c<11;c++){
				   Random random1=new Random();
				   Random random2=new Random();
				  m.setrecordPlayer(league.getClub().get(a).getPlayer().get((Integer) a1.get(c)));
				  m.setrecordPlayer(league.getClub().get(b).getPlayer().get((Integer) a2.get(c)));
				  m.setplayerScored(league.getClub().get(a).getPlayer().get((Integer) a1.get(c)), random1.nextInt(2));
				  m.setplayerScored(league.getClub().get(b).getPlayer().get((Integer) a2.get(c)), random2.nextInt(2));
				}
			 System.out.println(m.getFinalscore()+"-----"+m.getResult());   
		   }
	 }
	   
	   //球队积分榜
	   
	   System.out.println("--------Here are the League table--------");
	   System.out.println("Club     point  goal  goal-conceded  goal-difference");
	   String top_team=league.findTopteam();
	   String top_player=league.findTopplayer();
	   
	       for(int x=0;x<league.getClub().size();x++){
	    	   System.out.println(league.getClub().get(x).getName()+"      "+league.getClub().get(x).getPoint()+"       "+league.getClub().get(x).getGoal()+"        "+league.getClub().get(x).getGoal_conceded()+"              "+league.getClub().get(x).getGoal_difference());
	    	   
	       }
	   System.out.println("--------Here are the player table------");
	   System.out.println("Name    Goals");
	   for(int y=0;y<league.getPlayer().size();y++){
		   System.out.println(league.getPlayer().get(y).getName()+"    "+league.getPlayer().get(y).getGoal());
		   
	   }
	   
   }
   
}
