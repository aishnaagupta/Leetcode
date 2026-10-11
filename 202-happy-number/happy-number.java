class Solution {
    //USING LINKED LIST CYCLE METHOD
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = SquareSum(slow);
            fast = SquareSum(SquareSum(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }

        return false;
    }

    private int SquareSum(int num) {
        int s = 0;
        while (num > 0) {
            int rem = num % 10;
            s += rem * rem;
            num /= 10;
        }
        return s;
    }
}