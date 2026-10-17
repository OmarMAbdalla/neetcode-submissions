class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<List<Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length]; 

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek().get(0)<temperatures[i]){
                List<Integer> tmp = stack.pop();
                res[tmp.get(1)] = i - tmp.get(1);
            }
            stack.push(Arrays.asList(temperatures[i], i));
        }

        return res;
    }
}
