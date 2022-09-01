class Solution {
    public int mySqrt(int x) {
        for(int i = mySqrtHelper(x, 1); i < 46341; i++)
        {
            if(i * i > x)
                return i - 1;
        }
        return 46340;
    }
    
    public int mySqrtHelper(double x, int sqrt)
    {
        if(x / 9 > 1)
        {
            sqrt *= 3;
            return mySqrtHelper(x / 9, sqrt);
        }
        if(x / 4 > 1)
        {
            sqrt *= 2;
            return mySqrtHelper(x / 4, sqrt);
        }
        return (int)(sqrt);
    }
}