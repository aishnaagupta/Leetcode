
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long total = 0;
        int mod = 1000000007;

        int[] psee = PSEE(arr);
        int[] nse = NSE(arr);

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;

            total = (total + (left * right * arr[i]) % mod) % mod;
        }

        return (int) total;
    }

    int[] PSEE(int[] arr) { //PREVIOUS SMALLER OR EQUAL ELEMENT
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    int[] NSE(int[] arr) { //NEXT SMALLER ELEMENT
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
}
