class Solution {
    public int divide(int dividend, int divisor) {
        
        int counter = 0;
        
        boolean negative = false;
        boolean min = false;
        
        if(divisor == 1)
            return dividend;
        if(dividend == Integer.MIN_VALUE)
        {
            if(divisor == -1)
                return Integer.MAX_VALUE;
            negative = !negative;
            dividend = Integer.MAX_VALUE;
            min = true;
        }
        if(dividend < 0)
        {
            dividend = Math.abs(dividend);
            negative = !negative;
        }
        
        if(divisor == Integer.MIN_VALUE)
        {
            if(min)
                return 1;
            return 0;
        }
        if(divisor < 0)
        {
            divisor = Math.abs(divisor);
            negative = !negative;
        }
        if(divisor == 1)
        {
            if(negative)
                return dividend * -1;
            else
                return dividend;
        }
        if(dividend < divisor)
            return 0;
        while(dividend >= divisor)
        {
            dividend -= divisor;
            counter++;
            if(dividend + 1 - divisor == 0 && min)
            {
                counter ++;
            }
        }
        if(negative)
            counter *= -1;
        
        return counter;
    }
}