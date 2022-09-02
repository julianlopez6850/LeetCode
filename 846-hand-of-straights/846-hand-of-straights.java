class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int groupedCards = 0;
        
        int smallest = -1;
        int smallestIndex = 0;
        
        if(hand.length % groupSize != 0)
            return false;
        if(groupSize == 1)
            return true;
        
        for(int i = 0; i < hand.length; i++)
        {
            if(hand[i] != -1)
            {
                if(groupedCards % groupSize == 0)
                {
                    if((hand[i] < smallest || smallest == -1))
                    {
                        smallest = hand[i];
                        smallestIndex = i;
                    }
                    if(i == hand.length - 1)
                    {
                        groupedCards++;
                        smallest++;
                        hand[smallestIndex] = -1;
                        i = -1;
                    }
                }
                else
                {
                    if(hand[i] == smallest)
                    {
                        groupedCards++;
                        smallest = (groupedCards % groupSize != 0) ? smallest + 1 : -1;
                        hand[i] = -1;
                        i = -1;
                    }
                }
            }
            else if(i == hand.length - 1)
            {
                if(groupedCards % groupSize == 0)
                {
                    groupedCards++;
                    smallest++;
                    hand[smallestIndex] = -1;
                    i = -1;
                }
            }
            if(groupedCards == hand.length)
                return true;
        }
        return false;
    }
}