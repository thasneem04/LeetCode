class Solution {
    public int minOperations(int[] nums, int k) {

        int sum =0;
        for(int x:nums)
        {
            sum = sum +x;
        }
        return sum%k;
    }
}