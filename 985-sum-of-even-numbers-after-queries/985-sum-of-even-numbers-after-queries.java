class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int answer[] = new int[queries.length];
        int numBeforeQuery = 0;
        Boolean before = false, after = false;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0)
                answer[0] += nums[i];
        }
        
        for(int i = 0; i < queries.length; i++)
        {
            numBeforeQuery = nums[queries[i][1]];
            
            if(nums[queries[i][1]] % 2 == 0)
                before = true;
            
            nums[queries[i][1]] = nums[queries[i][1]] + queries[i][0];
            
            if(nums[queries[i][1]] % 2 == 0)
                after = true;
            
            if(before == true && after == true)
                answer[i] += nums[queries[i][1]] - numBeforeQuery;
            else if(before == true)
                answer[i] -= numBeforeQuery;
            else if(after == true)
                answer[i] += nums[queries[i][1]];
            
            if(i + 1 != queries.length)
                answer[i+1] = answer[i];
            
            before = after = false;
        }
        return answer;
    }
}