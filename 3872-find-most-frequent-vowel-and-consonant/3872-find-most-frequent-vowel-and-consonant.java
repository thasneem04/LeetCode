class Solution {
    public int maxFreqSum(String s) {
       int []farr=new int [26];
       for(int i=0;i<s.length();i++){
        farr[s.charAt(i)-'a']++;
       }
       int maxvowel=0;
       int maxcons=0;
       for(int i=0;i<26;i++){
        if(i==0 || i==4 ||i==8 || i==14 ||i==20){
            maxvowel=Math.max(farr[i],maxvowel);
        }
        else{
             maxcons=Math.max(farr[i],maxcons);
        }
       }
         return maxvowel+maxcons;
    }
}