class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;

        int even = 1;
        int odd = 0;

        int sum = 0;

        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum % 2 == 0) {
                ans = (ans + odd) % MOD;
                even++;
            } else { // sum % 2 != 0
                ans = (ans + even) % MOD;
                odd++;
            }
        }

        return ans;

        // return
    }
}

/*

int even = 1;
int odd = 0;

int sum = 0;
int ans = 0;

for (int num : arr) {
    sum += num;

    if (sum % 2 != 0) {
        ans += even;
        odd++;
    } else {
        ans += odd;
        even++;
    }
}

*/