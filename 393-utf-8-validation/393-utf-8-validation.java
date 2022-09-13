class Solution {
    public boolean validUtf8(int[] data) 
    {
        for(int i = 0; i < data.length; i++)
        {
            int j = 0;
            
            if(data[i] > 127) // check if data[i] != 0xxxxxxx
            {
                if(data[i] >= 192 && data[i] <= 223) // check if data[i] = 110xxxxx
                    j = 1;
                
                else if(data[i] >= 224 && data[i] <= 239) // check if data[i] = 1110xxxx
                    j = 2;
                
                else if(data[i] >= 240 && data[i] <= 247) // check if data[i] = 11110xxx
                    j = 3;
                
                else                        // if none of the above cases are met, return false.
                    return false;
                
                if(i + j >= data.length)    // if there are not at least j more elements in data[] after the current one, return false.
                    return false;
            
                // check if the next j elements in data[] = 10xxxxxx
                for(int k = j; k > 0; k--)
                    if(!(data[i + k] >= 128 && data[i + k] <= 191))
                        return false;
                
                i += j;
            }
        }
        return true;
    }
}