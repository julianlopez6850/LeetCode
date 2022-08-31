class Solution {
    
    Stack<Integer> stack = new Stack<Integer>();
    
    public boolean isPalindrome(int x) {
        if(x < 0 || x == Integer.MAX_VALUE)
            return false;
        
        int num = x;
        int reversed = 0;
        
        for(int i = 0; x > 0; i++)
        {
            stack.push(x % 10);
            x /= 10;
        }
        for(int i = 0; stack.size() > 0; i++)
            reversed += stack.pop() * Math.pow(10, i);
        
        if(num == reversed)
            return true;
        return false;
    }
}