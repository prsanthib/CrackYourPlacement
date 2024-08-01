import java.util.*;
class rabinKarp
{
    public static void main(String args[])
    {
        String text = "This is a text text";
        String pattern = "text";

        int len = pattern.length();
        for(int i = 0 ; i <= text.length()-pattern.length() ; i++)
        {
            if(text.substring(i,i+len).equals(pattern))
            {
                System.out.println(i);
            }
        }
    }
}