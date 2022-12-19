

public class Word {
    String hiddenWord;

    char[] characters;

    public Word(String hiddenWord) {

        this.hiddenWord = hiddenWord;
    }

    public char[] getHiddenWordAsArray() {
        return characters = hiddenWord.toCharArray();
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}
