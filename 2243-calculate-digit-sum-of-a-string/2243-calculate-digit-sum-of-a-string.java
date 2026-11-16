class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder sb = new StringBuilder();
            StringBuilder group = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {

                group.append(s.charAt(i));

                if (group.length() == k) {

                    sb.append(findSum(group.toString()));
                    group.setLength(0);
                }
            }

            // Process leftover characters
            if (group.length() > 0) {
                sb.append(findSum(group.toString()));
            }

            s = sb.toString();
        }

        return s;
    }

    //--- Helper
    public String findSum(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        return Integer.toString(sum);
    }

}