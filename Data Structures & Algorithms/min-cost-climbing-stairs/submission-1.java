class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = Math.min(minCost[0]+cost[1], cost[1]);

        for(int i = 2; i < minCost.length; i++){
            minCost[i] = Math.min(minCost[i-1]+cost[i], minCost[i-2]+cost[i]);
        }
        return Math.min(minCost[minCost.length-1],minCost[minCost.length-2]);
    }
}
