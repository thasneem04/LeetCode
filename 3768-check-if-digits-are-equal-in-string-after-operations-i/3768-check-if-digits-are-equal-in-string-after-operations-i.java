class Solution {
    public boolean hasSameDigits(String s) {
        
        int iteration = 0;
        char[] ch = s.toCharArray();

        while(ch.length - iteration != 2)
        {
            for(int i=0;i<ch.length -1- iteration;i++)
            {
                ch[i] = (char)(((ch[i] - '0') + (ch[i+1] - '0')) % 10 +'0');
            }
            iteration++;
        }
        return ch[0] == ch[1];
    }
}