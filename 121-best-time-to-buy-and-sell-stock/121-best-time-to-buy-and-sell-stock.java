class Solution {
    public int maxProfit(int[] prices) {
        int currLeast = prices[0];
        int bestProfit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < currLeast)
                currLeast = prices[i];
            else
                bestProfit = (prices[i] - currLeast > bestProfit) ? prices[i] - currLeast : bestProfit;
        }
        return bestProfit;
    }
}