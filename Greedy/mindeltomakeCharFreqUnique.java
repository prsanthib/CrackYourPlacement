import  java.util.*;
class Solution {

    public int minDeletions(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int c = 1;
        char ch = arr[0];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1 ; i < arr.length ; i++)
        {
            if(arr[i] == ch)
            {
                c++;
            }
            else
            {
                al.add(c);
                c = 1;
                ch = arr[i];
            }
        }
        al.add(c);
        Collections.sort(al);

        int j = 0;

        for(int i = 0 ; i < al.size() ; i++)
        {
            int k = al.remove(i);
            if(!al.contains(k))
            {
                al.add(i,k);
                continue;
            }
            else
            {
                while(k != 0 && al.contains(k))
                {
                    k--;
                    j++;
                }
                al.add(i,k);
            }
        }
        return j;
    }
}