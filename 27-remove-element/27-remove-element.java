class Solution {
    public int removeElement(int[] nums, int val) {
        
        if(val > 50)
            return nums.length;
        
        int counter = 0;
        int temp = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == val)
                counter++;
            else if(counter > 0)
            {
                temp = nums[i];
                nums[i] = nums[i - counter];
                nums[i - counter] = temp;
            }
        }
        return nums.length - counter;
    }
}