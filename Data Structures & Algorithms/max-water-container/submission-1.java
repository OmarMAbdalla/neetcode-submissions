class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length -1;

        int max = 0;

        while(l<r){
            int height = Math.min(heights[l], heights[r]);
            max = Math.max(max, (r-l) *height);

            if(heights[l]< heights[r]){
                l++;
            }else if(heights[l]> heights[r]){
                r--;
            }else{
                l++;
                r--;
            }
        }
        return max;
    }
}
