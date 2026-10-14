class Solution {
    public int jump(int[] nums) {
       int[] jumpsTo = new int[nums.length];
       Arrays.fill(jumpsTo, Integer.MAX_VALUE);
       jumpsTo[0] = 0;

       for(int i = 0; i < nums.length;i++){
        for(int j = i+1; j <= nums[i]+i && j < nums.length; j++){
            jumpsTo[j] = Math.min(jumpsTo[i]+1,jumpsTo[j]);
        }
       }
       return jumpsTo[nums.length-1]; 
    }
}
