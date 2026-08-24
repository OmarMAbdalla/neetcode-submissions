class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i = 0; i < n+1; i++){
            res[i] = numOfOnes(i);
        }
        return res;
    }

    private int numOfOnes (int n){
        int res = 0;
        while (n != 0){
            int tmp = n % 2;
            res += tmp;
            n /= 2;
        }
        return res;
    }
}
