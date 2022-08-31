class Solution {
    public int maxArea(int[] height) {
        
        int mostStorage = 0;
        int currStorage = 0;
        
        for(int i = 0; i < height.length; i++)
        {
            while(height[i] <= mostStorage/(height.length - i))
            {
                if(i == height.length - 1)
                    break;
                i++;
            }
            for(int j = i + 1; j < height.length ; j++)
            {
                if(height[i] > height[j])
                    currStorage = (j - i) * (height[j]);
                else
                    currStorage = (j - i) * (height[i]);
                
                if(currStorage > mostStorage)
                    mostStorage = currStorage;
            }
        }
        return mostStorage;
    }
}