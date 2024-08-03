class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }

        // Restore the array to its original state (optional)
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicates;
    }

}