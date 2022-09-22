class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int answer[] = new int[queries.length];
        int even = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0)
                even += nums[i];
        }
        for(int i = 0; i < queries.length; i++)
        {
            int index = queries[i][1];
            
            if(nums[index] % 2 == 0)
                even -= nums[index];
            
            nums[index] += queries[i][0];
            
            if(nums[index] % 2 == 0)
                even += nums[index];
            
            answer[i] = even;
        }
        return answer;
    }
}