class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1; // Extract LSB
            res = (res << 1) | bit; // Append the bit to the result
            n = n >>> 1; // Unsigned right-shift      
        }
        return res;

    }
}