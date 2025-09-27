// class Solution {
//     public int differenceOfSums(int n, int m) {
        

//         int num1 = 0;
//         int num2 = 0;
//         for(int i=0;i<=n;i++)
//         {
//             if(i%m!=0){

//               num1 = num1 + i;  
              
//              }
//              else{
//                 num2 = num2 + i;
//              }
//         }
//         return num1 - num2;
        
//     }
// }

public class Solution {
    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int divisibleCount = n / m;
        int divisibleSum = m * divisibleCount * (divisibleCount + 1) / 2;
        return totalSum - 2 * divisibleSum;
    }
}