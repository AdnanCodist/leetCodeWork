class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int start = 0;
        int currGas = 0;
        for (int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];

            // account start idx
            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        currGas = 0;
        // since i found sart idx try it too
        for (int i = 0; i < n; i++) {
            int idx = (start + i) % n;

            currGas = currGas + gas[idx] - cost[idx];

            if (currGas < 0) { // failed circle try
                return -1;
            }
        }

        return start;

        // return
    }
}