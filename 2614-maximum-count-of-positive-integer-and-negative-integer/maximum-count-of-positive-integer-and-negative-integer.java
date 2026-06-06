class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        int neg = firstGreaterEqual(nums, 0);
        int pos = n - firstGreater(nums, 0);

        return Math.max(neg, pos);
    }

    private int firstGreaterEqual(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private int firstGreater(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}