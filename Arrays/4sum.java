class Solution {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums[0] > 0 && t < 0)
        {
            return res;
        }
        for(int i = 0 ; i < nums.length-3 ; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
            {
                continue; // neglect duplicates
            }

            for(int j  = i+1 ; j < nums.length-2 ; j++)
            {
                if(j > i+1 && nums[j] == nums[j-1])
                {
                    continue;
                }

                int l = j+1;
                int r = nums.length-1;

                while(l<r)
                {
                    int sum = (nums[i]%1000000009+nums[j]%1000000009+nums[l]%1000000009+nums[r]%1000000009)%1000000009;
                    if(sum == t)
                    {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l < r && nums[l] == nums[l+1])
                        {
                            l++;
                        }
                        while(r > l && nums[r] == nums[r-1])
                        {
                            r--;
                        }
                        l++;
                        r--;
                    }
                    else if(sum < t)
                    {
                        l++;
                    }
                    else
                    {
                        r--;
                    }

                }
            }

        }

        return res;
    }
}