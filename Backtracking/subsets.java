class Solution {

    public static void sets(int[] nums , int i , List<Integer> al , List<List<Integer>> res)
    {
        if(i == nums.length)
        {
            if(!res.contains(al))
            {
                res.add(new ArrayList<>(al));
            }
            return;
        }

        //include
        al.add(nums[i]);
        sets(nums,i+1,al,res);
        al.remove(Integer.valueOf(nums[i]));
        //avoid
        sets(nums,i+1,al,res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        sets(nums,0,al,res);
        return res;
    }
}