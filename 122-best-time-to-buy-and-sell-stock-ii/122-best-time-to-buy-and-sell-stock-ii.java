class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int boughtPrice = -1;
        
        if(prices.length == 1)
            return 0;
        for(int i = 0; i < prices.length - 1; i++)
        {
            if(prices[i + 1] > prices[i])
            {
                if(boughtPrice == -1)
                {
                    boughtPrice = prices[i];
                    profit -= boughtPrice;
                }
            }
            else if(boughtPrice != -1)
            {
                profit += prices[i];
                boughtPrice = -1;
            }
            if(i == prices.length - 2 && boughtPrice != -1)
                profit += prices[i + 1];
        }
        return profit;
    }
}