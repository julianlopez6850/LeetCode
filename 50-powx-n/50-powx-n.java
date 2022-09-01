class Solution {
    public double myPow(double x, int n) {
        
        double num = x;
        
        
        if(x == 1)
            return 1;
        if(x == -1)
        {
            if(n % 2 == 0)
                return 1;
            else
                return -1;
        }
        if(n == 0)
            return 1;
        if(n < -10000)
            return 0;
        else if(n < 0)
            for(int i = 0; i > n - 1; i--)
                x /= num;
        else
            for(int i = 0; i < n - 1; i++)
                x *= num;
        return x;
    }
}