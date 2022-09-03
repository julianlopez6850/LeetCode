class Solution {
    
    public int[] numsSameConsecDiff(int n, int k)
    {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i < 10; i++)
            DepthFirstSearch(n, i, k, result);
        
        int[] resultArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            resultArray[i] = result.get(i);
            
        return resultArray;
    }
    
    public void DepthFirstSearch(int n, int num, int k, List<Integer> result)
    {
        if(n == 1)              // if there are no more digits to be added, return.
        {
            result.add(num);
            return;
        }
        
        List<Integer> nextDigits = new ArrayList<Integer>();
        int lastDigit = num % 10;
        
        /*  
            if (lastDigit + k) < 10, it is a possible next digit, thus add it to nextDigit.
            if (lastDigit - k) >= 0, it is a possible next digit, thus add it to nextDigit.
            if k = 0, make sure to not add the digit twice.
        */
        if(lastDigit + k < 10)
            nextDigits.add(lastDigit + k);
        if(k != 0 && lastDigit - k >= 0)
            nextDigits.add(lastDigit - k);
        
        // repeat method call with newNum (num with nextDigits appended).
        for(int i = 0; i < nextDigits.size(); i++)
            DepthFirstSearch(n - 1, num * 10 + nextDigits.get(i), k, result);
    }
}