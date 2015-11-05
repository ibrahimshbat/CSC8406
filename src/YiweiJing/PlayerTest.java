package YiweiJing;



/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 22/10/2015 15:24
 * This is my assessment
 * Project name is league
 */
public class PlayerTest {
    public static void main(String[] args) throws Exception {
        //create a player
        String playerName = "Dan";
        String clubName = "Chelsea";
        Player player = new Player(playerName,"1987-09-24",202,0,clubName,"player");
        Player.dao.modify(player);
        System.out.println("  Create player successfully!The name is="+player.getName()+",birthdate="+player.getBirthdate()+",height="+player.getHeight()+",belongs to club "+player.getClubName()+", and he is a "+player.getRole());

        //add to the goal tally of a player
        System.out.println("\n  add to the goal tally of a player");
        System.out.println("  before adding,the tally goals of player "+player.getName()+" is "+player.getGoal()+"\n  now we will add 3 goals");
        player = Player.dao.addGoalTally(player, 3);
        System.out.println("  after adding,the tally goals of player"+player.getName()+" is "+player.getGoal());

        //get the goal tally of a player.
        System.out.println("\n  get the goal difference of the club");
        int tallyGoals = Player.dao.getGoalTally(player);
        System.out.println("  The tally goal of player "+player.getName()+" is "+ tallyGoals);

    }
}
