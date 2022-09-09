class Solution {
    
    public int numberOfWeakCharacters(int[][] properties) {
        
        quickSortAttack(properties, 0, properties.length - 1);
        
        int weak = 0;
        int prevAttack = properties[0][0];
        boolean attackDown = false;
        int nextMax = properties[0][1];
        int maxDefense = 0;
        
        for(int i = 0; i < properties.length; i++)
        {
            if(properties[i][0] < prevAttack)
                attackDown = true;
            
            if(attackDown == true)
            {
                maxDefense = nextMax;
                attackDown = false;
            }
            
            if(properties[i][1] < maxDefense)
                weak++;
            
            nextMax = Math.max(nextMax, properties[i][1]);
            prevAttack = properties[i][0];
        }
        return weak;
    }
    
    public void quickSortAttack(int[][] arr, int start, int end) 
    {
        if(start < end)
        {
            int pivot = arr[end][0];
            int i = (start - 1);

            for(int j = start; j <= end - 1; j++)
            {
                if (arr[j][0] >= pivot) 
                {
                    i++;
                    int[] temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int[] temp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = temp;
            quickSortAttack(arr, start, i);
            quickSortAttack(arr, i + 2, end);
        }
    }
}