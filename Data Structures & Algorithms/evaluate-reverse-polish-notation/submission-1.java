class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            switch(token){
                case "+":
                if(stack.size()>=2){
                    int int1 = stack.pop();
                    int int2 = stack.pop();

                    int1 += int2;
                    stack.push(int1);
                }
                break;

                case "*":
                if(stack.size()>=2){
                    int int1 = stack.pop();
                    int int2 = stack.pop();

                    int1 *= int2;
                    stack.push(int1);
                }
                break;

                case "/":
                if(stack.size()>=2){
                    int int1 = stack.pop();
                    int int2 = stack.pop();

                    int1 = (int) int2/int1;
                    stack.push(int1);
                }
                break;

                case "-":
                if(stack.size()>=2){
                    int int1 = stack.pop();
                    int int2 = stack.pop();

                    int1 = int2-int1;
                    stack.push(int1);
                }
                break;
            
                default:
                stack.push(Integer.parseInt(token));
                break;
            }
        }
        if (stack.size()==1)
            return stack.pop();
        
        return -1;

    }
}
