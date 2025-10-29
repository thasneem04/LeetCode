class Solution {
    public int smallestNumber(int n) {

        // Step 1: Find how many bits are needed to represent 'n' in binary
        // Example: n = 10 → binary = 1010 → needs 4 bits
        int k = Integer.SIZE - Integer.numberOfLeadingZeros(n);

        // Step 2: Compute (1 << k) - 1  → this gives 2^k - 1
        // Example: (1 << 4) = 16 → (1 << 4) - 1 = 15 (binary 1111)
        int ans = (1 << k) - 1;

        // Step 3: If ans is smaller than n, we need the next higher all-ones number
        // Example: n = 17 → bitLength = 5 → (1<<5)-1 = 31 → ok
        // But if n = 16 → bitLength = 5 → ans = 31 → ok
        // Just in case, check the condition
        if (ans < n) {
            k++; // increase bit count
            ans = (1 << k) - 1; // recompute
        }

        // Step 4: Return the final smallest all-set-bit number ≥ n
        return ans;
    }
}
