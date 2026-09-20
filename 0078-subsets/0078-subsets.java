class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solver(0, nums, list, ans);

        return ans;
        //return
    }

    //solver
    public void solver(int i, int[] arr, List<Integer> list, List<List<Integer>> ans) {
        if (i == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // add this element
        list.add(arr[i]);

        // take
        solver(i + 1, arr, list, ans);

        // remove (dont take this element)
        list.remove(list.size() - 1);

        // dont
        solver(i + 1, arr, list, ans);

    }
}