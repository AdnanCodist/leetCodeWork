
class Solution {

    Stack<Character> st;
    List<Character> list;

    public boolean parseBoolExpr(String s) {

        int n = s.length();
        char ans = 't';

        st = new Stack<>();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == ',')
                continue;

            if (ch == ')') {

                // Collect all values inside this expression
                while (st.peek() != '(') {
                    list.add(st.pop());
                }

                // Remove '('
                st.pop();

                // Remove operator
                char opr = st.pop();

                // Evaluate
                ans = solver(list, opr);

                // Push result back
                st.push(ans);

                list.clear();

            } else {
                st.push(ch);
            }
        }

        return st.peek() == 't';
    }

    public char solver(List<Character> list, char opr) {

        if (opr == '&') {

            if (list.contains('f'))
                return 'f';

            return 't';

        } else if (opr == '|') {

            if (list.contains('t'))
                return 't';

            return 'f';

        } else { // opr == '!'

            if (list.get(0) == 'f')
                return 't';

            return 'f';
        }
    }
}
