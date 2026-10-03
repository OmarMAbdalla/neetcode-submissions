/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return minHeap.poll();
    }

    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        minHeap.offer(root.val);
        if(minHeap.size() > k)
        {
            minHeap.poll();
        }
        dfs(root.left,k);
        dfs(root.right,k);
    }



}
