class Solution {
    public String longestCommonPrefix(String[] str) {
        int size = Integer.MAX_VALUE;
        for(int i = 0 ; i < str.length ; i++)
        {
            size = Math.min(size,str[i].length());
        }

        int i = 0;
        String s = "";
        boolean flag = false;
        while(i < size)
        {
            char ch = str[0].charAt(i);
            for(int j = 0 ; j < str.length ; j++)
            {
                if(str[j].charAt(i) != ch)
                {
                    flag = true;
                    break;
                }
            }
            if(flag == true)
            {
                break;
            }
            s += ch;
            i++;
        }

        return s;
    }
}