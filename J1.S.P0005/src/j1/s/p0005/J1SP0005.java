package j1.s.p0005;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0005 {

    private String words;

    public J1SP0005() {

    }

    public void inputWords(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        words = scanner.nextLine();
    }

    public String getWords() {
        return words;
    }

    private void displayWords(HashMap<String, Integer> wordCount) {
        System.out.println(wordCount);
    }

    private void displayCharacter(HashMap<Character, Integer> characterCount) {
        System.out.println(characterCount);
    }

    public static void main(String[] args) {
        J1SP0005 obj = new J1SP0005();
        obj.inputWords("Enter your content: ");

        Counter counter = new Counter(obj.getWords());
        obj.displayWords(counter.wordCount());
        obj.displayCharacter(counter.characterCount());
    }
}
