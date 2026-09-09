class Solution {
    public int partitionString(String s) {

        int n = s.length();

        HashSet<Character> set = new HashSet<>();

        int ans = 1; // kyuke shuuru me ek way hai hee, always hai, tyhe string itself

        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                ans++;
                set.clear();
            }

            set.add(s.charAt(i));
        }

        return ans;
        /// rtrune
    }
}