import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        Collection<Integer> keys = map.keySet();
        for(Integer k : keys)
        {
            System.out.print(k+" ");
            if(map.get(k) > nums.length/2)
            {
                return k;
            }
        }

        return -1;
    }
}