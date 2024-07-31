class Solution {
    public int[] restoreArray(int[][] adjPairs) {
        //find the ele with only one connected ele
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < adjPairs.length ; i++)
        {
            if(!map.containsKey(adjPairs[i][0]))
            {
                map.put(adjPairs[i][0],new ArrayList<>());
            }
            if(!map.containsKey(adjPairs[i][1]))
            {
                map.put(adjPairs[i][1],new ArrayList<>());
            }

            map.get(adjPairs[i][0]).add(adjPairs[i][1]);
            map.get(adjPairs[i][1]).add(adjPairs[i][0]);
        }

        //find start idx
        int start = -1;
        Set<Integer> set = new HashSet<>();

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet())
        {
            if(entry.getValue().size() == 1)
            {
                set.add(entry.getKey());
                start = entry.getKey();
                break;
            }
        } 
        
        int res[] = new int[adjPairs.length+1];
        res[0] = start;

        int curr = start;
        for(int i = 1 ; i < res.length ; i++)
        {
            List<Integer> al = map.get(curr);
            for(int j = 0 ; j < al.size() ; j++)
            {
                if(!set.contains(al.get(j)))
                {
                    set.add(al.get(j));
                    res[i] = al.get(j);
                    curr = res[i];
                    break;
                }
            }
        }

        return res;

    }
}z