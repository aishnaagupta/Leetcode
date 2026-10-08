class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int n : nums) {
            ans ^= n; //xor of number with itself gives 0, so in the end, single one remains
        }
        return ans;
    }
}