class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int c = 0;
        map.put(0,1);
        int sum = 0;
        for(int num : nums)
        {
            sum += num;
            int mod = (sum%k+k)%k;
            if(map.containsKey(mod))
            {
                c += map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
        }

        return c;
    }
}