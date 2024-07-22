import java.util.*;
class printDuplicates
{
    public static void main(String args[])
    {
        String str = "geeksforgeeks";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++)
        {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }

        Collection<Character> keys = map.keySet();

        for(Character k : keys)
        {
            System.out.println(k+" "+map.get(k));
        }
        System.out.println();
    }
}