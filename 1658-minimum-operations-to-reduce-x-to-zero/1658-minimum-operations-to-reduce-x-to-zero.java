class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int sum = 0;
        int max = -1;

        // try both
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int remain = totalSum - x;

        for (int i = 0; i < n; i++) {

            sum += nums[i];
            map.put(sum, i);

            if (map.containsKey(sum - remain)) {
                int start = map.get(sum - remain);

                int len = i - start;

                max = Math.max(max, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        if (max == -1) {
            return -1;
        }

        return n - max;
        // return
    }
}