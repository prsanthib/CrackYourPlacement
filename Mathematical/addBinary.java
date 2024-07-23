class Solution {
    public String addBinary(String a, String b) {
        if(a == "")
        {
            return b;
        }
        if(b == "")
        {
            return a;
        }
        int c = 0;
        
        int i = a.length()-1;
        int j = b.length()-1;

        String str = "";
        while(i>= 0 && j >= 0)
        {
            int p = a.charAt(i)-'0'+b.charAt(j)-'0'+c;
            if(p == 0)
            {
                str = "0"+str;
                c = 0;
            }
            else if(p == 1)
            {
                str = "1"+str;
                c = 0;
            }
            else if(p ==2)
            {
                str = "0"+str;
                c = 1;
            }
            else
            {
                str = "1"+str;
                c = 1;
            }
            i--;
            j--;
        }

        while(i >= 0)
        {
            int p = a.charAt(i)-'0'+c;
            if(p == 0)
            {
                str = "0"+str;
                c = 0;
            }
            else if(p == 1)
            {
                str = "1"+str;
                c = 0;
            }
            else if(p == 2)
            {
                str = "0"+str;
                c = 1;
            }
            else
            {
                str = "1"+str;
                c = 1;
            }
            i--;
        }

        while(j >= 0)
        {
            int p = b.charAt(j)-'0'+c;
            if(p == 0)
            {
                str = "0"+str;
                c = 0;
            }
            else if(p == 1)
            {
                str = "1"+str;
                c = 0;
            }
            else if(p ==2)
            {
                str = "0"+str;
                c = 1;
            }
            else
            {
                str = "1"+str;
                c = 1;
            }
            j--;
        }

        if(c == 1)
        {
            str = "1"+str;
        }

        return str;


    }
}