class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i]; // size dtereminer
            }
        }

        int[] tb = new int[largest + 1];

        for (int no : nums) {
            tb[no] += no;
        }

        int p1 = 0;
        int p2 = 0;

        for (int i = 1; i <= largest; i++) {
            int take = tb[i] + p2;
            int dont = p1;

            int curr = Math.max(take, dont);

            p2 = p1;
            p1 = curr;
        }

        return p1;
        // return
    }
}