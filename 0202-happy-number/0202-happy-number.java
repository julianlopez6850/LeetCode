class Solution {
    public boolean isHappy(int n) {
        int original = n;
        Set<Integer> seen = new HashSet<>();
        while(n != 1) {
            int newNum = 0;
            while(n / 10.0 > 0) {
                newNum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = newNum;
            if(seen.contains(n))
                return false;
            seen.add(n);
        }
        return true;
    }
}