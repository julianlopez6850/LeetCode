class Solution {
    public String convert(String s, int numRows) {
        
        String result = "";
        
        String[] stringList = new String[numRows];
        
        for(int i = 0; i < numRows; i++)
            stringList[i] = "";
        
        int currRow = 0;
        int rowStep = 1;

        for(int i = 0; i < s.length(); i++)
        {
            stringList[currRow] += s.charAt(i);
            
            if(numRows > 1)
                currRow += rowStep;
            if((rowStep == -1 && currRow == 0) || (rowStep == 1 && currRow == numRows - 1))
                rowStep *= -1;
        }
        
        for(int i = 0; i < stringList.length; i++)
            result += stringList[i];
        return result;
    }
}