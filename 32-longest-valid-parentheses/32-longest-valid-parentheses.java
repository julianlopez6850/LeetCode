class Solution {
    public int longestValidParentheses(String s) {
        
        int opened = 0;
        int curr = 0;
        int longest = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                if(opened == -1)
                    opened = 1;
                else
                    opened++;
            }
            else if(opened <= 0)
            {
                opened = -1;
                curr = 0;
            }
            else
            {
                opened--;
                curr += 2;
                if(opened == 0)
                    longest = (curr > longest) ? curr : longest;
            }
        }
        
        opened = curr = 0;
            
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) == ')')
            {
                if(opened == -1)
                    opened = 1;
                else
                    opened++;
            }
            else if(opened <= 0)
            {
                opened = -1;
                curr = 0;
            }
            else
            {
                opened--;
                curr += 2;
                if(opened == 0)
                    longest = (curr > longest) ? curr : longest;
            }
        }
        
        return longest;
    }
}