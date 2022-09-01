class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[][] list = new int[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 || j == 0)
                    list[i][j] = 1;
                else
                    list[i][j] = list[i-1][j] + list[i][j-1];
            }
        }
        return list[m-1][n-1];
    }
}