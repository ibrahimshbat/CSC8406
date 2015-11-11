package JiacanLi;
import java.text.ParseException;
import java.util.ArrayList;


public class Club {
  private String name;
  private int goals_scored=0;
  private int goals_conceded=0;
  private int goals_difference=0;
  private int point=0;
 
  int sumAge=0;
  double sumHeight=0.0;
  private ArrayList<Player> squad=new ArrayList<Player>();
  
  
  public Club(String name){
	  this.name=name;
	  
  }
  public void setGoal_scored(int g){
	  this.goals_scored=goals_scored+g;
	  
  }
  public int getGoal(){
	  
	  return goals_scored;
  }
  public void setGoal_conceded(int i ){
	  this.goals_conceded=goals_conceded+i;
	  
  }
  public int getGoal_conceded(){
	  return goals_conceded;
	  
  }
  public int getGoal_difference(){
	  
	  return goals_scored-goals_conceded;
  }
  
  public String getName() {
	return name;
}
  public void setName(String name) {
	this.name = name;
} 
  
  public void addPoint(int p){
	  this.point=point+p;
  }
  public int getPoint(){
	  return point;
  }
  public void addPlayer(Player player){
	  squad.add(player); 
  }
  public boolean findPlayer(Player player){
	  boolean result=false;
	  for(int i=0;i<squad.size();i++){
		  Player p=squad.get(i);
		  if(player.equals(p)){
			  result=true;
		  }
	  }
	  
	  return result;
	 
  }
  public double getaverage_Age() throws ParseException{
	  double avery_age;
	  for(int i=0;i<squad.size();i++){
		  Player p = squad.get(i);
		  sumAge=sumAge+p.getAge();
	  }
	  avery_age=sumAge/squad.size()*1.0;
	  
	  return avery_age;
 
	 
	 }  
  public double getaverage_Height(){
	  double avery_height;
	  for(int i=0;i<squad.size();i++){
		  Player p =squad.get(i);
		  sumHeight=sumHeight+p.getHeight();
		  
	  }
	  avery_height=sumHeight/squad.size();
	  return avery_height;
  }
  
  public Player getTopplayer(){
	  
	  for(int i=0;i<squad.size();i++){
		  for(int j=i+1;j<squad.size();j++){
			  if(squad.get(i).getGoal()>squad.get(j).getGoal()){
				  Player p=squad.get(j);
				  squad.set(j, squad.get(i));
				  squad.set(i, p);
				  
			  }
			  
			  
		  }
     }
	  return squad.get(squad.size()-1);
  }
  
  public ArrayList<Player> getPlayer(){
	  return squad;
	  
  }
		  
	  }
	//public static void main(String arg[]){}  
  





