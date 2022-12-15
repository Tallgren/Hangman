import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler {

    public String generateWord(String file) throws IOException {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()){
            wordList.add(scanner.nextLine());
        }
        Collections.shuffle(wordList);

        return wordList.get(0);
    }


    public void writeHighscore(String name, int score){

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Scores",true));

            bufferedWriter.write("Player: "  + name + " Score: " + score + "\n");
            bufferedWriter.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }







}
