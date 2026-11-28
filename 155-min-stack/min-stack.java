class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int value) {
        s1.push(value);
        if (s2.isEmpty() || value <= s2.peek()) {
            s2.push(value);
        }
    }

    public void pop() {
        if (s2.peek().equals(s1.peek())) { //very important to use 'equals' instead of == because that might give false in some cases
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */