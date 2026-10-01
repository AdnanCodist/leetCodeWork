class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        int n = s.length();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {

if (st.isEmpty()) {
    return false;
}
                if (ch == ')' && st.peek() == '(') {
                    st.pop();
                } else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                } else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }

                // end
            }

        }

        return st.isEmpty();
        // end
    }
}