class Solution {
    
    Stack<Integer> stack = new Stack<Integer>();
    
    public int reverse(int x) {
        
        int reverse = reverseHelper(x);
        int doubleReverse = reverseHelper(reverse);
        
        while(x != 0 && x % 10 == 0)
        {
            x /= 10;
        }
        
        if(x == doubleReverse)
            return reverse;
        return 0;
    }
    
    public int reverseHelper(int x)
    {
        int reversed = 0;
        int counter = 0;
        
        boolean positive = false;
        if(x > 0)
            positive = true;
        
        x = Math.abs(x);
        while(x > 0)
        {
            System.out.print(x);
            stack.push(x % 10);
            x /= 10;
            System.out.println(" "+ stack + " " + counter + "\n-------------");
        }
        while(stack.size() > 0)
        {
            reversed += (int)Math.pow(10, counter) * stack.pop();
            counter++;
            System.out.println(counter + " " + reversed);
        }
        if(!positive)
            reversed *= -1;
        
        System.out.println(positive);
        System.out.println(reversed);
        
        if((positive && reversed < 0) || (!positive && reversed > 0))
            return 0;
        else
            return reversed;
    }
    
    
}