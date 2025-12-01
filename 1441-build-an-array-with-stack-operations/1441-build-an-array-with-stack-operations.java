class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();

        int targetIndex = 0;

        for(int i=1;i<=n;i++)
        {
            result.add("Push");


            if(i==target[targetIndex])
            {
                targetIndex++;


                if(targetIndex==target.length)
                {
                    break;
                }
            }
            else{
                result.add("Pop");
            }
        }
        return result;
    }
}