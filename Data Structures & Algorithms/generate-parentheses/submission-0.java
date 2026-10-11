class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0,0,n,res,stack);
        return res;
    }

    private void backtrack(int openN, int closedN, int n, List<String> result, StringBuilder stack){
        if(openN == n && closedN == n){
            result.add(stack.toString());
            return;
        }

        if(openN<n){
            stack.append('(');
            backtrack(openN+1, closedN, n, result, stack);
            stack.deleteCharAt(stack.length()-1);
        }

        if(closedN < openN){
            stack.append(')');
            backtrack(openN, closedN+1, n, result, stack);
            stack.deleteCharAt(stack.length()-1);
        }


    }
}
