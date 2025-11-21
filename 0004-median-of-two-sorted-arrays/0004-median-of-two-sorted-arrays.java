class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        
      int[] newArr = new int[m+n];

      int i=0;
      int j=0;
      int k=0;

      while(i<m && j<n)
      {
        if(nums1[i] < nums2[j])
        {
            newArr[k++] = nums1[i++];
        }
        else{
            newArr[k++] = nums2[j++];
        }
      }
        while (i < m) newArr[k++] = nums1[i++];
        while (j < n) newArr[k++] = nums2[j++];

        int total = m + n;

        // If odd  middle element
        if (total % 2 == 1) {
            return newArr[total / 2];
        } 
        // If even  average of two middle elements
        else {
            return (newArr[total/2 - 1] + newArr[total/2]) / 2.0;
        }


    }
}