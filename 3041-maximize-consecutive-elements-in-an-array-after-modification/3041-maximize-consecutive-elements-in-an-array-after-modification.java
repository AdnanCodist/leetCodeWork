class Solution {
    int[][] dp;
    int n;

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        dp = new int[n][2];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int len = 1;
        for (int i = 0; i < n; i++) {
            len = Math.max(len,
                    Math.max(
                            solver(i, 0, nums),
                            solver(i, 1, nums)));
        }

        return len;
        // return
    }

    public int solver(int i, int incr, int[] nums) {
        if (dp[i][incr] != -1) {
            return dp[i][incr];
        }

        int currVal = nums[i] + incr;
        int len = 1;
        int j;

        // find laregr
        j = finder(i + 1, nums, currVal + 1);
        if (j != -1) {
            len = Math.max(len, 1 + solver(j, 0, nums));
        }

        // find self
        j = finder(i + 1, nums, currVal);
        if (j != -1) {
            len = Math.max(len, 1 + solver(j, 1, nums));
        }

        return dp[i][incr] = len;
    }

    public int finder(int left, int[] arr, int target) {
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {

                if (arr[mid] == target) {
                    ans = mid;
                }

                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return ans;

    }
}

/*
    public int solver(int i, int incr, int[] nums) {

        if (dp[i][incr] != -1) {
            return dp[i][incr];
        }

        int currVal = nums[i] + incr;
        int len = 1;

        // Find original value = currVal + 1
        int j = finder(i + 1, nums, currVal + 1);

        if (j != -1) {
            len = Math.max(len, 1 + solver(j, 0, nums));
        }

        // Find original value = currVal
        // Increment it to currVal + 1
        j = finder(i + 1, nums, currVal);

        if (j != -1) {
            len = Math.max(len, 1 + solver(j, 1, nums));
        }

        return dp[i][incr] = len;
    }

    public int finder(int left, int[] arr, int target) {

        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } 
            else if (arr[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}


*/
