class Solution {
    public String convert(String s, int numRows) {
        
        String result = "";
        
        List<String> stringList = new ArrayList<String>();
        
        for(int i = 0; i < numRows; i++)
        {
            stringList.add("");
        }
        
        int currRow = 0;
        boolean isRowIncreasing = true;

        for(int i = 0; i < s.length(); i++)
        {
            stringList.set(currRow, stringList.get(currRow) + s.charAt(i));
            
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
        
        for(int i = 0; i < stringList.size(); i++)
        {
            result += stringList.get(i);
        }
        return result;
    }
}