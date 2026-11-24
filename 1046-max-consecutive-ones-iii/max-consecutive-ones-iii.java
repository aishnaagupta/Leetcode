class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroes++;
            }
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }

            max = Math.max(r - left + 1, max);
        }

        return max;
    }
}