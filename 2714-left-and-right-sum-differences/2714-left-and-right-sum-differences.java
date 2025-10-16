class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int i : nums) 
            total += i;
        int[] ans = new int[nums.length];
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            int tempTotal = total - nums[i];
            int right = tempTotal - left;
            if (right >= left)
                ans[i] = right - left;
            else
                ans[i] = left - right;
            left += nums[i]; 
        }
        return ans;
    }
}