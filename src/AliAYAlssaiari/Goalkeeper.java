package AliAYAlssaiari;

import java.time.LocalDate;
import java.time.Period;


public class Goalkeeper extends Player{
	private String position;
	private int goalkeeperConceded;
	public Goalkeeper(){
		super();
		goalkeeperConceded = 0;
		position = "Goalkeeper";
		}
	
	   public Goalkeeper(String name, String position, double height, int year,int month, int day)
	   {
		   super(name,position ,height,year,month,day);
		  // position = "Goalkeeper";
	    }
	
	 public void setGoalKeeprConcededGoals(int goalsIn)
	 {
		 goalkeeperConceded +=goalsIn;
	 }
	 
	 public int getGoalKeeperConGoals()
	 {
		 
		 return goalkeeperConceded;
	 }
	 
	 public  void info()
	    {
	       super.info();
	       System.out.println(position);
	        
	    }

}
