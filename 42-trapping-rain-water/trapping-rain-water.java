class Solution {
    public int trap(int[] height) {
        int[] premax = PrefixMax(height);
        int[] suffmax = SuffixMax(height);

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int leftmax = premax[i];
            int rightmax = suffmax[i];

            if (height[i] < leftmax && height[i] < rightmax) { //the position we are at should be in between the left and right max so as to collect water
                total += Math.min(leftmax, rightmax) - height[i];
            }
        }

        return total;
    }

    public int[] PrefixMax(int[] arr) { 
        int n = arr.length;
        int[] ans = new int[n];
        ans[0] = arr[0];
        for (int i = 1; i < n; i++) {
            ans[i] = Math.max(ans[i - 1], arr[i]);
        }
        return ans;
    }

    public int[] SuffixMax(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], arr[i]);
        }
        return ans;
    }
}