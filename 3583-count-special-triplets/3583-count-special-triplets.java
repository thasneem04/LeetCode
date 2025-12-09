class Solution {
    public int specialTriplets(int[] nums) {
        long MOD = 1000000007;
        int n = nums.length;

        Map<Integer, Integer> rightCount = new HashMap<>();
        Map<Integer, Integer> leftCount = new HashMap<>();

        // Step 1: All numbers initially on the right side
        for (int num : nums) {
            rightCount.put(num, rightCount.getOrDefault(num, 0) + 1);
        }

        long result = 0;

        // Step 2: Iterate each index as middle
        for (int j = 0; j < n; j++) {
            int mid = nums[j];

            // Remove current from right (middle is not right side anymore)
            rightCount.put(mid, rightCount.get(mid) - 1);

            long left = 0, right = 0;
            int doubleVal = mid * 2;

            // Check left side doubles
            if (leftCount.containsKey(doubleVal)) {
                left = leftCount.get(doubleVal);
            }

            // Check right side doubles
            if (rightCount.containsKey(doubleVal)) {
                right = rightCount.get(doubleVal);
            }

            result = (result + (left * right) % MOD) % MOD;

            // Add current to left side
            leftCount.put(mid, leftCount.getOrDefault(mid, 0) + 1);
        }

        return (int) result;
    }
}
