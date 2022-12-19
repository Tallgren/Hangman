import java.util.ArrayList;

public class PlayerView {

    public void welcomeMessage(){
        System.out.println("Hello! Welcome to Hangman. Please enter a username: ");
    }

    public void mainMenu(){
        System.out.println("1. Play game");
        System.out.println("2. High-score");
        System.out.println("3. Rules");
        System.out.println("0. Exit");
    }

    public void wrongValue(){
        System.out.println("Wrong input value");
    }

    public void writeHighScore(ArrayList<String> highScoreList){
        System.out.println("HighScore: ");
        for (String e : highScoreList){
            System.out.println(e);
        }
        System.out.println();
    }

    public void printHighScores(ArrayList<Player> playerList){
        System.out.println("HighScores: ");
        for (Player e : playerList) {
            System.out.println(e.getName() + "\t" + e.getScore());
        }
        System.out.println();
    }

    public void printRules(){
        System.out.println("\nRules:");
        System.out.println("You need to guess the word in 5 tries, else you are hanged.");
        System.out.println("Guess one letter at a time(Or we will punish this...)\n");
    }





}
