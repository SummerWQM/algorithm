
    public static void main(String[] args) {

        System.out.println(findTarget(new int[]{4, 5, 6, 6, 5, 1, 2, 3}, 6));


    }

    /**
     * @param
     * @param
     */
    public static int findTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        int n = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;

    }

