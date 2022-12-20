import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public ArrayList<String> generateWordList(String file) throws IOException {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
            wordList.add(scanner.nextLine());
        }

        return wordList;
    }


    public void writeHighscore(Player player, String filePath) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write("\n" + player.name + " " + player.score);
            bufferedWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> readHighScore(String filePath) {
        String tmp;
        // returnerar en lista från highScores
        ArrayList<String> scoreList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(filePath));

            while (scanner.hasNext()) {
                tmp = scanner.nextLine();
                if (!tmp.isEmpty()) {
                    scoreList.add(tmp.toUpperCase());
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return scoreList;
    }
}
