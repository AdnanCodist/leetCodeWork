class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int digSum = digSum(nums[i]);
            if (digSum == i) {
                return i;
            }
        }

        return -1;
    }

    public int digSum(int num) {
        int sum = 0;

        while (num != 0) {

            sum += (num % 10);
            num = num / 10;
        }

        return sum;
    }
}