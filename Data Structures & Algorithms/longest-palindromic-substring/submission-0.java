class Solution {
    public String longestPalindrome(String s) {
        int resultLength =0;
        int resultIndex =0;

        for(int i = 0; i < s.length(); i++){
            // odd length
            int l = i;
            int r = i;
            while(l >= 0 && r < s.length() && s.charAt(l)== s.charAt(r)){
                if(r-l+1 > resultLength){
                    resultIndex = l;
                    resultLength = r-l+1;
                }
                l--;
                r++;
            }

            // even length
            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l)== s.charAt(r)){
                if(r-l+1 > resultLength){
                    resultIndex = l;
                    resultLength = r-l+1;
                }
                l--;
                r++;
            }

        }            
        return s.substring(resultIndex, resultIndex + resultLength);
    }
}
