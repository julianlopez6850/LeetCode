class Solution {
    public String convert(String s, int numRows) {
        
        String result = "";
        
        String[] stringList = new String[numRows];
        
        for(int i = 0; i < numRows; i++)
            stringList[i] = "";
        
        int currRow = 0;
        boolean isRowIncreasing = true;

        for(int i = 0; i < s.length(); i++)
        {
            stringList[currRow] += s.charAt(i);
            
            if(numRows > 1)
            {
                if(isRowIncreasing)
                    currRow++;
                else
                    currRow--;
            }
            if((!isRowIncreasing && currRow == 0) || (isRowIncreasing && currRow == numRows - 1))
                isRowIncreasing = !isRowIncreasing;
        }
        
        for(int i = 0; i < stringList.length; i++)
            result += stringList[i];
        return result;
    }
}