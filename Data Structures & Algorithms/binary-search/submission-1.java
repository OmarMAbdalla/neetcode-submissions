class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }

    public int binarySearch(int l, int r, int[] nums, int target)
    {
        if (l > r) return -1;
        int mi = l +(r-l)/2;
        if(nums[mi]==target)
        {
            return mi;
        }

        if(nums[mi] < target)
        {
            return binarySearch(mi+1,r,nums,target);
        }
        return binarySearch(l,mi-1,nums,target);

    }
}
