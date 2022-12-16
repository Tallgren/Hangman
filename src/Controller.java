

import java.io.IOException;
import java.util.*;

public class Controller {
    private final String wordFile = "src/Words.txt";
    private ArrayList<String>listOfWords;
    Scanner sc = new Scanner(System.in);
    private Player player;
    private PlayerView pView = new PlayerView();
    private FileHandler fh = new FileHandler();
    private int state = 0;
    private int tries = 0;
    private Graphics g = new Graphics();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

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
        char[] array = hiddenWord.getHiddenWordAsArray();
        char[] array2 = new char[array.length];
        for (int i=0;i<array2.length;i++){
            array2[i]='_';
        }
        System.out.print(Arrays.toString(array2));

        while (true) {
           // System.out.println(hiddenWord.getHiddenWord());
            String guess = sc.nextLine().toUpperCase();
            char guessLetter = guess.charAt(0);

            if (hiddenWord.getHiddenWord().contains(guess)) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == guessLetter) {
                        array2[i] = guessLetter;
                    }
                }
                System.out.println(array2);
                if (Arrays.equals(array,array2)) {
                    System.out.println("You win");
                    break;
                }
            } else {
                //om du gissat fel

                System.out.println(g.returnGraphics(++state));

            }
            tries++;
            if (state==5){
                System.out.println("You lose!!");
                System.out.println("You did "+ tries + " tries");
                break;
            }

        }

    }

    void highscore() {
        System.out.println("highscore");
    }
}
