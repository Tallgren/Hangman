import java.io.*;
import java.util.ArrayList;
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


    public void writeHighscore(Player player, int score){

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Scores",true));

            bufferedWriter.write("Player: "  + player.name + " Score: " + player.score + "\n");
            bufferedWriter.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }







}
