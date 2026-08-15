/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    private List<Integer> result;
    public List<Integer> postorder(Node root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }
    private void dfs (Node root){
        if (root == null) return;

        for (Node child : root.children){
            dfs(child);
        }
        result.add(root.val);

    }
}