class Solution {
       public int splitArray(int[] nums, int k) {
        int left = getMax(nums);
        int right = getSum(nums);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int subarrays = 1;
        
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                subarrays++;
                currentSum = num;
                if (subarrays > k) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}