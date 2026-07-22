class Solution {
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];

                if (sum == target) {
                    result.add(List.of(nums[i], nums[l], nums[r]));

                    // Skip duplicates for second and third elements
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;

                    // Move pointers to the next new numbers
                    l++;
                    r--;
                } else if (sum < target) {
                    l++; // Need a larger sum
                } else {
                    r--; // Need a smaller sum
                }
            }
        }
        return result;
    }
}
