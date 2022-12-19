import org.testng.annotations.Test;

import java.util.*;

public class FileHandlerTest {
    FileHandler fileHandler = new FileHandler();


    @Test
    public void testReadHighScore() {

        ArrayList<String> scores = new ArrayList<>();
        scores = fileHandler.readHighScore("Tests/testHighScore.txt");
//Tests/testHighScorePrint.txt
        ArrayList<Player> playerList = new ArrayList<>();

        for (String e : scores) {
            String playerName = (e.substring(0, e.indexOf(' ')));
            int playerPoints = Integer.parseInt(e.substring(e.indexOf(' ') + 1));
            Player player = new Player(playerName, playerPoints);
            playerList.add(player);
        }

        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o2.score == o1.score) {
                    return o2.name.compareTo(o1.name);
                }
                return o2.score - o1.score;
            }
        });

        assert playerList.get(0).getName().equalsIgnoreCase("prohanger");
        assert playerList.get(0).getScore() == 15;


    }

    @Test
    public void writeHighScoreTest() {
        Player player = new Player("PlayerX", 4);
        //"Tests/testHighScore.txt"
        fileHandler.writeHighscore(player, "Tests/testHighScorePrint.txt");

    }
}