import java.util.*;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> countMap = new HashMap<>();

        // count words in s1
        for (String w : s1.split(" ")) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }

        // count words in s2
        for (String w : s2.split(" ")) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }

        // collect uncommon words (count == 1)
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        // convert to array and return
        return result.toArray(new String[0]);
    }
}
