class Solution {
    
    Stack<Integer> stack = new Stack<Integer>();
    
    public int reverse(int x) {
        
        if(x == 0)
            return 0;
        
        int reverse = reverseHelper(x);
        int doubleReverse = reverseHelper(reverse);
        
        while(x % 10 == 0)
            x /= 10;
        
        if(x == doubleReverse)
            return reverse;
        return 0;
    }
    
    public int reverseHelper(int x)
    {
        int reversed = 0;
        
        int sign = 1;
        if(x < 0)
            sign = -1;
        x = Math.abs(x);
        while(x > 0)
        {
            stack.push(x % 10);
            x /= 10;
        }
        for(int i = 0; stack.size() > 0; i++)
            reversed += (int)Math.pow(10, i) * stack.pop();
        reversed *= sign;
        
        return reversed;
    }
}