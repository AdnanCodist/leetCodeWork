class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solver(0, candidates, target, list, ans);

        return ans;
    }

    // solver
    public void solver(int i, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i == arr.length) {
            return;
        }

        //take
        list.add(arr[i]);
        // use
        solver(i, arr, target - arr[i], list, ans);

        // untake
        list.remove(list.size() - 1);

        // dont use
        solver(i + 1, arr, target, list, ans);

        // return
    }
}