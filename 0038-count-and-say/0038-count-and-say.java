class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        return countAndSayHelper("1", 1, n);
    }
    
    public String countAndSayHelper(String say, int n, int target) {

        if(n == target)
            return say;
        
        Character currLetter = '0';
        int counter = 0;
        
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i <= say.length(); i++)
        {
            if(i == say.length())
            {
                str.append(Integer.toString(counter));
                str.append(say.charAt(i - 1));
                counter = 1;
            }
            else if(currLetter == '0')
            {
                counter++;
                currLetter = say.charAt(i);
            }
            else if(say.charAt(i) == currLetter)
            {
                counter++;
            }
            else
            {
                str.append(Integer.toString(counter));
                str.append(say.charAt(i - 1));
                currLetter = say.charAt(i);
                counter = 1;
            }
        }
        return countAndSayHelper(str.toString(), n + 1, target);
    }
}