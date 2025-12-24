class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        int total = 0;
        int count = 0;

        for(int a : apple)
        {
            total+=a;
        }


        Arrays.sort(capacity);

        for(int i=capacity.length-1;i>=0;i--)
        {
            total-=capacity[i];
            count++;

            if(total <=0)
            {
                return count;
            }
        }

        return count;
        
    }
}