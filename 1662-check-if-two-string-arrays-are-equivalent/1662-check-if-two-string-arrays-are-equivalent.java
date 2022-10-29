class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        int l = 0;
        for(int i = 0, j = 0; i < word1.length; i++)
        {
            for(int k = 0; k < word1[i].length(); k++, l++)
            {
                if(j == word2.length)
                    return false;
                if(word1[i].charAt(k) != word2[j].charAt(l))
                    return false;
                if(l == word2[j].length() - 1)
                {
                    l = -1;
                    j++;
                }
            }
        }
        l = 0;
        for(int i = 0, j = 0; i < word2.length; i++)
        {
            for(int k = 0; k < word2[i].length(); k++, l++)
            {
                if(j == word1.length)
                    return false;
                if(word2[i].charAt(k) != word1[j].charAt(l))
                    return false;
                if(l == word1[j].length() - 1)
                {
                    l = -1;
                    j++;
                }
            }
        }
        return true;
    }
}