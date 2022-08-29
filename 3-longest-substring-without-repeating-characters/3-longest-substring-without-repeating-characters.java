class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        String currString = "";
        String longest = "";
        
        
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                if(!currString.contains(Character.toString(s.charAt(j))))
                    currString += s.charAt(j);
                else
                {
                    currString = "";
                    break;
                }
                
                if(currString.length() > longest.length())
                {
                    longest = currString;
                }
            }
        }
        
        return longest.length();
    }
}