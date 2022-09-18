class Solution {
    public int trap(int[] height) {
        
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftSide[] = new int[height.length];
        int rightSide[] = new int[height.length];
        int min = 0;
        
        for(int i = 0; i < height.length; i++)
        {
            if(height[i] > leftMax)
                leftMax = height[i];
            if(height[height.length - 1 - i] > rightMax)
                rightMax = height[height.length - 1 - i];
            
            leftSide[i] = leftMax;
            rightSide[height.length - 1 - i] = rightMax;
        }
        
        for(int i = 0; i < height.length; i++)
        {
            min = ((leftSide[i] > rightSide[i]) ? rightSide[i] : leftSide[i]);
            if(min != 0 && height[i] < min)
                result += min - height[i];
        }
        return result;
    }
}