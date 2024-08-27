class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , Integer> map = new HashMap<>();
        List<List<String>> al = new ArrayList<>();


        for(String s : strs)
        {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String res = new String(temp);
            if(map.containsKey(res))
            {
                al.get(map.get(res)).add(s);
            }
            else
            {
                map.put(res , al.size());
                List<String> tempal = new ArrayList<>();
                tempal.add(s);
                al.add(tempal);
            }
        }

        return al;
    }
}