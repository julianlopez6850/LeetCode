class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    // check rows and columns
                    for(int k = i + 1, l = j + 1; k < 9 || l < 9; k++, l++)
                    {
                        // check row
                        if(k <= 8 && board[i][j] == board[k][j])
                            return false;
                        //check column
                        if(l <= 8 && board[i][j] == board[i][l])
                            return false;
                    }
                    
                    // check 3x3 boxes
                    int box_i = (i / 3) * 3, box_j = (j / 3) * 3;
                    for(int k = box_i; k < box_i + 3;k++)
                    {
                        for(int l = box_j; l < box_j + 3; l++)
                        {
                            if((i != k || j != l) && board[i][j] == board[k][l])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}