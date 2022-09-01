class Solution {
    public double myPow(double x, int n) {
        if(x == 1)
            return 1;
        if(x == -1)
            if(n % 2 == 0)
                return 1;
            else
                return -1;
        if(n == 0)
            return 1;
        if(n < -10000)
            return 0;
        if(n < 0)
            x = 1 / x;
        return myPowHelper(x, n);
    }
    public double myPowHelper(double x, int n) 
    {
        if(n > 0)
        {
            if(n == 1)
                return x;
            if(n % 2 == 0)
                return myPowHelper(x * x, n / 2);
            else
                return myPowHelper(x * x, n / 2) * x;
        }
        else
        {
            if(n == -1)
                return x;
            if(n % 2 == 0)
                return myPowHelper(x * x, n / 2);
            else
                return myPowHelper(x * x, n / 2) * x;
        }
    }
}