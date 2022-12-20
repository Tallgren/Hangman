

import java.io.IOException;
import java.util.*;

public class Controller {
    private final String wordFile = "src/Words.txt";
    private final String highScoreFile = "src/highScore.txt";
    private ArrayList<String> listOfWords;
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
        player = new Player(sc.nextLine(), 0);
        runMainMenu();
    }


    void runMainMenu() throws IOException {
        pView.mainMenu();
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> playGame();
            case "2" -> printHighScore(highScoreFile);
            case "3" -> printRules();
            case "0" -> System.exit(0);
            default -> pView.wrongValue();
        }
    }

    void playGame() throws IOException {
        tries = 0;
        state = 0;
        listOfWords = fh.generateWordList(wordFile);
        Collections.shuffle(listOfWords);
        hiddenWord = new Word(listOfWords.get(0));
        ArrayList<Character> wrongArray = new ArrayList<>();
        char[] array = hiddenWord.getHiddenWordAsArray();
        char[] array2 = new char[array.length];

        Arrays.fill(array2, '_');
        System.out.println(array2);
        boolean run = true;
        while (run) {
            System.out.println();
            String guess = sc.nextLine().toUpperCase();
            char guessLetter = guess.charAt(0);

            if (hiddenWord.getHiddenWord().contains(guess)) {
                //om du gissat rätt
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == guessLetter) {
                        array2[i] = guessLetter;
                    }
                }
                System.out.println(g.returnGraphics(state));
                System.out.println("Wrong guesses " + wrongArray);
                System.out.println(array2);
                if (Arrays.equals(array, array2)) {
                    System.out.println("\nYou win!!!");
                    System.out.println("Points: " + tries);
                    player.setScore(tries);
                    fh.writeHighscore(player, highScoreFile);
                    run = false;
                    runMainMenu();
                }
            } else {
                //om du gissat fel
                if(!wrongArray.contains(guessLetter)) {
                    wrongArray.add(guessLetter);
                    System.out.println(g.returnGraphics(++state));
                    System.out.println("Wrong guesses " + wrongArray);
                    System.out.print(array2);
                    tries++;
                } else {
                    System.out.println("You have already tried that letter!");
                }
            }

            if (state == 5) {
                System.out.println("\nYou lose!!!");
                System.out.println("The correct word was " + hiddenWord.getHiddenWord());
                System.out.println("Points: " + tries);
                run = false;
                runMainMenu();
                }
            }
        }

    public void printRules() throws IOException {
        pView.printRules();
        runMainMenu();
    }

    public void printHighScore(String highScoreFile) {

        ArrayList<String> scores;
        scores = fh.readHighScore(highScoreFile);

        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 0; i < scores.size(); i++) {
            String playerName = (scores.get(i).substring(0, scores.get(i).indexOf(' ')));
            int playerPoints = Integer.parseInt(scores.get(i).substring(scores.get(i).indexOf(' ') + 1));
            Player player = new Player(playerName, playerPoints);
            playerList.add(player);
        }
        playerList.sort((o1, o2) -> {
            if (o1.score == o2.score) {
                return o1.name.compareTo(o2.name);
            }
            return o1.score - o2.score;
        });
        pView.printHighScores(playerList);
        try {
            runMainMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
