class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        int i=1;
        int index=0;

        Arrays.sort(nums);

        while(index<nums.length)
        {
          int target = k*i;

          if(nums[index] == target)
          {
            i++;
            index++;
          }
          else if(nums[index]<target)
          {
            index++;
          }
          else{
            return target;
          }
        }
           return k*i;
    }
}