import java.util.ArrayList;

public class Words {
    private ArrayList<String> words = new ArrayList<String>();

    public void collectWord(String s) {
        words.add(s);
    }

    public String randomWord() {
        int x = (int)(Math.random() * words.size());
        return words.get(x);
    }
}
