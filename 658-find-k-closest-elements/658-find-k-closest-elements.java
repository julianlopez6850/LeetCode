class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> result = new ArrayList<>();
        
        if(arr.length == k)
        {
            for(int i = 0; i < arr.length; i++)
                result.add(i, arr[i]);
            return result;
        }
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(result.size() < k)
                result.add(0, arr[i]);
            else if(Math.abs(result.get(result.size() - 1) - x) >= Math.abs(arr[i] - x))
            {
                result.add(0, arr[i]);
                result.remove(result.size() - 1);
            }
        }
        return result;
    }
}