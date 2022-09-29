class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        
        if(arr.length == k)
        {
            for(int i = 1; i < arr.length; i++)
            {
                result.add(i, arr[i]);
            }
            return result;
        }
        
        for(int i = 1; i < arr.length; i++)
        {
            if(result.size() < k)
                for(int j = 0; j < result.size() + 1; j++)
                {
                    if(j == result.size() || Math.abs(result.get(j) - x) > Math.abs(arr[i] - x))
                    {
                        result.add(result.size(), arr[i]);
                        break;
                    }
                }
            else
            {
                for(int j = 0; j < result.size(); j++)
                {
                    if(Math.abs(result.get(j) - x) > Math.abs(arr[i] - x))
                    {
                        result.add(arr[i]);
                        result.remove(0);
                        break;
                    }
                }
            }
        }
        return result;
    }
}