class Solution {
    public String reverseWords(String s) {
        
        StringBuilder currStr = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ')
            {
                for(int j = currStr.toString().length() - 1; j >= 0; j--)
                {
                    result.append(currStr.toString().charAt(j));
                }
                result.append(" ");
                currStr.setLength(0);
            }
            else
            {
                currStr.append(s.charAt(i));
                if(i == s.length() - 1)
                {
                    for(int j = currStr.toString().length() - 1; j >= 0; j--)
                    {
                        result.append(currStr.toString().charAt(j));
                    }
                }
            }
        }
        
        
        return result.toString();
    }
}