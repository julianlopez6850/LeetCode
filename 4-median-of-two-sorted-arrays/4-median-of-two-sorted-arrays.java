class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] combined = new int[nums1.length + nums2.length];
        
        int index1 = 0;
        int index2 = 0;
        
        for(int i = 0; i < nums1.length + nums2.length; i++)
        {
            if(index1 >= nums1.length)
            {
                combined[i] = nums2[index2];
                index2++;
            }
            else if(index2 >= nums2.length)
            {
                combined[i] = nums1[index1];
                index1++;
            }  
            else if(nums1[index1] <= nums2[index2])
            {
                combined[i] = nums1[index1];
                index1++;
            }
            else
            {
                combined[i] = nums2[index2];
                index2++;
            }
        }
        
        double output = 0;
        
        if(combined.length % 2 == 1)
            output = combined[combined.length / 2];
        else
            output = (combined[combined.length / 2 - 1] + combined[combined.length / 2]) / 2.0;
        
        return output;
    }
}