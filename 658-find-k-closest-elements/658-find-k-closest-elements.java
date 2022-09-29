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
            {
                result.add(0, arr[i]);
            }
            else if(Math.abs(result.get(result.size() - 1) - x) > Math.abs(arr[i] - x))
            {
                result.add(0, arr[i]);
                result.remove(result.size() - 1);
            }
        }
        reverseList(result);
        return result;
    }
    
    public void reverseList(List<Integer> arr)
    {
        for(int i = 0; i < arr.size() / 2; i++)
        {
            int temp = arr.get(i);
            arr.set(i, arr.get(arr.size() - i - 1));
            arr.set(arr.size() - i - 1,  temp);
        }
    }
}