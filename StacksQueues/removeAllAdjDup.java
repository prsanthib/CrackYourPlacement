class Solution {
    static class dup
    {
        char c;
        int k;
        public dup(char c , int k)
        {
            this.c = c;
            this.k = k;
        }
    }

    public String removeDuplicates(String s, int p) {

        if(s.length() == 0 || s.length() == 1)
        {
            return s;
        }
        
        Stack<dup> stack = new Stack<>();
        char ch = s.charAt(0);
        stack.push(new dup(ch,1));

        for(int i = 1 ; i < s.length() ; i++)
        {
            if(!stack.isEmpty() && s.charAt(i) == stack.peek().c)
            {
                int count = stack.pop().k+1;
                if(count == p)
                {
                    continue;
                }
                else
                {
                    stack.push(new dup(s.charAt(i),count));
                }
            }
            else
            {
                stack.push(new dup(s.charAt(i),1));
            }
        }

        String str = "";
        while(!stack.isEmpty())
        {
            for(int i = 0 ; i< stack.peek().k ; i++)
            {
                str = stack.peek().c+str;
            }
            stack.pop();
        }

        return str;
    }
}