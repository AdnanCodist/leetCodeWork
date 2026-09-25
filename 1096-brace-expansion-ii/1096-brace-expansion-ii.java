class Solution {

    int i = 0;

    public List<String> braceExpansionII(String s) {

        Set<String> ans = solver(s);
        List<String> ansr = new ArrayList<>(ans);
        Collections.sort(ansr);
        return ansr;
    }

    // solver
    public Set<String> solver(String s) {
        Set<String> res = new HashSet<>();
        Set<String> cur = new HashSet<>();

        cur.add(""); // empty string se shuru karo

        while (i < s.length()) {
            char ch = s.charAt(i);

            // cases
            if (ch == '{') {

                i++; // aage badho { se

                //{} keandar processkaro
                Set<String> inside = solver(s);

                // comnine karlo bahar waale se
                cur = comb(cur, inside);

            } else if (ch == ',') {

                i++; // aage badho , se 
                res.addAll(cur);

                //curr ko khali rakho alpha process karne
                cur.clear();
                cur.add("");

            } else if (ch == '}') {

                i++; //global variable hai aage badhao
                // {} ka union leke wapis chalo
                res.addAll(cur);
                return res; // ye jayega inside ke paas

            } else { // an alpha

                // process karo fir combaine karo
                Set<String> tmp = new HashSet<>();
                tmp.add(String.valueOf(ch));

                cur = comb(cur, tmp);
                i++;
            }
        }

        res.addAll(cur);

        return res;
    }

    // joiner
    public Set<String> comb(Set<String> a, Set<String> b) {

        Set<String> comb = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                comb.add(x + y);
            }
        }

        return comb;
        //return
    }
}