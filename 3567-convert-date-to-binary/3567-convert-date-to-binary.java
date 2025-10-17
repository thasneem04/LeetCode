class Solution {
    public String convertDateToBinary(String date) {
        
        String[] parts = date.split("-");

        StringBuilder result = new StringBuilder();

        for(int i=0;i<parts.length;i++)
        {
            int number = Integer.parseInt(parts[i]);
            String binary = Integer.toBinaryString(number);

            result.append(binary);

            if(i<parts.length - 1)
            {
                result.append("-");
            }
        }

        return result.toString();
    }
}