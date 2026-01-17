class Solution {
    public int mirrorDistance(int n) {
        
        int rev =0;
        int temp=n;
        int sum =0;
        while(n>0)
        {
          sum = n%10;
          rev=rev*10+sum;
          n=n/10;
        }
        int res = Math.abs(temp-rev);

        return res;

        
    }
}