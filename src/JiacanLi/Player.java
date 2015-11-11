package JiacanLi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Player {

	private String name;
	private String birthDate=null;//  yyyy-mm-dd;
	private Club club;
	private double height=0.0;
	private int goal=0;
	
	public Player(){
		
	}
	
	public Player(String name,Club c){
		this.name=name;
		this.club=c;
		
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) throws java.text.ParseException {
		
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		date = sdf.parse(birthDate);  //bith of date
		Calendar now = Calendar.getInstance();
		Calendar born=Calendar.getInstance();
		
		if(date!=null){
			now.setTime(new Date());
			born.setTime(date);
		}
		if (born.after(now)) {
			 System.out.println("not available");
			}
		else{
		this.birthDate = birthDate;
		}
		
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void addGoal(int i){
		goal=goal+i;
		
	}
	public int getGoal(){
		return goal;
		
	}
	public void setGoal(int goal){
		this.goal=goal;
	}
    public int getAge() throws java.text.ParseException{
    	int age;
    	Date date=new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		date = sdf.parse(birthDate);  //bith of date
    	Calendar now=Calendar.getInstance();
        Calendar born=Calendar.getInstance();
        now.setTime(new Date());
        born.setTime(date);
        age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
        age -= 1;
        }

    	return age;
    }
    
}
    	
    

