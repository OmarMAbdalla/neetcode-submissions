class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Character> window = new HashMap<>();
        int maxSize = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            while(window.containsValue(s.charAt(r))){
                window.remove(l);
                l++;
            }
            window.put(r,s.charAt(r));
            maxSize = Math.max(maxSize, window.size());
        }
        return maxSize;
    }
}
