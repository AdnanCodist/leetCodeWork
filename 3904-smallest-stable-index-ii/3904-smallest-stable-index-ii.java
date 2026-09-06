class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // suffixMin[i] = minimum element from i to n-1
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            maxSoFar = Math.max(maxSoFar, nums[i]);

            int score = maxSoFar - suffixMin[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }
}