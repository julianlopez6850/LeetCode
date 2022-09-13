class Solution {
    public int longestValidParentheses(String s) {
        
        int opened = 0;
        int curr = 0;
        int longest = 0;
        
        
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                if(s.charAt(j) == '(')
                {
                    opened++;
                    curr++;
                }
                else if(opened > 0)
                {
                    opened--;
                    curr++;
                    if(opened == 0)
                        longest = (curr > longest) ? curr : longest;
                }
                else
                    curr = 0;
            }
            curr = 0;
            opened = 0;
        }
        return longest;
    }
}