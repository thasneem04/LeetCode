class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1000000007L;

        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: one way to partition an empty prefix

        long totalWays = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            int num = nums[right];

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < num)
                maxDeque.pollLast();
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > num)
                minDeque.pollLast();
            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                totalWays = (totalWays - dp[left] + MOD) % MOD;
                left++;
            }

            dp[right + 1] = totalWays;
            totalWays = (totalWays + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
