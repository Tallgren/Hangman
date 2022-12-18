import org.testng.annotations.Test;

import java.util.*;

public class FileHandlerTest {
    FileHandler fileHandler = new FileHandler();


    @Test
    public void testReadHighScore() {
        ArrayList<String> scores = new ArrayList<>();
        scores = fileHandler.readHighScore("Tests/testHighScore.txt");

        ArrayList<Player> playerList = new ArrayList<>();

        for (String e : scores) {
            String playerName = (e.substring(0, e.indexOf(' ')));
            int playerPoints = Integer.parseInt(e.substring(e.indexOf(' ') + 1));
            Player player = new Player(playerName, playerPoints);
            playerList.add(player);
        }

        System.out.println(playerList);
        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o2.score == o1.score) {
                    return o2.name.compareTo(o1.name);
                }
                return o2.score - o1.score;
            }
        });

        System.out.println("HighScores: ");
        for(Player e : playerList){
            System.out.println(e.getName()+"\t"+e.getScore());
        }


        assert playerList.get(0).getName().equalsIgnoreCase("prohanger");
        assert playerList.get(0).getScore() == 15;


    }
}