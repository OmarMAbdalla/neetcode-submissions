class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr, boolean[] pick){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                curr.add(nums[i]);
                pick[i] = true;
                backtrack(nums, curr, pick);
                curr.remove(curr.size()-1);
                pick[i] = false;
            }
        }
    }
}
