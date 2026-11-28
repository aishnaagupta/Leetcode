class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!s.isEmpty() && k > 0 && s.peek() > num.charAt(i) - '0') {
                s.pop();
                k--;
            }
            s.push(num.charAt(i) - '0');
        }

        while (k > 0) {
            s.pop();
            k--;
        }

        if (s.isEmpty()) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}