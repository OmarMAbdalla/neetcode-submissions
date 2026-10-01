class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] bucketSort = new int[26];
        for(int i = 0; i < s1.length();i++){
                bucketSort[s1.charAt(i) - 'a']++;
            }
        
        int l = 0;
        int r = l+s1.length();
        while(r<=s2.length()){
            int[] bucketSortedString = new int [26];
            for(int i = l; i < r;i++){
                bucketSortedString[s2.charAt(i) - 'a']++;
            }
            if(Arrays.equals(bucketSort,bucketSortedString)){
                return true;
            }
            l++;
            r++;
        }
        return false;

        }
    }

