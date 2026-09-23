class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalsum = 0;

        for (int num : nums) {
            totalsum += num;
        }

        int remain = totalsum - x;

        // edge case
        if (remain < 0)
            return -1;

        int left = 0;
        int sum = 0;
        int max = -1;

        // left [] right

        // increase to right
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // shrink from left if sum is bigger than required
            while (sum > remain) {
                sum -= nums[left];
                left++;
            }

            //found a subarray where sum is total - x
            if (sum == remain) {
                int len = right - left + 1;
                max = Math.max(max, len);
            }
        }

        return max == -1 ? -1 : n - max;
        // return
    }
}