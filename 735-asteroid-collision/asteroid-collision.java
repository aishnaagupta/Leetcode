class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) { //if both same value, both get destroyed 
                    stack.pop();
                }

                else if (stack.isEmpty() || stack.peek() < 0) { //push only if next element in stack is also -ve or stack is empty
                    stack.push(asteroids[i]);
                }
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) { //in reverse because top element in stack needs to be the last in array
            ans[i] = stack.pop();
        }

        return ans;
    }
}