class Solution {
    public int differenceOfSum(int[] nums) {

        int element_sum = 0;
        int digit_sum = 0;
        int d =0;

        for(int i=0;i<nums.length;i++)
        {
            element_sum+=nums[i];
        }
        
        for(int i=0;i<nums.length;i++)
        {
            int val = nums[i];
            while(val > 0) {
                digit_sum += val % 10;
                val /= 10;
            }
        }
        
        return element_sum - digit_sum;
        
    }
}

