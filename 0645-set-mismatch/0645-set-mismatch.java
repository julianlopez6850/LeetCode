class Solution {
    public int[] findErrorNums(int[] nums) {
        int numsPresent[] = new int[nums.length];
        int repeated = 0, missing = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            numsPresent[nums[i] - 1]++;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(numsPresent[i] == 2)
                repeated = i + 1;
            else if(numsPresent[i] == 0)
                missing = i + 1;
        }
        return new int[] {repeated, missing};
    }
}