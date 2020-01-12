package j1.s.p0005;

import java.util.HashMap;

/**
 *
 * @author tangminhtin
 */
public class Counter {

    private String words;

    public Counter(String words) {
        this.words = words;
    }

    public HashMap<String, Integer> wordCount() {
        // Creating a HashMap containing char as a key and occurrences as a value
        HashMap<String, Integer> charCountMap = new HashMap<String, Integer>();

        // checking each char of strArray
        for (String c : words.split(" ")) {
            if (!c.contains(" ")) {
                if (charCountMap.containsKey(c)) {
                    // If char 'c' is present in charCountMap, incrementing it's count by 1
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    // If char 'c' is not present in charCountMap, 
                    // putting 'c' into charCountMap with 1 as it's value
                    charCountMap.put(c, 1);
                }
            }
        }

        return charCountMap;    // Return inputString and charCountMap 
    }

    public HashMap<Character, Integer> characterCount() {
        // Creating a HashMap containing char as a key and occurrences as a value
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        // checking each char of strArray
        for (char c : words.toCharArray()) {
            if (c != ' ') {
                if (charCountMap.containsKey(c)) {
                    // If char 'c' is present in charCountMap, incrementing it's count by 1
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    // If char 'c' is not present in charCountMap, 
                    // putting 'c' into charCountMap with 1 as it's value
                    charCountMap.put(c, 1);
                }
            }
        }

        return charCountMap;    // Return inputString and charCountMap 
    }
}
