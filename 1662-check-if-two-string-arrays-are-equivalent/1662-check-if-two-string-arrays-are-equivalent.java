class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder combined1 = new StringBuilder();
        StringBuilder combined2 = new StringBuilder();
        
        for(String i : word1)
        {
            combined1.append(i);
        }
        for(String i : word2)
        {
            combined2.append(i);
        }
        if(combined1.toString().equals(combined2.toString()))
            return true;
        return false;
    }
}