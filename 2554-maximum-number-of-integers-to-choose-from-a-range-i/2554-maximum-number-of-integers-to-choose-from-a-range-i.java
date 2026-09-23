class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        HashSet<Integer> bannedNum = new HashSet<>();

        //take nums lower than 
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] <= n) {
                bannedNum.add(banned[i]);
            }
        }

        int sum = 0;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (!bannedNum.contains(i) && (sum + i) <= maxSum) {
                sum += i;
                cnt++;
            }
        }

        return cnt;
        ///rturn
    }
}

/*

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        HashSet<Integer> bannedNum = new HashSet<>();

        for (int num : banned) {
            bannedNum.add(num);
        }

        int sum = 0;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {

            if (!bannedNum.contains(i) && sum + i <= maxSum) {
                sum += i;
                cnt++;
            }
        }

        return cnt;
    }
}

*/