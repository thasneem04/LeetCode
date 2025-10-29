import java.util.*;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        // Step 1: Combine both sentences
        String combined = s1 + " " + s2;

        // Step 2: Split the combined sentence into words
        String[] words = combined.split(" ");

        // Step 3: Create a HashMap to count each word
        Map<String, Integer> count = new HashMap<>();

        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        // Step 4: Collect words that appear only once
        List<String> result = new ArrayList<>();

        for (String w : count.keySet()) {
            if (count.get(w) == 1) {
                result.add(w);
            }
        }

        // Step 5: Convert list to array and return
        return result.toArray(new String[0]);
    }
}
