class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        String currString = "";
        String longest = "";
        
        int currStringStartIndex = 0;
        int repeatCharIndex = 0;
        
        
        for(int i = 0; i < s.length(); i++)
        {
            if(currString.contains(Character.toString(s.charAt(i))))
                currString = currString.substring(currString.indexOf(s.charAt(i)) + 1);
            
            currString += s.charAt(i);

            if(currString.length() > longest.length())
            {
                longest = currString;
            }
        }
        return longest.length();
    }
}