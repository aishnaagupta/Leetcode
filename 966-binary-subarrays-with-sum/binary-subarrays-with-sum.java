class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }

    public int atmost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0, r = 0, sum = 0, count = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1); //basically getting all subarray with sum <= goal
            r++;
        }
        return count;
    }
}