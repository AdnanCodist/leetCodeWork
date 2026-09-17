class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int i = 0;
        int j = 0;

        int ans = Integer.MAX_VALUE;
        int[] besttilli = new int[n];
        Arrays.fill(besttilli, Integer.MAX_VALUE);

        int sum = 0;
        int bestLen = Integer.MAX_VALUE;

        while (j < n) {

            sum += arr[j];

            // settle window
            while (i < j && sum > target) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {

                int len = j - i + 1;

                if (i > 0 && besttilli[i - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + besttilli[i - 1]);
                }

                bestLen = Math.min(bestLen, len);
            }

            besttilli[j] = bestLen;
            j++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
        //return
    }
}