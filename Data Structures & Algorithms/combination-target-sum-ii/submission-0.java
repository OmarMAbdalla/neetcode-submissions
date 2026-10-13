class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curSolution = new ArrayList<>();
        backtrack(candidates, curSolution, 0,0, target);
        return result;
    }

    public void backtrack(int[] candidates, List<Integer> curSolution, int i,int rollingSum, int target){
        if(rollingSum > target || i > candidates.length){
            return;
        }
        if(rollingSum == target){
            result.add(new ArrayList<>(curSolution));
            return;
        }

        for(int j = i; j <candidates.length; j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            curSolution.add(candidates[j]);
            backtrack(candidates, curSolution, j+1, rollingSum+candidates[j], target);
            curSolution.remove(curSolution.size()-1);
        }
    }
}
