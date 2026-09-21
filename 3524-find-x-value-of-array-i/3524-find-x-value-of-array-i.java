class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            // curr number [2], [3], [4]....
            int mod = num % k;

            newDp[mod] = 1;

            // calculate all prefixes
            for (int r = 0; r < k; r++) {

                // new remaindr if subarray is extende backwrds
                int newRem = (r * mod) % k;

                newDp[newRem] += dp[r];

                /*
                new rem explanation
                
                oldprod * num % k
                =>  ((oldprod % k) * (num % k)) % k
                => (r * mod) % k, since wo remainder toh < k hee hona hai so 0 se ktak saare lelo
                
                */

            }

            // update ans array
            for (int j = 0; j < k; j++) {
                ans[j] += newDp[j];
            }

            // update dp
            dp = newDp;
        }

        return ans;

    }
}

/*

   long[] answer = new long[k];

        // Number of subarrays ending at previous index
        // grouped by product % k
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int mod = num % k;

            // Start a new subarray with only num
            newDp[mod] = 1;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                int newRemainder = (r * mod) % k;

                newDp[newRemainder] += dp[r];
            }

            // Add current subarrays to global answer
            for (int r = 0; r < k; r++) {
                answer[r] += newDp[r];
            }

            dp = newDp;
        }

        return answer;

*/
