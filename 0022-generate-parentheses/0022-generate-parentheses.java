class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        solver(list, "", 0, 0, n);

        return list;
        // end
    }

    public void solver(List<String> list, String s, int op, int cl, int n) {

        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }

        // try (
        if (op < n) {
            solver(list, s + "(", op + 1, cl, n);
        }

        // try )
        if (cl < op) {
            solver(list, s + ")", op, cl + 1, n);
        }
        // return
    }
}

/* 


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        backtrack(list, "", 0, 0, n);

        return list;
    }

    private void backtrack(List<String> list, String currStr, int op, int cl, int n) {

        // base case
        if(currStr.length() == 2*n) {
            list.add(currStr);
            return;
        }

        // to add "("
        if(op < n) {
            backtrack(list, currStr + "(", op + 1, cl, n);
        }

        // to add ")"
        if(cl < op) {
            backtrack(list, currStr + ")", op, cl + 1, n);
        }
    }
}

*/