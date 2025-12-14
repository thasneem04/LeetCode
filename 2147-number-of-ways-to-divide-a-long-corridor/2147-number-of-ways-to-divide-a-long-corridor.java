class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        int seatCount = 0;

        // Count total seats
        for (char c : corridor.toCharArray()) {
            if (c == 'S') seatCount++;
        }

        // Invalid cases
        if (seatCount == 0 || seatCount % 2 != 0) return 0;
        if (seatCount == 2) return 1;

        long ways = 1;
        int seatsSeen = 0;
        int plants = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatsSeen++;

                // When we reach the first seat of the next pair
                if (seatsSeen > 2 && seatsSeen % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else if (seatsSeen >= 2 && seatsSeen % 2 == 0) {
                // Count plants only between seat pairs
                plants++;
            }
        }

        return (int) ways;
    }
}
