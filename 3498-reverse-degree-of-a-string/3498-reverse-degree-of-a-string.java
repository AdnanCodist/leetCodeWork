class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        int n = s.length();

        int num;

        for (int i = 0; i < n; i++) {
            num = 'z' - s.charAt(i) + 1;
            num *= (i + 1);
            ans += num;
        }

        return ans;
        //return
    }
}
