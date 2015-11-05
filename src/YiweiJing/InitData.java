package YiweiJing;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 21/10/2015 12:57
 * This is my assessment
 * Project name is league
 */
public class InitData {
    public static void main(String[] args) throws Exception {
        String leagueName = "England League";

        Random random = new Random();
        int i = 0;
        int j = 0;
        String clubNames = "Newcastle-united,Manchester-united,Manchester-city,Sunderland,Chelsea,Derby,Liverpool,Southampton";
        String[] clubName = clubNames.split(",");

        int player_size = 15;
        String playerNames = "Tom,Tommy,John,Tina,Garen,Temmo,Ashe,Xin";
        String[] playerName = playerNames.split(",");

        int match_size = 30;
        String matchPlace = "London,Newcastle,Chelsea,Sunderland,Ireland,Scotland";
        String[] matchPlaces = matchPlace.split(",");

        /* test create league */
        League league = new League(leagueName);
        League.dao.modify(league);
        System.out.println("Create league "+league.getName()+" success!");


        /* test create club */
        for (i=0;i<clubName.length;i++){
            String content = clubName[i]+","+0+","+0+","+0+","+"England League";
            Club.dao.createFile(clubName[i],content);
        }
        System.out.println("Create club success!");

        List<Club> clubs = Club.dao.list();
        List<Match> matches = new ArrayList<>();

        /* test create player */
        for (j=0;j<playerName.length;j++) {
            for (i = 0; i < player_size; i++) {
                String role = "player";
                if (i==0){
                    role = "goalkeeper";
                }
                Player player = new Player(playerName[j] + (i + 1), "19" + (70 + random.nextInt(30)) + "-01-" + (10 + random.nextInt(20)), 170 + (random.nextInt(50)),0, clubName[j],role);
                Player.dao.modify(player);
            }
        }
        System.out.println("Create player success!");

        /* test create match */
        for (j=0;j<match_size;j++){
            int clubA = random.nextInt(clubs.size());
            int clubB = random.nextInt(clubs.size());
            while (clubA==clubB){
                clubB = random.nextInt(clubs.size());
            }
            List<Player> players = new ArrayList<>();
            players.addAll(Player.dao.getPlayersByClubname(clubs.get(clubA).getName()));
            players.addAll(Player.dao.getPlayersByClubname(clubs.get(clubB).getName()));
            Match match = new Match(matchPlaces[random.nextInt(matchPlaces.length)],"2015-"+(random.nextInt(12)+1)+"-"+(random.nextInt(27)+1),clubs.get(clubA),clubs.get(clubB),players);
            Match.dao.modify(match);
            matches.add(match);
        }
        System.out.println("Create match success!");
    }
}
