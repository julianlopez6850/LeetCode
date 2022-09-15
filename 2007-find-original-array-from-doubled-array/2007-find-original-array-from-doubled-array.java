class Solution {
    public int[] findOriginalArray(int[] changed)
    {
        if(changed.length % 2 == 1)
            return new int[0];
        
        int result[] = new int[changed.length / 2];
        int resIndex = 0;
        int prevDoubleIndex = 0;
        
        Arrays.sort(changed);
        
        for(int i = 0; i < changed.length; i++)
        {
            if(changed[i] != -1)
            {
                for(int j = (i > prevDoubleIndex) ? i + 1 : prevDoubleIndex + 1; j < changed.length; j++)
                {
                    if(changed[j] == changed[i] * 2)
                    {
                        result[resIndex++] = changed[i];
                        if(resIndex == result.length)
                            return result;
                        changed[j] = -1;
                        prevDoubleIndex = j;
                        break;
                    }
                    else if(j == changed.length - 1)
                        return new int[0];
                }
            }
        }
        if(resIndex != result.length)
            return new int[0];
        return result;
    }
}