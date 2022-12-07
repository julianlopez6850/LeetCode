class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String a = s.substring(0, len/2);
        String b = s.substring(len/2);
        
        if(countVowels(a) == countVowels(b))
            return true;
        return false;
        
    }
    
    public int countVowels(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            Character a = Character.toLowerCase(s.charAt(i));
            if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
                count ++;
            }
        }
        return count;
    }
}