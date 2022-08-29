class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int indeces[] = new int[2];
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    indeces[0] = i;
                    indeces[1] = j;
                    break;
                }
            }
            
        }
        return indeces;
    }
}