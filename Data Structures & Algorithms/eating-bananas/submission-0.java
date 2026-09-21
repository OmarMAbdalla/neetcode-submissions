class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;
        for (int pile : piles) 
            r = Math.max(r, pile);        
            
        int result = r;
        while (l <= r){
            int mid = (l+r)/2;
            
            long time = 0;
            for (int pile : piles){
                time += Math.ceil((double) pile/mid);
            }
            if (h >= time){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }

        }
        return result;
    }
}
