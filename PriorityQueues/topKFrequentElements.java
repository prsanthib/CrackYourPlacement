import java.util.*;
class Solution {
    static class Info implements Comparable<Info>
    {
        int num;
        int mode;
        public Info(int n , int m)
        {
            num = n;
            mode = m;
        }

        @Override
        public int compareTo(Info i2)
        {
            return i2.mode-this.mode ;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        Collection<Integer> keys = map.keySet();
        for(Integer key : keys)
        {
            pq.add(new Info(key,map.get(key)));
        }

        int res[] = new int[k];
        for(int i = 0 ; i < k ; i++)
        {
            Info curr = pq.remove();
            res[i] = curr.num;
            
        }

        return res;
    }
}