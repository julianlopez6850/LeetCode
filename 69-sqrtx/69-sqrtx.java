class Solution {
    public int mySqrt(int x) {
        for(int i = 0; i < 46341; i++)  // 46341 is the maximum sqrt
        {
            if(i * i > x)
                return i - 1;
        }
        return 46340;
    }
}