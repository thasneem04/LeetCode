class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] extra = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length && k < 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    extra[k++] = nums[i];
                    break; 
                }
            }
        }
        return extra;
    }
}