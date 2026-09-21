class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        int prev = arr[0];
        int prev2 = 0;

        for(int i = 1; i < n; i++) {
            
            int take = arr[i] + prev2;
            int dont = 0 + prev;

            int curri = Math.max(take, dont);

            prev2 = prev;
            prev = curri;
        }

        return prev;
        // returbn
    }
}