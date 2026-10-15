class Solution {
    String[] chars = new String[] {"","","abc","def", "ghi", "jkl",
                                        "mno","pqrs","tuv", "wxyz"};

    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList();
        if(digits.isEmpty()) return res;
        backtrack(0,"",digits);
        return res;
    }

    public void backtrack(int num, String curString, String digits){
        if(num == digits.length()){
            res.add(new String(curString));
            return;
        }
        for(char c : chars[digits.charAt(num)-'0'].toCharArray()){
            String tmp = curString + c;
            backtrack(num+1, tmp, digits);
        }
        return;

    }
}
