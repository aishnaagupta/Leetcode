class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftsum = 0;
        int maxSum = 0;
        int rightsum = 0;

        for (int i = 0; i < k; i++) {
            leftsum = leftsum + cardPoints[i];
        }
        maxSum = leftsum;

        int rightInd = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftsum = leftsum - cardPoints[i];
            rightsum = rightsum + cardPoints[rightInd];
            rightInd--;

            maxSum = Math.max(maxSum, leftsum + rightsum);
        }
        
        return maxSum;
    }
}