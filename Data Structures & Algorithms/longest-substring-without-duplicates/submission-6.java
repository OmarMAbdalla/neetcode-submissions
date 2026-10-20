class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int maxSize = 0;
        int l = 0; 
        for(int r = 0; r < s.length(); r++){
            while(charSet.contains(s.charAt(r))){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            maxSize = Math.max(maxSize, charSet.size());
        }

        return maxSize;
    }
}
