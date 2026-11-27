class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && (st.peek()) > num.charAt(i) - '0') {
                st.pop();
                k--;
            }
            st.push(num.charAt(i) - '0');
        }

        while (k > 0) { //if at the end by this method no elements have been popped, simply pop the top k elements for eg in "654321"
            st.pop();
            k--;
        }

        if (st.isEmpty()) { 
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') { //to avoid leading zeroes
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}