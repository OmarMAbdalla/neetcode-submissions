class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < s.length()){
            switch(s.charAt(i)){
                case '(':
                    stack.push(')');
                    break;
                
                case '[':
                    stack.push(']');
                    break;

                case '{':
                    stack.push('}');
                    break;

                default:
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != s.charAt(i)){
                        return false;
                    }
                    break;
            }
            i++;
        }

        return stack.isEmpty();
        
    }
}
