import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ; i < nums.length ; i++)
        {
            pq.add(nums[i]);
        }

        int c = 0;
        while(c < k-1)
        {
            pq.remove();
            c++;
        }

        return pq.peek();
    }
}