class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // int[] dp = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i <= n; i++) {
            list.add(0);
        }

        list.set(n, 1);

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                list.set(i, list.get(i + 1));
            }

            if ((i + 1 < n) &&
                    ((s.charAt(i) == '1' && s.charAt(i + 1) <= '9') ||
                            (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                list.set(i, list.get(i) + list.get(i + 2));
            }
        }

        return list.get(0);
        /// return
    }
}
