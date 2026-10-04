class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                len++;

            } else {
                int ind = lowerBound(temp, nums[i]);
                temp.set(ind, nums[i]);
            }
        }
        return len;
    }

    // Returns index of first element >= target
    public static int lowerBound(ArrayList<Integer> temp, int target) {
        int low = 0;
        int high = temp.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (temp.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
