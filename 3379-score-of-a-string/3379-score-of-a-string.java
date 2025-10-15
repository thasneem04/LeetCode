class Solution {
    public int scoreOfString(String s) {

        if(s.length()==0)
        {
            return 0;
        }
        int sum = 0;
        for(int i=0;i<s.length()-1;i++)
        {
          sum = sum +( Math.abs ((s.charAt(i) - s.charAt(i+1))));
        }

        return sum;
        
    }
}