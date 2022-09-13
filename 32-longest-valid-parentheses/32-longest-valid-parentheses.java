class Solution {
    public int longestValidParentheses(String s) {
        
        int opened = 0;
        int curr = 0;
        int longest = 0;
        
        int[] sValue = new int[s.length()];
        
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) == ')' && s.charAt(i - 1) == '(')
            {
                if(i - 2 > 0)
                    sValue[i] = sValue[i - 2] + 2;
                else
                    sValue[i] = 2;
            }
            else if(s.charAt(i) == ')' && s.charAt(i - 1) == ')')
            {
                if(i - sValue[i - 1] - 1 >= 0 && s.charAt(i - sValue[i - 1] - 1) == '(')
                {
                    if(i - sValue[i - 1] - 2 > 0)
                        sValue[i] = sValue[i - 1] + sValue[i - sValue[i - 1] - 2] + 2;
                    else
                        sValue[i] = sValue[i - 1] + 2;
                }
            }
            
            if(sValue[i] > longest)
                longest = sValue[i];
        }
        return longest;
    }
}