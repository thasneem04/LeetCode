// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         int start = 0 ,mid = n,index = 0;
//         int[] ans = new int[nums.length];
        
//         while(mid<nums.length)
//         {
//             ans[index++] = nums[start++];
//             ans[index++] = nums[mid++];
            
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        
        int[] first = new int[n];       // first half
        int[] second = new int[n];      // second half
        
        // split nums into two arrays
        for(int i=0; i<n; i++) {
            first[i] = nums[i];
            second[i] = nums[i+n];
        }
        
        // combine alternately
        int index = 0;
        for(int i=0; i<n; i++) {
            ans[index++] = first[i];
            ans[index++] = second[i];
        }
        
        return ans;
    }
}
