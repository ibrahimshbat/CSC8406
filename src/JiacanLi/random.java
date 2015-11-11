package JiacanLi;
import java.util.ArrayList;
import java.util.Random;


public class random {
	
	
	//randomly pick player
	//generate i numbers form 0 to j randomly;
	public ArrayList random(int i,int j){
		int count=0;
		ArrayList list = new ArrayList(); 
		Random r=new Random();
		boolean[] bool=new boolean[j];
		int num=0;
	
		for(int a=0;a<i;a++){
			
			do{
				num=r.nextInt(j);
				
				count=count+1;
				
			}while(bool[num]);
			bool[num]=true;
			list.add(num);
			
		}
		return list;
		
		
	}
	public static void main(String[] args){
	  for(int i=0;i<3;i++){
		  for(int j=i+1;j<3;j++){
			  System.out.println(i+"  "+j);
			  
		  }
		  
	  }
		
	}
}
