package JiacanLi;
import java.util.*;


public class Match {
    private Date time;
    private String place;
    private ArrayList<Club> club=new ArrayList<Club>();
    private ArrayList<Player> player=new ArrayList<Player>();
    private ArrayList<player_score> player_scored=new ArrayList<player_score>();
    private ArrayList<club_score> club_scored=new ArrayList<club_score>();
    
    
    
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}    
	
	public ArrayList<Club> getClub(){
		
		return club;
	}
    public void setmatchClub(Club c1,Club c2){
    	club.add(c1);
        club.add(c2);
        club_score cs1=new club_score(c1);
        club_score cs2=new club_score(c2);
        club_scored.add(cs1);
        club_scored.add(cs2);
    	}
   
    public ArrayList<Club> getmatchClub(){
    	
    	return club;
    }
    public void setrecordPlayer(Player p){
    	//记录上场球员
    	player.add(p);
    	player_score ps = new player_score(p);
    	player_scored.add(ps);
    }
    
    
    public ArrayList<Player> getrecordPlayer(){
    	return player;
    	
    }
    public void setplayerScored(Player p,int score) {
    	for(int i=0;i<player_scored.size();i++){
    		if(player_scored.get(i).getPlayer().equals(p)){
    			p.addGoal(score);	
    		
    			player_scored.get(i).setScore(score);
    		}
    		
    	}
    	
    }
    public String getFinalscore(){
    	
    	for(int i =0;i<club_scored.size();i++){
    		int club1=0;
    		for(int j=0;j<player_scored.size();j++){
    			if(player_scored.get(j).getPlayer().getClub().equals(club_scored.get(i).getClub())){
    				club1=club1+player_scored.get(j).getScore();
    				//club_scored.get(i).getClub().setGoal_scored(club1);//记录本场进球数到goal
    				//if(i==0){club_scored.get(1).getClub().setGoal_conceded(club1);}
    				//if(i==1){club_scored.get(0).getClub().setGoal_conceded(0);}
    				
    				//club_scored.get(i).setScore(club1);
                  
    			}
    			//club_scored.get(i).getClub().setGoal_scored(club1);
    			//club_scored.get(i).setScore(club1);
    			//if(i==0){club_scored.get(1).getClub().setGoal_conceded(club1);}
				//if(i==1){club_scored.get(0).getClub().setGoal_conceded(club1);}
    		}
    		
    		club_scored.get(i).getClub().setGoal_scored(club1);
			club_scored.get(i).setScore(club1);
			if(i==0){club_scored.get(1).getClub().setGoal_conceded(club1);}
			if(i==1){club_scored.get(0).getClub().setGoal_conceded(club1);}
    	
    }
    	
    
                  return club_scored.get(0).getClub().getName()+" "+club_scored.get(0).getScore()+"-"
                		 +club_scored.get(1).getScore() +" "+club_scored.get(1).getClub().getName();
    }
    
    public String getResult(){
    	
    	String result=null;
    	if(club_scored.get(0).getScore()>club_scored.get(1).getScore()){
    		result=club_scored.get(0).getClub().getName()+"  win!";
    		club_scored.get(0).getClub().addPoint(3);
    	}
    	if(club_scored.get(0).getScore()==club_scored.get(1).getScore()){
    		result="  drawing";
    		club_scored.get(0).getClub().addPoint(1);
    		club_scored.get(1).getClub().addPoint(1);
    	}
    	if(club_scored.get(0).getScore()<club_scored.get(1).getScore()){
    		result=club_scored.get(1).getClub().getName()+"  win!";
    		club_scored.get(1).getClub().addPoint(3);
    	}
    	return result;
    }
    
}

