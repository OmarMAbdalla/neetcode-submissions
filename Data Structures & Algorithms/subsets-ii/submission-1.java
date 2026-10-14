class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(), 0);
        return new ArrayList<>(res);

    }

    private void backtrack(int[] nums,List<Integer> curr, int i){
        if(i== nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, curr,i+1);
        curr.remove(curr.size()-1);
        backtrack(nums,curr,i+1);    }

}
