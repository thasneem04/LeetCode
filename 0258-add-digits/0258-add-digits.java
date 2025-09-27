class Solution {
    public int addDigits(int num) {
        int sum=0;
        if(num==0){
            return 0;
        }
        else{
            while(num>0){
                int d=num%10;
                sum=sum+d;
                num=num/10;
            }
        }
        if(sum>=10){
            return addDigits(sum);
             }
         return sum;
    }
}