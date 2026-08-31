class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int diff;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            diff = target - arr[i];

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff) + 1, i + 1 };
            }

            map.put(arr[i], i);
        }

        return new int[] { -1, -1 };
        // return
    }
}