class Solution {
    public static void set(int[] nums , int i , List<Integer> al , List<List<Integer>> res)
    {
        if(i == nums.length)
        {
            if(!res.contains(al))
            {
                res.add(new ArrayList<>(al));
            }
            return;
        }

        al.add(nums[i]);
        set(nums,i+1,al,res);
        al.remove(Integer.valueOf(nums[i]));

        set(nums,i+1,al,res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        set(nums,0,al,res);
        return res;
    }
}