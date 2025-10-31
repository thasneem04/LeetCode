class Solution {
    public int[][] largestLocal(int[][] grid) {
        int [][] result = new int[grid.length-2][grid.length-2];

        for(int i =0; i <result.length; i++){
            for(int j =0; j<result.length ; j++){
                int lastrow = i+2;
                int lastcol = j+2;
                int max =0;
                for(int startrow=i; startrow<=lastrow; startrow++){
                    for(int startcol = j; startcol <= lastcol; startcol++){
                        if(grid[startrow][startcol]>max) max = grid[startrow]
                        [startcol];
                    }
                }
                result[i][j]=max;
            }
        }
        return result;
    }
}