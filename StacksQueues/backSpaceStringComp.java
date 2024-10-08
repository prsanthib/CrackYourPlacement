class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) != '#')
            {
                s1.push(s.charAt(i));
            }
            else
            {
                if(!s1.isEmpty())
                {
                    s1.pop();
                }
                
            }
        }
        for(int i = 0 ; i < t.length() ; i++)
        {
            if(t.charAt(i) != '#')
            {
                s2.push(t.charAt(i));
            }
            else
            {
                if(!s2.isEmpty())
                {
                    s2.pop();
                }
                
            }
        }


        while(!s1.isEmpty() && !s2.isEmpty())
        {
            if(s1.pop() != s2.pop() || s1.isEmpty() && !s2.isEmpty() || s2.isEmpty()&& !s1.isEmpty())
            {
                return false;
            }
        }

        if(s1.isEmpty() && s2.isEmpty())
        {
            return true;
        }
        return false;
    }
}