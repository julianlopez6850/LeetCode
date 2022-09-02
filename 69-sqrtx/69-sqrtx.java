class Solution {
    public int mySqrt(int x)
    {
        return mySqrtHelper(x, 0, 46341);
    }
    
    public int mySqrtHelper(double x, int startIndex, int endIndex)
    {
        if(endIndex - startIndex == 1)
            return startIndex;
        int midIndex = endIndex - (endIndex - startIndex) / 2;
        if(midIndex * midIndex > x)
            return mySqrtHelper(x, startIndex, midIndex);
        else
            return mySqrtHelper(x, midIndex, endIndex);
    }
}