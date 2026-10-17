class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j <= nums[i]+i && j < nums.length && canJump[i] == true; j++){
                canJump[j] = true;
            }
        }
        return canJump[nums.length-1];
    }
}
