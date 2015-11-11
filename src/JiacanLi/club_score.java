package JiacanLi;

public class club_score {
  Club club=null;
  int score=0;
  
 
  public club_score(Club c){
	  this.club=c;
	  
  }
  public void setScore(int i ){
	  this.score=i;
	  }
  public int getScore(){
	  return score;
	  }
  public Club getClub(){
	  
	  return club;
  }
  }

