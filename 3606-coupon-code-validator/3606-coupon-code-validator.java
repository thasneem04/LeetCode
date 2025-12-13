import java.util.*;

class Solution {
    public List<String> validateCoupons(
            String[] code,
            String[] businessLine,
            boolean[] isActive
    ) {
        
        // Business line priority
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<String[]> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            // 1. Active check
            if (!isActive[i]) continue;

            // 2. Code validation
            if (code[i] == null || code[i].length() == 0) continue;
            if (!code[i].matches("^[a-zA-Z0-9_]+$")) continue;

            // 3. Business line validation
            if (!priority.containsKey(businessLine[i])) continue;

            validCoupons.add(new String[]{businessLine[i], code[i]});
        }

        // Sorting
        Collections.sort(validCoupons, (a, b) -> {
            int cmp = priority.get(a[0]) - priority.get(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        // Extract only codes
        List<String> result = new ArrayList<>();
        for (String[] coupon : validCoupons) {
            result.add(coupon[1]);
        }

        return result;
    }
}
