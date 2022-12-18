import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileHandler {

    public ArrayList<String> generateWordList(String file) throws IOException {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()){
            wordList.add(scanner.nextLine());
        }

        return wordList;
    }


    public void writeHighscore(Player player, int score) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("highScore.txt",true));

            bufferedWriter.write("Player: "  + player.name + " Score: " + player.score + "\n");
            bufferedWriter.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> readHighScore(String filePath){

        // returnerar en lista från highScores
        ArrayList<String> scoreList = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new FileReader(filePath));

            while (scanner.hasNext()){
            scoreList.add(scanner.nextLine().toUpperCase());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return scoreList;
    }










}
