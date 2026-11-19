class Solution {
    public int minimizeSum(int[] arr) {
        
        int n = arr.length;
        Arrays.sort(arr);
        
        // change idea
        int startEnd = arr[n - 2] - arr[1];
        int startStart = arr[n - 1] - arr[2];
        int endEnd = arr[n - 3] - arr[0];

        return Math.min(startEnd, Math.min(startStart, endEnd));
        //return
    }
}