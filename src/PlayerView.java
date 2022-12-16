import java.util.ArrayList;

public class PlayerView {

    public void welcomeMessage(){
        System.out.println("Hello! Welcome to Hangman. Please enter a username: ");
    }

    public void mainMenu(){
        System.out.println("1. Play game");
        System.out.println("2. High-score");
        System.out.println("3. Exit");
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





}
