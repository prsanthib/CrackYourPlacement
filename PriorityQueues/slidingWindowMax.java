class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ; i < k ; i ++)
        {
            pq.add(nums[i]);
        }

        int temp[] = new int[nums.length-k+1];
        int j = 0;
        for(int i = k ; i < nums.length ; i++)
        {
            temp[j] = pq.peek();
            pq.remove(nums[j]);
            pq.add(nums[i]);
            j++;
        }
        temp[j] = pq.remove();
        
        return temp;
    }
}