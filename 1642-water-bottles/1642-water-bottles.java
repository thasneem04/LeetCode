class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinked = 0;
        int empty_bottles = 0; 
        
        while (numBottles > 0) {
            drinked += numBottles;
             empty_bottles  += numBottles;       
            
            numBottles =  empty_bottles  / numExchange; 
             empty_bottles  =  empty_bottles  % numExchange;         
        }
        return drinked;
    }
}