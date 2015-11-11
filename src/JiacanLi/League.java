package JiacanLi;
import java.util.*;
public class League {
  private String name;
  private ArrayList<Club> club=new ArrayList<Club>();
  private ArrayList<Match> match=new ArrayList<Match>();
  private ArrayList<Player> player=new ArrayList<Player>();
  
  
  public League(String name){
	  this.name=name;
	  
  }
  
  public ArrayList<Club> getClub(){
	  
	  return club;
  }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  public void  addClub(Club c){
	  this.club.add(c);
	  
  }
  
  public void addMatch(Match m){
	  this.match.add(m);
  }
  
  public String findTopteam(){
	  //bubble sort
	  for(int i=0;i<club.size();i++){
		  for(int j=i+1;j<club.size();j++){
			  if(club.get(i).getPoint()<club.get(j).getPoint()){
				  Club c=club.get(j);
				  club.set(j, club.get(i));
				  club.set(i, c);
				  
			  }
			  if(club.get(i).getPoint()==club.get(j).getPoint()){
				  if(club.get(i).getGoal_difference()<club.get(j).getGoal_difference()){
					  Club c=club.get(j);
					  club.set(j, club.get(i));
					  club.set(i, c);
					  
				  }
				  
			  }
			  
		  }
		  
	  }
	  return club.get(club.size()-1).getName();
	  
  }
  public String findTopplayer(){
	  
	  //bubble sort;
	  for(int i=0;i<club.size();i++){
		  Player p = club.get(i).getTopplayer();
		  player.add(p); 
	  }
	  for(int j=0;j<player.size();j++){
		  for(int k=j+1;k<player.size();k++){
			  if(player.get(j).getGoal()>player.get(k).getGoal()){
				  Player p =player.get(k);
				  player.set(k, player.get(j));
				  player.set(j, p);
				  
			  }
			  
			  
		  }
		  
	  }
	  return player.get(player.size()-1).getName();
  }
  public ArrayList<Player> getPlayer(){
	  return player;
	  
  }
  
}
