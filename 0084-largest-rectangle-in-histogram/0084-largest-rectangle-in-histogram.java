class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // If current height is smaller → pop until stack becomes valid
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int poppedIndex = stack.pop(); // POP → we found right boundary
                int height = heights[poppedIndex]; 
                
                // if stack empty → no smaller on left
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            // PUSH always after popping → new possible rectangle
            stack.push(i);
        }

        // Process remaining bars (Right boundary = end of array)
        while (!stack.isEmpty()) {

            int poppedIndex = stack.pop();
            int height = heights[poppedIndex];

            int width = stack.isEmpty() ? n : (n - stack.peek() - 1);

            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
