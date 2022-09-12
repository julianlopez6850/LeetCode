class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        if(tokens.length == 0)
            return 0;
        
        int result = 0;
        
        // sort tokens in ascending order using quicksort algorithm.
        quickSort(tokens, 0, tokens.length - 1);
        
        for(int i = 0, j = 1; i + j <= tokens.length;)
        {
            if(tokens[i] <= power)
            {
                power -= tokens[i];
                i++;
                result++;
            }
            else if(result > 0 && i + j != tokens.length)
            {
                power += tokens[tokens.length - j];
                j++;
                result--;
            }
            else
                break;
        }
        
        return result;
    }
    
    public void quickSort(int[] arr, int start, int end)
    {
        if(start < end)
        {
            int pivot = arr[end];
            int i = start - 1;
            
            for(int j = start; j < end; j++)
            {
                if(arr[j] < pivot)
                {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = temp;
            quickSort(arr, start, i);
            quickSort(arr, i + 2, end);
        }
    }
    
}