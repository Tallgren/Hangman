import java.io.IOException;

public class Controller {
    private String wordFile = "src/Words.txt";
    public Controller() throws IOException {
        FileHandler fh = new FileHandler();

        fh.writeHighscore("Robin",999);
        System.out.println(fh.generateWord(wordFile));
    }
}
