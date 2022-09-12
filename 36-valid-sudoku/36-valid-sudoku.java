class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    for(int k = i + 1, l = j + 1; k < 9 || l < 9; k++, l++)
                    {
                        if(k <= 8)
                            if(board[i][j] == board[k][j])
                            {
                                return false;
                            }
                        if(l <= 8)
                            if(board[i][j] == board[i][l])
                            {
                                return false;
                            }
                    }
                    
                    int box_i = (i / 3) * 3;
                    int box_j = (j / 3) * 3;
                    
                    for(int k = box_i; k < box_i + 3;k++)
                    {
                        for(int l = box_j; l < box_j + 3; l++)
                        {
                            if(i != k || j != l)
                            {
                                if(board[i][j] == board[k][l])
                                    return false;
                            }
                        }
                    }
                    
                }
            }
        }
        return true;
    }
}