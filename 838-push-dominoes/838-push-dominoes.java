class Solution {
    public String pushDominoes(String dominoes) {
        
        StringBuilder str = new StringBuilder(dominoes);
        StringBuilder prevStr = new StringBuilder(dominoes);
        Boolean change = false;
        
        if(dominoes.length() == 1)
            return dominoes;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(i == 0)
            {
                if(prevStr.charAt(i) == '.' && prevStr.charAt(i + 1) == 'L')
                {
                    str.setCharAt(i, 'L');
                    change = true;
                }
            }
            else if(i == str.length() - 1)
            {
                if(prevStr.charAt(i) == '.' && prevStr.charAt(i - 1) == 'R')
                {
                    str.setCharAt(i, 'R');
                    change = true;
                }
            }
            else if(prevStr.charAt(i) == '.' && prevStr.charAt(i + 1) == 'L' && prevStr.charAt(i - 1) != 'R')
            {
                str.setCharAt(i, 'L');
                change = true;
            }
            else if(prevStr.charAt(i) == '.' && prevStr.charAt(i + 1) != 'L' && prevStr.charAt(i - 1) == 'R')
            {
                str.setCharAt(i, 'R');
                change = true;
            }
            if(i == prevStr.length() - 1)
            {
                if(change == true)
                {
                    change = false;
                    prevStr.setLength(0);
                    prevStr.append(str.toString());
                    i = -1;
                }
                else
                    return str.toString();
            }
        }
        return str.toString();
    }
}