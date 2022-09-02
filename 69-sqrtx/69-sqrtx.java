class Solution {
    
    
    
    public int mySqrt(int x)
    {
        int startIndex = 0;
        int endIndex = 46341;
        
        while(true)
        {
            if(endIndex - startIndex == 1)
                return startIndex;
            int midIndex = endIndex - (endIndex - startIndex) / 2;
            if(midIndex * midIndex > x)
                endIndex = midIndex;
            else
                startIndex = midIndex;
        }
    }
}