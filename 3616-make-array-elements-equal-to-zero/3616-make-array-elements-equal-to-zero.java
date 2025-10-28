class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int validCount = 0;
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
             
                leftSum += nums[i];
            } else {
               
                int rightSum = totalSum - leftSum;   

              
                if (leftSum == rightSum) {
                    
                    validCount += 2;
                } else if (Math.abs(leftSum - rightSum) == 1) {
                    
                    validCount += 1;
                }
                
            }
        }

        return validCount;
    }
}
