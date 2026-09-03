class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean ans = true;
        int smallest = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num < smallest) {
                smallest = num;
            }
        }

        // smalllest false check
        if (smallest % 2 == 1) { // smnallest false hai matlab, sare even ban sakte hai odds yaani sare odds an sakte hai
            return ans;
        }

        /// smallest isnt false means, smallest is even so sabko even hona padega
        for (int num : nums1) {
            if (num % 2 != 0) {
                ans = false;
                return ans;
            }
        }

        return ans;
        // returtn
    }
}

/*

intuition based on :

odd - odd = even , so smallest must not be odd for nums[i] to be >= 1, as itll result intoo 0

even - odd = odd , so even smallest must not be an odd again

*/ 