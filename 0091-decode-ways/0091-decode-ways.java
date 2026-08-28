class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev1 = 1;
        int prev2 = 0;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            if (s.charAt(i - 1) != '0') {
                count += prev1;
            }

            if (i > 1) {
                int dig = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');

                if (dig >= 10 && dig <= 26) {
                    count += prev2;
                }
            }

            prev2 = prev1;
            prev1 = count;
        }

        return prev1;
        // return;
    }
}