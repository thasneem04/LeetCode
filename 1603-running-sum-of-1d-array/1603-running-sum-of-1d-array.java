class Solution {
    public int[] runningSum(int[] nums) {
        for(int first=1; first<nums.length; first++)
        {
            nums[first] = nums[first-1] + nums[first];
        }
        return nums;
    }
}