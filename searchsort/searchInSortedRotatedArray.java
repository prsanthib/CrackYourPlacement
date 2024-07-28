class Solution {
    public int search(int[] nums, int target) {
      return find(nums,0,nums.length-1,target);
    } 
    public int find(int[]nums,int start,int end,int target){
        if(start>end)return -1;
        int middle = start+(end-start)/2;
        if(nums[middle] == target)
        return middle;
        
        if(nums[start]<=nums[middle])
        {
            if(target>=nums[start]&&target<nums[middle])
            {
                return find(nums,start,middle-1,target);
            }else{
                return find(nums,middle+1,end,target);
            }
        }
        if(target>nums[middle]&&target<=nums[end]){
            return find(nums,middle+1,end,target);
        }
        return find(nums,start,middle-1,target);
    }
}
    