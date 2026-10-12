class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int total = nums1.length + nums2.length;
        int half = (total +1)/2;

        int l = 0; 
        int r = nums1.length;
        while(l <= r){
            int i = (l+r)/2;
            int j = half - i;

            int nums1Left = i > 0? nums1[i-1] : Integer.MIN_VALUE;
            int nums1Right = i < nums1.length? nums1[i] : Integer.MAX_VALUE;
            int nums2Left = j > 0? nums2[j-1] : Integer.MIN_VALUE;
            int nums2Right = j < nums2.length? nums2[j] :Integer.MAX_VALUE;

            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                if(total % 2 != 0){
                    return Math.max(nums1Left, nums2Left);
                }
                return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right))/2.0;
            }else if(nums1Left > nums2Right){
                r = i-1;
            }else{
                l = i+1;
            }
        }
        return -1; 

    }
}
