class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans = ans | (1 << bit);
            }
        }
        return ans;
    }
}