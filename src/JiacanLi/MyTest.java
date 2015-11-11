package JiacanLi;

import java.text.ParseException;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player p = new Player();
		try {
			p.setBirthDate("1984-07-28");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(p.getAge());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
