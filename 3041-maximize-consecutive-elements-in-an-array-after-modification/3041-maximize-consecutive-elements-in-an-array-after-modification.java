class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] dp = new int[max + 3];
        int best = 0;
        for (int a : nums) {
            int b = a + 1;
            dp[b] = Math.max(dp[b], dp[b - 1] + 1);
            dp[a] = Math.max(dp[a], dp[a - 1] + 1);
            best = Math.max(best, Math.max(dp[a], dp[b]));
        }
        return best;
    }
}