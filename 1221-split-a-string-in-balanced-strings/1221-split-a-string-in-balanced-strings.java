class Solution {
    public int balancedStringSplit(String s) {
        // res: counts the number of balanced splits found.
        int res = 0;
        // count: tracks the current balance of 'R' (+1) vs 'L' (-1).
        int count = 0;
        
        // Loop through the entire string.
        for (int i = 0; i < s.length(); i++) {
            // 'R' increases the balance.
            if (s.charAt(i) == 'R') {
                count++;
            }
            // 'L' decreases the balance.
            else {
                count--;
            }
            
            // If balance is 0, we just finished a balanced segment.
            if (count == 0) {
                res++; // Count this split.
            }
        }
        
        // Return the total number of splits.
        return res;
    }
}