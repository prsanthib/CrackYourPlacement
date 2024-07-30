class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length-2 ; i++)
        {
            List<Integer> ll = new ArrayList<>();
            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while(left < right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0)
                {
                    ll.add(nums[i]);
                    ll.add(nums[left]);
                    ll.add(nums[right]);
                    res.add(new ArrayList<>(ll));
                    ll.clear();
                    while(left < right && nums[left] == nums[left+1])
                    {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right-1])
                    {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if(sum < 0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }

        return res;
    }
}