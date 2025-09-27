class Solution {
    public boolean isPalindrome(int x) {




        int original = x;
        int rem = 0;
    while(x>0)
    {
       int m = x%10;
       rem = rem*10+m;
       x/=10;
       
    }
    return original == rem;    
        
    }
}