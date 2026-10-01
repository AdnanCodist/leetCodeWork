class Solution {
    public boolean search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            // Found target
            if (nums[mid] == target) {
                return true;
            }

            // Cannot determine which half is sorted
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            }

            // Left half is sorted
            else if (nums[l] <= nums[mid]) {

                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}