class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        int xor = start ^ goal; //gives 1 where bits differ

        while (xor != 0) {
            ans += xor & 1;  //if MSB=1, ans++
            xor >>= 1; //right shift xor
        }
        return ans;
    }
}