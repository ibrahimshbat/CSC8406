package JiacanLi;

public class player_score {
	//player 
	
	//scored
	
	
   private Player player=null;
   private int score=0;
   
   public player_score(Player p){
	   this.player=p;
	   
   }
   public void setScore(int i ){
	   this.score=i;
	  
	   
   } 
   public int getScore(){
	   
	   return score;
   }
   public Player getPlayer(){
	   return player;
   }
}
