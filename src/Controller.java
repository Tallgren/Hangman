import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controller {
    private final String wordFile = "src/Words.txt";
    private ArrayList<String>listOfWords;
    Scanner sc = new Scanner(System.in);
    private Player player;
    private PlayerView pView = new PlayerView();
    private FileHandler fh = new FileHandler();

    private Word hiddenWord;

    public Controller() throws IOException {

        // Welcome the player and adds name to the player
        // and runs mainMenu.
        pView.welcomeMessage();
        player = new Player(sc.nextLine());
        runMainMenu();
    }


    void runMainMenu() throws IOException {
        pView.mainMenu();
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> playGame();
            case "2" -> highscore();
            case "3" -> System.exit(0);
            default -> pView.wrongValue();
        }
    }

    void playGame() throws IOException {
        listOfWords = fh.generateWordList(wordFile);
        Collections.shuffle(listOfWords);
        hiddenWord = new Word(listOfWords.get(0));

    }

    void highscore() {
        System.out.println("highscore");
    }
}
