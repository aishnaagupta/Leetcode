//SAME METHOD AS 930- binary subarrays with sum
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int l = 0, r = 0, odd = 0, count = 0;

        while (r < nums.length) {
            if (nums[r] % 2 != 0) {
                odd++;
            }

            while (odd > k) {
                if (nums[l] % 2 != 0) {
                    odd--;
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}