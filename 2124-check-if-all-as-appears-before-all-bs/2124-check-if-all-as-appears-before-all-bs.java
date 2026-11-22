class Solution {
    public boolean checkString(String s) {
        boolean isb = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                isb = true;
            }

            if (isb && s.charAt(i) == 'a') {
                return false;
            }
        }

        return true;
        // return
    }
}