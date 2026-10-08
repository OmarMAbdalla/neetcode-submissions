class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Character> chars = new HashMap<>();
        int maxLength = 0;
        if(s.length()<=1){
            return s.length();
        }
        int l = 0;
        chars.put(0, s.charAt(0));
        for(int r = 1; r < s.length(); r++){
            while(chars.containsValue(s.charAt(r))){
                chars.remove(l);
                l++;
            }
            chars.put(r,s.charAt(r));
            maxLength = Math.max(r-l+1, maxLength);
        }
        return maxLength;
    }
}
