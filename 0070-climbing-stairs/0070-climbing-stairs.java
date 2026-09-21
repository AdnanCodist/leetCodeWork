class Solution {
    public int climbStairs(int n) {
        int [] tab = new int[n+1];

        tab[0] = 1;
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                tab[i] = tab[i-1];
            } else {
                tab[i] = tab[i-1] + tab[i-2];
            }
        }

        return tab[n];
    }
}