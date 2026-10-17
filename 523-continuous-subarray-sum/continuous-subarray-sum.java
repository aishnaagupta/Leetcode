class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k; //checking divisibility
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) { //checking if length of subarray is atleast 2 or no
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}