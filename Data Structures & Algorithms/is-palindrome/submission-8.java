class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (right > left)
        {
            while( right > left && !alphaNum(s.charAt(left)))
            {
                left++;
            }
            while( right > left && !alphaNum(s.charAt(right)))
            {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right)))
                {
                    return false;
                }
            
            left++;
            right--;
        }
        return true;
    }

    boolean alphaNum(final int codePoint) {
    return (codePoint >= 65 && codePoint <= 90) ||
           (codePoint >= 97 && codePoint <= 122) ||
           (codePoint >= 48 && codePoint <= 57);
}
}
