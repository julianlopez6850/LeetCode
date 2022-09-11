class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k)
    {
        // Create a 2D int array, engineers,
        // - engineers[i][0] is the i-th engineers' efficiency,
        // - engineers[i][1] is the i-th engineers' speed.
        int[][] engineers = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        
        // sort engineers by their efficiency in descending order using a quickSort algorithm.
        // (we will begin by testing the performance of the team using the highest-efficiency engineers)
        quickSort(engineers, 0, n - 1);
        
        // this priority queue will hold the highest speeds among the engineers that have been tested on the team
        PriorityQueue<Integer> highestSpeeds = new PriorityQueue<>(k);
        
        long teamSpeed = 0, currPerformance = 0, maxPerformance = 0;
        
        for(int i = 0; i < n; i++)
        {
            // if new engineer would be the (k + 1)-th on the team, remove the lowest speed engineer currently on the team.
            if(highestSpeeds.size() >= k)
                teamSpeed -= highestSpeeds.remove();
            
            // add i-th speed to the team, and the highestSpeeds priority queue
            highestSpeeds.add(engineers[i][1]);
            teamSpeed += engineers[i][1];
            
            // compare the current performance to the max performance thus far, update maxPerformance accordingly.
            currPerformance = teamSpeed * engineers[i][0];
            maxPerformance = (currPerformance > maxPerformance) ? currPerformance : maxPerformance;
        }
        
        return (int)(maxPerformance % 1000000007);  // return maxPerformance modulo 10^9 + 7
    }
    
    public void quickSort(int[][] arr, int start, int end) 
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
            quickSort(arr, start, i);
            quickSort(arr, i + 2, end);
        }
    }
}