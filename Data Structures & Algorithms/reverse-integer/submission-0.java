class Solution {
    public int reverse(int x) {
        final int MIN = -2147483648; // -2^31
        final int MAX = 2147483647;  // 2^31 - 1
        int result = 0;

        while(x != 0){
            int tmp = x % 10;
            if (result > MAX / 10 || (result == MAX / 10 && tmp > MAX % 10))
                return 0;
            if (result < MIN / 10 || (result == MIN / 10 && tmp < MIN % 10))
                return 0;
            result = (result * 10)+tmp;
            x /= 10;
        }


        return result;
    }
}
